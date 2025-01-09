package com.app.tbz.Service;

import com.app.tbz.DTO.ConcessionDTO;
import com.app.tbz.Entity.Concession;
import com.app.tbz.Exception.ConcessionNotFoundException;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Request.ConcessionRequest;
import com.app.tbz.Request.ConcessionUpdateRequest;

import java.util.List;

public interface ConcessionService {

    ConcessionDTO createConcession(ConcessionRequest request) throws InsertCannotBeDoneException;
    ConcessionDTO getConcession(Integer conc_id) throws ConcessionNotFoundException;
    ConcessionDTO updateConcession(Integer conc_id, ConcessionUpdateRequest request) throws ConcessionNotFoundException ;

    List<Concession> getAllConcessions();
}
