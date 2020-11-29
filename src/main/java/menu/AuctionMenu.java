package menu;

import auction.ManageAudictions;
import enums.EnunSubMenu;
import java.time.LocalDate;

public class AuctionMenu extends Menu implements SubMenu  {


    private final ManageAudictions manageAudictions = new ManageAudictions();


    public void inicializador(){
        System.out.println("LEILÕES, O que deseja fazer?");
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


        boolean voltar = true;
        write("|| CADASTRO DE LEILÃO");
        while (voltar){
            Integer id = random.nextInt();
            write("Insira a data em que ocorrerá o leilão: ");
            LocalDate date = convert(input.next());
            write("Insira o local onde ocorrerá: ");
            String local = input.next();
            write("Insira a cidade onde ocorrerá: ");
            String cidade = input.next();
            write("Insira o estado onde ocorrerá: ");
            String estado = input.next();
            write("Digite o id da financeira: ");
            manager.showAll();

            manageAudictions.registerNewAuction(id, date, local, cidade, estado, null);
            Boolean control = true;
            while (control){
                write("Continuar Registrando? [Y/N]");
                String option = input.next();
                if (!option.equals("N") && !option.equals("Y")){
                    write("Opção invalida");
                }
                if (option.equals("N")){
                    write("Saindo ....");
                    voltar = false;
                    control = false;
                }
                if (option.equals("Y")){
                    write("Continue");
                    voltar = true;
                    control = false;
                }
            }

        }

    }

    @Override
    public void atualiza() {
        write("ID: ");
        Integer id = input.nextInt();
        write("Insira a data em que ocorrerá o leilão: ");
        LocalDate date = convert(input.next());
        write("Insira o local onde ocorrerá: ");
        String local = input.next();
        write("Insira a cidade onde ocorrerá: ");
        String cidade = input.next();
        write("Insira o estado onde ocorrerá: ");
        String estado = input.next();

        manageAudictions.updateAuction(id,date,local,cidade,estado);

    }

    @Override
    public void consultar() {
        write("ID:");
        Integer id = input.nextInt();
        manageAudictions.showLeilaoDetail(id);
    }

    @Override
    public void remover() {
        write("ID:");
        Integer id = input.nextInt();
        manageAudictions.removeAuction(id);
    }

    @Override
    public void listar() {
        manageAudictions.showAll();
    }
}
