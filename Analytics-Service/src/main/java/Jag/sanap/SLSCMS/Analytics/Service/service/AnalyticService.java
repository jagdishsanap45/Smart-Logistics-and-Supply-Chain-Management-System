package Jag.sanap.SLSCMS.Analytics.Service.service;


import Jag.sanap.SLSCMS.Analytics.Service.entity.EventLog;
import Jag.sanap.SLSCMS.Analytics.Service.repository.EventLogRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AnalyticService {

    @Autowired
    private EventLogRepo repository;

        public void saveEvent(String type, String message) {
            EventLog log = new EventLog();
            log.setEventType(type);
            log.setMessage(message);
            log.setTimestamp(LocalDateTime.now());
            repository.save(log);
        }

        public List<EventLog> getAllLogs() {
            return repository.findAll();
        }

        public List<EventLog> getLogsByType(String type) {
            return repository.findByEventType(type);
        }


}
