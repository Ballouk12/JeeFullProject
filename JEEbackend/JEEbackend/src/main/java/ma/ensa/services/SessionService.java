package ma.ensa.services;

import ma.ensa.beans.Seance;
import ma.ensa.beans.Session;
import ma.ensa.beans.utilities.SessionInput;
import ma.ensa.repositories.SeanceRepository;
import ma.ensa.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.Date;

@Service

public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private SeanceRepository seanceRepository;

    public Session updateSession(SessionInput sessionInput) {
        Session findedSession =  sessionRepository.findById(sessionInput.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        findedSession.setDateDebut(sessionInput.getDateDebut());
        findedSession.setDateFin(sessionInput.getDateFin());
        findedSession.setType(sessionInput.getType());
        findedSession.getSeances().removeAll(findedSession.getSeances());
        for(int i=1 ;i<=4;i++){
            try {
                Seance seance = new Seance();
                Method getHeureDebut = SessionInput.class.getMethod("getHeureDebutS" + i);
                Method getHeureFin = SessionInput.class.getMethod("getHeureFinS" + i);
                seance.setHeureDebut((Date) getHeureDebut.invoke(sessionInput));
                seance.setHeureFin((Date) getHeureFin.invoke(sessionInput));
                seance.setOrdre(i);
               findedSession.getSeances().add(seance);
                seanceRepository.save(seance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionRepository.save(findedSession);
    }

    public Session createSession(SessionInput sessionInput) {
        Session newSession =new Session();
        newSession.setDateDebut(sessionInput.getDateDebut());
        newSession.setDateFin(sessionInput.getDateFin());
        newSession.setType(sessionInput.getType());
        for(int i=1 ;i<=4;i++){
            try {
            Seance seance = new Seance();
            Method getHeureDebut = SessionInput.class.getMethod("getHeureDebutS" + i);
            Method getHeureFin = SessionInput.class.getMethod("getHeureFinS" + i);
            seance.setHeureDebut((Date) getHeureDebut.invoke(sessionInput));
            seance.setHeureFin((Date) getHeureFin.invoke(sessionInput));
            seance.setOrdre(i);
            newSession.getSeances().add(seance);
            seanceRepository.save(seance);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return sessionRepository.save(newSession);
    }
}
