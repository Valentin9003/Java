package org.softuni.mostwanted.repository;

import org.softuni.mostwanted.model.entity.Race;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceRepository extends JpaRepository<Race, Integer> {

}
