package com.gestionmaquinitas.GestionMaquinas.mapper;

import com.gestionmaquinitas.GestionMaquinas.dto.request.UsuarioRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.*;
import com.gestionmaquinitas.GestionMaquinas.model.*;

public class MapperEntity {

    //Mapeo CorteDTO a Corte
    public static Corte toDTO(CorteDTO c, Usuario usuario, Asignacion asignacion){
        if (c == null) return null;

        return Corte.builder()
                .dineroRecolectado(c.getDineroRecolectado())
                .fechaCorte(c.getFechaCorte())
                .peluchesRestantes(c.getPeluchesRestantes())
                .porcentajePactado(c.getPorcentajePactado())
                .costoPorPeluche(c.getCostoPorPeluche())
                .recargaPeluches(c.getRecargaPeluches())
                .usuario(usuario)
                .asignacion(asignacion)
                .build();
    } 


    //Mapeo EmpresaDTO a Empresa
    public static EmpresaDTO toDTO(Empresa e){
        return null;
    }


    //Mapeo InventarioDTO a Inventario
    public static InventarioDTO toDTO(Inventario i){
        return null;
    }


    //Mapeo MaquinaDTO a Maquina
    public static MaquinaDTO toDTO(Maquina m){
        return null;
    }


    //Mapeo TiendaDTO a Tienda
    public static TiendaDTO toDTO(Tienda t){
        return null;
    }


    //Mapeo UsuarioDTO a Usuario
    public static Usuario toEntity(UsuarioRequestDTO u){
        if (u == null) return null;

        return Usuario.builder()
                .nombre(u.getNombre())
                .apellidoPaterno(u.getApellidoPaterno())
                .apellidoMaterno(u.getApellidoMaterno())
                .username(u.getUsername())
                .contrasena(u.getContrasena())
                .rol(u.getRol())
                .build();
    }


    //Mapeo AsignacionDTO a Asignacion
    public static AsignacionDTO toDTO(Asignacion a){
        return null;
    }
}
