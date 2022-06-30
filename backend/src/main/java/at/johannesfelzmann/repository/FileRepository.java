package at.johannesfelzmann.repository;

import at.johannesfelzmann.model.File;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {

    List<File> findAllByType(File.Type type);
}
