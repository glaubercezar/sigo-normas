package com.sigo.norm;

import com.sigo.norm.model.Norm;
import com.sigo.norm.repository.NormRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class NormService {

    private static final Logger LOGGER = LoggerFactory.getLogger(NormService.class);

    @Autowired
    private NormRepository normRepository;

    public void addNorm(Norm norm) {

        Norm newNorm = new Norm();
        newNorm.setCode(norm.getCode());
        newNorm.setTitle(norm.getTitle());
        newNorm.setCommittee(norm.getCommittee());
        newNorm.setPublicationDate(norm.getPublicationDate());
        newNorm.setLink(norm.getLink());
        newNorm.setStatus(norm.getStatus());
        newNorm.setDescription(norm.getDescription());
        newNorm.setAreaName(norm.getAreaName());
        newNorm.setAreaDepartment(norm.getAreaDepartment());
        normRepository.save(newNorm);

        LOGGER.info("Nova norma adicionada");
    }

    public void updateNorm(Long id, Norm norm) {

        Norm editNorm = new Norm();
        editNorm.setId(id);
        editNorm.setCode(norm.getCode());
        editNorm.setTitle(norm.getTitle());
        editNorm.setCommittee(norm.getCommittee());
        editNorm.setPublicationDate(norm.getPublicationDate());
        editNorm.setLink(norm.getLink());
        editNorm.setStatus(norm.getStatus());
        editNorm.setDescription(norm.getDescription());
        editNorm.setAreaName(norm.getAreaName());
        editNorm.setAreaDepartment(norm.getAreaDepartment());
        normRepository.save(editNorm);

        LOGGER.info("Norma alterada");
    }

    public Norm getNorm(Long id) {
        Norm norm = normRepository.findById(id).orElseThrow();
        return norm;
    }

    public void deleteNorm(Long id) {
        normRepository.deleteById(id);
    }

    public HashMap<String, List<Norm>> getNorms() {

        List<Norm> norms = normRepository.findAll();
        HashMap<String, List<Norm>> response = new HashMap<>();
        response.put("data", norms);
        return response;
    }
}
