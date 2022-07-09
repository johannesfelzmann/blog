package at.johannesfelzmann.endpoint.dto;

import at.johannesfelzmann.enumeration.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDto {
    private Long id;
    @NotEmpty(message = "Name cannot be empty!")
    private String name;
    private String text;
    private FileDto[] images = new FileDto[10];
    private Category category;
}
