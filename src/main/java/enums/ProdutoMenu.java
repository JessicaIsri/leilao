package enums;

public enum ProdutoMenu {
    CRIAVEICULO("1 - Criar veiculo"),
    REMOVEVEICULO("2 - Remove veiculo"),
    ATUALIZAVEICULO("3 - Atualiza veiculo"),
    CRIAIMOVEL("5 - Cria imovel"),
    REMOVEIMOVEL("6 - Remove imovel"),
    ATUALIZAIMOVEL("7 - Atualiza imovel"),
    SAIR("8 - Sair");

    private final String value;

    ProdutoMenu(String value){
        this.value = value;
    }

    public String getValor(){
        return value;
    }
}
