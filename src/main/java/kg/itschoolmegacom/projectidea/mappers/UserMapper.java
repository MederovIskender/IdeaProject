package kg.itschoolmegacom.projectidea.mappers;

import kg.itschoolmegacom.projectidea.models.dtos.UserDto;
import kg.itschoolmegacom.projectidea.models.dtos.UserEntityDto;
import kg.itschoolmegacom.projectidea.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

        User toUser(UserEntityDto userEntityDto);

        UserEntityDto ToUserDto(User user);

        default User userDtoToUser(UserDto userDto){
                User user = new User();
                user.setPhone(userDto.getPhone());
                user.setCode(userDto.getCode());
                return  user;
        }
}
