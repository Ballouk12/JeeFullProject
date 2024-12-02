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
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String libelle;
    private int size ;
    private String type;
    @OneToMany(mappedBy = "local" ,cascade = CascadeType.ALL)
    private List<ExamLocal> examenLocation  = new ArrayList<>();
}
