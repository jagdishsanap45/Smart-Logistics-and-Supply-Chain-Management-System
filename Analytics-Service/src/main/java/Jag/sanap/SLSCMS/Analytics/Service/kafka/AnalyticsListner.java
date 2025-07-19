package Jag.sanap.SLSCMS.Analytics.Service.kafka;


import Jag.sanap.SLSCMS.Analytics.Service.service.AnalyticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration

public class AnalyticsListner {

    @Autowired
    private AnalyticService analyticService;

    @KafkaListener(topics = "order-events", groupId = "analytics-group")
    public void consumeOrder(String message){
        System.out.println("Consumed message: " + message);
        analyticService.saveEvent("ORDER_PLACED", message);
    }

}
