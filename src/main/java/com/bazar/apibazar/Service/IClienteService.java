package com.bazar.apibazar.Service;
import com.bazar.apibazar.Model.Cliente;
import java.util.List;

public interface IClienteService {

    //Método para traer todos los clientes
    public List<Cliente> getClientes();


    //Alta
    public void saveCliente(Cliente cliente);


    //Baja
    public void deleteCliente(Long id_cliente);


    //Lectura de un solo objeto
    public Cliente findCliente(Long id_cliente);


    //Edición/Modificación
    public boolean editCliente(Cliente cliente, Long id_cliente);
}
