package sh.cjc.fm.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import sh.cjc.fm.mapper.AlbumMapper;
import sh.cjc.fm.model.Album;
import sh.cjc.fm.model.LayuiPageInfo;
import sh.cjc.fm.model.LayuiTable;
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
    public LayuiTable<Album> findAll(LayuiPageInfo<Album> pageModelInfo) {
        LayuiTable<Album> albumLayuiTable = new LayuiTable<Album>();
        if (pageModelInfo != null) {
            if (pageModelInfo.getField() != null && pageModelInfo.getField() != "") {
                PageHelper.startPage(pageModelInfo.getPage(), pageModelInfo.getLimit(), pageModelInfo.getField() + " " + pageModelInfo.getOrder());
            } else {
                PageHelper.startPage(pageModelInfo.getPage(), pageModelInfo.getLimit());
            }
        }
        PageInfo<Album> pageInfo = new PageInfo<>(albumMapper.selectAll());
        albumLayuiTable.setData(pageInfo.getList());
        albumLayuiTable.setCount(pageInfo.getTotal());
        albumLayuiTable.setCode(0L);
        return albumLayuiTable;
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
