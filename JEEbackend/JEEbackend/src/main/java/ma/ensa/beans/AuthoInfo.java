package ma.ensa.beans;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AuthoInfo {
    private String login;
    private String password;
}
