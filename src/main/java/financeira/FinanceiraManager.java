package financeira;

import auction.Auction;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import utils.Utils;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

@Setter
@Getter
@ToString
public class FinanceiraManager extends Utils {
    private final Map<Integer, Financeira> financeiraMap = new TreeMap<Integer,Financeira>();

    public void registerNewFinanceira(String cnpj, String nome, Integer id){
        Financeira financeira = new Financeira(cnpj, nome);
        financeiraMap.put(id, financeira);
    }

    public Optional<Financeira> geFinanceira(Integer id){

        Financeira financeira = financeiraMap.get(id);
        Optional<Financeira> opt = Optional.ofNullable(financeira);
        return opt;

    }

    public void showAll(){
        printMap(financeiraMap);
    }

    public void showDetail(Integer id){
        try{
            Financeira financeira = financeiraMap.get(id);
            write(financeira.toString());

            write("");
        }
        catch (NullPointerException e){
            nullPointerMessage(id);
        }
    }

    public void remove(Integer id){
        try{
            Financeira financeira = financeiraMap.remove(id);
            write(financeira.toString());
        }
        catch (NullPointerException e){
            nullPointerMessage(id);
        }
    }

    public void atualiza(Integer id, String cnpj, String name){
        try{
            Financeira financeira = financeiraMap.remove(id);
            financeira.setCnpj(cnpj);
            financeira.setNome(name);
        }
        catch (NullPointerException e){
            nullPointerMessage(id);
        }
    }


}
