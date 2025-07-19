package Jag.sanap.SLSCMS.Vendor.Service.repositery;

import Jag.sanap.SLSCMS.Vendor.Service.entity.Vendor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepo extends JpaRepository<Vendor, Long> {

}
