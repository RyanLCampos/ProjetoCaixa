package com.projeto.supermercado_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "item_venda")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class ItemVenda {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "venda_id", nullable = false)
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Column(nullable = false)
    private Integer quantidade;

    @Column(name = "preco_unitario", nullable = false)
    private BigDecimal precoUnitario;

    @Transient
    private BigDecimal subtotal;

    @CreatedDate
    @Column(name = "data_cadastro")
    private LocalDateTime dataCadastro;

    public BigDecimal calcularSubtotal(){
        return precoUnitario.multiply(new BigDecimal(quantidade));
    }

    public void atualizarSubtotal(){
        this.subtotal = calcularSubtotal();
    }

    @PrePersist
    @PreUpdate
    public void beforeSave(){
        atualizarSubtotal();
    }
}
