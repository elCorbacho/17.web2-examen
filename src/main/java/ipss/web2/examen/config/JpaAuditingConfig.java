package ipss.web2.examen.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Configuración para habilitar auditoría automática en entidades JPA
 * Permite que @CreatedDate y @LastModifiedDate se generen automáticamente
 */
@Configuration
@EnableJpaAuditing
public class JpaAuditingConfig {
    // Habilita auditoría automática para @CreatedDate y @LastModifiedDate
}
