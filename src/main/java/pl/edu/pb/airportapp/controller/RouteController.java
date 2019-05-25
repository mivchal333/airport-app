package pl.edu.pb.airportapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.edu.pb.airportapp.domain.Airport;
import pl.edu.pb.airportapp.domain.Route;
import pl.edu.pb.airportapp.service.AirportService;
import pl.edu.pb.airportapp.service.RouteService;

import java.util.List;
import java.util.Optional;

@Controller
public class RouteController {
    private final RouteService service;

    @Autowired
    private AirportService airportService;

    public RouteController(RouteService service) {
        this.service = service;
    }

    @GetMapping("/route")
    public String listAllRoutes(Model model) {
        List<Route> routes = service.listAll();
        model.addAttribute("routes", routes);
        return "route/routes";
    }

    @GetMapping("/route/new")
    public String getEmptyForm(Model model) {
        model.addAttribute("route", new Route());
        return "route/routeForm";
    }

    @GetMapping(value = "/route/edit/{id}")
    public String editRoute(@PathVariable Long id, Model model) {
        Optional<Route> routeOpt = service.getRouteById(id);

        routeOpt.ifPresent(route -> model.addAttribute("route", route));
        return "route/routeForm";
    }

    @PostMapping("/route")
    public String saveOrUpdateRoute(Route route) {
        service.saveOrUpdateRoute(route);
        return "redirect:/route/" + route.getId();
    }

    @RequestMapping("/route/delete/{id}")
    public String deleteRoute(@PathVariable Long id) {
        service.deleteRoute(id);
        return "redirect:/route";
    }

    @GetMapping("/route/{id}")
    public String getRoute(@PathVariable Long id, Model model) {
        Optional<Route> routeOpt = service.getRouteById(id);
        routeOpt.ifPresent(route -> model.addAttribute("route", route));
        return "route/route";
    }

    @GetMapping("/route/add-airports/{id}")
    public String getAirportsAddList(Model model, @PathVariable Long id) {
        Optional<Route> routeOpt = service.getRouteById(id);
        if (routeOpt.isPresent()) {
            Route route = routeOpt.get();
            model.addAttribute("route", route);
        }
        model.addAttribute("airports", airportService.listAll());
        return "route/airports-add";
    }

    @GetMapping("/route/{routeId}/add-airport/{airportId}")
    public String addAirportToRoute(@PathVariable Long routeId, @PathVariable Long airportId) {
        Optional<Route> routeOpt = service.getRouteById(routeId);
        Optional<Airport> airportOpt = airportService.getAirportById(airportId);
        if (routeOpt.isPresent() && airportOpt.isPresent()) {
            Route route = routeOpt.get();
            Airport airport = airportOpt.get();
            route.getAirports().add(airport);
            service.saveOrUpdateRoute(route);
            return "redirect:/route/edit/" + route.getId();
        }
        return "route/routeForm";
    }

}
