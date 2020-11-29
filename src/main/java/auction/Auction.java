package auction;

import financeira.Financeira;
import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.Nullable;
import products.Immobile;
import products.Vehicle;
import utils.Utils;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Getter
@Setter
public class Auction extends Utils implements Comparable<Auction> {
    private Integer idAuction;
    private LocalDate date;
    private String local;
    private String cidade;
    private String estado;
    private Financeira financeira;
    private final Map<Integer,Vehicle> vehicles = new TreeMap<Integer,Vehicle>();
    private final Map<Integer, Immobile> immobilises = new TreeMap<Integer,Immobile>();

    public int compareTo(Auction otherAuction) {
        return this.getDate().compareTo( otherAuction.getDate());
    }

    public Auction(Integer id, LocalDate date, String local,String cidade, String estado, Financeira financeira){
        this.idAuction = id;
        this.date = date;
        this.local = local;
        this.cidade = cidade;
        this.estado = estado;
        this.financeira = financeira;
    }

    public void registerNewVehicle(
            Integer id, Double value,
            String model, String typeVehicle,
            Integer year, String nome
    ){
        Vehicle vehicle = new Vehicle(id, value, idAuction, typeVehicle, model, year, nome);
        if (id > 0){
            vehicles.put(id,vehicle);
            System.out.println(vehicle.toString() + " foi cadastrado");
        }
        else{
            System.out.println("ID invalido");
        }

    }

    public void removeVehicle(Integer id){
        vehicles.remove(id);
        removeMessage(id);

    }

    public void removeImmobilies(Integer id){
        immobilises.remove(id);
        removeMessage(id);
    }

    public void updateVehicle(
            Integer id, @Nullable Double value,
            @Nullable String model, @Nullable String typeVehicle,
            @Nullable Integer year
    ){
        try{
            Vehicle vehicle = vehicles.get(id);
            if (checkIfNull(value)){
                vehicle.setValue(value);
            }
            if (checkIfNull(model)){
                vehicle.setModel(model);
            }
            if (checkIfNull(typeVehicle)){
                vehicle.setTypeVehicle(typeVehicle);
            }
            if (checkIfNull(year)){
                vehicle.setYear(year);
            }
            updateMessage(id);
        }catch (NullPointerException e){
            nullPointerMessage(id);
        }

    }

    public void updateImmobile(
            Integer id, Double value,
            String typeImmobile,
            String address, Integer cep
    ){
        try{
            Immobile immobile = immobilises.get(id);
            if (checkIfNull(value)){
                immobile.setValue(value);
            }
            if (checkIfNull(typeImmobile)){
                immobile.setTypeImmobile(typeImmobile);
            }
            if (checkIfNull(address)){
                immobile.setAddress(address);
            }
            if (checkIfNull(cep)){
                immobile.setCep(cep);
            }
            updateMessage(id);
        }
        catch (NullPointerException exception){
            nullPointerMessage(id);
        }

    }

    public void registerNewImmobile(
            Integer id, Double value,
            Integer idAuction, String typeImmobile,
            String address, Integer cep, String nome
    ){
        Immobile immobile = new Immobile(id, value, idAuction, address, typeImmobile, cep, nome);
        immobilises.put(id, immobile);
        System.out.println(immobile.toString() + " foi cadastrado");
    }



    public void showAllProducts(){
        showMap(immobilises);
        showMap(vehicles);
    }

    @Override
    public String toString() {
        return "Auction{" +
                "idAuction=" + idAuction +
                ", date=" + date +
                ", local='" + local + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +

                ", Imovel=" + sortImmobileByValue(immobilises) +
                ", Veiculo=" + sortVehicleByValue(vehicles) +
                '}';
    }

    public void sortValue(){
        Map<Integer, Immobile> sorted = sortImmobileByValue(immobilises);
        printMap(sorted);
    }



    private static Map<Integer, Immobile> sortImmobileByValue(Map<Integer, Immobile> unsortMap) {
        List<Map.Entry<Integer, Immobile>> list =
                new LinkedList<Map.Entry<Integer, Immobile>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Immobile>>() {
            public int compare(Map.Entry<Integer, Immobile> o1,
                               Map.Entry<Integer, Immobile> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        Map<Integer, Immobile> sortedMap = new LinkedHashMap<Integer, Immobile>();
        for (Map.Entry<Integer, Immobile> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    private static Map<Integer, Vehicle> sortVehicleByValue(Map<Integer, Vehicle> unsortMap) {
        List<Map.Entry<Integer, Vehicle>> list =
                new LinkedList<Map.Entry<Integer, Vehicle>>(unsortMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<Integer, Vehicle>>() {
            public int compare(Map.Entry<Integer, Vehicle> o1,
                               Map.Entry<Integer, Vehicle> o2) {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        Map<Integer, Vehicle> sortedMap = new LinkedHashMap<Integer, Vehicle>();
        for (Map.Entry<Integer, Vehicle> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }

    public void filterContain(String filter){
        Map<Integer, Immobile> result = immobilises.entrySet().stream()
                .filter(map -> map.getValue().getNome().contains(filter))
                .collect(Collectors.toMap(map -> map.getKey(), map-> map.getValue()));
        System.out.println("Result: " + result);
    }


    public void filterValue(Double min, Double max){
        Map<Integer, Immobile> result = immobilises.entrySet().stream()
                .filter(map -> map.getValue().getValue() < max && map.getValue().getValue() > min)
                .collect(Collectors.toMap(map -> map.getKey(), map-> map.getValue()));
        System.out.println("Result: " + result);
    }


}
