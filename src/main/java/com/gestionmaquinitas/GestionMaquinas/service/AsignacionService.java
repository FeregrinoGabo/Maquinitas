package com.gestionmaquinitas.GestionMaquinas.service;

import com.gestionmaquinitas.GestionMaquinas.dto.request.AsignacionRequestDTO;
import com.gestionmaquinitas.GestionMaquinas.dto.response.AsignacionDTO;
import com.gestionmaquinitas.GestionMaquinas.exception.NotFoundException;
import com.gestionmaquinitas.GestionMaquinas.mapper.MapperDTO;
import com.gestionmaquinitas.GestionMaquinas.model.Asignacion;
import com.gestionmaquinitas.GestionMaquinas.model.Maquina;
import com.gestionmaquinitas.GestionMaquinas.model.Tienda;
import com.gestionmaquinitas.GestionMaquinas.model.Usuario;
import com.gestionmaquinitas.GestionMaquinas.repository.AsignacionRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AsignacionService implements IAsignacionService{

    private final AsignacionRepository asignacionRepository;
    private final UsuarioService usuarioService;
    private final TiendaService tiendaService;
    private final MaquinaService maquinaService;

    @Override
    public List<AsignacionDTO> getAsignacion() {
        return asignacionRepository.findAll().stream().map(MapperDTO::toDTO).toList();
    }

    @Override
    public AsignacionDTO getOneAsignacion(Long id) {
        return asignacionRepository.findById(id).map(MapperDTO::toDTO).orElseThrow(() -> new NotFoundException(
                "La asignacion con el id: " + id + " no se ha encontrado"
        ));
    }

    @Override
    public Asignacion getOneAsignacionEntity(Long id) {
        return asignacionRepository.findById(id).orElseThrow(() -> new NotFoundException("La asignacion con ID: " + id +
                " no se ha encontrado"));
    }

    @Override
    @Transactional
    public AsignacionDTO createAsignacion(AsignacionRequestDTO asignacionRequestDTO) {
        Usuario usuario = usuarioService.getOneUsuarioEntity(asignacionRequestDTO.getIdUsuario());
        Tienda tienda = tiendaService.getOneTiendaEntity(asignacionRequestDTO.getIdTienda());
        Maquina maquina = maquinaService.getOneMaquinaEntity(asignacionRequestDTO.getIdMaquina());

        Asignacion asignacion = Asignacion.builder()
                .usuario(usuario)
                .tienda(tienda)
                .maquina(maquina)
                .build();

        Asignacion asignacionGuardar = asignacionRepository.save(asignacion);

        return MapperDTO.toDTO(asignacionGuardar);
    }

    @Override
    @Transactional
    public AsignacionDTO updateAsignacion(AsignacionRequestDTO asignacionRequestDTO, Long id) {
        Asignacion asignacion = asignacionRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "No se ha encontrado la asignacion. Asignacion con ID: " + id
        ));

        asignacion.setUsuario(usuarioService.getOneUsuarioEntity(asignacionRequestDTO.getIdUsuario()));
        asignacion.setTienda(tiendaService.getOneTiendaEntity(asignacionRequestDTO.getIdTienda()));
        asignacion.setMaquina(maquinaService.getOneMaquinaEntity(asignacionRequestDTO.getIdMaquina()));

        return MapperDTO.toDTO(asignacionRepository.save(asignacion));
    }

    @Override
    @Transactional
    public void deleteAsignacion(Long id) {
        asignacionRepository.deleteById(id);
    }
}
