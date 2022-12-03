package abdul.com.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long likeId;
//    private Integer myLike;
//    private Integer likeCount;

    @OneToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @OneToOne
    @JoinColumn(name = "postId", nullable = false)
    private Post post;

//    @ManyToOne
//    @JoinColumn(name = "commentId", nullable = false)
//    private Comment comment;

}
