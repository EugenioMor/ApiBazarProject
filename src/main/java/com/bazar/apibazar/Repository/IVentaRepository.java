package com.bazar.apibazar.Repository;
import com.bazar.apibazar.Model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.math.BigDecimal;
import java.time.LocalDate;

@Repository
public interface IVentaRepository extends JpaRepository<Venta, Long> {

    @Query("SELECT SUM(v.total) FROM Venta v WHERE v.fecha_venta = :fecha_venta")
    BigDecimal obtenerSumatoriaMontoPorDia(@Param("fecha_venta") LocalDate fecha_venta);

    @Query("SELECT COUNT(v) FROM Venta v WHERE v.fecha_venta = :fecha_venta")
    int obtenerCantidadTotalVentasPorDia(@Param("fecha_venta") LocalDate fecha_venta);
}
