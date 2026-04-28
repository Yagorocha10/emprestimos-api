package com.yago.emprestimos_api.repository;

import com.yago.emprestimos_api.entity.ModalidadeEmprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModalidadeRepository extends JpaRepository<ModalidadeEmprestimo, Long> {
}
