# API REST - Gestión de Álbumes y Láminas

## 📋 Estructura de Rutas

### 1️⃣ CRUD de Álbumes `/api/albums`
```
POST   /api/albums                    → Crear álbum
GET    /api/albums                    → Listar todos
GET    /api/albums/{id}               → Obtener por ID
PUT    /api/albums/{id}               → Actualizar
DELETE /api/albums/{id}               → Eliminar
```

### 2️⃣ CRUD de Láminas como Usuario `/api/laminas`
**Validación automática contra catálogo + Detección de repetidas**

```
POST   /api/laminas                   → Agregar lámina (VALIDA catálogo + DETECTA REPETIDAS)
GET    /api/laminas                   → Listar todas las láminas del sistema
GET    /api/laminas/{id}              → Obtener lámina por ID
GET    /api/laminas/album/{albumId}   → Listar láminas de un álbum
PUT    /api/laminas/{id}              → Actualizar lámina
DELETE /api/laminas/{id}              → Eliminar lámina (soft delete)
```

### 3️⃣ Catálogo y Estado `/api/albums/{albumId}/catalogo`
**Administración del catálogo maestro**

```
POST   /api/albums/{albumId}/catalogo           → Crear catálogo de láminas
GET    /api/albums/{albumId}/catalogo           → Ver catálogo disponible
GET    /api/albums/{albumId}/catalogo/estado    → Ver estado (poseídas, faltantes, repetidas, totales)
```

### 4️⃣ Carga Masiva de Láminas `/api/laminas/masivo`
**Agregar múltiples láminas en una solicitud**

```
POST   /api/laminas/masivo                      → Agregar 10+ láminas (valida cada una, detecta repetidas)
```

---

