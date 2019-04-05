/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class JDBCInformeDAO implements InformeDAO {

    private static Connection c = Conexion.getConnection();
    
    @Override
    public ArrayList<Object[]> llenarTablaHabitacionOcupada() {

        ArrayList<Object[]> elementosTabla = new ArrayList<Object[]>();

        try {
            String query = "SELECT \n" +
                            "    h.nombre,\n" +
                            "    r.num_pasajeros AS 'numero de pasajeros',\n" +
                            "    p.nombre AS 'nombre producto consumido',\n" +
                            "    r.limite_tiempo AS 'limite de tiempo'\n" +
                            "FROM\n" +
                            "    habitacion h\n" +
                            "        JOIN\n" +
                            "    reserva r ON (h.idhabitacion = r.habitacion_idhabitacion)\n" +
                            "        INNER JOIN\n" +
                            "    (SELECT \n" +
                            "        rr.habitacion_idhabitacion idhabitacion,\n" +
                            "            MAX(idjornada) idjornada\n" +
                            "    FROM\n" +
                            "        reserva rr\n" +
                            "    GROUP BY idhabitacion) b ON h.idhabitacion = b.idhabitacion\n" +
                            "        AND r.idjornada = b.idjornada\n" +
                            "        JOIN\n" +
                            "    reserva_has_producto rhp ON (r.idjornada = rhp.reserva_idjornada)\n" +
                            "		INNER JOIN\n" +
                            "	(SELECT rrhp.reserva_idjornada idjornada,\n" +
                            "		MAX(rrhp.idreserva_has_producto) idreserva_has_producto\n" +
                            "    FROM\n" +
                            "		reserva_has_producto rrhp\n" +
                            "	GROUP BY idjornada) c ON r.idjornada = c.idjornada AND\n" +
                            "    c.idreserva_has_producto = rhp.idreserva_has_producto\n" +
                            "        JOIN\n" +
                            "    producto p ON (rhp.producto_idproducto = p.idproducto)\n" +
                            "WHERE\n" +
                            "    h.ocupado = '1'\n" +
                            "ORDER BY r.idjornada , rhp.idreserva_has_producto DESC";

            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                
                
                elementosTabla.add(new Object[]{
                    rs.getObject("nombre"),
                    rs.getObject("numero de pasajeros"),
                    rs.getObject("nombre producto consumido"),
                    rs.getObject("limite de tiempo")
//                    rs.getObject("limite de tiempo"
                });

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return elementosTabla;

    }
    
    @Override
    public ArrayList<Object[]> informeCliente(int rut) {
        // Retorna toda la información del cliente contenida en la clase
        // Además de todos sus registros de entrada, habitaciones utilizadas y consumo por periodo
       ArrayList<Object[]> elementosTabla = new ArrayList<Object[]>(); 
          
        try 
        {
            // queri para ver el historial del cliente
            String query = "SELECT \n" +
                        "    r.inicio 'Fecha y hora de ingreso',\n" +
                        "    CASE r.pasajero_rut\n" +
                        "        WHEN ? THEN 'Pasajero Principal'\n" +
                        "        ELSE 'Acompañante'\n" +
                            "    END AS 'Visita como',\n" +
                        "    h.nombre AS 'Nombre Habitación',\n" +
                        "    SUM(rhp.precio * rhp.cantidad) AS 'Consumo Total'\n" +
                        "FROM\n" +
                        "    registro_pasajeros rp\n" +
                        "        JOIN\n" +
                        "    reserva r ON r.idjornada = rp.reserva_idjornada\n" +
                        "        JOIN\n" +
                        "    habitacion h ON r.habitacion_idhabitacion = h.idhabitacion\n" +
                        "        JOIN\n" +
                        "    reserva_has_producto rhp ON r.idjornada = rhp.reserva_idjornada\n" +
                        "        JOIN\n" +
                        "    producto p ON rhp.producto_idproducto = p.idproducto\n" +
                        "WHERE\n" +
                        "    rp.pasajero_rut = ?\n" +
                        "GROUP BY r.idjornada";
            PreparedStatement ps = c.prepareStatement(query);
            ps.setInt(1, rut);
            ps.setInt(2, rut);
            ResultSet rs = ps.executeQuery();
            while (rs.next() ) {
                elementosTabla.add(new Object[] {
                    rs.getObject("Fecha y hora de ingreso"),
                    rs.getObject("Visita como"),
                    rs.getObject("Nombre Habitación"),
                    rs.getObject("Consumo Total")
                });
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return elementosTabla;
        
}
    
    @Override
    public ArrayList<Object[]> informeClienteDelAmor() {
        // similar pero sin rut a busqueda cliente
        // recuperar RUT del cliente del amor
        ArrayList<Object[]> elementosTabla = new ArrayList<Object[]>(); 
        int rut = 0;
        try {
            String query1 = "SELECT r.pasajero_rut , COUNT(r.pasajero_rut) cuenta\n" +
                            "FROM reserva r\n" +
                            "GROUP BY r.pasajero_rut\n" +
                            "ORDER BY cuenta DESC\n" +
                            "LIMIT 1";
            PreparedStatement ps = c.prepareStatement(query1);
            ResultSet rs1 = ps.executeQuery();
            rs1.next();
            rut = rs1.getInt("pasajero_rut");
            
            elementosTabla = informeCliente(rut);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return elementosTabla;
    
    
}
    @Override
    public ArrayList<Object[]> informeHabitacion(boolean mayorUso){
        ArrayList<Object[]> elementosTabla = new ArrayList<Object[]>(); 
        String query = "";
        
        try
        {
            if (mayorUso) 
            {
            query = "SELECT \n" +
                    "    a.inicio,\n" +
                    "    CASE a.momento\n" +
                    "        WHEN '1' THEN 'Momento (3 hrs)'\n" +
                    "        ELSE 'Jornada (12 hrs)'\n" +
                    "    END AS 'Tipo de estadía',\n" +
                    "    CONCAT(p.nombres , ' ',\n" +
                    "        p.apellido_paterno,\n" +
                    "        ' ',\n" +
                    "        p.apellido_materno) AS 'Nombre Cliente',\n" +
                    "    SUM(rhp.precio * rhp.cantidad) AS 'Consumo Total de la Visita (incluye precio habitacion)'\n" +
                    "FROM\n" +
                    "    reserva a\n" +
                    "        JOIN\n" +
                    "    pasajero p ON a.pasajero_rut = p.rut\n" +
                    "        JOIN\n" +
                    "    reserva_has_producto rhp ON a.idjornada = rhp.reserva_idjornada\n" +
                    "        JOIN\n" +
                    "    producto prod ON rhp.producto_idproducto = prod.idproducto\n" +
                    "WHERE\n" +
                    "    a.habitacion_idhabitacion = (SELECT \n" +
                    "            r.habitacion_idhabitacion idhabitacion\n" +
                    "        FROM\n" +
                    "            reserva r\n" +
                    "                JOIN\n" +
                    "            habitacion h ON r.habitacion_idhabitacion = h.idhabitacion\n" +
                    "        GROUP BY r.habitacion_idhabitacion\n" +
                    "        ORDER BY COUNT(r.idjornada) DESC\n" +
                    "        LIMIT 1)\n" +
                    "GROUP BY a.idjornada";
            } 
            else 
            {
                query = "SELECT \n" +
                    "    a.inicio,\n" +
                    "    CASE a.momento\n" +
                    "        WHEN '1' THEN 'Momento (3 hrs)'\n" +
                    "        ELSE 'Jornada (12 hrs)'\n" +
                    "    END AS 'Tipo de estadía',\n" +
                    "    CONCAT(p.nombres , ' ',\n" +
                    "        p.apellido_paterno,\n" +
                    "        ' ',\n" +
                    "        p.apellido_materno) AS 'Nombre Cliente',\n" +
                    "    SUM(rhp.precio * rhp.cantidad) AS 'Consumo Total de la Visita (incluye precio habitacion)'\n" +
                    "FROM\n" +
                    "    reserva a\n" +
                    "        JOIN\n" +
                    "    pasajero p ON a.pasajero_rut = p.rut\n" +
                    "        JOIN\n" +
                    "    reserva_has_producto rhp ON a.idjornada = rhp.reserva_idjornada\n" +
                    "        JOIN\n" +
                    "    producto prod ON rhp.producto_idproducto = prod.idproducto\n" +
                    "WHERE\n" +
                    "    a.habitacion_idhabitacion = (SELECT \n" +
                    "            r.habitacion_idhabitacion idhabitacion\n" +
                    "        FROM\n" +
                    "            reserva r\n" +
                    "                JOIN\n" +
                    "            habitacion h ON r.habitacion_idhabitacion = h.idhabitacion\n" +
                    "        GROUP BY r.habitacion_idhabitacion\n" +
                    "        ORDER BY COUNT(r.idjornada) ASC\n" +
                    "        LIMIT 1)\n" +
                    "GROUP BY a.idjornada";
            }
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            
              while (rs.next() ) {
                elementosTabla.add(new Object[] {
                    rs.getObject("inicio"),
                    rs.getObject("Tipo de estadía"),
                    rs.getObject("Nombre Cliente"),
                    rs.getObject("Consumo Total de la Visita (incluye precio habitacion)")
                });
              }
        } catch (SQLException e) {
            e.printStackTrace();
        }

       return elementosTabla;
}
    @Override
    public Object[] informeProducto(boolean mayorVenta){
        // producto mas ventas (true) menos ventas (false)
        // habitacion mayor ventas, numero ventas
        // habitacion menor ventas, numero ventas
        
        Object[] elementos = new Object[6];

        // 1 recuperar producto mayor o menor venta
        
        // 2 a partir de la idproducto calcular habitacion que mas vende y que menos vende
        int idproducto = 0;
        
        Object nombreProducto;
        Object nombreHabitacionMasVentas;
        Object cantidadMayorVentas;
        Object nombreHabitacionMenosVentas;
        Object cantidadMenorVentas;
        Object cantidadVendida;
        
        
        String queryMenorProducto = "SELECT \n" +
                       "    p.idproducto,\n" +
                        "    p.nombre AS 'Nombre Producto Menos Vendido',\n" +
                        "    COUNT(rhp.producto_idproducto) 'numero de ventas',\n" +
                        "    sum(rhp.cantidad) AS 'unidades vendidas',\n" +
                        "    p.precio AS 'Precio Unidad',\n" +
                        "    SUM(p.precio * rhp.cantidad) 'Total'\n" +
                        "FROM\n" +
                        "    reserva_has_producto rhp\n" +
                        "        JOIN\n" +
                        "    producto p ON rhp.producto_idproducto = p.idproducto\n" +
                        "        JOIN\n" +
                        "    reserva r ON rhp.reserva_idjornada = r.idjornada\n" +
                        "WHERE NOT p.tipo = 'Habitacion'\n" +
                        "GROUP BY p.idproducto\n" +
                        "ORDER BY SUM(rhp.cantidad) ASC\n" +
                        "LIMIT 1";

        String queryMayorProducto = "SELECT \n" +
                        "    p.idproducto,\n" +
                        "    p.nombre AS 'Nombre Producto Más Vendido',\n" +
                        "    COUNT(rhp.producto_idproducto) 'numero de ventas',\n" +
                        "    sum(rhp.cantidad) AS 'unidades vendidas',\n" +
                        "    p.precio AS 'Precio Unidad',\n" +
                        "    SUM(p.precio * rhp.cantidad) 'Total'\n" +
                        "FROM\n" +
                        "    reserva_has_producto rhp\n" +
                        "        JOIN\n" +
                        "    producto p ON rhp.producto_idproducto = p.idproducto\n" +
                        "        JOIN\n" +
                        "    reserva r ON rhp.reserva_idjornada = r.idjornada\n" +
                        "WHERE NOT p.tipo = 'Habitacion'\n" +
                        "GROUP BY p.idproducto\n" +
                        "ORDER BY SUM(rhp.cantidad) DESC\n" +
                        "LIMIT 1";

        String queryHabitacionMayorVenta = "SELECT \n" +
                        "    SUM(rhp.cantidad) AS 'N ventas',\n" +
                        "    rhp.producto_idproducto AS 'idproducto',\n" +
                        "    p.nombre,\n" +
                        "    r.habitacion_idhabitacion AS 'idhabitacion',\n" +
                        "    h.nombre AS 'Nombre Habitacion Mayor Ventas'\n" +
                        "FROM\n" +
                        "    reserva_has_producto rhp\n" +
                        "        JOIN\n" +
                        "    reserva r ON rhp.reserva_idjornada = r.idjornada\n" +
                        "        JOIN\n" +
                        "    habitacion h ON h.idhabitacion = r.habitacion_idhabitacion\n" +
                        "		JOIN\n" +
                        "	producto p ON rhp.producto_idproducto = p.idproducto\n" +
                        "where rhp.producto_idproducto = ?\n" +
                        "GROUP BY rhp.producto_idproducto , r.habitacion_idhabitacion\n" +
                        "ORDER BY COUNT(rhp.producto_idproducto) DESC LIMIT 1";

        String queryHabitacionMenorVenta = "SELECT \n" +
                        "    SUM(rhp.cantidad) AS 'N ventas',\n" +
                        "    rhp.producto_idproducto AS 'idproducto',\n" +
                        "    p.nombre,\n" +
                        "    r.habitacion_idhabitacion AS 'idhabitacion',\n" +
                        "    h.nombre AS 'Nombre Habitacion Menos Ventas'\n" +
                        "FROM\n" +
                        "    reserva_has_producto rhp\n" +
                        "        JOIN\n" +
                        "    reserva r ON rhp.reserva_idjornada = r.idjornada\n" +
                        "        JOIN\n" +
                        "    habitacion h ON h.idhabitacion = r.habitacion_idhabitacion\n" +
                        "		JOIN\n" +
                        "	producto p ON rhp.producto_idproducto = p.idproducto\n" +
                        "where rhp.producto_idproducto = ?\n" +
                        "GROUP BY rhp.producto_idproducto , r.habitacion_idhabitacion\n" +
                        "ORDER BY COUNT(rhp.producto_idproducto) ASC LIMIT 1";
        
        try
        {
            PreparedStatement ps1;
            if (mayorVenta) {
                ps1 = c.prepareStatement(queryMayorProducto);
            } else {
                ps1 = c.prepareStatement(queryMenorProducto);
            }
            ResultSet rs1 = ps1.executeQuery();
            rs1.next();
            idproducto = rs1.getInt("idproducto");
            
            if (mayorVenta) {
                nombreProducto = rs1.getObject("Nombre Producto Más Vendido");
            } else {
                nombreProducto = rs1.getObject("Nombre Producto Menos Vendido");
            }
            
            cantidadVendida = rs1.getObject("unidades vendidas");
            
            PreparedStatement ps2 = c.prepareStatement(queryHabitacionMayorVenta);
            ps2.setInt(1, idproducto);
            
            ResultSet rs2 = ps2.executeQuery();
            rs2.next();
            nombreHabitacionMasVentas = rs2.getObject("Nombre Habitacion Mayor Ventas");
            cantidadMayorVentas = rs2.getObject("N ventas");
            
            
            PreparedStatement ps3 = c.prepareStatement(queryHabitacionMenorVenta);
            ps3.setInt(1, idproducto);
            
            ResultSet rs3 = ps3.executeQuery();
            rs3.next();
            
            nombreHabitacionMenosVentas = rs3.getObject("Nombre Habitacion Menos Ventas");
            cantidadMenorVentas = rs3.getObject("N ventas");
            
            elementos[0] = nombreProducto;
            elementos[1] = nombreHabitacionMasVentas;
            elementos[2] = nombreHabitacionMenosVentas;
            elementos[3] = cantidadMayorVentas;
            elementos[4] = cantidadMenorVentas;
            elementos[5] = cantidadVendida;
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return elementos;
}
    @Override
    public Object[] informeHabitacionMayorPromedioPasajeros(){
        // informe habitacion pero en vez de mayor uso mayor promedio pasajeros ingreso
        
        Object[] elementos = new Object[2]; 
        String query = "SELECT\n" +
                        "	h.nombre, AVG(r.num_pasajeros) AS 'promedio pasajeros'\n" +
                        "FROM\n" +
                        "	reserva r\n" +
                        "JOIN\n" +
                        "	habitacion h ON r.habitacion_idhabitacion = h.idhabitacion\n" +
                        "GROUP BY\n" +
                        "	r.habitacion_idhabitacion\n" +
                        "ORDER BY\n" +
                        "	AVG(r.num_pasajeros) DESC\n" +
                        "LIMIT 1";
        
        try
        {
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            
            
            elementos[0]=rs.getObject("nombre");
            elementos[1]=rs.getObject("promedio pasajeros");
            
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return elementos;
}
    @Override
    public ArrayList<Object[]> informeHabitaciones(){
        
        ArrayList<Object[]> elementosTabla = new ArrayList<Object[]>(); 
        
        String query =  "SELECT \n" +
                        "    r.habitacion_idhabitacion AS idhabitacion,\n" +
                        "    h.nombre AS 'Nombre Habitacion',\n" +
                        "    CASE r.momento\n" +
                        "        WHEN '1' THEN 'Momento'\n" +
                        "        ELSE 'Jornada'\n" +
                        "    END AS 'Tipo Estadía',\n" +
                        "    AVG(r.num_pasajeros) AS 'Promedio Pasajeros',\n" +
                        "    COUNT(r.num_pasajeros) AS 'Numero de visitas',\n" +
                        "    SUM(r.num_pasajeros) AS 'Total Pasajeros'\n" +
                        "FROM\n" +
                        "    reserva r\n" +
                        "        JOIN\n" +
                        "    habitacion h ON r.habitacion_idhabitacion = h.idhabitacion\n" +
                        "GROUP BY r.habitacion_idhabitacion , r.momento;";
        
        try
        {
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                elementosTabla.add(new Object[] {
                    rs.getObject("Nombre Habitacion"),
                    rs.getObject("Tipo Estadía"),
                    rs.getObject("Promedio Pasajeros"),
                    rs.getObject("Numero de visitas"),
                    rs.getObject("Total Pasajeros")
                });
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return elementosTabla;
    }
    
    @Override
    public Object nombreHabitacion(boolean mayorUso) {
        Object nombre = new Object();
        String query = "";
        try
        {
            if (mayorUso) {
                query = "SELECT \n" +
                                "    h.nombre, h.idhabitacion, COUNT(r.idjornada) AS 'visitas'\n" +
                                "FROM\n" +
                                "    reserva r\n" +
                                "        JOIN\n" +
                                "    habitacion h ON r.habitacion_idhabitacion = h.idhabitacion\n" +
                                "GROUP BY idhabitacion\n" +
                                "ORDER BY COUNT(r.idjornada) DESC\n" +
                                "LIMIT 1";
            } else {
                query =  "SELECT \n" +
                                "    h.nombre, h.idhabitacion, COUNT(r.idjornada) AS 'visitas'\n" +
                                "FROM\n" +
                                "    reserva r\n" +
                                "        JOIN\n" +
                                "    habitacion h ON r.habitacion_idhabitacion = h.idhabitacion\n" +
                                "GROUP BY idhabitacion\n" +
                                "ORDER BY COUNT(r.idjornada) ASC\n" +
                                "LIMIT 1";
            }
            PreparedStatement ps = c.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            rs.next();
            nombre = rs.getObject("nombre");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return nombre;
    }

    @Override
    public ArrayList<Object[]> informeConsumoReserva(int idjornada) {
        
        ArrayList<Object[]> elementos = new ArrayList<Object[]>();
        String queri ="SELECT p.nombre, rhp.cantidad, rhp.precio, rhp.cantidad*rhp.precio AS 'Subtotal'\n" +
                        "FROM reserva r \n" +
                        "JOIN reserva_has_producto rhp\n" +
                        "ON r.idjornada = rhp.reserva_idjornada\n" +
                        "JOIN producto p\n" +
                        "ON rhp.producto_idproducto = p.idproducto\n" +
                        "WHERE r.idjornada = ?";
        try
        {
            PreparedStatement ps = c.prepareStatement(queri);
            ps.setInt(1, idjornada);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()) {
                elementos.add(new Object[] {
                    rs.getObject("nombre"),
                    rs.getObject("cantidad"),
                    rs.getObject("precio"),
                    rs.getObject("Subtotal")
                });
            }
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return elementos;
    }
}
