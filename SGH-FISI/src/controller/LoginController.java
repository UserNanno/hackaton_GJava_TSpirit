package controller;

import model.UsuarioDAO;

public class LoginController {
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    public boolean autenticar(String nombreUsuario, String contrasena) {
        return usuarioDAO.validarCredenciales(nombreUsuario, contrasena);
    }
}

