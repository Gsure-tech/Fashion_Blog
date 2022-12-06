package abdul.com.services;

import abdul.com.dto.CommentDto;
import abdul.com.dto.CommentResponseDto;
import abdul.com.model.Comment;
import abdul.com.model.User;

import java.util.List;

public interface CommentService {
    Comment saveComment(CommentDto commentDto);
    List<CommentResponseDto> viewComments();
}
