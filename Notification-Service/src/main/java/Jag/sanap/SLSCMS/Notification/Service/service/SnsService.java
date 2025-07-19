package Jag.sanap.SLSCMS.Notification.Service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Service
public class SnsService {

    @Autowired
    private SnsClient snsClient;

    private final String topicArn = "AWS_SNS_TOPIC_ARN"; // Replace with your actual SNS Topic ARN

    public void sendEmail(String message) {
        PublishRequest request = PublishRequest.builder()
                .message(message)
                .topicArn(topicArn)
                .build();

        PublishResponse result = snsClient.publish(request);
        System.out.println("📩 SNS Message ID: " + result.messageId());
    }
}
