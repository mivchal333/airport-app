package pl.edu.pb.airportapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pb.airportapp.domain.Airport;
import pl.edu.pb.airportapp.domain.Plane;
import pl.edu.pb.airportapp.repository.PlaneRepo;
import pl.edu.pb.airportapp.service.PlaneService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class PlaneServiceImpl implements PlaneService {
    @Autowired
    private PlaneRepo repo;

    @Override
    public void deletePlane(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void saveOrUpdatePlane(Plane plane) {
        if (plane != null) {
            repo.save(plane);
        }
    }


    @Override
    public List<Plane> listAll() {
        List<Plane> result = new LinkedList<>();
        Iterable<Plane> all = repo.findAll();
        all.forEach(result::add);
        return result;
    }

    @Override
    public Optional<Plane> getPlaneById(Long id) {
        return repo.findById(id);

    }
}
