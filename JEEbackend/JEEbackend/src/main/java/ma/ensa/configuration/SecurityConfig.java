package ma.ensa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .anyRequest().permitAll() // Permet toutes les requêtes (ajuster selon vos besoins)
                )
                .cors(withDefaults()) // Active CORS avec les paramètres par défaut
                .csrf(csrf -> csrf.disable()); // Désactive CSRF pour les API REST (nécessaire pour une API stateless)

        return http.build();
    }
}
