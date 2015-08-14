package media.controller;


import media.domain.MediaContent;
import media.service.MediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController()
public class MediaController {

    @Autowired
    private MediaService mediaService;

    @RequestMapping( method = RequestMethod.POST)
    public MediaContent createContent(@RequestBody MediaContent content,
                                      HttpServletRequest request,
                                      HttpServletResponse response) {

        response.addHeader("Location", request.getRequestURL().toString());
        if (content != null) {
            return mediaService.createContentMetaData(content);
        }
        throw new IllegalArgumentException("content");
    }

    @RequestMapping(value="/media/{id}")
    public MediaContent getMediaContent(@PathVariable Long id){
        return mediaService.getMediaContentById(id);
    }

}