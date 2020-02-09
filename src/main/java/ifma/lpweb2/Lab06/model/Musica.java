package ifma.lpweb2.Lab06.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    private int duracao;

    @ManyToMany(mappedBy = "interpretacoes")
    private Set<Artista> interpretes = new HashSet<>();

    @ManyToMany(mappedBy = "autorias")
    private Set<Artista> autores = new HashSet<>();

    @ManyToMany(mappedBy = "musicas")
    private Set<Album> albuns = new HashSet<>();
}
