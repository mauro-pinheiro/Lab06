package ifma.lpweb2.Lab06.repository;

import ifma.lpweb2.Lab06.model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepositorio extends JpaRepository<Artista, Integer> {
    Artista buscaPor(String nome);
}
