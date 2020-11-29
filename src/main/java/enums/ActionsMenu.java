package enums;

import lombok.Getter;


@Getter

public enum ActionsMenu {
    LEILAO("1 - Leilão"),
    FINANCEIRA("2 - Financeira"),
    CLIENTE("3 - Cliente"),
    SAIR("4 - Sair");

    private final String valor;
    ActionsMenu(String valorOpcao){
        valor = valorOpcao;
    }

    public String getValor(){
        return valor;
    }

}
