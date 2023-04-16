package com.thecatlong.back.application.deporte;

import java.util.List;

import org.springframework.stereotype.Component;

import com.thecatlong.back.application.provider.out.DeporteService;
import com.thecatlong.back.domain.Deporte;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DeporteUseCase {
    private final DeporteService deporteService;

    /**
     * Metodo del usecase para invocar al servicio de busqueda
     * @param nombre valor por el cual se busca
     * @return Lista de valores encontrados
     */
    public List<Deporte> searchByNombre(String nombre){
        return deporteService.findByNombre(nombre);
    }

    public List<Deporte> getAll(){
        return deporteService.findAll();
    }

    public Deporte searchById(Long id){
        return deporteService.findById(id);
    }
}
