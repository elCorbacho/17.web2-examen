package ipss.web2.examen.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * DTO básico de Album para relaciones
 * Evita serialización circular
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AlbumBasicResponseDTO {
    
    private Long id;
    private String nombre;
    private Integer year;
}
