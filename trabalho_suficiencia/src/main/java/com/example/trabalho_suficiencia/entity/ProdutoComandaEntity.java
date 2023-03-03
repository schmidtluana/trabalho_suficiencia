package com.example.trabalho_suficiencia.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Entity
@Data
@Table(name = "produtos_comanda")
public class ProdutoComandaEntity {
    @Id
    @Column(name = "id", nullable = false, columnDefinition = "INT(11)")
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "preco", nullable = false)
    private String preco;

    public void setId(Long id) {
        if(id == null) {
            throw new IllegalArgumentException("O id do produto não pode ser nulo");
        } else {
            this.id = id;
        }
    }

    public void setNome(String nome) {
        if(nome == null) {
            throw new IllegalArgumentException("O nome do produto não pode ser nulo");
        } else {
            this.nome = nome;
        }
    }

    public void setPreco(String preco) {
        if(preco == null) {
            throw new IllegalArgumentException("O preço do produto não pode ser nulo");
        } else {
            this.preco = preco;
        }
    }
}