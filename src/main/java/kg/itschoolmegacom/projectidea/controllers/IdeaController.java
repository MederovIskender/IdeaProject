package kg.itschoolmegacom.projectidea.controllers;

import kg.itschoolmegacom.projectidea.models.dtos.IdeaDto;
import kg.itschoolmegacom.projectidea.models.entities.Idea;
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
    public IdeaDto save(@RequestBody IdeaDto ideaDto) {
        return ideaService.save(ideaDto);
    }

    @GetMapping("/getIdeas")
    public List<IdeaDto>getAllUserIdeas(@RequestParam String phone){
        return ideaService.getAllIdeas(phone);

    }
}
