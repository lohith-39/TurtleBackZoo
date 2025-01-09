package com.app.tbz.Controller;

import com.app.tbz.Exception.ConcessionNotFoundException;
import com.app.tbz.Exception.InsertCannotBeDoneException;
import com.app.tbz.Request.ConcessionRequest;
import com.app.tbz.Request.ConcessionUpdateRequest;
import com.app.tbz.Service.ConcessionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ConcessionBackendController {

    private ConcessionService concessionService;

    public ConcessionBackendController(ConcessionService concessionService) {
        super();
        this.concessionService = concessionService;
    }

    @GetMapping("/concessionmanagement")
    public String concessionManagementPage() {
        return "concessionmanagement";
    }

    @GetMapping("/createConcession")
    public String addConcessionForm() {
        return "createConcession";
    }

    @PostMapping("/createConcession")
    public String createConcession(Model model, @ModelAttribute ConcessionRequest concessionRequest) throws InsertCannotBeDoneException {
        model.addAttribute("createConcession", concessionService.createConcession(concessionRequest));
        return "redirect:/getAllConcessions";
    }

    @GetMapping("/getAllConcessions")
    public String listConcessions(Model model) {
        model.addAttribute("getAllConcessions", concessionService.getAllConcessions());
        return "getAllConcessions";
    }

    @GetMapping("/editConcession/{conc_id}")
    public String getConcessionById(Model model, @PathVariable("conc_id") Integer conc_id) throws ConcessionNotFoundException {
        model.addAttribute("concession", concessionService.getConcession(conc_id));
        return "updateConcession";
    }

    @PostMapping("/updateConcession/{conc_id}")
    public String updateConcession(@PathVariable("conc_id") Integer conc_id, @ModelAttribute("concession") ConcessionUpdateRequest concessionUpdateRequest) throws ConcessionNotFoundException {
        concessionService.updateConcession(conc_id, concessionUpdateRequest);
        return "redirect:/getAllConcessions";
    }
}
