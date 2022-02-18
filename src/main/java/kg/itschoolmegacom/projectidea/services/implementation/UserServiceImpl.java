package kg.itschoolmegacom.projectidea.services.implementation;

import kg.itschoolmegacom.projectidea.dao.UserRepo;
import kg.itschoolmegacom.projectidea.exceptions.CodeDoesnotMatchException;
import kg.itschoolmegacom.projectidea.mappers.UserMapper;
import kg.itschoolmegacom.projectidea.models.dtos.UserDto;
import kg.itschoolmegacom.projectidea.models.dtos.UserEntityDto;
import kg.itschoolmegacom.projectidea.models.entities.User;
import kg.itschoolmegacom.projectidea.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


    @Override
    public UserEntityDto findByPhone(String phone) {
        User user = userRepo.findByPhone(phone);
        return UserMapper.INSTANCE.ToUserDto(user);
    }

    @Override
    public String save(UserDto UserDto) {
        boolean exist = userRepo.existsByPhone(UserDto.getPhone());
        if(exist){

        }
        User user = UserMapper.INSTANCE.userDtoToUser(UserDto);
        String code = generateRandomCode();
        user.setCode(code);
        user = userRepo.save(user);
        return "Ваш код подтвержден " + user.getCode();
    }

    @Override
    public String confirm(UserDto userConfirmDto) {
        User user = userRepo.findByPhone(userConfirmDto.getPhone());
        if(!user.getCode().equals(userConfirmDto.getCode())){
           throw new CodeDoesnotMatchException("Код не совпадает");
        }
        user.setActivated(true);
        userRepo.save(user);
        return "Успешно зарегистрировались";
    }

    private String generateRandomCode() {
        int code = (int) (Math.random() *(9999-1000+1)+1000);
        return String.valueOf(code);
    }
}
