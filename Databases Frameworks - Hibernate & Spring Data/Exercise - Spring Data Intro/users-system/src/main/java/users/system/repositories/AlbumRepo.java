package users.system.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import users.system.entity.Album;
import users.system.entity.Country;

@Repository
public interface AlbumRepo extends JpaRepository<Album, Long> {
}
