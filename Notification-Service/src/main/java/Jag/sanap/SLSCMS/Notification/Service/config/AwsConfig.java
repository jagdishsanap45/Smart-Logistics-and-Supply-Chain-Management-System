package Jag.sanap.SLSCMS.Notification.Service.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.sns.SnsClient;

@Configuration
public class AwsConfig {

    @Bean
    public SnsClient snsClient() {
        return SnsClient.builder()
                .region(Region.AP_SOUTH_1) // ✅ Use your region (e.g., Mumbai)
                .credentialsProvider(
                        StaticCredentialsProvider.create(
                                        AwsBasicCredentials.create("AWS_ACCESS_KEY_ID","AWS_SECRET_ACCESS_KEY")
                                )
                )
                .build();
    }
}
