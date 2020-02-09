package ifma.lpweb2.Lab06.service;

import ifma.lpweb2.Lab06.model.Musica;
import ifma.lpweb2.Lab06.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class MusicaService {
    private final MusicaRepository musicaRepository;

    private final GenericService<Musica> genericService;

    @Autowired
    public MusicaService(MusicaRepository musicaRepository) {
        this.musicaRepository = musicaRepository;
        genericService = new GenericService<>(musicaRepository);
    }


    @Transactional(readOnly = true)
    public Optional<Musica> buscaPor(String nome){
        return Optional.ofNullable(musicaRepository.buscaPor(nome));
    }

    @Transactional
    public Musica salva(Musica entity) {
        return genericService.salva(entity);
    }

    @Transactional(readOnly = true)
    public List<Musica> todos() {
        return genericService.todos();
    }

    @Transactional
    public Musica atualiza(Integer id, Musica entity) {
        return genericService.atualiza(entity, id);
    }

    @Transactional(readOnly = true)
    public Musica buscaPor(Integer id) {
        return genericService.buscaPor(id);
    }

    @Transactional
    public void excluirPor(Integer id) {
        genericService.excluirPor(id);
    }
}
