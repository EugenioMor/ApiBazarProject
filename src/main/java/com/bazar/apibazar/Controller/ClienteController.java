package com.bazar.apibazar.Controller;
import com.bazar.apibazar.Model.Cliente;
import com.bazar.apibazar.Model.Producto;
import com.bazar.apibazar.Service.IClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClienteController {

    @Autowired
    private IClienteService clienteService;


    @GetMapping("/clientes")
    public List<Cliente> traerClientes() {
        return clienteService.getClientes();
    }

    @GetMapping("/clientes/{id_cliente}")
    public Cliente traerCliente(@PathVariable Long id_cliente) {
        return clienteService.findCliente(id_cliente);
    }


    @PostMapping("/clientes/crear")
    public String saveCliente(@RequestBody Cliente cliente) {
        clienteService.saveCliente(cliente);

        return "El cliente fue creado correctamente";
    }

    @PutMapping("/clientes/editar/{id_cliente}")
    public String editCliente(@RequestBody Cliente cliente, @PathVariable Long id_cliente) {

        clienteService.editCliente(cliente, id_cliente);
        return "El cliente con el id " + id_cliente + " fue editado correctamente";
    }

    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public String deleteCliente(@PathVariable Long id_cliente) {
        clienteService.deleteCliente(id_cliente);
        return "El cliente con el id " + id_cliente + " fue eliminado correctamente";
    }
}
