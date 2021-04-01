package com.spring.jpa;
import com.spring.jpa.model.TableModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.util.List;

@Controller
public class CentreController {
	private final CentreService centreService;
	public CentreController(CentreService centreService) {
		this.centreService = centreService;
	}

	@GetMapping("/")
	public String home (Model model){
		TableModel<Centre> centreTableModel = new TableModel<>(
				new String[]{"Centre Name", "Address", "City", "Phone", "Website", "Email"},
				"Centres",
				centreService.getCentres()
		);

		model.addAttribute("tableModel", centreTableModel);
		return "centre-list";
	}

	@GetMapping("/centre/new")
	public String newCentre(Model model){
		model.addAttribute("centre", new Centre());
		return "new-centre";
	}

	@PostMapping("/centre/new")
	public String saveCentre (@Valid Centre centre, BindingResult result) {
		if (result.hasErrors()) {
			return "new-centre";
		}

		centreService.addCentre(centre);
		return "redirect:/";
	}

	@GetMapping("/editCentre/{id}")
	public String getEditCentre(@PathVariable String id, Model model){
		Centre centre = centreService.getCentre(Integer.parseInt(id));

		if (centre != null) {
			model.addAttribute("centre", centre);
			model.addAttribute("update", true);
			return "new-centre";
		}

		return "redirect:/";
	}


	@PostMapping("/editCentre/{id}")
	public String editCentre(@ModelAttribute Centre centre, @PathVariable String id){
		centre.setId(Integer.parseInt(id));
		centreService.updateCentre(centre);

		return "redirect:/";
	}

	@PostMapping("/deleteCentre/{id}")
	public String deleteCentre(@PathVariable String id){
		centreService.deleteCentre(Integer.parseInt(id));
		return "redirect:/";
	}
}
