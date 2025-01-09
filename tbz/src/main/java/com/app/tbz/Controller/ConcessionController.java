package com.app.tbz.Controller;

import com.app.tbz.DTO.ConcessionDTO;
import com.app.tbz.Entity.Concession;
import com.app.tbz.Exception.ConcessionNotFoundException;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Request.ConcessionRequest;
import com.app.tbz.Request.ConcessionUpdateRequest;
import com.app.tbz.Service.ConcessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/concession")
public class ConcessionController {

    @Autowired
    private ConcessionService concessionService;

    @PostMapping("")
    public ResponseEntity<ConcessionDTO> createConcession(@RequestBody ConcessionRequest request) throws InsertCannotBeDoneException {
        ConcessionDTO response = concessionService.createConcession(request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("/{conc_id}")
    public ResponseEntity<ConcessionDTO> getConcessionById(@PathVariable Integer conc_id) throws ConcessionNotFoundException {
        ConcessionDTO response = concessionService.getConcession(conc_id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("/{conc_id}")
    public ResponseEntity<ConcessionDTO> updateConcessionById(@PathVariable Integer conc_id, @RequestBody ConcessionUpdateRequest request) throws ConcessionNotFoundException {
        ConcessionDTO response = concessionService.updateConcession(conc_id, request);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("")
    public ResponseEntity<List<Concession>> getConcessions(){
        return new ResponseEntity<>(concessionService.getAllConcessions(), HttpStatus.OK);

    }
}
