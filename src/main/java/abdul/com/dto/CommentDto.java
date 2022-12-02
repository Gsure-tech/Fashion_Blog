package abdul.com.dto;

import abdul.com.model.Post;
import abdul.com.model.User;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    private Long postId;
    private String comment;
  //  private Post post;

}
