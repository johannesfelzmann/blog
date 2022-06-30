package at.johannesfelzmann.endpoint.mapper;

import at.johannesfelzmann.endpoint.dto.FileDto;
import at.johannesfelzmann.exception.BadFileException;
import at.johannesfelzmann.model.File;
import org.mapstruct.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

@Mapper
public interface FileMapper extends FileTypeMapper {

    FileDto fileToFileDto(File file);

    File fileDtoToFile(FileDto fileDto);

    FileDto[] fileSetToFileDtoArray(Set<File> set);

    Set<File> fileDtoArrayToFileSet(FileDto[] fileDtoArray);

    /**
     * Maps a MultipartFile object to a File entity.
     *
     * @param multipartFile the MultipartFile object to be mapped
     * @return the corresponding File object
     * @throws BadFileException if file cannot be read or is unsupported
     */
    default File multipartFileToFile(MultipartFile multipartFile) throws BadFileException {
        File file;
        if (multipartFile.getContentType() == null) {
            throw new BadFileException("The file is missing content type");
        }
        try {
            file = File.builder()
                .data(multipartFile.getBytes())
                .type(File.Type.fromMime(multipartFile.getContentType()))
                .build();
        } catch (IOException e) {
            throw new BadFileException("Couldn't retrieve bytes from file", e);
        } catch (IllegalArgumentException e) {
            throw new BadFileException("File format \"" + multipartFile.getContentType() + "\" is not supported", e);
        }
        return file;
    }

}
