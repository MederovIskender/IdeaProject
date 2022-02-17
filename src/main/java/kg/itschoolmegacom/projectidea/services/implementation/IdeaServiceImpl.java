package kg.itschoolmegacom.projectidea.services.implementation;

import kg.itschoolmegacom.projectidea.dao.IdeaRepo;
import kg.itschoolmegacom.projectidea.dao.UserRepo;
import kg.itschoolmegacom.projectidea.mappers.IdeaMapper;
import kg.itschoolmegacom.projectidea.models.dtos.IdeaDto;
import kg.itschoolmegacom.projectidea.models.entities.Idea;
import kg.itschoolmegacom.projectidea.models.entities.User;
import kg.itschoolmegacom.projectidea.services.IdeaService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IdeaServiceImpl implements IdeaService {
    private IdeaRepo ideaRepo;
    private UserRepo userRepo;

    public IdeaServiceImpl(IdeaRepo ideaRepo, UserRepo userRepo) {
        this.ideaRepo = ideaRepo;
        this.userRepo = userRepo;
    }

    @Override
    public IdeaDto save(IdeaDto ideaDto) {
        Idea idea = IdeaMapper.INSTANCE.ideaDtoToIdea(ideaDto);
        idea.setUser(userRepo.findAllByPhone(ideaDto.getPhone()));
        idea = ideaRepo.save(idea);

        return IdeaMapper.INSTANCE.ideaToIdeaDto(idea);
    }

    @Override
    public List<IdeaDto> getAllIdeas(String phone) {
        return ideaRepo.getAllIdeaDtos(phone);
    }
}
