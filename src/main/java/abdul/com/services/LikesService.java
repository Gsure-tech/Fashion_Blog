package abdul.com.services;

import abdul.com.dto.CommentDto;
import abdul.com.dto.LikesDto;
import abdul.com.model.Comment;
import abdul.com.model.Likes;

import java.util.List;

public interface LikesService {
    Likes saveLike(LikesDto likesDto);
    List<Likes> viewLikes();
}
