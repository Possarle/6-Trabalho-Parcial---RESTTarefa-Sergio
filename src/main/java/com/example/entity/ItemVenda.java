package com.example.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "item_venda")
public class ItemVenda extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long codigo;

    public BigDecimal valorParcial;

    public Integer quantidadeParcial;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    public Produto produto;

    @ManyToOne
    @JoinColumn(name = "venda_id")
    public Venda venda;
}
