package cliente;

import auction.Auction;
import dtos.LancesDTO;
import lombok.Getter;
import lombok.Setter;
import products.Immobile;
import products.Product;

import java.util.*;

@Getter
@Setter
public class Cliente {
    private String nome;
    private String email;
    private String senha;
    private List<LancesDTO> lances = new ArrayList<LancesDTO>();



    public Cliente(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }


}
