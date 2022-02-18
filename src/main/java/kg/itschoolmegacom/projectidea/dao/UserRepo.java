package kg.itschoolmegacom.projectidea.dao;

import kg.itschoolmegacom.projectidea.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByPhone(String phone);
    boolean existsByPhone(String phone);
}
