package at.johannesfelzmann.endpoint.mapper;
import at.johannesfelzmann.endpoint.dto.PostDto;
import at.johannesfelzmann.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {FileMapper.class})
public interface PostMapper {
    PostMapper INSTANCE = Mappers.getMapper(PostMapper.class);

    Post postDtoToPost(PostDto postDto);

    PostDto postToPostDto(Post post);

    List<PostDto> postListToPostListDto(List<Post> postList);
}
