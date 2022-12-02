package abdul.com.services;

import abdul.com.dto.CommentDto;
import abdul.com.model.Comment;

public interface CommentService {
    Comment saveComment(CommentDto commentDto);
}
