package cliente;

import org.jetbrains.annotations.Nullable;
import utils.Utils;

import java.util.Hashtable;

public class ClienteManager extends Utils {
    private final Hashtable<String, Cliente> clientes = new Hashtable<String, Cliente>();

    public void registerNewCliente(String nome, String email, String password){
        Cliente cliente = new Cliente(nome, email, password);
        clientes.put(email, cliente);
    }

    public boolean login(String email, String senha){
        try {
            Cliente cliente = clientes.get(email);
            if (cliente.getSenha().equals(senha)){
                return true;
            }
            else{
                return false;
            }
        }
        catch (NullPointerException e){
            System.out.println("Usuario não encontrado");
            return false;
        }
    }

    public void updateCliente(@Nullable String email,@Nullable String senha,@Nullable String nome){
        try {
            Cliente cliente = clientes.get(email);
            if (checkIfNull(senha)){
                cliente.setSenha(senha);
            }
            if (checkIfNull(nome)){
                cliente.setNome(nome);
            }
        }
        catch (NullPointerException e){
            System.out.println("Usuario não encontrado");
        }
    }

    public void removeCliente(String email){
        try{
            clientes.remove(email);
        }
        catch (NullPointerException e){
            System.out.println("Usuario não encontrado");
        }
    }
}
