package abdul.com.services.serviceImpl;

import abdul.com.dto.CommentDto;
import abdul.com.exceptions.ResourceNotFoundException;
import abdul.com.model.Comment;
import abdul.com.model.Post;
import abdul.com.model.User;
import abdul.com.repositories.CommentRepository;
import abdul.com.repositories.PostRepository;
import abdul.com.repositories.UserRepository;
import abdul.com.services.CommentService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final HttpSession httpSession;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    @Override
    public Comment saveComment(CommentDto commentDto) {
        User user = userRepository.findById((long) httpSession.getAttribute("loginUser"))
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));

        Post post = postRepository.findById(commentDto.getPostId())
                .orElseThrow(()-> new ResourceNotFoundException("Post doesnt exist"));

        //System.out.println("This is post" + post);
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto,comment);
        comment.setUser(user);
        comment.setPost(post);
        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> viewComments() {
        List <Comment> comments = commentRepository.findAll();
        return comments;
    }
}
