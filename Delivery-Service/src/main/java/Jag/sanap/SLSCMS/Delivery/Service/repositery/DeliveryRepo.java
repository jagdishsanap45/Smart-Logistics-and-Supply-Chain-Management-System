package Jag.sanap.SLSCMS.Delivery.Service.repositery;

import Jag.sanap.SLSCMS.Delivery.Service.entity.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DeliveryRepo extends JpaRepository <Delivery, Long> {

    Optional<Delivery> findByOrderId(Long orderId);
}
