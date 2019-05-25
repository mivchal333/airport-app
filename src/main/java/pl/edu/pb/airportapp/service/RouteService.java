package pl.edu.pb.airportapp.service;


import pl.edu.pb.airportapp.domain.Route;

import java.util.List;
import java.util.Optional;

public interface RouteService {
    void deleteRoute(Long id);

    void saveOrUpdateRoute(Route route);

    List<Route> listAll();

    Optional<Route> getRouteById(Long id);

}
