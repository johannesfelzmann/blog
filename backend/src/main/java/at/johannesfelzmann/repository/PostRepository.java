package at.johannesfelzmann.repository;

import at.johannesfelzmann.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Johannes Felzmann
 */
public interface PostRepository extends JpaRepository<Post, Long> {
}
