package javasql;

import java.sql.*;

public class Cotacaomoeda {
    public static void main(String[] args) {
        String host = "localhost";
        String database = "exercicios2";
        String usuario = "root";
        String senha = "";
        try (Connection conexao = DriverManager.getConnection("jdbc:mysql://"
                + host + ":3306/" + database, usuario, senha)) {
            String moeda = "Dolar";
            Double valor = 5.00;

            String sql = "INSERT INTO cotacao_moeda (moeda, valor) VALUES (?,?)";
            
            PreparedStatement stmt = conexao.prepareStatement(sql);

            stmt.setString(1, moeda);
            stmt.setDouble(2, valor);
                         
            int linhasAfetadas = stmt.executeUpdate();
            if (linhasAfetadas > 0) {
                System.out.println("Moeda adicionada com sucesso!");
            } else {
                System.out.println("Erro ao inserir moeda");
            }
        } catch (SQLException e) {
            System.err.println("Erro ao conectar ao banco de dados: " +
                    e.getMessage());
        }
    }
}