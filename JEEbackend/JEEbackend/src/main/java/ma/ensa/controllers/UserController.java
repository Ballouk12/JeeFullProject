package ma.ensa.controllers;

import ma.ensa.beans.utilities.AuthoInfo;
import ma.ensa.beans.User;
import ma.ensa.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:5173")
public class UserController {
    @Autowired
    private  UserService userService;
    @PostMapping("signup")
    public ResponseEntity<User> signUp(@RequestBody User user) {
        User savedUser = userService.signUp(user);
       return ResponseEntity.ok(savedUser);
    }
    @PostMapping("signin")
    public ResponseEntity<User> singIn(@RequestBody AuthoInfo infos) {
        User user = userService.signIn(infos);
        if (user != null) {
            return ResponseEntity.ok(user);
        }
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(null);
    }

}
