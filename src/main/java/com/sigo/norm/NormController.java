package com.sigo.norm;

import com.sigo.norm.model.Norm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequestMapping(value = "/api/v1/norms", produces = MediaType.APPLICATION_JSON_VALUE)
public class NormController {

    private static final Logger LOGGER = LoggerFactory.getLogger(NormController.class);

    @Autowired
    private NormService normService;

    @GetMapping()
    public ResponseEntity<HashMap<String, List<Norm>>> getNorms() {
        HashMap<String, List<Norm>> norms = normService.getNorms();
        return new ResponseEntity<>(norms, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<String> addNorm(@RequestBody Norm norm) {
        normService.addNorm(norm);
        String response = "{\"message\":\"Adicionado com sucesso!\"}";
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> editNorm(@PathVariable("id") Long id, @RequestBody Norm norm) {
        normService.updateNorm(id, norm);
        String response = "{\"message\":\"Atualizado com sucesso!\"}";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Norm> getNorm(@PathVariable("id") Long id) {
        Norm norm = normService.getNorm(id);
        return new ResponseEntity<>(norm, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNorm(@PathVariable("id") Long id) {
        normService.deleteNorm(id);
        String response = "{\"message\":\"Removido com sucesso!\"}";
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}