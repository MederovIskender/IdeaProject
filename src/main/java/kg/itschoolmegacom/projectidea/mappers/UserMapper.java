package kg.itschoolmegacom.projectidea.mappers;

import kg.itschoolmegacom.projectidea.models.dtos.IdeaDto;
import kg.itschoolmegacom.projectidea.models.dtos.UserDto;
import kg.itschoolmegacom.projectidea.models.entities.Idea;
import kg.itschoolmegacom.projectidea.models.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapper {
        UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
        User UserDtoToUser(UserDto userDto);
        UserDto UserToUserDto(User user);
}
