package utils;

import financeira.FinanceiraManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Utils {
    public Random random = new Random();
    public Scanner input = new Scanner(System.in);

    public void showMap(Map hashMap){
        for (int index = 1; index <= hashMap.size(); index++){
            try{
                System.out.println(hashMap.get(index).toString());
            }
            catch (NullPointerException exception){
                System.out.println("continue");
            }

        }
    }

    public static <K, V> void printMap(Map<K, V> map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            System.out.println("Key : " + entry.getKey()
                    + " Value : " + entry.getValue());
        }
    }

    public void write(String output){
        System.out.println(output);
    }


    public static LocalDate convert(String dateStr) {
        return LocalDate.parse(dateStr, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    protected boolean checkIfNull(Object value){
        return value != null;
    }

    public void removeMessage(Integer id){
        write("Registro " + id +" removido");
    }

    public void updateMessage(Integer id){
        write("Registro " + id +" removido");
    }

    public void nullPointerMessage(Integer id){
        write("Registro " + id +" não encontrado");
    }
}
