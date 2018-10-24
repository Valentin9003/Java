package org.softuni.mostwanted.repository;

import org.softuni.mostwanted.model.entity.Town;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TownRepository extends JpaRepository<Town, Integer> {

    Town findByName(String townName);
}
