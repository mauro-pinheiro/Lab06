package ifma.lpweb2.Lab06.repository;

import ifma.lpweb2.Lab06.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepositorio extends JpaRepository<Musica, Integer> {
    Musica buscaPor(String nome);
}
