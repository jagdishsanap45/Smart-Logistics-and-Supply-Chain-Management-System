package Jag.sanap.SLSCMS.Delivery.Service.kafka;

import Jag.sanap.SLSCMS.Delivery.Service.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component

public class OrderEventConsumer {

    @Autowired
    private DeliveryService deliveryService;

    @KafkaListener(topics = "order-events", groupId = "delivery-service")
    public  void consume(String message){
        System.out.println("Messagev received: " + message);

        //Simple parsing for now (extract orderId)
        if (message.contains("Order Placed:")){
            Long orderId = Long.parseLong(message.split(":")[1].trim());
            deliveryService.assignDelivery(orderId);
        }
    }
}
