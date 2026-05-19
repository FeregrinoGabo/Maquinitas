package com.gestionmaquinitas.GestionMaquinas.mapper;

import com.gestionmaquinitas.GestionMaquinas.dto.response.*;
import com.gestionmaquinitas.GestionMaquinas.model.*;

public class MapperDTO {

    //Mapeo Corte a CorteDTO
    public static CorteDTO toDTO(Corte c){
        if (c == null) return null;

        return CorteDTO.builder()
                .id(c.getId())
                .dineroRecolectado(c.getDineroRecolectado())
                .fechaCorte(c.getFechaCorte())
                .peluchesRestantes(c.getPeluchesRestantes())
                .porcentajePactado(c.getPorcentajePactado())
                .costoPorPeluche(c.getCostoPorPeluche())
                .recargaPeluches(c.getRecargaPeluches())
                .idUsuario(c.getUsuario() != null ? c .getUsuario().getId() : null)
                .nombreUsuario(c.getUsuario() != null ? c.getUsuario().getNombre() : null)
                .usernameUsuario(c.getUsuario() != null ? c.getUsuario().getUsername() : null)
                .idAsignacion(c.getAsignacion() != null ? c.getAsignacion().getId() : null)
                .idMaquina(c.getAsignacion() != null && c.getAsignacion().getMaquina() != null ? c.getAsignacion().getMaquina().getId() : null)
                .idTienda(c.getAsignacion() != null && c.getAsignacion().getTienda() != null ? c.getAsignacion().getTienda().getId() : null)
                .nombreTienda(c.getAsignacion() != null && c.getAsignacion().getTienda() != null ? c.getAsignacion().getTienda().getNombre() : null)
                .build();
    }


    //Mapeo Empresa a EmpresaDTO
    public static EmpresaDTO toDTO(Empresa e){
        if (e == null) return null;

        return EmpresaDTO.builder()
                .id(e.getId())
                .nombre(e.getNombre())
                .build();
    }


    //Mapeo Inventario a InventarioDTO
    public static InventarioDTO toDTO(Inventario i){
        if (i == null) return null;

        return InventarioDTO.builder()
                .id(i.getId())
                .nombre(i.getNombre())
                .stock(i.getStock())
                .costoPromedio(i.getCostoPromedio())
                .build();
    }


    //Mapeo Maquina a MaquinaDTO
    public static MaquinaDTO toDTO(Maquina m){
        if (m == null) return null;

        return MaquinaDTO.builder()
                .id(m.getId())
                .color(m.getColor())
                .capacidad(m.getCapacidad())
                .descripcion(m.getDescripcion() != null ? m.getDescripcion() : null)
                .estado(m.getEstado())
                .build();
    }



    //Mapeo Tienda a TiendaDTO
    public static TiendaDTO toDTO(Tienda t){
        if (t == null) return null;

        return TiendaDTO.builder()
                .id(t.getId())
                .nombre(t.getNombre())
                .pais(t.getPais())
                .estado(t.getEstado())
                .municipio(t.getMunicipio())
                .colonia(t.getColonia())
                .porcentajeBase(t.getPorcentajeBase())
                .fechaCreacion(t.getFechaCreacion())
                .fechaRetiro(t.getFechaRetiro())
                .build();
    }


    //Mapeo Usuario a UsuarioDTO
    public static UsuarioDTO toDTO(Usuario u){
        if (u == null) return null;

        return UsuarioDTO.builder()
                .id(u.getId())
                .nombre(u.getNombre())
                .apellidoPaterno(u.getApellidoPaterno())
                .apellidoMaterno(u.getApellidoMaterno())
                .username(u.getUsername())
                .build();
    }


    //Mapeo Asignacion a AsignacionDTO
    public static AsignacionDTO toDTO(Asignacion a){
        if (a == null) return null;

        return AsignacionDTO.builder()
                .id(a.getId())
                .fechaAsignacion(a.getFechaAsignacion())
                .fechaRetiro(a.getFechaRetiro())
                .nombreUsuario(a.getUsuario() != null ? a.getUsuario().getNombre() : null)
                .nombreTienda(a.getTienda() != null ? a.getTienda().getNombre() : null)
                .idMaquina(a.getMaquina() != null ? a.getMaquina().getId() : null)
                .build();
    }


    //Mapeo Entrada a EntradaDTO
    public static EntradaDTO toDTO(Entrada e){
        if (e == null) return null;

        return EntradaDTO.builder()
                .id(e.getId())
                .cantidad(e.getCantidad())
                .costo(e.getCosto())
                .descripcion(e.getDescripcion())
                .fechaLlegada(e.getFechaLlegada())
                .idEncargado(e.getEncargado().getId())
                .build();
    }
}
