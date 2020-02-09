package ifma.lpweb2.Lab06.controller;

import ifma.lpweb2.Lab06.controller.event.HeaderLocationEvent;
import ifma.lpweb2.Lab06.model.Artista;
import ifma.lpweb2.Lab06.service.ArtistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class ArtistaController {
    @Autowired
    private ApplicationEventPublisher publisher;

    private ArtistaService albumService;

    @Autowired
    public ArtistaController(ArtistaService artistaService){
        this.albumService = artistaService;
    }

    @GetMapping
    public List<Artista> todos(){
        return albumService.todos();
    }

    @PostMapping
    public ResponseEntity<Artista> cria(@Validated @RequestBody Artista artista, HttpServletResponse response) {
        Artista artistaSalvo = albumService.salva(artista);

        publisher.publishEvent(new HeaderLocationEvent(this, response, artistaSalvo.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(artistaSalvo);
    }

    @GetMapping("/{id}")
    public Artista buscaPor(@PathVariable Integer id) {
        return albumService.buscaPor(id );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Artista> atualiza(@PathVariable Integer id, @Validated @RequestBody Artista artista ) {
        Artista artistaManager = albumService.atualiza(id, artista);
        return ResponseEntity.ok(artistaManager );
    }
}
