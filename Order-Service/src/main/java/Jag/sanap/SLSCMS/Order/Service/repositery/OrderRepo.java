package Jag.sanap.SLSCMS.Order.Service.repositery;

import Jag.sanap.SLSCMS.Order.Service.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
