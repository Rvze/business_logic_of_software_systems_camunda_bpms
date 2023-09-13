package com.nmakarov.generalservice.repository;

import com.nmakarov.generalservice.model.Stash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StashJpaRepository extends JpaRepository<Stash, Long> {
    Stash findByUsername(String username);
}
