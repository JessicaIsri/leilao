package menu;

import auction.Auction;
import auction.ManageAudictions;
import cliente.Cliente;
import cliente.ClienteManager;
import enums.ActionsMenu;
import enums.EnunSubMenu;
import financeira.Financeira;
import financeira.FinanceiraManager;
import memory.Memory;
import utils.Utils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.Random;
import java.util.Scanner;

public class Menu extends Utils {
    public final FinanceiraManager manager =  new FinanceiraManager();
    public final ClienteManager clienteManager = new ClienteManager();
    public final ManageAudictions manageAudictions = new ManageAudictions();

    public void menuPrincipal(){
        System.out.println("Bem vindo ao Leilão Eletronico, O que deseja fazer?");
        for (ActionsMenu actionsMenu: ActionsMenu.values()){
            System.out.println(actionsMenu.getValor());
        }
        int escolha = Integer.parseInt(input.next());

        switch (escolha){
            case 1:
                AuctionMenu auctionMenu = new AuctionMenu();
                auctionMenu.inicializador();
                break;
            case 2:
                FinanceiraMenu financeiraMenu = new FinanceiraMenu();
                financeiraMenu.inicializador();
                break;
            case 3:

                break;
            case 4:
                System.exit(0);
        }
    }





}
