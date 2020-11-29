package dtos;

import auction.Auction;
import cliente.Cliente;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import products.Product;

@AllArgsConstructor
@Getter
@Setter
public class LancesDTO {
    private Cliente cliente;
    private Double  lance;
    private Auction leilao;
}
