package at.johannesfelzmann.resource;

import at.johannesfelzmann.model.Post;
import at.johannesfelzmann.model.Response;
import at.johannesfelzmann.service.implementation.PostServiceImplementation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.Map;

/**
 * @author Johannes Felzmann
 */

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostResource {
    private final PostServiceImplementation postServiceImplementation;

    @GetMapping("/list")
    public ResponseEntity<Response> getPosts() {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("posts", postServiceImplementation.list(30)))
                        .message("Posts retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> savePost(@RequestBody @Valid Post post) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("post", postServiceImplementation.create(post)))
                        .message("Post created")
                        .status(HttpStatus.CREATED)
                        .statusCode(HttpStatus.CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getPost(@PathVariable("id") Long id) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("post", postServiceImplementation.get(id)))
                        .message("Post retrieved")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deletePost(@PathVariable("id") Long id) {

        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(LocalDateTime.now())
                        .data(Map.of("deleted", postServiceImplementation.delete(id)))
                        .message("Post deleted")
                        .status(HttpStatus.OK)
                        .statusCode(HttpStatus.OK.value())
                        .build()
        );
    }

    @GetMapping(path = "/image/{fileName}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] getPostImage(@PathVariable("fileName") String fileName) throws IOException {

        return Files.readAllBytes(Paths.get(System.getProperty("user.home") + "Downloads/images/" + fileName));
    }
}
