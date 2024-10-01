package DAO;

import Entidades.InfoJogo;
import Util.ConnectionMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class InfoJogoDAO {

    public InfoJogo createInfoJogo(InfoJogo infoJogo){
        try {
            Connection conn = ConnectionMysql.openConnection();

            String sql = "INSERT INTO infojogo (partidasJogadas, vitorias, derrotas, empates, pontuacao, usuario_idUsuario)"+
                    "VALUES (?,?,?,?,?,?)";

            PreparedStatement preparedInfoJogo = conn.prepareCall(sql);

            preparedInfoJogo.setInt(1, infoJogo.getPartidasJogadas());
            preparedInfoJogo.setInt(2, infoJogo.getVitorias());
            preparedInfoJogo.setInt(3, infoJogo.getDerrotas());
            preparedInfoJogo.setInt(4, infoJogo.getEmpates());
            preparedInfoJogo.setInt(5, infoJogo.getPontuacao());
            preparedInfoJogo.setInt(6, infoJogo.getIdUsuario());
            preparedInfoJogo.executeUpdate();
            System.out.println("infoJgo criado");

        }catch (SQLException e){
            System.out.println("Erro ao criar infoJogo: "+e.getMessage());
        }

        return infoJogo;
    }

    public InfoJogo findById(int id){

        InfoJogo infoJogo = new InfoJogo();
        try {
            Connection coon = ConnectionMysql.openConnection();

            String sql = "SELECT * FROM infojogo WHERE usuario_idUsuario=? LIMIT 1";
            PreparedStatement statement = coon.prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                infoJogo.setIdInfoJogo(resultSet.getInt("idInfoJogo"));
                infoJogo.setPartidasJogadas(resultSet.getInt("partidasJogadas"));
                infoJogo.setVitorias(resultSet.getInt("vitorias"));
                infoJogo.setDerrotas(resultSet.getInt("derrotas"));
                infoJogo.setEmpates(resultSet.getInt("empates"));
                infoJogo.setPontuacao(resultSet.getInt("pontuacao"));
                infoJogo.setIdUsuario(id);
            }

        }catch (SQLException e){
            System.out.println("Erro ao encontrar id: "+e.getMessage());
        }

        return infoJogo;
    }

    public void atualizarInformacoes(InfoJogo infoJogo){

        try {

            Connection coon = ConnectionMysql.openConnection();

            String sqlAttLoginUsuario = "UPDATE infojogo SET partidasJogadas = ?, vitorias = ?, derrotas = ?, empates = ?, pontuacao = ?"+
                    " WHERE usuario_idUsuario = ? LIMIT 1";

            PreparedStatement statementAttLoginUsuario = coon.prepareStatement(sqlAttLoginUsuario);
            statementAttLoginUsuario.setInt(1, infoJogo.getPartidasJogadas());
            statementAttLoginUsuario.setInt(2, infoJogo.getVitorias());
            statementAttLoginUsuario.setInt(3, infoJogo.getDerrotas());
            statementAttLoginUsuario.setInt(4, infoJogo.getEmpates());
            statementAttLoginUsuario.setInt(5, infoJogo.getPontuacao());
            statementAttLoginUsuario.setInt(6, infoJogo.getIdUsuario());

            int rowsAffected = statementAttLoginUsuario.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Informações atualizadas com sucesso.");
            }

        }catch (SQLException e){
            System.out.println("Erro na atualizar informações: "+e.getMessage());
        }
    }
