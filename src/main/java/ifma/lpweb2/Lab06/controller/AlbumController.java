package ifma.lpweb2.Lab06.controller;

import ifma.lpweb2.Lab06.controller.event.HeaderLocationEvent;
import ifma.lpweb2.Lab06.model.Album;
import ifma.lpweb2.Lab06.service.AlbumService;
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
public class AlbumController {
    @Autowired
    private ApplicationEventPublisher publisher;

    private AlbumService albumService;

    @Autowired
    public AlbumController(AlbumService albumService){
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> todos(){
        return albumService.todos();
    }

    @PostMapping
    public ResponseEntity<Album> cria(@Validated @RequestBody Album album, HttpServletResponse response) {
        Album albumSalvo = albumService.salva(album);

        publisher.publishEvent(new HeaderLocationEvent(this, response, albumSalvo.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(albumSalvo);
    }

    @GetMapping("/{id}")
    public Album buscaPor(@PathVariable Integer id) {
        return albumService.buscaPor(id );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Album> atualiza(@PathVariable Integer id, @Validated @RequestBody Album album ) {
        Album albumManager = albumService.atualiza(id, album);
        return ResponseEntity.ok(albumManager );
    }
}
