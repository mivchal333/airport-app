package pl.edu.pb.airportapp.service;

import pl.edu.pb.airportapp.domain.Plane;

import java.util.List;
import java.util.Optional;

public interface PlaneService {
    void deletePlane(Long id);
    void saveOrUpdatePlane(Plane plane);
    List<Plane> listAll();
    Optional<Plane> getPlaneById(Long id);
}
