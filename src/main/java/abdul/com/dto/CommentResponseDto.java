package abdul.com.dto;

import abdul.com.model.Post;
import abdul.com.model.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

public class CommentResponseDto {
    private Post post;
    private String comment;
    @JsonFormat(pattern = "HH:mm:ss, yyyy-MM-dd")
    private LocalDateTime commentTime;
    private User user;
    private String username;




    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = user.getFirstName();
    }
}
