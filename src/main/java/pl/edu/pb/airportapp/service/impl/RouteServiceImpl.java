package pl.edu.pb.airportapp.service.impl;

import org.springframework.stereotype.Service;
import pl.edu.pb.airportapp.domain.Route;
import pl.edu.pb.airportapp.repository.RouteRepo;
import pl.edu.pb.airportapp.service.RouteService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class RouteServiceImpl implements RouteService {
    private final RouteRepo repo;

    public RouteServiceImpl(RouteRepo repo) {
        this.repo = repo;
    }

    @Override
    public void deleteRoute(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void saveOrUpdateRoute(Route route) {
        if (route != null) {
            repo.save(route);
        }
    }


    @Override
    public List<Route> listAll() {
        List<Route> result = new LinkedList<>();
        Iterable<Route> all = repo.findAll();
        all.forEach(result::add);
        return result;
    }

    @Override
    public Optional<Route> getRouteById(Long id) {
        return repo.findById(id);

    }


}
