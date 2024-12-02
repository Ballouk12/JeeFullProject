package ma.ensa.beans.utilities;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SessionInput {
    private int id;
    private String type;
    private Date dateDebut;
    private Date dateFin;
    private Date heureDebutS1;
    private Date heureFinS1;
    private Date heureDebutS2;
    private Date heureFinS2;
    private Date heureDebutS3;
    private Date heureFinS3;
    private Date heureDebutS4;
    private Date heureFinS4;
}
