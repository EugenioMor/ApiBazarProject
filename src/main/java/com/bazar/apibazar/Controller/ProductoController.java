package com.bazar.apibazar.Controller;
import com.bazar.apibazar.Model.Producto;
import com.bazar.apibazar.Service.IProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private IProductoService productoService;


    @GetMapping("/productos")
    public List<Producto> traerProductos() {

        return productoService.getProductos();
    }


    @GetMapping("/productos/{codigo_producto}")
    public Producto traerProducto(@PathVariable Long codigo_producto) {

        return productoService.findProducto(codigo_producto);
    }


    @PostMapping("/productos/crear")
    public String saveProducto(@RequestBody Producto producto) {
        productoService.saveProducto(producto);

        return "El producto fue creado correctamente";
    }


    @PutMapping("/productos/editar/{codigo_producto}")
    public String editProducto(@RequestBody Producto producto, @PathVariable Long codigo_producto) {

        productoService.editProducto(producto, codigo_producto);
        return "El producto con el id " + codigo_producto + " fue editado correctamente";
    }


    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public String deleteProducto(@PathVariable Long codigo_producto) {
        productoService.deleteProducto(codigo_producto);
        return "El producto con el id " + codigo_producto + " fue eliminado correctamente";
    }


    @GetMapping("/productos/falta_stock")
    public List<Producto> faltaDeStock() {

        return productoService.faltaDeStock();
    }
}
