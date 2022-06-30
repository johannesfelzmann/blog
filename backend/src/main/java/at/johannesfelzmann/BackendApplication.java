package at.johannesfelzmann;

import at.johannesfelzmann.model.Post;
import at.johannesfelzmann.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(PostRepository postRepository) {
		return args -> {
			postRepository.save(new Post(null, "Test1", "TestTestTest1", null, null));
			postRepository.save(new Post(null, "Test2", "TestTestTest2", null, null));
			postRepository.save(new Post(null, "Test3", "TestTestTest3", null, null));
		};
	}
}
