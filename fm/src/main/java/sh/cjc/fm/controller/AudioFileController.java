package sh.cjc.fm.controller;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import sh.cjc.fm.model.AudioFile;
import sh.cjc.fm.model.ResultSupplier;
import sh.cjc.fm.model.ServiceResult;
import sh.cjc.fm.service.AudioFileService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/audiofile")
public class AudioFileController {
    @Autowired
    AudioFileService audioFileService;

    @RequestMapping(method = RequestMethod.GET)
    public List<AudioFile> selectAll() {
        PageHelper.startPage(1, 10).setOrderBy("title");
        return audioFileService.selectAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public AudioFile selectById(@PathVariable("id") Integer id) {
        return audioFileService.selectById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ServiceResult add(@Valid @RequestBody AudioFile audioFile, BindingResult result) {
        return ResultSupplier.getResult(result, () -> {
            return audioFileService.add(audioFile) == 1;
        });
    }

    @RequestMapping(method = RequestMethod.PUT)
    public ServiceResult edit(@Valid @RequestBody AudioFile audioFile, BindingResult result) {
        return ResultSupplier.getResult(result, () -> {
            return audioFileService.edit(audioFile) == 1;
        });
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ServiceResult delete(@PathVariable("id") Integer id) {
        return ResultSupplier.getResult(() -> {
            return audioFileService.delete(id) == 1;
        });
    }

    @RequestMapping(value = "/album", method = RequestMethod.GET)
    public AudioFile selectAlbum(@RequestParam("id") Integer id) {
        return audioFileService.selectAlbum(id);
    }

    @RequestMapping(value = "/album/{albumId}", method = RequestMethod.GET)
    public List<AudioFile> selectAudioFileByAlbumId(@PathVariable("albumId") Integer albumId) {
        return audioFileService.selectAudioFileByAlbumId(albumId);
    }

}
