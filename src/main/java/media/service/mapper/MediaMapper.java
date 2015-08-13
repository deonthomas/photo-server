package media.service.mapper;

import media.domain.MediaContent;
import org.springframework.stereotype.Component;

@Component
public class MediaMapper {

    public media.data.MediaContent Map(MediaContent mediaContent) {

        return new media.data.MediaContent(
                mediaContent.getName(),
                mediaContent.getDateTime(),
                mediaContent.getLongitude(),
                mediaContent.getLatitude(),
                mediaContent.getContentUrl());

    }
}
