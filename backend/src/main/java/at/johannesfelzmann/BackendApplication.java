package at.johannesfelzmann;

import at.johannesfelzmann.enumeration.Category;
import at.johannesfelzmann.model.File;
import at.johannesfelzmann.model.Post;
import at.johannesfelzmann.repository.FileRepository;
import at.johannesfelzmann.repository.PostRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@SpringBootApplication
public class BackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}

	@Bean
	CommandLineRunner run(PostRepository postRepository, FileRepository fileRepository) {
		return args -> {

			 final String[] imageUrls = new String[]{
					"https://cdn.pixabay.com/photo/2013/07/12/17/47/test-pattern-152459_960_720.png",
					"https://cdn.pixabay.com/photo/2015/11/22/19/04/crowd-1056764_960_720.jpg",
					"https://cdn.pixabay.com/photo/2016/11/22/19/15/hand-1850120_960_720.jpg"
			};

			for (int i = 0; i < 5; i++) {
				File file = File.builder()
						.data(download(imageUrls[i % imageUrls.length]))
						.type(getTypeFrom(imageUrls[i % imageUrls.length]))
						.build();

				fileRepository.save(file);
			}

			List<File> images = fileRepository.findAll().stream()
					.filter(item -> item.getType() == File.Type.IMAGE_JPG || item.getType() == File.Type.IMAGE_PNG)
					.collect(Collectors.toList());

			Set<File> postImages = new HashSet<>();
			postImages.add(images.get(0));
			postImages.add(images.get(1));
			postImages.add(images.get(2));

			postRepository.save(new Post(null, "Test1", "TestTestTest1", postImages, Category.NEWS, "Johannes Felzmann"));
			postRepository.save(new Post(null, "Test2", "TestTestTest2", null, Category.NEWS, "Johannes Felzmann"));
			postRepository.save(new Post(null, "Test3", "TestTestTest3", null, Category.RACE, "Johannes Felzmann"));
			postRepository.save(new Post(null, "Test4", "TestTestTest4", null, Category.TECHNIC, "Johannes Felzmann"));

		};
	}

	private byte[] download(String urlText) throws Exception {
		URL url = new URL(urlText);
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try (InputStream inputStream = url.openStream()) {
			int n;
			byte [] buffer = new byte[1024];
			while (-1 != (n = inputStream.read(buffer))) {
				output.write(buffer, 0, n);
			}
		}
		return output.toByteArray();
	}

	private File.Type getTypeFrom(String url) {
		int extensionDotIndex = url.length() - 1;
		for (int i = extensionDotIndex; i >= 0; i--) {
			if (url.charAt(i) == '.') {
				extensionDotIndex = i + 1;
				break;
			}
		}
		String extension = url.substring(extensionDotIndex);
		switch (extension) {
			case "jpg":
				return File.Type.IMAGE_JPG;
			case "png":
				return File.Type.IMAGE_PNG;
			default:
				throw new IllegalArgumentException("Couldn't map extension \"" + extension + "\" to file type for downloading");
		}
	}
}
