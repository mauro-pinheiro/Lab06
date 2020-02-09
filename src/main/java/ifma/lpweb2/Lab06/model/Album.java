package ifma.lpweb2.Lab06.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "albuns")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    private int ano;

    @ManyToMany
    @JoinTable(
            name="album_musica",
            joinColumns = @JoinColumn(name = "id_album"),
            inverseJoinColumns = @JoinColumn(name = "id_musica")
    )
    private Set<Musica> musicas = new HashSet<>();

    @ManyToMany(mappedBy = "participacoes")
    private Set<Artista> participantes = new HashSet<>();
}
