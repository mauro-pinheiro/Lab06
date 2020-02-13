package ifma.lpweb2.Lab06.service;

import ifma.lpweb2.Lab06.model.Album;
import ifma.lpweb2.Lab06.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumService {
    private final AlbumRepository albumRepository;

    private final GenericService<Album> genericService;

    @Autowired
    public AlbumService(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
        genericService = new GenericService<>(albumRepository);
    }

    @Transactional(readOnly = true)
    public Optional<Album> buscaPor(String nome){
        return Optional.ofNullable(albumRepository.findByNome(nome));
    }

    @Transactional
    public Album salva(Album entity) {
        return genericService.salva(entity);
    }

    @Transactional(readOnly = true)
    public List<Album> todos() {
        return genericService.todos();
    }

    @Transactional
    public Album atualiza(Integer id, Album entity) {
        return genericService.atualiza(entity, id);
    }

    @Transactional(readOnly = true)
    public Album buscaPor(Integer id) {
        return genericService.buscaPor(id);
    }

    @Transactional
    public void excluirPor(Integer id) {
        genericService.excluirPor(id);
    }
}
