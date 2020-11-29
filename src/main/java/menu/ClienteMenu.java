package menu;

import enums.EnunSubMenu;

public class ClienteMenu extends Menu implements SubMenu {
    @Override
    public void inicializador() {
        System.out.println("CLIENTES, O que deseja fazer?");
        for (EnunSubMenu subMenu: EnunSubMenu.values()){
            System.out.println(subMenu.getValor());
        }
        int escolha = Integer.parseInt(input.next());

        switch (escolha){
            case 1:
                cadastrar();
                inicializador();
                break;
            case 2:
                atualiza();
                inicializador();

                break;
            case 3:
                consultar();
                inicializador();

                break;
            case 4:
                remover();
                inicializador();

                break;
            case 5 :
                listar();
                inicializador();

                break;
            case 6 :
                menuPrincipal();


                break;
            default:
                menuPrincipal();
        }
    }

    @Override
    public void cadastrar() {

    }

    @Override
    public void atualiza() {

    }

    @Override
    public void consultar() {

    }

    @Override
    public void remover() {

    }

    @Override
    public void listar() {

    }
}
