package kg.itschoolmegacom.projectidea.controllers;

import kg.itschoolmegacom.projectidea.models.dtos.UserDto;
import kg.itschoolmegacom.projectidea.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody UserDto userDto){
        return userService.save(userDto);
    }

    @PostMapping("/confirm")
    public String confirmUserCode(@RequestBody UserDto userConfirmDto){
        return userService.confirm(userConfirmDto);
    }
}
