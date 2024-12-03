package ma.ensa.controllers;

import ma.ensa.beans.Session;
import ma.ensa.beans.utilities.SessionInput;
import ma.ensa.services.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/session")
public class SessionController {
    @Autowired
    private  SessionService sessionService;
    @PutMapping("update")
    public ResponseEntity<Session> updateSession(SessionInput session) {
        Session upsession = sessionService.updateSession(session);
        return ResponseEntity.ok(upsession);
    }
    @PostMapping("save")
    public ResponseEntity<Session> saveSession(SessionInput session) {
       Session savedSession = sessionService.createSession(session);
       return ResponseEntity.ok(savedSession);
    }

}
