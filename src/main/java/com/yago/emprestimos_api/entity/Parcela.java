package com.yago.emprestimos_api.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "parcelas")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Parcela {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "emprestimo_id")
    private Emprestimo emprestimo;

    private Integer numeroParcela;
    private BigDecimal valor;
    private LocalDate dataVencimento;
    private boolean paga;


}
