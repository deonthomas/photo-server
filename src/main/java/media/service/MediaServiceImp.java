package media.service;

import media.domain.MediaContent;
import media.repository.interfaces.MediaRepository;
import media.service.mapper.MediaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class MediaServiceImp implements MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private MediaMapper mapper;

    public MediaContent createContentMetaData(MediaContent content) {
        if (content != null) {
            return mapper
                    .fromDataModel(mediaRepository
                            .save(mapper
                                    .toDataModel(content)));
        }
        throw new IllegalArgumentException("content");
    }

    @Override
    public Iterable<media.data.MediaContent> getMediaContents() {
        return mediaRepository.findAll();
    }
}
