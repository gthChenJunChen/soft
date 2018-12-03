package sh.cjc.fm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sh.cjc.fm.mapper.AudioFileMapper;
import sh.cjc.fm.model.AudioFile;
import sh.cjc.fm.service.AudioFileService;

import java.util.List;

@Service
public class AudioFileImpl implements AudioFileService {
    @Autowired
    AudioFileMapper audioFileMapper;

    @Override
    public List<AudioFile> selectAll() {
        PageHelper.startPage(1, 10);
        return audioFileMapper.selectAll();
    }

    @Override
    public AudioFile selectById(Integer id) {
        return audioFileMapper.selectById(id);
    }

    @Override
    public Integer add(AudioFile audioFile) {
        return audioFileMapper.insert(audioFile);
    }

    @Override
    public Integer edit(AudioFile audioFile) {
        return audioFileMapper.update(audioFile);
    }

    @Override
    public Integer delete(Integer id) {
        return audioFileMapper.delete(id);
    }

    @Override
    public AudioFile selectAlbum(Integer id) {
        return audioFileMapper.selectAlbum(id);
    }

    @Override
    public AudioFile selectAlbumTwo(Integer id) {
        return audioFileMapper.selectAlbumTwo(id);
    }

    @Override
    public List<AudioFile> selectAudioFileByAlbumId(Integer albumId) {
        return audioFileMapper.selectByAlbumId(albumId);
    }
}
