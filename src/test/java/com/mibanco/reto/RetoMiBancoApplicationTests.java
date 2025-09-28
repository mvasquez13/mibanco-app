package com.mibanco.reto;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")
class RetoMiBancoApplicationTests {

    @Test
    void contextLoads() {
        // Test que verifica que el contexto de Spring Boot se carga correctamente
    }
}