package abdul.com.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Data
public class PostResponseDto {
    private String photo;

    @JsonFormat(pattern = "HH:mm:ss, yyyy-MM-dd")
    private LocalDateTime postTime;
}
