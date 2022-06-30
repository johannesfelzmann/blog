package at.johannesfelzmann.service.implementation;

import at.johannesfelzmann.model.Post;
import at.johannesfelzmann.repository.PostRepository;
import at.johannesfelzmann.service.PostService;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.lang.invoke.MethodHandles;
import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;

/**
 * @author Johannes Felzmann
 */

@Service
@Transactional
@RequiredArgsConstructor
public class PostServiceImplementation implements PostService {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final PostRepository postRepository;

    @Override
    public Post create(Post post) {
        LOGGER.info("Saving new Post: {}", post.getName());

        return postRepository.save(post);
    }

    @Override
    public List<Post> list(int limit) {
        LOGGER.info("List all Posts to number {}", limit);

        return postRepository.findAll(PageRequest.of(0, limit)).toList();
    }

    @Override
    public Post get(Long id) {
        LOGGER.info("Get Post with id {}", id);

        return postRepository.findById(id).get(); //TODO
    }

    @Override
    public Post update(Post post) {
        LOGGER.info("Update Post: {} {}", post.getId(), post.getName());

        return postRepository.save(post);
    }

    @Override
    public Boolean delete(Long id) {
        LOGGER.info("Delete Post with id {}", id);

        postRepository.deleteById(id);

        return true;
    }

}
