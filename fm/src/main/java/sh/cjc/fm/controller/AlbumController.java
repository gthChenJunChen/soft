package sh.cjc.fm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import sh.cjc.fm.model.Album;
import sh.cjc.fm.model.ResultSupplier;
import sh.cjc.fm.model.ServiceResult;
import sh.cjc.fm.service.AlbumService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("album")
public class AlbumController {

    @Autowired
    AlbumService albumService;

    @RequestMapping(value = "index")
    public ModelAndView index() {
        return new ModelAndView("album/index");
    }

    @RequestMapping(method = RequestMethod.POST)
    public ServiceResult add(@Valid @RequestBody Album album, BindingResult result) {
        return ResultSupplier.getResult(result, () -> {
            return albumService.add(album) == 1;
        });
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Album> findAll() {
        return albumService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Album findById(@PathVariable("id") Integer id) {
        Album album = albumService.findByIdTwo(id);
        return albumService.findById(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ServiceResult edit(@Valid @RequestBody Album album, BindingResult result) {
        return ResultSupplier.getResult(result, () -> {
            return albumService.edit(album) == 1;
        });
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ServiceResult delete(@PathVariable("id") Integer id) {
        return ResultSupplier.getResult(() -> {
            return albumService.delete(id) == 1;
        });
    }
}
