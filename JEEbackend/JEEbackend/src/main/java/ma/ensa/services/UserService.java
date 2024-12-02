package ma.ensa.services;

import ma.ensa.beans.utilities.AuthoInfo;
import ma.ensa.beans.User;
import ma.ensa.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User signUp(User user) {
        return userRepository.save(user);
    }
    public User signIn(AuthoInfo infos) {return userRepository.findCompte(infos.getLogin(),infos.getPassword());}

}
