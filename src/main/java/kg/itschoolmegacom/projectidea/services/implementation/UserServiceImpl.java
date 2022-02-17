package kg.itschoolmegacom.projectidea.services.implementation;

import kg.itschoolmegacom.projectidea.dao.UserRepo;
import kg.itschoolmegacom.projectidea.services.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserRepo userRepo;

    public UserServiceImpl(UserRepo userRepo) {
        this.userRepo = userRepo;
    }


}
