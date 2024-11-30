package ma.ensa.controllers;

import ma.ensa.beans.Session;
import ma.ensa.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private  SessionService sessionService;
    @PutMapping("update")
    public ResponseEntity<Session> updateSession(Session session) {
        Session upsession = sessionService.updateSession(session);
        return ResponseEntity.ok(upsession);
    }

}