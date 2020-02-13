package ifma.lpweb2.Lab06.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "artistas")
public class Artista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    private String nacionalidade;

    @ManyToMany()
    @JoinTable(
            name="autorias",
            joinColumns = @JoinColumn(name = "id_artista"),
            inverseJoinColumns = @JoinColumn(name = "id_musica")
    )
    @JsonIgnoreProperties("autores")
    private Set<Musica> autorias = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name="interpretacoes",
            joinColumns = @JoinColumn(name = "id_artista"),
            inverseJoinColumns = @JoinColumn(name = "id_musica")
    )
    @JsonIgnoreProperties("interpretes")
    private Set<Musica> interpretacoes = new HashSet<>();

    @ManyToMany
    @JoinTable(
            name="participacoes",
            joinColumns = @JoinColumn(name = "id_artista"),
            inverseJoinColumns = @JoinColumn(name = "id_album")
    )
    @JsonIgnoreProperties("participantes")
    private Set<Musica> participacoes = new HashSet<>();


    public Integer getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public Set<Musica> getAutorias() {
        return autorias;
    }

    public void setAutorias(Set<Musica> autorias) {
        this.autorias = autorias;
    }

    public Set<Musica> getInterpretacoes() {
        return interpretacoes;
    }

    public void setInterpretacoes(Set<Musica> interpretacoes) {
        this.interpretacoes = interpretacoes;
    }

    public Set<Musica> getParticipacoes() {
        return participacoes;
    }

    public void setParticipacoes(Set<Musica> participacoes) {
        this.participacoes = participacoes;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
