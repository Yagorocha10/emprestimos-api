package com.yago.emprestimos_api.service;

import com.yago.emprestimos_api.entity.*;
import com.yago.emprestimos_api.repository.ClienteRepository;
import com.yago.emprestimos_api.repository.EmprestimoRepository;
import com.yago.emprestimos_api.repository.ModalidadeRepository;
import com.yago.emprestimos_api.repository.ParcelaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

@Service
public class EmprestimoService {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    ModalidadeRepository modalidadeRepository;

    @Autowired
    ParcelaRepository parcelaRepository;

    public void criarEmprestimo(Long clienteId, Long modalidadeId, BigDecimal valor, Integer numeroParcelas) {

     var cliente = clienteRepository.findById(clienteId)
             .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));

     var modalidade = modalidadeRepository.findById(modalidadeId)
             .orElseThrow(() -> new RuntimeException("Modalidade de empréstimo não encontrada"));


     var emprestimo = new Emprestimo(
             null,
             cliente,
             modalidade,
             valor,
             numeroParcelas,
             LocalDate.now(),
             StatusEmprestimo.ATIVO
     );

     emprestimoRepository.save(emprestimo);

     var taxaDeJuros = modalidade.getTaxaJuros();

     var valorComJuros = valor.add(valor.multiply(taxaDeJuros));

     var valorParcela = valorComJuros.divide(BigDecimal.valueOf(numeroParcelas), RoundingMode.HALF_UP);

     for (int i = 1; i<= numeroParcelas; i++) {

         var parcela = new Parcela(
                 null,
                 emprestimo,
                 i,
                 valorParcela,
                 LocalDate.now().plusMonths(1),
                 false
         );

         parcelaRepository.save(parcela);


     }













    }




}
