package com.example.centaure.Centaure.models;

public enum UsuarioRoles {
    Usuario("usuario");
    private String role;
    UsuarioRoles (String role){
        this.role = role;
    }

    public String getRole(){
        return role;

    }
}
