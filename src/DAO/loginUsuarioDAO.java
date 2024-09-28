package DAO;

import Entidades.loginUsuario;
import Util.ConnectionMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginUsuarioDAO {

    public loginUsuario createLoginUsuario(loginUsuario loginUsuario){

        try {

            //Inserindo usuario
            Connection coon = ConnectionMysql.openConnection();

            String sqlUsuario = "INSERT INTO usuario (nome, ano_nascimento, cpf, email, ativo)" +
                    "VALUES (?,?,?,?,?)";

            PreparedStatement statementUsuario = coon.prepareStatement(sqlUsuario);

            statementUsuario.setString(1, loginUsuario.getNome());
            statementUsuario.setInt(2, loginUsuario.getAno_nascimento());
            statementUsuario.setString(3, loginUsuario.getCpf());
            statementUsuario.setString(4, loginUsuario.getEmail());
            statementUsuario.setInt(5, loginUsuario.getAtivo());
            statementUsuario.executeUpdate();

            //Buscando id do usuario criado
            String sqlFindIdUsuario = "SELECT idUsuario FROM usuario WHERE cpf=? LIMIT 1";

            PreparedStatement statementFindIdUsuario = coon.prepareStatement(sqlFindIdUsuario);
            statementFindIdUsuario.setString(1, loginUsuario.getCpf());
            ResultSet resultSet = statementFindIdUsuario.executeQuery();

            int idPessoa = -1;
            while (resultSet.next()) {
                idPessoa = resultSet.getInt("idUsuario");
            }

            //Inserindo loginUsuario
            String sqlLoginUsuario =  "INSERT INTO loginusuario (login, senha, Usuario_idUsuario)"+
                    "VALUES (?,?,?)";

            PreparedStatement statementLoginUsuario = coon.prepareStatement(sqlLoginUsuario);

            statementLoginUsuario.setString(1, loginUsuario.getLogin());
            statementLoginUsuario.setString(2, loginUsuario.getSenha());
            statementLoginUsuario.setInt(3, idPessoa);
            statementLoginUsuario.executeUpdate();

            System.out.println("loginUsuario inserido");

        }catch (SQLException e){
            System.out.println("Erro ao criar loginUsario: "+e.getMessage());
        }
        return null;
    }

    public loginUsuario aprovarLogin(String login, String senha){
        loginUsuario aprovado = new loginUsuario();

        try{
            Connection coon = ConnectionMysql.openConnection();

            String sqlBusca = "SELECT * FROM loginusuario join usuario on loginusuario.Usuario_idUsuario = usuario.idUsuario"+
                    " WHERE loginusuario.login = ? and loginusuario.senha = ? LIMIT 1";

            PreparedStatement statementBusca = coon.prepareStatement(sqlBusca);
            statementBusca.setString(1, login);
            statementBusca.setString(2, senha);

            ResultSet resultSet = statementBusca.executeQuery();

            while (resultSet.next()){
                aprovado.setIdUsuario(resultSet.getInt("idUsuario"));
                aprovado.setNome(resultSet.getString("nome"));
                aprovado.setAno_nascimento(resultSet.getInt("ano_nascimento"));
                aprovado.setCpf(resultSet.getString("cpf"));
                aprovado.setEmail(resultSet.getString("email"));
                aprovado.setLogin(login);
                aprovado.setSenha(senha);
            }

        }catch (SQLException e){
            System.out.println("Erro na busca: "+e.getMessage());
        }

        return aprovado;
    }
}
