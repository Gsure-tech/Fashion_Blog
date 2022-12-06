package abdul.com.services.serviceImpl;

import abdul.com.dto.CommentResponseDto;
import abdul.com.dto.LikesDto;
import abdul.com.dto.LikesResponseDto;
import abdul.com.exceptions.ResourceNotFoundException;
import abdul.com.model.Comment;
import abdul.com.model.Likes;
import abdul.com.model.Post;
import abdul.com.model.User;
import abdul.com.repositories.CommentRepository;
import abdul.com.repositories.LikesRepository;
import abdul.com.repositories.PostRepository;
import abdul.com.repositories.UserRepository;
import abdul.com.services.LikesService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LikesServiceImpl implements LikesService {
    private final CommentRepository commentRepository;
    private final HttpSession httpSession;
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final LikesRepository likesRepository;


    @Override
    public Likes saveLike(LikesDto likesDto) {
        User user = userRepository.findById((long) httpSession.getAttribute("loginUser"))
                .orElseThrow(()-> new ResourceNotFoundException("User not found"));
        Post post = postRepository.findById(likesDto.getPostId())
                .orElseThrow(()-> new ResourceNotFoundException("Post doesnt exist"));

        Likes likes = new Likes();
        //BeanUtils.copyProperties(likesDto,likes);
        likes.setUser(user);
        likes.setPost(post);

        Optional<Likes> checkLike = likesRepository.findByPostAndUser(post,user);
        if(checkLike.isPresent()){
           likesRepository.delete(checkLike.get());
           return likes;
        }
        return likesRepository.save(likes);
    }

    @Override
    public List<LikesResponseDto> viewLikes() {
            List<Likes> likes = likesRepository.findAll();
            List <LikesResponseDto> likesResponseDtoList = new ArrayList<>();
            for(Likes alike:likes){
                LikesResponseDto likesResponseDto = new LikesResponseDto();
                BeanUtils.copyProperties(alike,likesResponseDto);
                likesResponseDto.setLikedBy(alike.getUser().getFirstName());
                likesResponseDtoList.add(likesResponseDto);
            }
            return likesResponseDtoList;
    }
}
