package com.springboot.h2.restservicio;


import com.springboot.h2.modelo.entidad.Coches;
import com.springboot.h2.modelo.servicio.ICochesService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(name = "serviciorestcoches")
public class ServicioRestCoches {
    private Logger LOG = LoggerFactory.getLogger(this.getClass());

    @Autowired
    ICochesService  iCochesService;

    @GetMapping(value="allCoches")
    @Transactional(readOnly = true)
    public List<Coches> getAllCoches() {
        return iCochesService.getAllCoches();
    }

    @PostMapping(value="addCoches")
    @Transactional
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
    @Transactional
    public Coches updateCoche(@RequestBody Coches coche)  {
        return iCochesService.updateCoche(coche);
    }

    @DeleteMapping(value="borrarCoches/{id}" )
    @Transactional
    public boolean deleteCoches(@PathVariable(value="id") Long id) {
        iCochesService.removeCocheById(id);
        return true;
    }

    @GetMapping(value="getcoches/{id}" )
    @Transactional(readOnly = true)
    public Optional<Coches> getCochesById(@PathVariable(value="id") Long id) throws FileNotFoundException {
        Optional<Coches> coche = iCochesService.getCocheById(id);
        File file = new File(System.getProperty("user.dir")+"\\test1.txt");
        file.setWritable(true);
         PrintWriter pw = new PrintWriter(file);
         pw.println(coche);
         pw.close();
         System.out.println(System.getProperty("user.dir"));

        return coche;

    }
}
