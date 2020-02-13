package ifma.lpweb2.Lab06.repository.musicas;

import ifma.lpweb2.Lab06.model.Musica;
import ifma.lpweb2.Lab06.repository.filter.MusicaFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MusicaRepositoryQuery {
    Page<Musica> filtrar(MusicaFilter filtro, Pageable pageable);
}
