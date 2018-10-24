package users.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.system.entity.Country;
import users.system.entity.Town;

@Repository
public interface TownRepo extends JpaRepository<Town, Long> {
}
