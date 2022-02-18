package kg.itschoolmegacom.projectidea.services.implementation;

import kg.itschoolmegacom.projectidea.dao.IdeaRepo;
import kg.itschoolmegacom.projectidea.exceptions.UserNotActivatedException;
import kg.itschoolmegacom.projectidea.exceptions.UserNotFoundException;
import kg.itschoolmegacom.projectidea.mappers.IdeaMapper;
import kg.itschoolmegacom.projectidea.mappers.UserMapper;
import kg.itschoolmegacom.projectidea.models.dtos.IdeaEntityDto;
import kg.itschoolmegacom.projectidea.models.dtos.UserEntityDto;
import kg.itschoolmegacom.projectidea.models.dtos.UserIdeasDto;
import kg.itschoolmegacom.projectidea.models.entities.Idea;
import kg.itschoolmegacom.projectidea.services.IdeaService;
import kg.itschoolmegacom.projectidea.services.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class IdeaServiceImpl implements IdeaService {
    private IdeaRepo ideaRepo;
    private UserService userService;

    public IdeaServiceImpl(IdeaRepo ideaRepo, UserService userService) {
        this.ideaRepo = ideaRepo;
        this.userService =userService;
    }

    @Override
    public IdeaEntityDto save(IdeaEntityDto ideaEntityDto) {
        UserEntityDto userEntityDto = userService.findByPhone(ideaEntityDto.getPhone());
        if(Objects.isNull(userEntityDto)){
            throw new UserNotFoundException("User with phone " +
                    ideaEntityDto.getPhone() + " not found");
        }
        if(!userEntityDto.isActivated()){
            throw new UserNotActivatedException("User with phone " +
                    ideaEntityDto.getPhone() + " not activated");
        }
        Idea idea = IdeaMapper.INSTANCE.IdeaEntityDtoToIdea(ideaEntityDto);
        idea.setUser(UserMapper.INSTANCE.toUser(userEntityDto));
        idea = ideaRepo.save(idea);

        return IdeaMapper.INSTANCE.ideaToIdeaDto(idea);
    }

    @Override
    public List<UserIdeasDto> getAllIdeas(String phone) {
        return ideaRepo.getAllIdeaDtos(phone);
    }
}
