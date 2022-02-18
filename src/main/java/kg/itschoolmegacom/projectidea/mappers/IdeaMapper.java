package kg.itschoolmegacom.projectidea.mappers;

import kg.itschoolmegacom.projectidea.models.dtos.IdeaEntityDto;
import kg.itschoolmegacom.projectidea.models.entities.Idea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IdeaMapper {
    IdeaMapper INSTANCE = Mappers.getMapper(IdeaMapper.class);

    @Mapping(source = "phone", target = "user.phone")
    Idea IdeaEntityDtoToIdea(IdeaEntityDto ideaEntityDto);

    @Mapping(source = "user.phone", target = "phone")
    IdeaEntityDto ideaToIdeaDto(Idea idea);
}
