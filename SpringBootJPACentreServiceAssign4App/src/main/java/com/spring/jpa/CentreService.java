package com.spring.jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CentreService {
    @Autowired
    private CentreRepository centreRepository;

    public Centre addCentre(Centre cen){
       return centreRepository.save(cen);
    }

    //return the centre
    public List<Centre> getCentres() {
        return centreRepository.findAll();
    }

    //get a specific centre
    public Centre getCentre(int id) {
        return centreRepository.findById(id).orElse(null);
    }

    //update a centre
    public String updateCentre(Centre cen) {
		Centre centre = centreRepository.findById(cen.getId()).orElse(null);

        if (centre != null) {
			centreRepository.save(cen);
			return "Updated " + centre.getCentreName();
        } else {
            return "Not found";
        }
    }

    //delete centre
    public String deleteCentre(int id) {
		Centre centre = centreRepository.findById(id).orElse(null);

        if (centre != null) {
			centreRepository.deleteById(id);
			return "Deleted " + centre.getCentreName();
        } else {
            return "Not found";
        }
    }
}
