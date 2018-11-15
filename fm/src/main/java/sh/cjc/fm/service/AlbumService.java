package sh.cjc.fm.service;

import org.springframework.stereotype.Service;
import sh.cjc.fm.model.Album;

import java.util.List;

public interface AlbumService {
    Album findById(Integer id);

    List<Album> findAll();

    Integer add(Album album);

    Integer edit(Album album);

    Integer delete(Integer id);
}
