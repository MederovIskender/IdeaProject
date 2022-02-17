package kg.itschoolmegacom.projectidea.models.entities;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Idea {
    @Id
    long id;
    String title;
    String text;
    boolean contactWithMe;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;
}
