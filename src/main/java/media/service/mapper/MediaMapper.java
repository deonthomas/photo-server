package media.service.mapper;

import media.domain.MediaContent;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class MediaMapper {

    ModelMapper modelMapper = new ModelMapper();

    private MediaMapper() {
        modelMapper.createTypeMap(MediaContent.class, media.data.MediaContent.class);
        modelMapper.createTypeMap(media.data.MediaContent.class, MediaContent.class);
        modelMapper.validate();
    }

    public media.data.MediaContent toDataModel(MediaContent mediaContent) {
        return modelMapper.map(mediaContent, media.data.MediaContent.class);
    }

    public media.domain.MediaContent fromDataModel(media.data.MediaContent mediaContent) {
        return modelMapper.map(mediaContent, media.domain.MediaContent.class);
    }


}
