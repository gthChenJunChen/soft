package sh.cjc.fm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sh.cjc.fm.mapper.CategoryMapper;
import sh.cjc.fm.model.Category;
import sh.cjc.fm.service.CategoryService;

import java.util.List;

@Service
public class CategoryImpl implements CategoryService {
    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> findAll() {
        return categoryMapper.selectAll();
    }

    @Override
    public Category findById(Integer id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public Integer add(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public Integer edit(Category category) {
        return categoryMapper.update(category);
    }

}
