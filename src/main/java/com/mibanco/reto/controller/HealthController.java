package com.mibanco.reto.controller;

import com.mibanco.reto.model.HealthResponse;
import com.mibanco.reto.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class HealthController {

    @Autowired
    private HealthService healthService;

    @GetMapping("/health")
    public ResponseEntity<HealthResponse> health() {
        HealthResponse response = healthService.getHealth();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/info")
    public ResponseEntity<String> info() {
        return ResponseEntity.ok("MiBanco DevSecOps Challenge Application v1.0.0");
    }

    @PostMapping("/validate/{id}")
    public ResponseEntity<String> validate(@PathVariable String id, @RequestParam String data) {
        if (id == null || id.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("ID is required");
        }
        
        if (data == null || data.trim().isEmpty()) {
            return ResponseEntity.badRequest().body("Data is required");
        }
        
        String result = healthService.validateData(id, data);
        return ResponseEntity.ok(result);
    }
}