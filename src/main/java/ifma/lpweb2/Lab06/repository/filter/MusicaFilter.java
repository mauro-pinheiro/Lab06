package ifma.lpweb2.Lab06.repository.filter;

public class MusicaFilter {

    private String nome;
    private int duracao;

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

    @Override
    public String toString() {
        return "ProdutoFiltro{" +
                "nome='" + nome + '\'' +
                '}';
    }
}
