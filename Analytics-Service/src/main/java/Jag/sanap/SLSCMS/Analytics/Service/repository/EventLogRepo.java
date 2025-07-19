package Jag.sanap.SLSCMS.Analytics.Service.repository;


import Jag.sanap.SLSCMS.Analytics.Service.entity.EventLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventLogRepo extends JpaRepository<EventLog, Long> {

    // Custom query methods can be defined here if needed
    // For example, to find logs by event type:
    List<EventLog> findByEventType(String eventType);
}
