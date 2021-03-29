package com.spring.boot.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.boot.model.Centre;
import com.spring.boot.model.TableModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class CentreController {
    private final ObjectMapper mapper = new ObjectMapper();
    private List<Centre> localCentres;

    @GetMapping("/centres")
    public String getCentres(Model model) throws JsonProcessingException {
        final String uri = "http://localhost:8081/centres";
        RestTemplate restTemplate = new RestTemplate();
        String jsonCentres = restTemplate.getForObject(uri, String.class);

        List<Centre> centres = Arrays.asList(mapper.readValue(jsonCentres, Centre[].class));
        localCentres = centres;

        TableModel<Centre> centreTableModel = new TableModel<>(
                new String[]{"Centre Name", "Address", "City", "Phone", "Website", "Email"},
                "Centres",
                centres
        );

        model.addAttribute("tableModel", centreTableModel);
        return "centre/centre-list";
    }

    @GetMapping("/centre/new")
    public String newCentre(){
        return "centre/new-centre";
    }

    @PostMapping("/centre/new")
    public String saveCentre (@ModelAttribute Centre centre){
        RestTemplate restTemplate = new RestTemplate();
        final String uri = "http://localhost:8081/centre/";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        centre.setId(0L);
        HttpEntity<Centre> request = new HttpEntity<>(centre, headers);

        restTemplate.postForObject(uri, request, Centre.class);
        return "redirect:/centres";
    }

    @GetMapping("/editCentre/{id}")
    public String getEditCentre(@PathVariable String id, Model model){
        if (localCentres != null) {
            Centre centre = localCentres.stream()
                    .filter(p -> p.getId() == Long.parseLong(id))
                    .findAny()
                    .orElse(null);

            if (centre != null) {
                model.addAttribute("centre", centre);
                return "centre/new-centre";
            }
        }

        return "redirect:/centres";
    }

    @PostMapping("/editCentre/{id}")
    public String editCentre(@ModelAttribute Centre centre, @PathVariable String id){
        RestTemplate restTemplate = new RestTemplate();
        final String uri = "http://localhost:8081/centre/" + id;
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        centre.setId(Long.valueOf(id));
        HttpEntity<Centre> request = new HttpEntity<>(centre, headers);

        restTemplate.put(uri, request, Centre.class);

        return "redirect:/centres";
    }

    @PostMapping("/deleteCentre/{id}")
    public String deleteCentre(@PathVariable String id){
        final String uri = "http://localhost:8081/centre/" + id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri);
        return "redirect:/centres";
    }
}
