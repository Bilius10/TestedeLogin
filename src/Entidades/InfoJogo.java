package Entidades;

public class InfoJogo {
    private int idInfoJogo;
    private int partidasJogadas;
    private int vitorias;
    private int derrotas;
    private int empates;
    private int pontuacao;
    private int idUsuario;

    public InfoJogo(int derrotas, int empates, int idInfoJogo, int idUsuario, int partidasJogadas, int pontuacao, int vitorias) {
        this.derrotas = derrotas;
        this.empates = empates;
        this.idInfoJogo = idInfoJogo;
        this.idUsuario = idUsuario;
        this.partidasJogadas = partidasJogadas;
        this.pontuacao = pontuacao;
        this.vitorias = vitorias;
    }

    public InfoJogo() {
        this.partidasJogadas = 0;
        this.vitorias = 0;
        this.derrotas = 0;
        this.empates = 0;
        this.pontuacao = 0;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getIdInfoJogo() {
        return idInfoJogo;
    }

    public void setIdInfoJogo(int idInfoJogo) {
        this.idInfoJogo = idInfoJogo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getPartidasJogadas() {
        return partidasJogadas;
    }

    public void setPartidasJogadas(int partidasJogadas) {
        this.partidasJogadas = partidasJogadas;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getVitorias() {
        return vitorias;
    }

    public void setVitorias(int vitorias) {
        this.vitorias = vitorias;
    }

    @Override
    public String toString() {
        return "InfoJogo{" +
                "derrotas=" + derrotas +
                ", idInfoJogo=" + idInfoJogo +
                ", partidasJogadas=" + partidasJogadas +
                ", vitorias=" + vitorias +
                ", empates=" + empates +
                ", pontuacao=" + pontuacao +
                ", idUsuario=" + idUsuario +
                '}';
    }
}
