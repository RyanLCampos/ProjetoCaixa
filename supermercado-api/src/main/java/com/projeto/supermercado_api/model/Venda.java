package com.projeto.supermercado_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "venda")
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class Venda {

    @Id
    @Column(nullable = false, unique = true)
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;

    @CreatedDate
    @Column(name = "data_venda", updatable = false, nullable = false)
    private LocalDateTime dataVenda;

    @Column(name = "tipo_pagamento", nullable = false)
    private String tipoPagamento;
}
