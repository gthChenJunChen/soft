package sh.cjc.fm.service;

import sh.cjc.fm.model.Album;

import java.util.List;

public interface AlbumService {
    Album findById(Integer id);

    List<Album> findAll();

    Integer add(Album album);

    Integer edit(Album album);

    Integer delete(Integer id);

    Album findByIdTwo(Integer id);
}
