package abdul.com.services;

import abdul.com.dto.PostDto;
import abdul.com.model.Post;

public interface PostService {
    Post makePost(PostDto postDto);
}
