package pl.edu.pb.airportapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pb.airportapp.domain.Airport;
import pl.edu.pb.airportapp.service.AirportService;

import java.util.List;
import java.util.Optional;

@Controller
public class AirportController {
    private final AirportService service;

    public AirportController(AirportService service) {
        this.service = service;
    }

    @GetMapping("/airport")
    public String listAllAirports(Model model) {
        List<Airport> airports = service.listAll();
        model.addAttribute("airports", airports);
        return "airport/airports";
    }

    @GetMapping("/airport/new")
    public String getEmptyForm(Model model) {
        model.addAttribute("airport", new Airport());
        return "airport/airportForm";
    }

    @GetMapping(value = "/airport/edit/{id}")
    public String editAirport(@PathVariable Long id, Model model) {
        Optional<Airport> airportOpt = service.getAirportById(id);

        airportOpt.ifPresent(airport -> model.addAttribute("airport", airport));
        return "airport/airportForm";
    }

    @PostMapping("/airport")
    public String saveOrUpdateAirport(Airport airport) {
        service.saveOrUpdateAirport(airport);
        return "redirect:/airport/" + airport.getId();
    }

    @RequestMapping("/airport/delete/{id}")
    public String deleteAirport(@PathVariable Long id) {
        service.deleteAirport(id);
        return "redirect:/airport";
    }

    @GetMapping("/airport/{id}")
    public String getAirport(@PathVariable Long id, Model model) {
        Optional<Airport> airportOpt = service.getAirportById(id);
        airportOpt.ifPresent(airport -> model.addAttribute("airport", airport));
        return "airport/airport";
    }
}
