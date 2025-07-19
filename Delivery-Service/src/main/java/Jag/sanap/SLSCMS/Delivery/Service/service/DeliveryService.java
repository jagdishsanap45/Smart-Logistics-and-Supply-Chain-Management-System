package Jag.sanap.SLSCMS.Delivery.Service.service;

import Jag.sanap.SLSCMS.Delivery.Service.entity.Delivery;
import Jag.sanap.SLSCMS.Delivery.Service.repositery.DeliveryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    @Autowired
    private DeliveryRepo deliveryRepo;

    public Delivery assignDelivery(Long orderId) {
        Delivery delivery = new Delivery();
        delivery.setOrderId(orderId);
        delivery.setStatus("Assigned");
        delivery.setAssignedDate(String.valueOf(LocalDateTime.now()));
        return deliveryRepo.save(delivery);

    }
    public Optional<Delivery> getByOrderId(Long OrderId){
        return deliveryRepo.findByOrderId(OrderId);
    }
    public List<Delivery> getAllDeliveries(){
        return deliveryRepo.findAll();
    }
    public void updateStatus(Long orderId, String status){
        Delivery delivery = deliveryRepo.findByOrderId(orderId).orElseThrow();
        delivery.setStatus(status);
        deliveryRepo.save(delivery);
    }
}
