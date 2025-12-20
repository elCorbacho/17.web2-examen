package ipss.web2.examen.dtos;

public record LaminaCargueMasivoResponseDTO(
    Long laminaId,
    String nombre,
    Boolean esRepetida,
    Integer cantidadRepetidas,
    Boolean estaEnCatalogo,
    String estado
) {}
