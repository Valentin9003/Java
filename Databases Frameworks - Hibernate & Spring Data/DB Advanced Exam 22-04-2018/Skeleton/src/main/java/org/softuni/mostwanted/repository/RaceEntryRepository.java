package org.softuni.mostwanted.repository;

import org.softuni.mostwanted.model.entity.RaceEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaceEntryRepository extends JpaRepository<RaceEntry, Integer> {
}
