package com.bazar.apibazar.Service;

import com.bazar.apibazar.Model.Producto;
import com.bazar.apibazar.Repository.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository productoRepository;

    @Override
    public List<Producto> getProductos() {
        List<Producto> listaProductos = productoRepository.findAll();
        return listaProductos;
    }

    @Override
    public void saveProducto(Producto producto) {
        productoRepository.save(producto);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {

        productoRepository.deleteById(codigo_producto);
    }

    @Override
    public Producto findProducto(Long codigo_producto) {
        return productoRepository.findById(codigo_producto).orElse(null);
    }

    @Override
    public boolean editProducto(Producto producto, Long codigo_producto) {
        Optional<Producto> productoOptional = productoRepository.findById(codigo_producto);

        if (productoOptional.isPresent()) {
            Producto prod = productoOptional.get();

            prod.setNombre(producto.getNombre());
            prod.setMarca(producto.getMarca());
            prod.setCosto(producto.getCosto());
            prod.setCantidad_disponible(producto.getCantidad_disponible());

            productoRepository.save(prod);

            return true;
        }

        return false;
    }

    @Override
    public List<Producto> faltaDeStock() {

        List<Producto> productos = productoRepository.findAll();
        List<Producto> cantidadMenorA5 = new ArrayList<>();

        for (Producto producto : productos) {
            if (producto.getCantidad_disponible() < 5) {
                cantidadMenorA5.add(producto);
            }
        }

        return cantidadMenorA5;
    }
}

