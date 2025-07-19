package Jag.sanap.SLSCMS.Order.Service.configuration;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.cloud.openfeign.FeignClient;
//import org.springframework.cloud.openfeign.EnableFeignClients;
@Component
@FeignClient(name = "inventory-service", url = "${inventory.service.url}")
public interface InventoryClient {
    @GetMapping("/stock/{id}")
    Boolean checkStock(@PathVariable("id") Long productId);
}
