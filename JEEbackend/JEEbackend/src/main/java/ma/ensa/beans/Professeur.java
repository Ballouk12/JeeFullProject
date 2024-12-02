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
public class Professeur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstName;
    private String lastName;
    private boolean isDespense;
    @ManyToOne
    private Departement departement;
    @OneToMany(mappedBy = "professeur" ,cascade = CascadeType.ALL)
    private List<Exam> examsResp  = new ArrayList<>();
}
