package at.johannesfelzmann.endpoint;

import at.johannesfelzmann.endpoint.dto.PostDto;
import at.johannesfelzmann.endpoint.mapper.PostMapper;
import at.johannesfelzmann.model.Post;
import at.johannesfelzmann.model.Response;
import at.johannesfelzmann.service.implementation.PostServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

/**
 * @author Johannes Felzmann
 */

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostResource {
    private final PostServiceImplementation postServiceImplementation;
    private final PostMapper postMapper;

    @GetMapping("/list")
    public List<PostDto> getPosts() {

        return postMapper.postListToPostListDto(postServiceImplementation.list(30));
    }

    @PostMapping("/save")
    public PostDto savePost(@RequestBody @Valid PostDto post) {

        return postMapper.postToPostDto(postServiceImplementation.create(postMapper.postDtoToPost(post)));
    }

    @GetMapping("/get/{id}")
    public PostDto getPost(@PathVariable("id") Long id) {

        return postMapper.postToPostDto(postServiceImplementation.get(id));
    }

    @DeleteMapping("/delete/{id}")
    public void deletePost(@PathVariable("id") Long id) {

        postServiceImplementation.delete(id);
    }

    @GetMapping(path = "/image/{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPostImage(@PathVariable("fileName") String fileName) throws IOException {

        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "Downloads/images/" + fileName));
    }
}
