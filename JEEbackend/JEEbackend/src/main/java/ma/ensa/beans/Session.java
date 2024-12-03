package ma.ensa.beans;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Session {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateDebut;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateFin;
    @OneToMany(mappedBy = "session" ,cascade = CascadeType.ALL)
    private List<Seance> seances  = new ArrayList<>();
    @OneToMany(mappedBy = "session")
    private List<Exam> exams  = new ArrayList<>();

}
