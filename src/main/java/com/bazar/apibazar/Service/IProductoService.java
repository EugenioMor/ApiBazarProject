package com.bazar.apibazar.Service;
import com.bazar.apibazar.Model.Producto;
import java.util.List;

public interface IProductoService {

    //Método para traer todos los productos
    public List<Producto> getProductos();


    //Alta
    public void saveProducto(Producto producto);


    //Baja
    public void deleteProducto(Long codigo_producto);


    //Lectura de un solo objeto
    public Producto findProducto(Long codigo_producto);


    //Edición/modificación
    public boolean editProducto(Producto producto, Long codigo_producto);


    //Falta de Stock
    public List<Producto> faltaDeStock();


}
