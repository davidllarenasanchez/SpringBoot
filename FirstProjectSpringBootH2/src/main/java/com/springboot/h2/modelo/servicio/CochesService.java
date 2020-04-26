package com.springboot.h2.modelo.servicio;

import com.springboot.h2.modelo.dao.ICochesDao;
import com.springboot.h2.modelo.entidad.Coches;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
public class CochesService implements ICochesService{


    @Autowired
    private ICochesDao iCochesDao;


    @Override
    public List<Coches> getAllCoches() {
        return (List<Coches>)iCochesDao.findAll();
    }

    @Override
    public Optional<Coches> getCocheById(final Long id) {
        return iCochesDao.findById(id);
    }

    @Override
    public void removeCocheById(final Long id) {
        iCochesDao.deleteById(id);
    }

    @Override
    public Coches updateCoche(Coches coche) {
        coche.setFechaDeCompra(new Date());
        return iCochesDao.save(coche);
    }


    @Override
    public Coches addCoche(Coches coche) {
        return iCochesDao.save(coche);

    }
}
