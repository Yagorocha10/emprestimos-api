package com.yago.emprestimos_api.repository;

import com.yago.emprestimos_api.entity.Parcela;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelaRepository extends JpaRepository<Parcela, Long> {
}
