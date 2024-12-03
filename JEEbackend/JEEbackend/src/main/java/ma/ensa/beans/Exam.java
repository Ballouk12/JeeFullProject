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
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int studentNumber;
    @ManyToOne
    private Departement departement;
    @ManyToOne
    private Professeur responsable;
    @OneToMany(mappedBy = "exam" , cascade = CascadeType.ALL)
    private List<ExamLocal> examenLocations  = new ArrayList<>();
    @ManyToOne
    private Session session ;
}
