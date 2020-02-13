package ifma.lpweb2.Lab06.controller.respose;

public class Erro {

    private final String mensagem;
    private final String detalhes;

    public Erro(String mensagem, String detalhes) {
        this.mensagem = mensagem;
        this.detalhes = detalhes;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getDetalhes() {
        return detalhes;
    }
}