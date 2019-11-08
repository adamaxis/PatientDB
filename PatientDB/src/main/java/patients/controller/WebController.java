package patients.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import patients.beans.Patient;
import patients.repository.PatientRepository;

@Controller
public class WebController {
	@Autowired
	PatientRepository repo;

	@GetMapping("/viewAll")
	public String viewAllPatients(Model model) {
		model.addAttribute("patients", repo.findAll());
		return "results";
	}
	
	
	@GetMapping("/inputPatient")
	public String addNewPatient(Model model) {
	    Patient p = new Patient();
	    model.addAttribute("newPatient", p);
	    return "input";
	}
	
	@PostMapping("/inputPatient")
	public String addNewPatient(@ModelAttribute Patient p, Model model) {
		repo.save(p);
		model.addAttribute("patients", repo.findAll());
		return "results";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
	    Patient p = repo.findById((long) id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
	    model.addAttribute("patient", p);
	    return "update";
	}

	
	@PostMapping("/update/{id}")
	public String updatePatient(@PathVariable("id") int id, @Valid Patient p, 
	  BindingResult result, Model model) {
	    if (result.hasErrors()) {
	        p.setId(id);
	        return "update";
	    }
	         
	    repo.save(p);
	    model.addAttribute("patients", repo.findAll());
		return "results";
	}
	     
	@GetMapping("/delete/{id}")
	public String deletePatient(@PathVariable("id") int id, Model model) {
	    Patient p = repo.findById((long) id)
	      .orElseThrow(() -> new IllegalArgumentException("Invalid patient Id:" + id));
	    repo.delete(p);
	    model.addAttribute("patients", repo.findAll());
		return "results";
	}
	
}
