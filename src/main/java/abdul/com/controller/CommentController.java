package abdul.com.controller;

import abdul.com.dto.CommentDto;
import abdul.com.dto.CommentResponseDto;
import abdul.com.dto.UserResponseDto;
import abdul.com.model.Comment;
import abdul.com.model.User;
import abdul.com.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping ("/api/v1/users")
public class CommentController {
    private final CommentService commentService;
    @PostMapping("/savecomment")
    public ResponseEntity<CommentDto> saveComment(@RequestBody CommentDto commentDto){
        commentService.saveComment(commentDto);
        return new ResponseEntity<>(commentDto , HttpStatus.OK);
    }

    @GetMapping("/viewcomments")
    public ResponseEntity<List<CommentResponseDto>> viewComments(){
        List <CommentResponseDto> commentResponseDtoList = commentService.viewComments();
        
        return new ResponseEntity<>(commentResponseDtoList,HttpStatus.OK);
    }

}
