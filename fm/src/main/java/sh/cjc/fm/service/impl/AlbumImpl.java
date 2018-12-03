package sh.cjc.fm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sh.cjc.fm.mapper.AlbumMapper;
import sh.cjc.fm.model.Album;
import sh.cjc.fm.service.AlbumService;

import java.util.List;

@Service
public class AlbumImpl implements AlbumService {
    @Autowired
    AlbumMapper albumMapper;

    @Override
    public Album findById(Integer id) {
        return albumMapper.selectById(id);
    }

    @Override
    public List<Album> findAll() {
        return albumMapper.selectAll();
    }

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public Integer add(Album album) {
        return albumMapper.insert(album);
    }

    @Override
    public Integer edit(Album album) {
        return albumMapper.update(album);
    }

    @Override
    public Integer delete(Integer id) {
        return albumMapper.delete(id);
    }

    @Override
    public Album findByIdTwo(Integer id) {
        return albumMapper.selectByIdTwo(id);
    }
}
