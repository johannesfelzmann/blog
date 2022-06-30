package at.johannesfelzmann.service;

import at.johannesfelzmann.model.Post;

import java.util.Collection;
import java.util.List;

/**
 * @author Johannes Felzmann
 */
public interface PostService {
    Post create(Post post);
    List<Post> list(int limit);
    Post get(Long id);
    Post update(Post post);
    Boolean delete(Long id);
}
