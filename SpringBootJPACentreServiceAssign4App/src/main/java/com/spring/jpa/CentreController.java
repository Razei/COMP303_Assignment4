package com.spring.jpa;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CentreController {
	private final CentreService centreService;
	public CentreController(CentreService centreService) {
		this.centreService = centreService;
	}

	@RequestMapping(value ="/centres", method = RequestMethod.GET)
	public List<Centre> getCentres(){
		return centreService.getCentres();
	}

	@PostMapping("/centre")
	public Centre create(@RequestBody Centre centre) {
		return centreService.addCentre(centre);
	}

	@PutMapping("/centre/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	String editCentre(@PathVariable String id, @RequestBody Centre centre){
		centre.setId(Integer.parseInt(id));
		return centreService.updateCentre(centre);
	}

	@DeleteMapping("/centre/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	String deletePatient(@PathVariable String id){
		return centreService.deleteCentre(Integer.parseInt(id));
	}
}
