package com.eventos.enums;

public enum Perfil {
    ADMINISTRADDOR("Administrador","Adm"),
    GERENTE("Gerente","Ger"),
    USUARIO("Usuário","Urs");;

    private final String descricao;

    private final String sigla;

    Perfil(String descricao, String sigla){
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public String getDescricao(){
        return descricao;
    }
}