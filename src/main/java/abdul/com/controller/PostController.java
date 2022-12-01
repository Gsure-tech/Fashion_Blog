package abdul.com.controller;

import abdul.com.dto.PostDto;
import abdul.com.repositories.PostRepository;
import abdul.com.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/admin")
public class PostController {
    private final PostService postService;

   @PostMapping("/makepost")
    public ResponseEntity<PostDto> makePost(@RequestBody PostDto postDto){
     postService.makePost(postDto);
     return new ResponseEntity<>(postDto, HttpStatus.CREATED);
    }
}
