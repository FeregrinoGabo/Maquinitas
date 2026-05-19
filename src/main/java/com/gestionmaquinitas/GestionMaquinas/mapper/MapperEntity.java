package com.gestionmaquinitas.GestionMaquinas.mapper;

import com.gestionmaquinitas.GestionMaquinas.dto.request.*;
import com.gestionmaquinitas.GestionMaquinas.model.*;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class MapperEntity {

    //Mapeo CorteRequestDTO a Corte
    public static Corte toEntity(CorteRequestDTO c, Usuario usuario, Asignacion asignacion){
        if (c == null) return null;

        return Corte.builder()
                .dineroRecolectado(c.getDineroRecolectado())
                .fechaCorte(c.getFechaCorte())
                .peluchesRestantes(c.getPeluchesRestantes())
                .porcentajePactado(c.getPorcentajePactado())
                .recargaPeluches(c.getRecargaPeluches())
                .usuario(usuario)
                .asignacion(asignacion)
                .build();
    } 


    //Mapeo EmpresaRequestDTO a Empresa
    public static Empresa toEntity(EmpresaRequestDTO e){
        if (e == null) return null;

        return Empresa.builder()
                .nombre(e.getNombre())
                .build();
    }


    //Mapeo InventarioRequestDTO a Inventario
    public static Inventario toEntity(InventarioRequestDTO i){
        if (i == null) return null;

        return Inventario.builder()
                .nombre(i.getNombre())
                .stock(i.getStock())
                .build();
    }


    //Mapeo MaquinaRequestDTO a Maquina
    public static Maquina toEntity(MaquinaRequestDTO m){
        if (m == null) return null;

        return Maquina.builder()
                .color(m.getColor())
                .capacidad(m.getCapacidad())
                .estado(m.getEstado())
                .descripcion(m.getDescripcion())
                .build();
    }


    //Mapeo TiendaRequestDTO a Tienda
    public static Tienda toEntity(TiendaRequestDTO t){
        if (t == null) return null;

        return Tienda.builder()
                .nombre(t.getNombre())
                .pais(t.getPais())
                .estado(t.getEstado())
                .municipio(t.getMunicipio())
                .colonia(t.getColonia())
                .porcentajeBase(t.getPorcentajeBase())
                .build();
    }


    //Mapeo UsuarioRequestDTO a Usuario
    public static Usuario toEntity(UsuarioRequestDTO u){
        if (u == null) return null;

        return Usuario.builder()
                .nombre(u.getNombre())
                .apellidoPaterno(u.getApellidoPaterno())
                .apellidoMaterno(u.getApellidoMaterno())
                .username(u.getUsername())
                .contrasena(u.getContrasena())
                .build();
    }


    //Mapeo AsignacionRequestDTO a Asignacion
    public static Asignacion toEntity(AsignacionRequestDTO a, Usuario usuario, Tienda tienda, Maquina maquina){
        if (a == null) return null;

        return Asignacion.builder()
                .fechaAsignacion(a.getFechaAsignacion())
                .usuario(usuario)
                .tienda(tienda)
                .maquina(maquina)
                .build();
    }


    //Mepeo EntradaRequestDTO a Entrada
    public static Entrada toEntity(EntradaRequestDTO e, Usuario encargado){
        if (e == null) return null;

        return Entrada.builder()
                .cantidad(e.getCantidad())
                .costo(e.getCosto())
                .descripcion(e.getDescripcion())
                .encargado(encargado)
                .build();
    }
}
