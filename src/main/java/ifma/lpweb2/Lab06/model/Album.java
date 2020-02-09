package ifma.lpweb2.Lab06.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "albuns")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

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

    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public Set<Musica> getMusicas() {
        return musicas;
    }

    public Set<Artista> getParticipantes() {
        return participantes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Album album = (Album) o;
        return id.equals(album.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
