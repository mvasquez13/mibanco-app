package com.mibanco.reto.service;

import com.mibanco.reto.model.HealthResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class HealthService {

    public HealthResponse getHealth() {
        HealthResponse response = new HealthResponse();
        response.setStatus("UP");
        response.setTimestamp(LocalDateTime.now());
        response.setUptime(getUptime());
        return response;
    }

    public String validateData(String id, String data) {
        // Simulación de validación de datos
        if (data.length() < 3) {
            throw new IllegalArgumentException("Data must be at least 3 characters long");
        }
        
        if (data.contains("invalid")) {
            throw new IllegalArgumentException("Data contains invalid content");
        }
        
        return String.format("Data validated successfully for ID: %s, Data length: %d", 
                           id, data.length());
    }

    private long getUptime() {
        // Simulación de uptime
        return ThreadLocalRandom.current().nextLong(1000, 10000);
    }
}