package com.nmakarov.generalservice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CalculatorJpaRepository extends JpaRepository<CalculatorEntity, Long> {
}
