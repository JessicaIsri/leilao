package products;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Immobile extends Product {

    private String typeImmobile;
    private String address;
    private Integer cep;

    public Immobile(
            Integer id, Double value,
            Integer auction, String address,
            String typeImmobile, Integer cep,
            String nome
    ) {

        super(id, value, auction, nome);

        this.address = address;
        this.typeImmobile = typeImmobile;
        this.cep = cep;
    }



    @Override
    public String toString() {
        return "Imovel{" +
                "Id ='" + getId() + '\'' +
                ", Nome ='" + getNome() + '\'' +
                ", Valor ='" + getValue() + '\'' +
                ", Tipo ='" + typeImmobile + '\'' +
                ", Endereço ='" + address + '\'' +
                ", cep =" + cep +
                '}';
    }
}
