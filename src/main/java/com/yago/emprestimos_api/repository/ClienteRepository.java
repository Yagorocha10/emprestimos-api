package com.yago.emprestimos_api.repository;

import com.yago.emprestimos_api.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
