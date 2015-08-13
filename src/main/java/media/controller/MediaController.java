package media.controller;


import com.mysql.fabric.Response;
import com.sun.javaws.exceptions.InvalidArgumentException;
import media.domain.MediaContent;
import media.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import provider.domain.Provider;
import provider.services.ProviderService;

import java.util.Date;
import java.util.List;

import static Utils.StringUtils.isNullOrEmpty;

@RestController()
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @RequestMapping(value = "/meta",method = RequestMethod.POST)
    public MediaContent createContent(@RequestBody  MediaContent content) {
        if (content != null) {
            return mediaService.createContentMetaData(content);
        }
        throw new IllegalArgumentException("content");
    }

    @RequestMapping(value = "/meta",method = RequestMethod.GET)
    public Iterable<media.data.MediaContent> getContent() {
            return mediaService.getMediaContents();
    }

}