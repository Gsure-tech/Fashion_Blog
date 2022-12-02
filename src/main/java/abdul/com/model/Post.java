package abdul.com.model;

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

    @CreationTimestamp
    private LocalDateTime postTime;

//    @OneToMany(targetEntity = Comment.class, cascade=CascadeType.ALL)
//    @JoinColumn(name ="postId", referencedColumnName = "id")
//    private List<Comment> comments;
}
