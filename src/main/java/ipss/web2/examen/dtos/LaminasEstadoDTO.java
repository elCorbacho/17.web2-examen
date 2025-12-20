package ipss.web2.examen.dtos;

import java.util.List;
import java.util.Map;

public record LaminasEstadoDTO(
    List<LaminaResponseDTO> laminasPoseidas,
    List<LaminaCatalogoResponseDTO> laminasFaltantes,
    Map<String, Integer> laminasRepetidas,
    Integer totalLaminas,
    Integer laminasFaltantesTotal,
    Integer laminasRepetidastotal
) {}
