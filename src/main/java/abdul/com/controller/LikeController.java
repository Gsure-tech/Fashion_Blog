package abdul.com.controller;

import abdul.com.dto.LikesDto;
import abdul.com.services.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
