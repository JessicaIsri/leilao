package auction;

import enums.EnunSubMenu;
import enums.ProdutoMenu;
import financeira.Financeira;
import lombok.Getter;
import lombok.Setter;
import products.Immobile;
import products.Vehicle;
import utils.Utils;

import javax.swing.plaf.synth.SynthToolTipUI;
import java.awt.*;
import java.time.LocalDate;
import java.util.*;
import java.util.List;

@Getter
@Setter
public class ManageAudictions extends Utils {
    private final Map<Integer, Auction> auctions = new TreeMap<Integer,Auction>();


    public void registerNewAuction(
            Integer id, LocalDate date,
            String local, String cidade,
            String estado, Financeira financeira
    ){
        Auction auction = new Auction(id, date, local, cidade, estado, financeira);
        auctions.put(id, auction);

    }

    public void removeAuction(Integer id){
        auctions.remove(id);
        removeMessage(id);
    }

    public void updateAuction(
            Integer id, LocalDate date,
            String local, String cidade,
            String estado
    ){
        try{
            Auction auction = auctions.get(id);
            if(checkIfNull(date)){
                auction.setDate(date);
            }
            if(checkIfNull(local)){
                auction.setLocal(local);
            }
            if(checkIfNull(cidade)){
                auction.setCidade(cidade);
            }
            if(checkIfNull(estado)){
                auction.setEstado(estado);
            }
        }
        catch (NullPointerException e){
            nullPointerMessage(id);
        }
    }

    public void sortValue(){
        Map<Integer, Auction> sorted = sortByValue(auctions);
        printMap(sorted);
    }



    private static Map<Integer, Auction> sortByValue(Map<Integer, Auction> unsortMap) {
        List<Map.Entry<Integer, Auction>> list =
                new LinkedList<Map.Entry<Integer, Auction>>(unsortMap.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Auction>>() {
            @Override
            public int compare(Map.Entry<Integer, Auction> o1,
                               Map.Entry<Integer, Auction> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        Map<Integer, Auction> sortedMap = new LinkedHashMap<Integer, Auction>();
        for (Map.Entry<Integer, Auction> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return sortedMap;
    }

    public void showLeilaoDetail(Integer id){
        try{
            Auction auction = auctions.get(id);
            System.out.println(auction.toString());
            subMenuProduto(auction);

        }
        catch (NullPointerException e){

        }

    }

    public void subMenuProduto(Auction auction){
        for (ProdutoMenu subMenu: ProdutoMenu.values()){
            System.out.println(subMenu.getValor());
        }
        int escolha = Integer.parseInt(input.next());
        switch (escolha){
            case 1:
                cadastraVeiculo(auction);
                break;
            case 5:
                cadastraImovel(auction);
                break;
        }
    }

    private void cadastraVeiculo(Auction auction){
        Integer id = random.nextInt();
        write("Valor: ");
        Double valor = input.nextDouble();
        Integer auctionId = auction.getIdAuction();
        write("Nome: ");
        String nome = input.next();
        write("Tipo do Veiculo: ");
        String tipo = input.next();
        write("Modelo: ");
        String modelo = input.next();
        write("Ano");
        Integer ano = input.nextInt();
        auction.registerNewVehicle(id, valor, modelo, tipo, ano, nome);
    }

    private void cadastraImovel(Auction auction){
        Integer id = random.nextInt();
        write("Valor: ");
        Double valor = input.nextDouble();
        Integer auctionId = auction.getIdAuction();
        write("Endereço: ");
        String endereco = input.next();
        write("Tipo do Imóvel");
        String tipo = input.next();
        write("CEP: ");
        Integer cep = input.nextInt();
        write("Nome: ");
        String nome = input.next();

        auction.registerNewImmobile(id, valor, auctionId, endereco, tipo, cep, nome);
    }

    public void showAll(){
        printMap(auctions);
    }

}
