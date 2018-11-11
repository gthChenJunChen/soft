package sh.cjc.fm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sh.cjc.fm.model.Category;
import sh.cjc.fm.service.CategoryService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

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
    public String add(@Valid @RequestBody Category category, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return result.getFieldError().getDefaultMessage();
            }
            return categoryService.add(category).toString();
        } catch (Exception e) {
            return e.toString();
        }
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update(@Valid @RequestBody Category category, BindingResult result) {
        try {
            if (result.hasErrors()) {
                return result.getFieldError().getDefaultMessage();
            }
            return categoryService.edit(category).toString();
        } catch (Exception e) {
            return e.toString();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Boolean delete(@PathVariable("id") Integer id) {
        return true;
    }
}
