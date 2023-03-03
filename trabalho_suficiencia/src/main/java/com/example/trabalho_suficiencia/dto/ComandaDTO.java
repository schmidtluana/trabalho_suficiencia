package com.example.trabalho_suficiencia.dto;
import com.example.trabalho_suficiencia.entity.ComandaEntity;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ComandaDTO {
    private Long id;

    @NotNull(message = "O id do usuário não pode ser nulo.")
    private Long idUsuario;

    @NotBlank(message = "O nome não pode estar em branco.")
    private String nomeUsuario;

    @NotBlank(message = "O nome não pode estar em branco.")
    private String telefoneUsuario;

    public ComandaDTO(ComandaEntity comandaEntity) {
        this.id = comandaEntity.getId();
        this.idUsuario = comandaEntity.getIdUsuario();
        this.nomeUsuario = comandaEntity.getNomeUsuario();
        this.telefoneUsuario = comandaEntity.getTelefoneUsuario();
    }
}
