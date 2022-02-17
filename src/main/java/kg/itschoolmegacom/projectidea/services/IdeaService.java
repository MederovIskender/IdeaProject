package kg.itschoolmegacom.projectidea.services;

import kg.itschoolmegacom.projectidea.models.dtos.IdeaDto;

import java.util.List;

public interface IdeaService {
    IdeaDto save(IdeaDto ideaDto);

    List<IdeaDto> getAllIdeas(String phone);
}
