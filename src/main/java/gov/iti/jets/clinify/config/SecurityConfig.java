package gov.iti.jets.clinify.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

    @Value("${server-Authorization.url}")
    private String AuthorizationServer;

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOriginPatterns(List.of("**","*"));
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");

        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
    private final String[] patientRole = {
            "/appointments/byPatientId/**",
            "/appointments/cancelAppointment/**",
            "/appointments/*",
            "/appointments/add",
            "/appointments/update",

            "/appointmentsForClinics/book/**",
            "/appointmentsForClinics/rate/**",

            "/patients/data/**",
            "/patients/update",
            "/patients/changePassword",
            "/patients/updatePatient"
//            "/patients/*"
    };

    private final String[] clinicRole = {

//            "/appointmentsForClinics/byDoctorId/*",
            "/appointmentsForClinics/add",
            "/appointmentsForClinics/update",
            "/appointmentsForClinics/delete",
            "/appointmentsForClinics/*",
//            "/appointmentsForClinics/{id}",
            "/appointmentsForClinics/getPage",

//            "/clinics/**",

            "/doctors/add",
            "/doctors/addDoctor",
            "/doctors/delete",
//            "/doctors/update",
            "/doctors/updateDoctor",
            "/doctors/upload",


//            "/patients/addPatient"


    };

    private final String[] secured = {

//            "/appointments/**",
//
//            "/appointmentsForClinics/byDoctorId/**",
//            "/appointmentsForClinics/book/**",

            "/doctors/addDoctor",
            "/doctors/updateDoctor",
            "/doctors/upload"
//            "/patients/addPatient"


    };
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors(withDefaults()).csrf(csrf -> csrf.disable());

        http.oauth2ResourceServer(oauth ->
                oauth.opaqueToken(op -> op
                        .introspectionUri(AuthorizationServer + "/oauth2/introspect")
                        .introspectionClientCredentials("iti-patient", "iti-patient-martina")
                ).opaqueToken(op -> op
                        .introspectionUri(AuthorizationServer + "/oauth2/introspect")
                        .introspectionClientCredentials("iti-clinic", "iti-clinic-martina")
                )
        );

        http.authorizeHttpRequests(auth -> {
            auth.requestMatchers(clinicRole).hasAnyAuthority("SCOPE_CLINIC", "SCOPE_ADMIN")
                    .requestMatchers(patientRole).hasAnyAuthority("SCOPE_PATIENT", "SCOPE_ADMIN")
                .requestMatchers("/**").permitAll();
        });
        return http.build();
    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}

