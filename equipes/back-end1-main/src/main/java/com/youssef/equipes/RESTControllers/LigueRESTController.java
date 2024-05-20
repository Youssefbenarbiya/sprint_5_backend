package com.youssef.equipes.RESTControllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.youssef.equipes.entities.Ligue;
import com.youssef.equipes.repo.LigueRepository;

@RestController
@RequestMapping("/api/ligue")
@CrossOrigin("*")
public class LigueRESTController {

    @Autowired
    LigueRepository ligueRepository;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Ligue>> getAllLigues() {
        List<Ligue> ligues = ligueRepository.findAll();
        return new ResponseEntity<>(ligues, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Ligue> getLigueById(@PathVariable("id") Long id) {
        Optional<Ligue> ligue = ligueRepository.findById(id);
        return ligue.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                    .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Ligue> createLigue(@RequestBody Ligue ligue) {
        Ligue createdLigue = ligueRepository.save(ligue);
        return new ResponseEntity<>(createdLigue, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> deleteLigue(@PathVariable("id") Long id) {
        if (ligueRepository.existsById(id)) {
            ligueRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity<Ligue> updateLigue(@PathVariable("id") Long id, @RequestBody Ligue ligue) {
        if (ligueRepository.existsById(id)) {
            ligue.setIdLigue(id);  // Ensure the ID is set correctly
            Ligue updatedLigue = ligueRepository.save(ligue);
            return new ResponseEntity<>(updatedLigue, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
