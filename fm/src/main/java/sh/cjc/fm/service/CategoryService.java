package sh.cjc.fm.service;

import sh.cjc.fm.model.Category;

import java.util.List;

public interface CategoryService {
    Category findById(Integer id);

    List<Category> findAll();

    Integer add(Category category);

    Integer edit(Category category);
}
