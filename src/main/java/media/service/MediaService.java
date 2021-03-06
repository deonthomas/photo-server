package media.service;

import media.domain.MediaContent;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MediaService {

    MediaContent createContentMetaData(MediaContent mediaContent);

    MediaContent getMediaContentById(Long mediaId);
}
