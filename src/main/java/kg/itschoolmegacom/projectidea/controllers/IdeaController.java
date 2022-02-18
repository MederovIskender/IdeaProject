package kg.itschoolmegacom.projectidea.controllers;

import kg.itschoolmegacom.projectidea.models.dtos.IdeaEntityDto;
import kg.itschoolmegacom.projectidea.models.dtos.UserIdeasDto;
import kg.itschoolmegacom.projectidea.services.IdeaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/idea")
public class IdeaController {

    private IdeaService ideaService;
    public IdeaController(IdeaService ideaService) {
        this.ideaService = ideaService;
    }

    @PostMapping("/save")
    public IdeaEntityDto save(@RequestBody IdeaEntityDto ideaEntityDto) {
        return ideaService.save(ideaEntityDto);
    }

    @GetMapping("/getIdeas")
    public List<UserIdeasDto>getAllUserIdeas(@RequestParam String phone){
        return ideaService.getAllIdeas(phone);

    }
}
