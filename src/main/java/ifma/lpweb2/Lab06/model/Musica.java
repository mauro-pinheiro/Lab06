package ifma.lpweb2.Lab06.model;

import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "musicas")
public class Musica {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private int duracao;

    @ManyToMany(mappedBy = "interpretacoes")
    private Set<Artista> interpretes = new HashSet<>();

    @ManyToMany(mappedBy = "autorias")
    private Set<Artista> autores = new HashSet<>();

    @ManyToMany(mappedBy = "musicas")
    private Set<Album> albuns = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public Set<Artista> getInterpretes() {
        return interpretes;
    }

    public Set<Artista> getAutores() {
        return autores;
    }

    public Set<Album> getAlbuns() {
        return albuns;
    }
}
