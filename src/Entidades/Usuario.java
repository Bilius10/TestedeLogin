package Entidades;

public class Usuario {

    private int idUsuario;
    private String nome;
    private int ano_nascimento;
    private String cpf;
    private String email;
    private int ativo;

    public Usuario(int ano_nascimento, int ativo, String cpf, String email, int idUsuario, String nome) {
        this.ano_nascimento = ano_nascimento;
        this.ativo = ativo;
        this.cpf = cpf;
        this.email = email;
        this.idUsuario = idUsuario;
        this.nome = nome;
    }

    public Usuario() {
    }

    public int getAno_nascimento() {
        return ano_nascimento;
    }

    public void setAno_nascimento(int ano_nascimento) {
        this.ano_nascimento = ano_nascimento;
    }

    public int getAtivo() {
        return ativo;
    }

    public void setAtivo(int ativo) {
        this.ativo = ativo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        cpf.replace(".", "");
        cpf.replace("-", "");

        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "ano_nascimento=" + ano_nascimento +
                ", idUsuario=" + idUsuario +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", ativo=" + ativo +
                '}';
    }
}
