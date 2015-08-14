package media.service;

import media.domain.MediaContent;
import media.repository.interfaces.MediaRepository;
import media.service.mapper.MediaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import static Utils.StringUtils.fromBase64;

@Service
public class MediaServiceImp implements MediaService {

    @Autowired
    private MediaRepository mediaRepository;

    @Autowired
    private MediaMapper mapper;

    public MediaContent createContentMetaData(MediaContent content) {
        if (content != null) {

            if(content.getMedia()!= null) {
                byte[] media = fromBase64(content.getMedia().getBytes());
                //todo: save media to queuing system
            }

            media.data.MediaContent meta = mapper.toDataModel(content);
            return mapper.fromDataModel(mediaRepository.save(meta));
        }
        throw new IllegalArgumentException("content");
    }

    @Override
    public MediaContent getMediaContentById(Long mediaId) {
        return mapper.fromDataModel(mediaRepository.findOne(mediaId));
    }
}
