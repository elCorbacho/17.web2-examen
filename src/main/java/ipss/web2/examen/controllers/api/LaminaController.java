package ipss.web2.examen.controllers.api;

import ipss.web2.examen.dtos.LaminaRequestDTO;
import ipss.web2.examen.dtos.LaminaResponseDTO;
import ipss.web2.examen.models.Album;
import ipss.web2.examen.services.LaminaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestión de Láminas
 * Endpoints: /api/laminas
 */
@RestController
@RequestMapping("/api/laminas")
@RequiredArgsConstructor
public class LaminaController {
    
    private final LaminaService laminaService;
    
    /**
     * POST /api/laminas - Crear una nueva lámina
     * 
     * @param requestDTO DTO con los datos de la lámina a crear
     * @return ResponseEntity con la lámina creada (201 CREATED)
     */
    @PostMapping
    public ResponseEntity<LaminaResponseDTO> crearLamina(@Valid @RequestBody LaminaRequestDTO requestDTO) {
        // Simular búsqueda de album (en producción, usar AlbumRepository)
        Album album = new Album();
        album.setId(requestDTO.getAlbumId());
        
        LaminaResponseDTO response = laminaService.crearLamina(requestDTO, album);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    /**
     * GET /api/laminas/{id} - Obtener lámina por ID
     * 
     * @param id ID de la lámina a recuperar
     * @return ResponseEntity con la lámina encontrada (200 OK)
     */
    @GetMapping("/{id}")
    public ResponseEntity<LaminaResponseDTO> obtenerLaminaPorId(@PathVariable Long id) {
        LaminaResponseDTO response = laminaService.obtenerLaminaPorId(id);
        return ResponseEntity.ok(response);
    }
    
    /**
     * GET /api/laminas - Obtener todas las láminas activas
     * 
     * @return ResponseEntity con lista de láminas (200 OK)
     */
    @GetMapping
    public ResponseEntity<List<LaminaResponseDTO>> obtenerTodasLasLaminas() {
        List<LaminaResponseDTO> laminas = laminaService.obtenerTodasLasLaminas();
        return ResponseEntity.ok(laminas);
    }
    
    /**
     * GET /api/laminas/album/{albumId} - Obtener láminas por album
     * 
     * @param albumId ID del album
     * @return ResponseEntity con lista de láminas del album (200 OK)
     */
    @GetMapping("/album/{albumId}")
    public ResponseEntity<List<LaminaResponseDTO>> obtenerLaminasPorAlbum(@PathVariable Long albumId) {
        List<LaminaResponseDTO> laminas = laminaService.obtenerLaminasPorAlbum(albumId);
        return ResponseEntity.ok(laminas);
    }
    
    /**
     * PUT /api/laminas/{id} - Actualizar una lámina existente
     * 
     * @param id ID de la lámina a actualizar
     * @param requestDTO DTO con los nuevos datos de la lámina
     * @return ResponseEntity con la lámina actualizada (200 OK)
     */
    @PutMapping("/{id}")
    public ResponseEntity<LaminaResponseDTO> actualizarLamina(
            @PathVariable Long id,
            @Valid @RequestBody LaminaRequestDTO requestDTO) {
        // Simular búsqueda de album (en producción, usar AlbumRepository)
        Album album = new Album();
        album.setId(requestDTO.getAlbumId());
        
        LaminaResponseDTO response = laminaService.actualizarLamina(id, requestDTO, album);
        return ResponseEntity.ok(response);
    }
    
    /**
     * DELETE /api/laminas/{id} - Eliminar una lámina (soft delete)
     * Marca la lámina como inactiva sin borrar los datos de la BD
     * 
     * @param id ID de la lámina a eliminar
     * @return ResponseEntity vacío (204 NO CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarLamina(@PathVariable Long id) {
        laminaService.eliminarLamina(id);
        return ResponseEntity.noContent().build();
    }
}
