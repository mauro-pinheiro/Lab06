package ifma.lpweb2.Lab06.repository;

import ifma.lpweb2.Lab06.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Integer> {
    Album buscaPor(String nome);
}
