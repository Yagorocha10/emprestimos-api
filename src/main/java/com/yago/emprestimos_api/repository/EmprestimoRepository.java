package com.yago.emprestimos_api.repository;

import com.yago.emprestimos_api.entity.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo, Long> {
}
