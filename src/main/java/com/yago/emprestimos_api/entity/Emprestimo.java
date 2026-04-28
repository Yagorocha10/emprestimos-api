package com.yago.emprestimos_api.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "emprestimos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Emprestimo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "modalidade_id")
    private ModalidadeEmprestimo modalidadeEmprestimo;

    private BigDecimal valor;

    private Integer numeroParcelas;

    private LocalDate dataEmprestimo;

    @Enumerated(EnumType.STRING)
    private StatusEmprestimo statusEmprestimo;









}
