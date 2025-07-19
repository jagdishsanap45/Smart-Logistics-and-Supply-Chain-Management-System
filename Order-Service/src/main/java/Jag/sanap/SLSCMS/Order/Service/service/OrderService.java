package Jag.sanap.SLSCMS.Order.Service.service;


import Jag.sanap.SLSCMS.Order.Service.configuration.InventoryClient;
import Jag.sanap.SLSCMS.Order.Service.entity.Order;
import Jag.sanap.SLSCMS.Order.Service.repositery.OrderRepo;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    @Autowired
    private  OrderRepo orderRepo;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private InventoryClient inventoryClient;


    public Order placeOrder(Long productId, int quantity){
        boolean available = inventoryClient.checkStock(productId);

        if (!available) {
            throw new RuntimeException("Product not available in stock");
        }

        Order order = new Order();
        order.setProductId(productId);
        order.setQuantity(quantity);
        order.setStatus("PLACED");
        order.setOrderDate(LocalDateTime.now());

        Order saved =orderRepo.save(order);

       //kafkaTemplate.send("order-topic", "Order placed with ID: " + saved.getId());
        try {
            kafkaTemplate.send("order-events", "Order Placed: " + saved.getId());
        } catch (Exception e) {
            System.out.println("Kafka error: " + e.getMessage());
        }


        return saved;
    }

    public Order getOrder(Long id) {
        return  orderRepo.findById(id).orElseThrow();
    }

    public List<Order> getAllOrders() {
        // Fetch all orders from the database
        return orderRepo.findAll();
    }
}
