package kg.itschoolmegacom.projectidea.services;

import kg.itschoolmegacom.projectidea.models.dtos.UserDto;
import kg.itschoolmegacom.projectidea.models.dtos.UserEntityDto;

public interface UserService {
    UserEntityDto findByPhone(String phone);

    String save(UserDto userDto);

    String confirm(UserDto userConfirmDto);
}
