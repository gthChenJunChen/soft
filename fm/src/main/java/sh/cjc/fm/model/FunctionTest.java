package sh.cjc.fm.model;


import java.util.function.Supplier;

public class FunctionTest {
    public static <V> ServiceResult aa(Supplier<V> bb) {
        ServiceResult serviceResult = new ServiceResult();
        try {
            serviceResult.setSuccess((Boolean) bb.get());
        } catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setError(e.toString());
        }
        return serviceResult;
    }


}
