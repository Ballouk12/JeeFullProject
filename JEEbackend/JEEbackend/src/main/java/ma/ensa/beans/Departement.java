package ma.ensa.beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String deptName;
    @OneToMany(mappedBy = "departement" ,cascade = CascadeType.ALL)
    private List<Professeur> professeurs  = new ArrayList<>();
    @OneToMany(mappedBy = "departement" ,cascade = CascadeType.ALL)
    private List<Exam> exams  = new ArrayList<>();
}
