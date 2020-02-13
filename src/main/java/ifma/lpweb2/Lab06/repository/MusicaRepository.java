package ifma.lpweb2.Lab06.repository;

import ifma.lpweb2.Lab06.model.Musica;
import ifma.lpweb2.Lab06.repository.musicas.MusicaRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Integer>, MusicaRepositoryQuery {
    Musica findByNome(String nome);
}
