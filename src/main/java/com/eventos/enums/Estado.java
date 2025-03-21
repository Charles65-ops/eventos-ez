package com.eventos.enums;

public enum Estado {
    ACRE("Acre", "AC"),
    ALAGOAS("Alagoas", "AL"),
    AMAZONAS("Amazonas", "AM"),
    BAHIA("Bahia", "BA"),
    CEARA("Ceará", "CE"),
    ESPIRITO_SANTO("Espírito Santo", "ES"),
    GOIAS("Goiás", "GO"),
    MARANHAO("Maranhão", "MA"),
    MATO_GROSSO("Mato Grosso", "MT"),
    MATO_GROSSO_DO_SUL("Mato Grosso do Sul", "MS"),
    MINAS_GERAIS("Minas Gerais", "MG"),
    PARA("Paraíba", "PB"),
    PARAIBA("Paraíba", "PB"),
    PARANA("Paraná", "PR"),
    PARANAS("Paranás", "PR"),
    PERNAMBUCO("Pernambuco", "PE"),
    PIAUI("Piauí", "PI"),
    RIO_DE_JANEIRO("Rio de Janeiro", "RJ"),
    RIO_GRANDE_DO_SUL("Rio Grande do Sul", "RS"),
    RONDONIA("Rondônia", "RO"),
    RORAIMA("Roraima", "RR"),
    SANTA_CATARINA("Santa Catarina", "SC"),
    SAO_PAULO("São Paulo", "SP"),
    SERGIPE("Sergipe", "SE"),
    TOCANTINS("Tocantins", "TO");

    private final String descricao;

    private final String sigla;

    Estado(String descricao, String sigla){
        this.descricao = descricao;
        this.sigla = sigla;
    }

    public String getDescricao(){
        return descricao;
    }
}
