package sh.cjc.fm.model;


import org.springframework.validation.BindingResult;

import java.util.function.Supplier;

public class ResultSupplier {
    public static ServiceResult getResult(Supplier<Boolean> bb) {
        ServiceResult serviceResult = new ServiceResult();
        try {
            serviceResult.setSuccess(bb.get());
        } catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setError(e.toString());
        }
        return serviceResult;
    }

    public static ServiceResult getResult(BindingResult result, Supplier<Boolean> function) {
        ServiceResult serviceResult = new ServiceResult();
        try {
            if (result.hasErrors()) {
                serviceResult.setSuccess(false);
                serviceResult.setError(result.getFieldError().getDefaultMessage());
            } else {
                serviceResult.setSuccess(function.get());
            }
        } catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setError(e.toString());
        }
        return serviceResult;
    }


}
