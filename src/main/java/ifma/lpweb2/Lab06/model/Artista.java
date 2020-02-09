package ifma.lpweb2.Lab06.model;

import com.sun.istack.NotNull;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String nome;

    @NotNull
    private String nacionalidade;

    @ManyToMany()
    @JoinTable(
            name="autorias",
            joinColumns = @JoinColumn(name = "id_artista"),
            inverseJoinColumns = @JoinColumn(name = "id_musica")
    )
    private Set<Musica> autorias = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name="interpretacoes",
            joinColumns = @JoinColumn(name = "id_artista"),
            inverseJoinColumns = @JoinColumn(name = "id_musica")
    )
    private Set<Musica> interpretacoes = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name="participacoes",
            joinColumns = @JoinColumn(name = "id_artista"),
            inverseJoinColumns = @JoinColumn(name = "id_album")
    )
    private Set<Musica> participacoes = new HashSet<>();
}
