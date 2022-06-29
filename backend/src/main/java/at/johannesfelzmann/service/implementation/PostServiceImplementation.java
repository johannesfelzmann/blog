package at.johannesfelzmann.service.implementation;

import at.johannesfelzmann.model.Post;
import at.johannesfelzmann.repository.PostRepository;
import at.johannesfelzmann.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

/**
 * @author Johannes Felzmann
 */

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class PostServiceImplementation implements PostService {

    private final PostRepository postRepository;

    @Override
    public Post create(Post post) {
        log.info("Saving new Post: {}", post.getName());

        return postRepository.save(post);
    }

    @Override
    public Collection<Post> list(int limit) {
        log.info("List all Posts to number {}", limit);

        return postRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Post get(Long id) {
        log.info("Get Post with id {}", id);

        return postRepository.findById(id).get(); //TODO
    }

    @Override
    public Post update(Post post) {
        log.info("Update Post: {} {}", post.getId(), post.getName());

        return postRepository.save(post);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Delete Post with id {}", id);

        postRepository.deleteById(id);

        return true;
    }

}
