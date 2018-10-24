package org.softuni.mostwanted.repository;

import org.softuni.mostwanted.model.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    @Query("SELECT c FROM Car c WHERE c.brand = :brand AND c.model = :model AND c.yearOfProduction = :year")
    Car findByBrandAndModelAndYearOfProduction(@Param("brand") String brand,
                                               @Param("model") String model,
                                               @Param("year") Integer yearOfProduction);

    Car findById(Integer id);
}
