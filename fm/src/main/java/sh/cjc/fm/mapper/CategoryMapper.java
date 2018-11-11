package sh.cjc.fm.mapper;

import org.apache.ibatis.annotations.Mapper;
import sh.cjc.fm.model.Category;

import java.util.List;

@Mapper
public interface CategoryMapper {
    List<Category> selectAll();

    Category selectById(Integer id);

    Integer insert(Category category);

    Integer update(Category category);
}
