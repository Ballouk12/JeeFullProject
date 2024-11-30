package ma.ensa.services;

import ma.ensa.beans.Session;
import ma.ensa.repositories.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Service;

@Service

public class SessionService {
    @Autowired
    private SessionRepository sessionRepository;
    @Autowired
    private Repositories repositories;

    public Session updateSession(Session newsession) {
        Session findedSession =  sessionRepository.findById(newsession.getId()).orElseThrow(() -> new RuntimeException("User not found"));
        findedSession.setDateDebut(newsession.getDateDebut());
        findedSession.setDateFin(newsession.getDateFin());
        findedSession.setType(newsession.getType());
        return sessionRepository.save(findedSession);

    }
}
