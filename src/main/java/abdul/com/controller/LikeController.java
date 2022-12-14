package abdul.com.controller;
import abdul.com.dto.LikesDto;
import abdul.com.dto.LikesResponseDto;
import abdul.com.services.LikesService;
import lombok.RequiredArgsConstructor;
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
          List <LikesResponseDto> likesResponseDto = likesService.viewLikes();
        return new ResponseEntity<>(likesResponseDto,HttpStatus.OK);
        }

    }

