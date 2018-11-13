package sh.cjc.fm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sh.cjc.fm.model.Category;
import sh.cjc.fm.model.FunctionTest;
import sh.cjc.fm.model.ServiceResult;
import sh.cjc.fm.service.CategoryService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

@RestController()
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Category findById(@PathVariable("id") Integer id) {
        return categoryService.findById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ServiceResult add(@Valid @RequestBody Category category, BindingResult result) {
        ServiceResult serviceResult = new ServiceResult();
        try {
            if (result.hasErrors()) {
                serviceResult.setSuccess(false);
                serviceResult.setError(result.getFieldError().getDefaultMessage());
            }
            serviceResult.setSuccess(categoryService.add(category) == 1);
        } catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setError(e.toString());
        }
        return serviceResult;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ServiceResult update(@Valid @RequestBody Category category, BindingResult result) {
        ServiceResult serviceResult = new ServiceResult();
        try {
            if (result.hasErrors()) {
                serviceResult.setSuccess(false);
                serviceResult.setError(result.getFieldError().getDefaultMessage());
            }
            serviceResult.setSuccess(categoryService.edit(category) == 1);
        } catch (Exception e) {
            serviceResult.setSuccess(false);
            serviceResult.setError(e.toString());
        }
        return serviceResult;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ServiceResult delete(@PathVariable("id") Integer id) {
        Supplier<Boolean> serviceResult = () -> {
            return categoryService.delete(id) == 1;
        };
        return FunctionTest.aa(serviceResult);
    }

}
