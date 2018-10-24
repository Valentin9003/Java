package users.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.system.entity.Country;

@Repository
public interface CountryRepo extends JpaRepository<Country, Long> {
}
