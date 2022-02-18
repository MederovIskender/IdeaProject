package kg.itschoolmegacom.projectidea.dao;

import kg.itschoolmegacom.projectidea.models.dtos.UserIdeasDto;
import kg.itschoolmegacom.projectidea.models.entities.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IdeaRepo extends JpaRepository<Idea, Long> {

    @Query("Select new kg.itschoolmegacom.projectidea.models.dtos.UserIdeasDto(p.title, p.text, p.contactWithMe) " +
            "from Idea p where p.user.phone=?1")
    List<UserIdeasDto>getAllIdeaDtos(String phone);
}
