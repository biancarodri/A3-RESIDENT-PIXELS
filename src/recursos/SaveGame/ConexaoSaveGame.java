package recursos.SaveGame;

import java.sql.*;
import java.sql.Driver;
import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoSaveGame {
//atributos
    private String url = "jdbc:mysql://residentpixel.alwaysdata.net/residentpixel_savegame";
    private String user = "416151";
    private String password = "@3ResidentPixel2025";
//comportamentos
    public void saveGame (GameState gameState) {
        String sql = "INSERT INTO savegame (localizacao, vida, tempoDeJogo) VALUES (?, ?, ?);";

        try (Connection conn = DriverManager.getConnection(url, user, password);
        PreparedStatement pstm = conn.prepareStatement(sql)) {

            pstm.setString(1, gameState.getLocalizacao());
            pstm.setInt(2, gameState.getVida());
            pstm.setTime(3, Time.valueOf(gameState.gettempoDeJogo()));

            pstm.executeUpdate();
            System.out.println("Jogo Salvo com sucesso!");

        } catch (SQLException erro) {
            erro.printStackTrace();


        }
    }



}
