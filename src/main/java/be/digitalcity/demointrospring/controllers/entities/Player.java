package be.digitalcity.demointrospring.controllers.entities;

import be.digitalcity.demointrospring.controllers.utils.Poste;
import lombok.*;
import lombok.experimental.FieldDefaults;
import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    long id ;

    @Column(nullable = false)
    String name ;

    @Column(columnDefinition = "DATE")
    LocalDate birthdate ;

    @Column
    int number;

    @Column
    double salaire ;

    @Column
    @Enumerated(EnumType.STRING)
    Poste poste;
}
