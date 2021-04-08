package br.com.smartservice.notificator.notificator.configurations;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;

@Configuration
public class FirebaseConfiguration {

    @Value("${google.application.credentials}")
    private String GOOGLE_APPLICATION_CREDENTIALS;

    @Value("${token.cloud.message}")
    private String TOKEN_CLOUD_MESSAGE;

    @Value("${database.url}")
    private String DATABASE_URL;

    @SneakyThrows
    @Bean
    public FirebaseApp firebaseApp() {
        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(GoogleCredentials.fromStream(new FileInputStream(GOOGLE_APPLICATION_CREDENTIALS)))
                .setDatabaseUrl(DATABASE_URL)
                .build();

        return FirebaseApp.initializeApp(options);
    }
}