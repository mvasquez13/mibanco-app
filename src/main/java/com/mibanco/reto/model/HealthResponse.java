package com.mibanco.reto.model;

import java.time.LocalDateTime;

public class HealthResponse {
    private String status;
    private LocalDateTime timestamp;
    private long uptime;

    public HealthResponse() {
    }

    public HealthResponse(String status, LocalDateTime timestamp, long uptime) {
        this.status = status;
        this.timestamp = timestamp;
        this.uptime = uptime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public long getUptime() {
        return uptime;
    }

    public void setUptime(long uptime) {
        this.uptime = uptime;
    }
}