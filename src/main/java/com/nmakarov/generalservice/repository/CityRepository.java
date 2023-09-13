package com.nmakarov.generalservice.repository;

import com.nmakarov.generalservice.model.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    Optional<City> findByName(String name);

    List<City> findAllByNameIn(List<String> name);
}
