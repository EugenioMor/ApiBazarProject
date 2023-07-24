package com.bazar.apibazar.Service;
import com.bazar.apibazar.Model.Cliente;
import com.bazar.apibazar.Model.Producto;
import com.bazar.apibazar.Repository.IClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService implements IClienteService {

    @Autowired
    private IClienteRepository clienteRepository;

    @Override
    public List<Cliente> getClientes() {
        List<Cliente> listaClientes = clienteRepository.findAll();
        return listaClientes;
    }

    @Override
    public void saveCliente(Cliente cliente) {

        this.clienteRepository.save(cliente);
    }

    @Override
    public void deleteCliente(Long id_cliente) {

        this.clienteRepository.deleteById(id_cliente);
    }

    @Override
    public Cliente findCliente(Long id_cliente) {

        return clienteRepository.findById(id_cliente).orElse(null);
    }

    @Override
    public boolean editCliente(Cliente cliente, Long id_cliente) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id_cliente);

        if (clienteOptional.isPresent()) {
            Cliente cli = clienteOptional.get();

            cli.setNombre(cliente.getNombre());
            cli.setApellido(cliente.getApellido());
            cli.setDni(cliente.getDni());

            clienteRepository.save(cli);

            return true;
        }

        return false;
    }
}
