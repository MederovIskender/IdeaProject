package kg.itschoolmegacom.projectidea.dao;

import kg.itschoolmegacom.projectidea.models.dtos.IdeaDto;
import kg.itschoolmegacom.projectidea.models.entities.Idea;
import org.apache.catalina.LifecycleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IdeaRepo extends JpaRepository<Idea, Long> {

    @Query("Select new kg.itschoolmegacom.projectidea.models.dtos.IdeaDto(p.id, p.title, p.text, p.contactWithMe, p.user.phone) " +
            "from Idea p where p.user.phone=?1")
    List<IdeaDto>getAllIdeaDtos(String phone);
}
