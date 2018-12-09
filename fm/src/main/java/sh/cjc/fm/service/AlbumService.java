package sh.cjc.fm.service;

import sh.cjc.fm.model.Album;
import sh.cjc.fm.model.LayuiPageInfo;
import sh.cjc.fm.model.LayuiTable;

import java.util.List;

public interface AlbumService {
    Album findById(Integer id);

    LayuiTable<Album> findAll(LayuiPageInfo<Album> pageModelInfo);

    Integer add(Album album);

    Integer edit(Album album);

    Integer delete(Integer id);

    Album findByIdTwo(Integer id);
}
