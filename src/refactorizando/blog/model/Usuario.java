package refactorizando.blog.model;

import lombok.Data;

import java.math.BigDecimal;
import java.util.UUID;

@Data
public class Usuario {
    private UUID id;
    private String nombreUsuario;
    private String apellidoPaterno;
    private BigDecimal balance;
}
