package test;

import dao.UsuarioDAO;
import domain.Usuario;

import java.util.List;

public class TestManejoUsuario {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("daniel", "1212121");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        int canti =  usuarioDAO.insertar(usuario);
        System.out.println("Registros afectados "+ canti);
        List<Usuario> users = usuarioDAO.seleccionar();
        users.forEach(user->{
            System.out.println(user);
        });
    }
}
