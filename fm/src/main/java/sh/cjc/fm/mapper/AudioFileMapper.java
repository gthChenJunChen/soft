package sh.cjc.fm.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import sh.cjc.fm.model.AudioFile;

import java.util.List;

@Mapper
public interface AudioFileMapper {
    List<AudioFile> selectAll();

    AudioFile selectById(Integer id);

    Integer insert(AudioFile audioFile);

    Integer update(AudioFile audioFile);

    Integer delete(@Param("id") Integer id);

    AudioFile selectAlbum(@Param("id") Integer id);

    AudioFile selectAlbumTwo(@Param("id") Integer id);

    List<AudioFile> selectByAlbumId(@Param("albumId") Integer albumId);
}
