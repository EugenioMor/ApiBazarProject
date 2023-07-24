package com.bazar.apibazar.Controller;
import com.bazar.apibazar.Model.Cliente;
import com.bazar.apibazar.Model.Producto;
import com.bazar.apibazar.Model.Venta;
import com.bazar.apibazar.Service.IVentaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
public class VentaController {

    @Autowired
    private IVentaService ventaService;


    @GetMapping("/ventas")
    public List<Venta> traerVentas() {
        return ventaService.getVentas();
    }

    @GetMapping("/ventas/{codigo_venta}")
    public Venta traerVenta(@PathVariable Long codigo_venta) {
        return ventaService.findVenta(codigo_venta);
    }

    @PostMapping("/ventas/crear")
    public String saveVenta(@RequestBody Venta venta) {
        ventaService.saveVenta(venta);

        return "La venta fue creada correctamente";
    }

    @PutMapping("/ventas/editar/{codigo_venta}")
    public String editVenta(@RequestBody Venta venta, @PathVariable Long codigo_venta) {

        ventaService.editVenta(venta, codigo_venta);
        return "La venta con el id " + codigo_venta + " fue editada correctamente";
    }

    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public String deleteVenta(@PathVariable Long codigo_venta) {
        ventaService.deleteVenta(codigo_venta);
        return "La venta con el id " + codigo_venta + " fue eliminada correctamente";
    }

    @GetMapping("/ventas/productos/{codigo_venta}")
    public ResponseEntity<List<Producto>> obtenerProductosDeVenta(@PathVariable Long codigo_venta) {
        List<Producto> productos = ventaService.obtenerProductosDeVenta(codigo_venta);
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/ventas/fecha_venta/{fecha_venta}")
    public ResponseEntity<Map<String, Object>> obtenerEstadisticasPorDia(@PathVariable LocalDate fecha_venta) {
        Map<String, Object> estadisticas = ventaService.obtenerEstadisticasPorDia(fecha_venta);
        return ResponseEntity.ok(estadisticas);
    }
}
