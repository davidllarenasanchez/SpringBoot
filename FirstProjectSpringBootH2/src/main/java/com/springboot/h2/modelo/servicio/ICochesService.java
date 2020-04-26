package com.springboot.h2.modelo.servicio;

import com.springboot.h2.modelo.entidad.Coches;

import java.util.List;
import java.util.Optional;

public interface ICochesService {

    public List<Coches> getAllCoches();
    public Optional<Coches> getCocheById(final Long id);
    public void removeCocheById( final Long id);
    public Coches updateCoche(final Coches coche);
    public Coches addCoche(Coches coche);
}
