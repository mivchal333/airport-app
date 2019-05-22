package pl.edu.pb.airportapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pb.airportapp.domain.Plane;
import pl.edu.pb.airportapp.service.PlaneService;

import java.util.List;
import java.util.Optional;

@Controller
public class PlaneController {
    private final PlaneService service;

    public PlaneController(PlaneService service) {
        this.service = service;
    }

    @GetMapping("/plane")
    public String listAllPlanes(Model model) {
        List<Plane> Planes = service.listAll();
        model.addAttribute("planes", Planes);
        return "plane/planes";
    }

    @GetMapping("/plane/new")
    public String getEmptyForm(Model model) {
        model.addAttribute("plane", new Plane());
        return "plane/planeForm";
    }

    @GetMapping(value = "/plane/edit/{id}")
    public String editPlane(@PathVariable Long id, Model model) {
        Optional<Plane> PlaneOpt = service.getPlaneById(id);

        PlaneOpt.ifPresent(Plane -> model.addAttribute("plane", Plane));
        return "plane/planeForm";
    }

    @PostMapping("/plane")
    public String saveOrUpdatePlane(Plane plane) {
        service.saveOrUpdatePlane(plane);
        return "redirect:/plane/" + plane.getId();
    }

    @RequestMapping("/plane/delete/{id}")
    public String deletePlane(@PathVariable Long id) {
        service.deletePlane(id);
        return "redirect:/plane";
    }

    @GetMapping("/plane/{id}")
    public String getPlane(@PathVariable Long id, Model model) {
        Optional<Plane> planeOpt = service.getPlaneById(id);
        planeOpt.ifPresent(plane -> model.addAttribute("plane", plane));
        return "plane/plane";
    }
}
