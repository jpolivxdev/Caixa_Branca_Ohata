package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Versão corrigida e comentada do User.
 * - Usa PreparedStatement para evitar SQL Injection
 * - Usa try-with-resources para fechar ResultSet/Statement/Connection
 * - Trata possibilidade de conexão nula
 */
public class UserFixed {

    /**
     * Abre conexão com o banco. Ajuste a URL, usuário e senha para seu ambiente.
     */
    public Connection conectarBD() {
        Connection conn = null;
        try {
            // Driver correto do MySQL moderno
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://127.0.0.1:3306/test?useTimezone=true&serverTimezone=UTC";
            String user = "lopes";
            String password = "123";
            conn = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            // Aqui você pode logar a exceção para diagnóstico
            System.err.println("Erro ao conectar no BD: " + e.getMessage());
        }
        return conn;
    }

    public String nome = "";
    public boolean result = false;

    /**
     * Verifica se usuário existe no banco.
     * Retorna true se encontrado; false caso contrário.
     */
    public boolean verificarUsuario(String login, String senha) {
        // Validação básica dos parâmetros
        if (login == null || senha == null) {
            return false;
        }

        String sql = "SELECT nome FROM usuarios WHERE login = ? AND senha = ?;";

        // Obtém a conexão e verifica se não é nula
        try (Connection conn = conectarBD()) {
            if (conn == null) {
                System.err.println("Conexão nula. Abortando verificação.");
                return false;
            }

            try (PreparedStatement pst = conn.prepareStatement(sql)) {
                pst.setString(1, login);
                pst.setString(2, senha);

                try (ResultSet rs = pst.executeQuery()) {
                    if (rs.next()) {
                        result = true;
                        nome = rs.getString("nome");
                    } else {
                        result = false;
                    }
                }
            }
        } catch (Exception e) {
            System.err.println("Erro ao executar verificação: " + e.getMessage());
            result = false;
        }

        return result;
    }
}
