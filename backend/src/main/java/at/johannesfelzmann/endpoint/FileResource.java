package at.johannesfelzmann.endpoint;


import at.johannesfelzmann.endpoint.dto.FileDto;
import at.johannesfelzmann.endpoint.mapper.FileMapper;
import at.johannesfelzmann.service.FileService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.PermitAll;
import java.lang.invoke.MethodHandles;

@RestController
@RequestMapping(value = "/files")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200") //TODO
public class FileResource{

    /*  ----- File Format Support -----
     *  Refer to the documentation of File.Type
     */

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final FileService fileService;
    private final FileMapper fileMapper;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public FileDto uploadFile(@RequestParam("file") MultipartFile file) {
        LOGGER.info("POST /files (size={}, type={})", file.getSize(), file.getContentType());

        return fileMapper.fileToFileDto(fileService.addFile(fileMapper.multipartFileToFile(file)));
    }

}
