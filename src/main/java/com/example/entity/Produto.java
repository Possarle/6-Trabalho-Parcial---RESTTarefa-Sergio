package com.example.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "produto")
public class Produto extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long codigo;

    public String nome;

    public BigDecimal preco;

    public Integer quantidade;

    public LocalDate validade;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    public Categoria categoria;

    @ManyToOne
    @JoinColumn(name = "fabricante_id")
    public Fabricante fabricante;
}
