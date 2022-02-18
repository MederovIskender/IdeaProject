package kg.itschoolmegacom.projectidea.models.dtos;

import lombok.*;

@NoArgsConstructor
@Getter
@Setter
public class IdeaEntityDto {

    long id;
    String title;
    String text;
    String contactWithMe;
    String phone;

    public IdeaEntityDto(long id, String title, String text, String contactWithMe, String phone) {
        this.id = id;
        this.title = title;
        this.text = text;
        this.contactWithMe = contactWithMe;
        this.phone = phone;
    }

}
