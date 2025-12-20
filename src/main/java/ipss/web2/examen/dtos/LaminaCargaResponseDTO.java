package ipss.web2.examen.dtos;

public record LaminaCargaResponseDTO(
    Boolean esRepetida,
    Boolean estaEnCatalogo,
    Integer cantidadRepetidas,
    LaminaResponseDTO lamina
) {}
