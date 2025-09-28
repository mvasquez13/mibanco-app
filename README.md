# MiBanco Demo Application

Este repositorio contiene una aplicación demo que consume las acciones compartidas de DevSecOps de MiBanco.

## 🎯 Propósito

Esta aplicación demuestra:
- Uso de actions reutilizables para CI/CD
- Integración de análisis de seguridad (SAST/SCA/DAST)
- Best practices de desarrollo seguro
- Deployment automatizado a Kubernetes

## 🏗️ Arquitectura

La aplicación utiliza:
- **Spring Boot 3.1.5** con Java 17
- **Maven 3.9** como build tool
- **Docker** para containerización
- **Kubernetes** para deployment
- **Actions compartidas** para DevSecOps pipeline

## 🛠️ Desarrollo Local

### Prerrequisitos
- Java 17+
- Maven 3.8+
- Docker
- kubectl

### Comandos Rápidos

```bash
# Build y test
mvn clean test

# Ejecutar aplicación
mvn spring-boot:run

# Build Docker image
docker build -t mibanco-demo .

# Ejecutar con Docker
docker run -p 8080:8080 mibanco-demo
```

## 📝 Endpoints Disponibles

- `GET /` - Página principal
- `GET /health` - Health check
- `GET /actuator/health` - Spring Boot actuator health
- `GET /actuator/metrics` - Métricas de la aplicación

## 🔧 Configuración

La aplicación se configura mediante:
- `application.yml` - Configuración base
- `application-prod.yml` - Configuración productiva
- Variables de entorno para secrets

## 🎯 Objetivos de Calidad

Esta aplicación mantiene:
- **Coverage** > 80%
- **Security Score** > 85/100
- **Build Success Rate** > 95%
- **Deployment Time** < 10 min