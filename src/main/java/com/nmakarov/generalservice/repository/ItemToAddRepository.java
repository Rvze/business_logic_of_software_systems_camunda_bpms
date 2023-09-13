package com.nmakarov.generalservice.repository;

import com.nmakarov.generalservice.model.ItemToAdd;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemToAddRepository extends JpaRepository<ItemToAdd, Long> {
}
