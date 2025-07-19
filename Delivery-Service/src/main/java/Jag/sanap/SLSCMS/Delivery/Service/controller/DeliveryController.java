package Jag.sanap.SLSCMS.Delivery.Service.controller;


import Jag.sanap.SLSCMS.Delivery.Service.entity.Delivery;
import Jag.sanap.SLSCMS.Delivery.Service.service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/deliveries")
public class DeliveryController {

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/{orderId}")
    public ResponseEntity<Delivery> getByOrderId(@PathVariable Long orderId) {
        return ResponseEntity.of(deliveryService.getByOrderId(orderId));
    }

    @PutMapping("/{orderId}/status")
    public ResponseEntity<Void> updateStatus(@PathVariable Long orderId, @RequestParam String status) {
        deliveryService.updateStatus(orderId, status);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Delivery>> getAll() {
        return ResponseEntity.ok(deliveryService.getAllDeliveries());
    }
}
