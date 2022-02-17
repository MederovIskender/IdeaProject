package kg.itschoolmegacom.projectidea.mappers;

import kg.itschoolmegacom.projectidea.models.dtos.IdeaDto;
import kg.itschoolmegacom.projectidea.models.entities.Idea;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface IdeaMapper {
    IdeaMapper INSTANCE = Mappers.getMapper(IdeaMapper.class);

    @Mapping(source = "IdeaDto.phone", target = "user.phone")
    Idea ideaDtoToIdea(IdeaDto ideaDto);


    @Mapping(source = "Idea.user.phone", target = "phone")
    IdeaDto ideaToIdeaDto(Idea idea);
}
