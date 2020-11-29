package menu;

import enums.EnunSubMenu;
import financeira.FinanceiraManager;

public class FinanceiraMenu extends Menu implements SubMenu{

    @Override
    public void inicializador() {
        System.out.println("FINANCEIRA, O que deseja fazer?");
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
                listar();
                inicializador();

                break;
            case 5 :
                remover();
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

        Boolean novo = true;
        while (novo){
            write("CNPJ: ");
            String cnpj = input.next();
            write("Nome: ");
            String nome = input.next();
            manager.registerNewFinanceira(cnpj, nome, random.nextInt(9999));

            Boolean control = true;
            while (control){
                write("Continuar Registrando? [Y/N]");
                String option = input.next();
                if (!option.equals("N") && !option.equals("Y")){
                    write("Opção invalida");
                }
                if (option.equals("N")){
                    write("Saindo ....");
                    novo = false;
                    control = false;
                }
                if (option.equals("Y")){
                    write("Continue");
                    novo = true;
                    control = false;
                }
            }

        }
    }

    @Override
    public void atualiza() {
        write("ID:");
        Integer id = input.nextInt();
        write("CNPJ: ");
        String cnpj = input.next();
        write("Nome: ");
        String name = input.next();
        manager.atualiza(id, cnpj, name);
    }

    @Override
    public void consultar() {
        write("ID:");
        Integer id = input.nextInt();
        manager.showDetail(id);
    }

    @Override
    public void remover() {
        write("ID:");
        Integer id = input.nextInt();
        manager.remove(id);
        consultar();
    }

    @Override
    public void listar() {
        manager.showAll();
    }
}
