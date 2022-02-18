package kg.itschoolmegacom.projectidea.models.dtos;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserEntityDto {
    Long id;
    String phone;
    String code;
    boolean activated;

}
