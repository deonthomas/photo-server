package media.repository.interfaces;

import media.data.MediaContent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepository extends CrudRepository<MediaContent, Long> {
}
