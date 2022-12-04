package abdul.com.controller;

import abdul.com.dto.CommentResponseDto;
import abdul.com.dto.LikesDto;
import abdul.com.dto.LikesResponseDto;
import abdul.com.model.Comment;
import abdul.com.model.Likes;
import abdul.com.services.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class LikeController {
    private final LikesService likesService;
    @PostMapping("/savelike")
    public ResponseEntity<LikesDto> saveLike(@RequestBody LikesDto likesDto){
        likesService.saveLike(likesDto);
        return new ResponseEntity<>(likesDto, HttpStatus.CREATED);
    }
    @GetMapping("/viewlikes")
    public ResponseEntity<List<LikesResponseDto>> viewLikes(){
        List<Likes> like = likesService.viewLikes();
        List<LikesResponseDto> likesResponseDto = new ArrayList<>();
        for(Likes likes : like){
            LikesResponseDto likesResponseDto1 = new LikesResponseDto();
            BeanUtils.copyProperties(likes,likesResponseDto1);
            likesResponseDto.add(likesResponseDto1);
        }
        return new ResponseEntity<>(likesResponseDto,HttpStatus.OK);
    }
}
