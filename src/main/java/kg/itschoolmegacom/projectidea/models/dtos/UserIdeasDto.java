package kg.itschoolmegacom.projectidea.models.dtos;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserIdeasDto {
    String title;
    String body;
    String contactWithMe;
}
