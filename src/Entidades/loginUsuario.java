package Entidades;

public class loginUsuario extends Usuario{

    private int idLoginUsuario;
    private String login;
    private String senha;

    public loginUsuario() {

    }

    public loginUsuario(int ano_nascimento, int ativo, String cpf, String email, int idUsuario, String nome, int idLoginUsuario, String login, String senha) {
        super(ano_nascimento, ativo, cpf, email, idUsuario, nome);
        this.idLoginUsuario = idLoginUsuario;
        this.login = login;
        this.senha = senha;
    }

    public int getIdLoginUsuario() {
        return idLoginUsuario;
    }

    public void setIdLoginUsuario(int idLoginUsuario) {
        this.idLoginUsuario = idLoginUsuario;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
