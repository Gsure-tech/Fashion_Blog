package abdul.com.services;

import abdul.com.dto.PostDto;
import abdul.com.dto.PostResponseDto;
import abdul.com.model.Post;

import java.util.List;

public interface PostService {
    Post savePost (PostDto postDto);
    List<PostResponseDto> viewAllPost();
}
