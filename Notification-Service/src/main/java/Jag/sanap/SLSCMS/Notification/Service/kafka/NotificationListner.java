package Jag.sanap.SLSCMS.Notification.Service.kafka;

import Jag.sanap.SLSCMS.Notification.Service.service.SnsService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationListner {

    @Autowired
    private SnsService snsService;

    @KafkaListener(topics = "order-events", groupId = "notification-service")
    public void consume(String message) {
        System.out.println("Notification Triggered: " + message);

        // Optional: You can simulate sending email or SMS
        if (message.contains("Order Placed:")) {
            Long orderId = Long.parseLong(message.split(":")[1].trim());

            // Simulate notification
            System.out.println("Sending notification for order ID: " + orderId);

            snsService.sendEmail("Order "+orderId+" has been placed successfully.");

            // If you want to integrate AWS SNS here, you can trigger it
        }
    }
}

