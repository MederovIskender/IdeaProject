package kg.itschoolmegacom.projectidea.models.dtos;

import kg.itschoolmegacom.projectidea.models.entities.User;
import lombok.*;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@NoArgsConstructor
@Getter
@Setter
public class IdeaDto {
    @Id
    long id;
    String title;
    String text;
    boolean contactWithMe;
    String phone;

    public IdeaDto(long id, String title, String text, boolean contactWithMe, String phone) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.contactWithMe = contactWithMe;
        this.phone = phone;
    }

}
