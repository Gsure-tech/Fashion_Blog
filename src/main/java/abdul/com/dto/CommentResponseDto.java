package abdul.com.dto;

import abdul.com.model.Post;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.time.LocalDateTime;
@Data
public class CommentResponseDto {
    private Post post;
    private String comment;
    @JsonFormat(pattern = "HH:mm:ss, yyyy-MM-dd")
    private LocalDateTime commentTime;
    private String commentBy;

}
