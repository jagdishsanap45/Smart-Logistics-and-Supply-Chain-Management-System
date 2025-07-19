package Jag.sanap.SLSCMS.Analytics.Service.controller;

import Jag.sanap.SLSCMS.Analytics.Service.entity.EventLog;
import Jag.sanap.SLSCMS.Analytics.Service.service.AnalyticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/analytics")

public class AnalyticsController {

    @Autowired
    private AnalyticService service;

    @GetMapping
    public ResponseEntity<List<EventLog>> getAll() {
        return ResponseEntity.ok(service.getAllLogs());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<EventLog>> filter(@RequestParam String type) {
        return ResponseEntity.ok(service.getLogsByType(type));
    }
}
