package com.bazar.apibazar.Service;
import com.bazar.apibazar.Model.Producto;
import com.bazar.apibazar.Model.Venta;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface IVentaService {


    //Método para traer todas las ventas
    public List<Venta> getVentas();


    //Alta
    public void saveVenta(Venta venta);


    //Baja
    public void deleteVenta(Long codigo_venta);


    //Lectura de un solo objeto
    public Venta findVenta(Long codigo_venta);


    //Edición/modificación
    public boolean editVenta(Venta venta, Long codigo_venta);


    //Obtener los productos de una determinada venta
    List<Producto> obtenerProductosDeVenta(Long codigo_venta);


    //Obtener estadísticas por día: cantidad de ventas y sumatoria del monto total/día
    Map<String, Object> obtenerEstadisticasPorDia(LocalDate fecha_venta);

}
