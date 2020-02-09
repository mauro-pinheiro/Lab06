package ifma.lpweb2.Lab06.service;

import ifma.lpweb2.Lab06.model.Artista;
import ifma.lpweb2.Lab06.repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService {
    private ArtistaRepository artistaRepository;
    private final GenericService<Artista> genericService;

    @Autowired
    public ArtistaService(ArtistaRepository artistaRepository) {
        this.artistaRepository = artistaRepository;
        genericService = new GenericService<>(artistaRepository);
    }

    @Transactional(readOnly = true)
    public Optional<Artista> buscaPor(String nome){
        return Optional.ofNullable(artistaRepository.buscaPor(nome));
    }

    @Transactional
    public Artista salva(Artista entity) {
        return genericService.salva(entity);
    }

    @Transactional(readOnly = true)
    public List<Artista> todos() {
        return genericService.todos();
    }

    @Transactional
    public Artista atualiza(Integer id, Artista entity) {
        return genericService.atualiza(entity, id);
    }

    @Transactional(readOnly = true)
    public Artista buscaPor(Integer id) {
        return genericService.buscaPor(id);
    }

    @Transactional
    public void excluirPor(Integer id) {
        genericService.excluirPor(id);
    }
}
