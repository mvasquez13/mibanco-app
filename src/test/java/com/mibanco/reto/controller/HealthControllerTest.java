package com.mibanco.reto.controller;

import com.mibanco.reto.service.HealthService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import com.mibanco.reto.model.HealthResponse;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HealthControllerTest {

    @Mock
    private HealthService healthService;

    @InjectMocks
    private HealthController healthController;

    @BeforeEach
    void setUp() {
        // Setup común para los tests
    }

    @Test
    void testHealth_ShouldReturnHealthResponse() {
        // Given
        HealthResponse mockResponse = new HealthResponse();
        mockResponse.setStatus("UP");
        when(healthService.getHealth()).thenReturn(mockResponse);

        // When
        ResponseEntity<HealthResponse> response = healthController.health();

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("UP", response.getBody().getStatus());
        verify(healthService, times(1)).getHealth();
    }

    @Test
    void testInfo_ShouldReturnApplicationInfo() {
        // When
        ResponseEntity<String> response = healthController.info();

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertTrue(response.getBody().contains("MiBanco DevSecOps"));
    }

    @Test
    void testValidate_WithValidData_ShouldReturnSuccess() {
        // Given
        String id = "test123";
        String data = "validData";
        String expectedResult = "Data validated successfully";
        when(healthService.validateData(id, data)).thenReturn(expectedResult);

        // When
        ResponseEntity<String> response = healthController.validate(id, data);

        // Then
        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals(expectedResult, response.getBody());
        verify(healthService, times(1)).validateData(id, data);
    }

    @Test
    void testValidate_WithEmptyId_ShouldReturnBadRequest() {
        // Given
        String id = "";
        String data = "validData";

        // When
        ResponseEntity<String> response = healthController.validate(id, data);

        // Then
        assertNotNull(response);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("ID is required", response.getBody());
        verify(healthService, never()).validateData(anyString(), anyString());
    }

    @Test
    void testValidate_WithNullData_ShouldReturnBadRequest() {
        // Given
        String id = "test123";
        String data = null;

        // When
        ResponseEntity<String> response = healthController.validate(id, data);

        // Then
        assertNotNull(response);
        assertEquals(400, response.getStatusCodeValue());
        assertEquals("Data is required", response.getBody());
        verify(healthService, never()).validateData(anyString(), anyString());
    }
}