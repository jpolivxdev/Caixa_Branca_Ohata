package login;

public class TestLogin {
    public static void main(String[] args) {
        UserFixed uf = new UserFixed();
        boolean ok = uf.verificarUsuario("admin", "admin123");
        System.out.println("Usuario encontrado? " + ok);
        if (ok) {
            System.out.println("Nome: " + uf.nome);
        }
    }
}
