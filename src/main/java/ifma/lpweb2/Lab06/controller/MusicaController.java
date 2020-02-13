package ifma.lpweb2.Lab06.controller;

import ifma.lpweb2.Lab06.controller.respose.Resposta;
import ifma.lpweb2.Lab06.model.Musica;
import ifma.lpweb2.Lab06.repository.filter.MusicaFilter;
import ifma.lpweb2.Lab06.service.MusicaService;
import ifma.lpweb2.Lab06.controller.event.HeaderLocationEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/musicas")
public class MusicaController {
    @Autowired
    private ApplicationEventPublisher publisher;

    private MusicaService musicaService;

    @Autowired
    public MusicaController(MusicaService musicaService){
        this.musicaService = musicaService;
    }

    @GetMapping
    public Resposta<Page<Musica>> busca(MusicaFilter filtro, Pageable page  ) {

        Page<Musica> musicas = musicaService.busca(filtro, page );

        return Resposta.comDadosDe(musicas);
    }


    @PostMapping
    public ResponseEntity<Musica> cria(@Validated @RequestBody Musica musica, HttpServletResponse response) {
        Musica musicaSalvo = musicaService.salva(musica);

        publisher.publishEvent(new HeaderLocationEvent(this, response, musicaSalvo.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(musicaSalvo);
    }

    @GetMapping("/{id}")
    public Musica buscaPor(@PathVariable Integer id) {
        return musicaService.buscaPor(id );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualiza(@PathVariable Integer id, @Validated @RequestBody Musica musica ) {
        Musica musicaManager = musicaService.atualiza(id, musica);
        return ResponseEntity.ok(musicaManager );
    }
}
