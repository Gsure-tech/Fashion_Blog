package abdul.com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity

public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String photo;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "HH:mm:ss, yyyy-MM-dd")
    @JsonProperty("Time")
    @CreationTimestamp
    private LocalDateTime postTime;

//    @OneToMany(targetEntity = Comment.class, cascade=CascadeType.ALL)
//    @JoinColumn(name ="postId", referencedColumnName = "id")
//    private List<Comment> comments;
}
