package DAO;

import Entidades.InfoJogo;
import Util.ConnectionMysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
}
