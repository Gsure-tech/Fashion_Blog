package abdul.com.controller;

import abdul.com.dto.PostDto;
import abdul.com.dto.PostResponseDto;
import abdul.com.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admin")
public class PostController {
    private final PostService postService;

   @PostMapping("/makepost")
    public ResponseEntity<PostDto> makePost(@RequestBody PostDto postDto){
     postService.savePost(postDto);
     return new ResponseEntity<>(postDto, HttpStatus.CREATED);
    }

    @GetMapping("/viewposts")
    public ResponseEntity<List<PostResponseDto>> viewPosts(){
        List<PostResponseDto> postResponseDto = postService.viewAllPost();

        return new ResponseEntity<>(postResponseDto, HttpStatus.OK);
    }
}
