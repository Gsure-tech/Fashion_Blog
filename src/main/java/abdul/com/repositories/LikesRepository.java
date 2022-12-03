package abdul.com.repositories;

import abdul.com.model.Likes;
import abdul.com.model.Post;
import abdul.com.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikesRepository extends JpaRepository<Likes, Long> {
    Optional<Likes> findByPostAndUser (Post post,User user);
}
