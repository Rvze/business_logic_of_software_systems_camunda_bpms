package com.nmakarov.generalservice.repository;

import com.nmakarov.generalservice.model.Distance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistanceRepository extends JpaRepository<Distance, Long> {
}
