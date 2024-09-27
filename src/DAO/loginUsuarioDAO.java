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

            String sqlUsuario = "INSERT INTO usuario (nome, ano_nascimento, cpf, email, ativo)+" +
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
}
