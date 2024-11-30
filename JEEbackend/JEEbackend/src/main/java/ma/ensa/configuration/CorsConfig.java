package ma.ensa.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedOrigin("http://localhost:5173"); // Autorise cette origine
        config.addAllowedMethod("*"); // Autorise toutes les méthodes HTTP
        config.addAllowedHeader("*"); // Autorise tous les en-têtes
        config.setAllowCredentials(true); // Autorise l'envoi de cookies ou sessions

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Applique la config CORS à tous les endpoints

        return new CorsFilter(source);
    }
}
