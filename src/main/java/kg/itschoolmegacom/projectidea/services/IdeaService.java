package kg.itschoolmegacom.projectidea.services;

import kg.itschoolmegacom.projectidea.models.dtos.IdeaEntityDto;
import kg.itschoolmegacom.projectidea.models.dtos.UserIdeasDto;

import java.util.List;

public interface IdeaService {
    IdeaEntityDto save(IdeaEntityDto ideaEntityDto);

    List<UserIdeasDto> getAllIdeas(String phone);
}
