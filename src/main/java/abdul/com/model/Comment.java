package abdul.com.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@NoArgsConstructor
@Entity
@Getter
@Setter

public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    private String comment;

    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @JsonFormat(pattern = "HH:mm:ss, yyyy-MM-dd")
    @JsonProperty("Time")
    @CreationTimestamp
    private LocalDateTime commentTime;

    @ManyToOne
    @JoinColumn(name = "postId", nullable = false)
    private Post post;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;
}
