package ipss.web2.examen.controllers.api;

import ipss.web2.examen.dtos.AlbumRequestDTO;
import ipss.web2.examen.dtos.AlbumResponseDTO;
import ipss.web2.examen.services.AlbumService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestión de Albums
 * Endpoints: /api/albums
 */
@RestController
@RequestMapping("/api/albums")
@RequiredArgsConstructor
public class AlbumController {
    
    private final AlbumService albumService;
    
    /**
     * POST /api/albums - Crear un nuevo album
     * 
     * @param requestDTO DTO con los datos del album a crear
     * @return ResponseEntity con el album creado (201 CREATED)
     */
    @PostMapping
    public ResponseEntity<AlbumResponseDTO> crearAlbum(@Valid @RequestBody AlbumRequestDTO requestDTO) {
        AlbumResponseDTO response = albumService.crearAlbum(requestDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    
    /**
     * GET /api/albums/{id} - Obtener album por ID
     * 
     * @param id ID del album a recuperar
     * @return ResponseEntity con el album encontrado (200 OK)
     */
    @GetMapping("/{id}")
    public ResponseEntity<AlbumResponseDTO> obtenerAlbumPorId(@PathVariable Long id) {
        AlbumResponseDTO response = albumService.obtenerAlbumPorId(id);
        return ResponseEntity.ok(response);
    }
    
    /**
     * GET /api/albums - Obtener todos los albums activos
     * 
     * @return ResponseEntity con lista de albums (200 OK)
     */
    @GetMapping
    public ResponseEntity<List<AlbumResponseDTO>> obtenerTodosLosAlbums() {
        List<AlbumResponseDTO> albums = albumService.obtenerTodosLosAlbums();
        return ResponseEntity.ok(albums);
    }
    
    /**
     * PUT /api/albums/{id} - Actualizar un album existente
     * 
     * @param id ID del album a actualizar
     * @param requestDTO DTO con los nuevos datos del album
     * @return ResponseEntity con el album actualizado (200 OK)
     */
    @PutMapping("/{id}")
    public ResponseEntity<AlbumResponseDTO> actualizarAlbum(
            @PathVariable Long id,
            @Valid @RequestBody AlbumRequestDTO requestDTO) {
        AlbumResponseDTO response = albumService.actualizarAlbum(id, requestDTO);
        return ResponseEntity.ok(response);
    }
    
    /**
     * DELETE /api/albums/{id} - Eliminar un album (soft delete)
     * Marca el album como inactivo sin borrar los datos de la BD
     * 
     * @param id ID del album a eliminar
     * @return ResponseEntity vacío (204 NO CONTENT)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAlbum(@PathVariable Long id) {
        albumService.eliminarAlbum(id);
        return ResponseEntity.noContent().build();
    }
}
