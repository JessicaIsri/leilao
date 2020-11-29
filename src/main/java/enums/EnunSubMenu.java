package enums;

public enum EnunSubMenu {
    CADASTRAR("1 - Cadastrar"),
    ATUALIZAR("2 - Atualiar"),
    CONSULTAR("3 - Consultar"),
    LISTAR("4 - Listar"),
    REMOVER("5 - Remover"),
    VOLTAR("6 - Voltar");

    private String value;

    EnunSubMenu(String value){
        this.value = value;
    }

    public String getValor(){
        return value;
    }
}
