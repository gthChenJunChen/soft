package sh.cjc.fm.service;

import org.apache.ibatis.annotations.Param;
import sh.cjc.fm.model.AudioFile;

import java.util.List;


public interface AudioFileService {
    List<AudioFile> selectAll();

    AudioFile selectById(Integer id);

    Integer add(AudioFile audioFile);

    Integer edit(AudioFile audioFile);

    Integer delete(@Param("id") Integer id);

    AudioFile selectAlbum(@Param("id") Integer id);

    AudioFile selectAlbumTwo(@Param("id") Integer id);

    List<AudioFile> selectAudioFileByAlbumId(@Param("albumId") Integer albumId);
}
