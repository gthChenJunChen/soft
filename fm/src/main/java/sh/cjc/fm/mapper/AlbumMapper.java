package sh.cjc.fm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sh.cjc.fm.model.Album;

import java.util.List;

@Mapper
public interface AlbumMapper {
    List<Album> selectAll();

    Album selectById(Integer id);

    Integer insert(Album album);

    Integer update(Album album);

    Integer delete(@Param("id") Integer id);

    Album selectByIdTwo(Integer id);
}
