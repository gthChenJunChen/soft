package sh.cjc.fm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sh.cjc.fm.model.Category;
import sh.cjc.fm.model.ResultSupplier;
import sh.cjc.fm.model.ServiceResult;
import sh.cjc.fm.service.CategoryService;

import javax.validation.Valid;
import java.util.List;
import java.util.function.Supplier;

@RestController()
@RequestMapping(value = "/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/index")
    public ModelAndView index() {
        return new ModelAndView("category/index");
    }

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
        return ResultSupplier.getResult(result, () -> {
            return categoryService.add(category) == 1;
        });
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ServiceResult update(@Valid @RequestBody Category category, BindingResult result) {
        return ResultSupplier.getResult(result, () -> {
            return categoryService.edit(category) == 1;
        });
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ServiceResult delete(@PathVariable("id") Integer id) {
        return ResultSupplier.getResult(() -> {
            return categoryService.delete(id) == 1;
        });
    }

}
