package com.projeto.supermercado_api.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "estoque_movimentacao")
@EntityListeners(AuditingEntityListener.class)
public class EstoqueMovimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, unique = true)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_movimentacao", nullable = false)
    private TipoMovimentacao tipoMovimentacao;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_evento", nullable = false)
    private TipoEvento tipoEvento;

    @Column(nullable = false)
    private Integer quantidade;

    @CreatedDate
    @Column(name = "data_movimentacao", nullable = false, updatable = false)
    private LocalDateTime dateTime;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;
}
