package com.mibanco.reto.service;

import com.mibanco.reto.model.HealthResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HealthServiceTest {

    @InjectMocks
    private HealthService healthService;

    @BeforeEach
    void setUp() {
        healthService = new HealthService();
    }

    @Test
    void testGetHealth_ShouldReturnHealthResponse() {
        // When
        HealthResponse response = healthService.getHealth();

        // Then
        assertNotNull(response);
        assertEquals("UP", response.getStatus());
        assertNotNull(response.getTimestamp());
        assertTrue(response.getUptime() > 0);
    }

    @Test
    void testValidateData_WithValidData_ShouldReturnSuccessMessage() {
        // Given
        String id = "test123";
        String data = "validData";

        // When
        String result = healthService.validateData(id, data);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("Data validated successfully"));
        assertTrue(result.contains(id));
        assertTrue(result.contains(String.valueOf(data.length())));
    }

    @Test
    void testValidateData_WithShortData_ShouldThrowException() {
        // Given
        String id = "test123";
        String data = "ab"; // Solo 2 caracteres

        // When & Then
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> healthService.validateData(id, data)
        );
        assertEquals("Data must be at least 3 characters long", exception.getMessage());
    }

    @Test
    void testValidateData_WithInvalidContent_ShouldThrowException() {
        // Given
        String id = "test123";
        String data = "invalidData";

        // When & Then
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class, 
            () -> healthService.validateData(id, data)
        );
        assertEquals("Data contains invalid content", exception.getMessage());
    }

    @Test
    void testValidateData_WithMinimumValidLength_ShouldSucceed() {
        // Given
        String id = "test123";
        String data = "abc"; // Exactamente 3 caracteres

        // When
        String result = healthService.validateData(id, data);

        // Then
        assertNotNull(result);
        assertTrue(result.contains("Data validated successfully"));
    }
}