package Jag.sanap.SLSCMS.Notification.Service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NotificationEvent {

    private Long orderId;
    private String message;
    private LocalDateTime timestamp;
}
