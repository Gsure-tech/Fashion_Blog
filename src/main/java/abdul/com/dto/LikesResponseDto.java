package abdul.com.dto;

import abdul.com.model.Post;
import abdul.com.model.User;
import lombok.Data;

@Data
public class LikesResponseDto {
    private Post post;
    private String likedBy;

}
