package kg.itschoolmegacom.projectidea.models.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import java.util.Date;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class User {
    @Id
    long id;
    String name;
    String phone;
    Date add_date;
    int code;
    boolean activated;

}
