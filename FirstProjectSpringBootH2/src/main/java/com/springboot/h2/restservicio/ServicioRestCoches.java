package com.springboot.h2.restservicio;


import com.springboot.h2.modelo.entidad.Coches;
import com.springboot.h2.modelo.servicio.ICochesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "serviciorestcoches")
public class ServicioRestCoches {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ICochesService  iCochesService;

    @GetMapping(value="allCoches")
    public List<Coches> getAllCoches() {
        return iCochesService.getAllCoches();
    }

    @PostMapping(value="addCoches")
    public Coches addCoches(@RequestBody Coches coche)  {
        return iCochesService.addCoche(coche);
        /*
        {
            "marca":"Hummer",
            "modelo":"H1 Diesel",
            "precio":50000
        }
        JSON UI
        */
    }

    @PutMapping(value="updateCoches")
    public Coches updateCoche(@RequestBody Coches coche)  {
        return iCochesService.updateCoche(coche);
    }

    @DeleteMapping(value="borrarCoches/{id}" )
    public boolean deleteCoches(@PathVariable(value="id") Long id) {
        iCochesService.removeCocheById(id);
        return true;
    }

    @GetMapping(value="getcoches/{id}" )
    public Optional<Coches> getCochesById(@PathVariable(value="id") Long id) {
        return iCochesService.getCocheById(id);

    }
}
