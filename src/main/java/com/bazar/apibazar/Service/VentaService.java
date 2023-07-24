package com.bazar.apibazar.Service;
import com.bazar.apibazar.Model.Producto;
import com.bazar.apibazar.Model.Venta;
import com.bazar.apibazar.Repository.IVentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository ventaRepository;

    @Override
    public List<Venta> getVentas() {
        List<Venta> listaVentas = ventaRepository.findAll();
        return listaVentas;
    }

    @Override
    public void saveVenta(Venta venta) {
        this.ventaRepository.save(venta);
    }

    @Override
    public void deleteVenta(Long codigo_venta) {
        this.ventaRepository.deleteById(codigo_venta);
    }

    @Override
    public Venta findVenta(Long codigo_venta) {
        return ventaRepository.findById(codigo_venta).orElse(null);
    }

    @Override
    public boolean editVenta(Venta venta, Long codigo_venta) {
        Optional<Venta> ventaOptional = ventaRepository.findById(codigo_venta);

        if (ventaOptional.isPresent()) {
            Venta vta = ventaOptional.get();

            vta.setFecha_venta(venta.getFecha_venta());
            vta.setTotal(venta.getTotal());
            vta.setListaProductos(venta.getListaProductos());
            vta.setUnCliente(venta.getUnCliente());

            ventaRepository.save(vta);

            return true;
        }

        return false;
    }

    @Override
    public List<Producto> obtenerProductosDeVenta(Long codigo_venta) {
        Venta venta = ventaRepository.findById(codigo_venta).orElse(null);

        return venta.getListaProductos();
    }

    @Override
    public Map<String, Object> obtenerEstadisticasPorDia(LocalDate fecha_venta) {

        Map<String, Object> estadisticas = new HashMap<>();

        BigDecimal sumatoriaMonto = ventaRepository.obtenerSumatoriaMontoPorDia(fecha_venta);
        int cantidadTotalVentas = ventaRepository.obtenerCantidadTotalVentasPorDia(fecha_venta);

        estadisticas.put("sumatoriaMonto", sumatoriaMonto != null ? sumatoriaMonto : BigDecimal.ZERO);
        estadisticas.put("cantidadTotalVentas", cantidadTotalVentas);

        return estadisticas;
    }
}
