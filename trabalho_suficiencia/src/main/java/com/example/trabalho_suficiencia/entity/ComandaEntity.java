package com.example.trabalho_suficiencia.entity;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@NoArgsConstructor
@Table(name = "comandas")
public class ComandaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, columnDefinition = "INT(11)")
    private Long id;

    @Column(name = "id_usuario")
    private Long idUsuario;

    @Column(name = "nome")
    private String nomeUsuario;

    @Column(name = "telefone")
    private String telefoneUsuario;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comanda", nullable = false)
    private List<ProdutoComandaEntity> produtos = new ArrayList<>(0);

    public void setIdUsuario(Long idUsuario) {
        if (idUsuario == null) {
            throw new IllegalArgumentException("O id do usuário não pode ser nulo");
        } else {
            this.idUsuario = idUsuario;
        }
    }

    public void setNomeUsuario(String nomeUsuario) {
        if (nomeUsuario == null) {
            throw new IllegalArgumentException("O nome do usuário não pode ser nulo");
        } else {
            this.nomeUsuario = nomeUsuario;
        }
    }

    public void setTelefoneUsuario(String telefoneUsuario) {
        if (telefoneUsuario == null) {
            throw new IllegalArgumentException("O telefone do usuário não pode ser nulo");
        } else {
            this.telefoneUsuario = telefoneUsuario;
        }
    }

    public void setProdutos(List<ProdutoComandaEntity> produtos) {
        if (produtos.isEmpty()) {
            throw new IllegalArgumentException("A lista de produtos não pode ser nula");
        } else {
            this.produtos = produtos;
        }
    }
}

