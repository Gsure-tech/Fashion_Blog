package abdul.com.controller;

import abdul.com.dto.CommentDto;
import abdul.com.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
