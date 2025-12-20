

## 🔴 CRÍTICO - Pendiente (65 min)

### 1. SEGURIDAD: Contraseña Expuesta ⚠️ URGENTE

- **Archivo:** `src/main/resources/application.properties` línea 6
- **Estado:** ❌ `spring.datasource.password=totoralillo12..` hardcodeada
- **Acción:** Cambiar a `${DB_PASSWORD:defaultpassword}`
- **Tiempo:** 5 minutos
- **Impacto:** 🚨 Vulnerabilidad crítica de seguridad

**Solución:**
```properties
# ANTES
spring.datasource.password=totoralillo12..

# DESPUÉS
spring.datasource.password=${DB_PASSWORD:defaultpassword}
```

**Pasos:**
1. Editar `application.properties`
2. Crear variable de entorno: `DB_PASSWORD=nueva_contraseña`
3. Reiniciar aplicación

---

### 2. Tests Unitarios 🧪

- **Archivo a crear:** `src/test/java/ipss/web2/examen/services/AlbumServiceTest.java`
- **Estado:** ❌ No existe
- **Contenido:** 5 tests (crear, obtener, excepción, actualizar, eliminar)
- **Tiempo:** 30 minutos
- **Impacto:** +3 puntos

**Ejecutar:**
```bash
.\mvnw.cmd test -Dtest=AlbumServiceTest
```

---

### 3. Tests de Integración 🧪

- **Archivo a crear:** `src/test/java/ipss/web2/examen/controllers/AlbumControllerIntegrationTest.java`
- **Estado:** ❌ No existe
- **Contenido:** 4 tests (crear API, listar, 404, validaciones)
- **Tiempo:** 30 minutos
- **Impacto:** +2 puntos

**Ejecutar:**
```bash
.\mvnw.cmd test
```

---

## 🟡 MENOR - Opcional

### 4. Propiedad Deprecada ⚠️

- **Archivo:** `application.properties` línea 29
- **Estado:** ⚠️ Warning de propiedad deprecada (no bloquea)
- **Propiedad:** `spring.mvc.throw-exception-if-no-handler-found=true`
- **Acción:** ✅ No existe en tu archivo - ya está correcto

---

## 📊 Resumen de Impacto

| Tarea | Tiempo | Impacto | Prioridad |
|-------|--------|---------|-----------|
| 1. Seguridad | 5 min | 🔴 Crítico | URGENTE |
| 2. Tests Unitarios | 30 min | +3 puntos | Alta |
| 3. Tests Integración | 30 min | +2 puntos | Alta |
| 4. Propiedad deprecada | - | ✅ OK | - |
| **TOTAL** | **65 min** | **+5 pts** | |

---

## ✅ Checklist de Ejecución

- [ ] Remover contraseña del código
- [ ] Crear `AlbumServiceTest.java`
- [ ] Crear `AlbumControllerIntegrationTest.java`
- [ ] Ejecutar `.\mvnw.cmd test`
- [ ] Verificar que pasen todos los tests

---
