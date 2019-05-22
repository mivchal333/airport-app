package pl.edu.pb.airportapp.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pb.airportapp.domain.Airport;
import pl.edu.pb.airportapp.repository.AirportRepo;
import pl.edu.pb.airportapp.service.AirportService;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class AirportServiceImpl implements AirportService {
    @Autowired
    private AirportRepo repo;

    @Override
    public void deleteAirport(Long id) {
        repo.deleteById(id);
    }

    @Override
    public void saveOrUpdateAirport(Airport airport) {
        if (airport != null) {
            repo.save(airport);
        }
    }


    @Override
    public List<Airport> listAll() {
        List<Airport> result = new LinkedList<>();
        Iterable<Airport> all = repo.findAll();
        all.forEach(result::add);
        return result;
    }

    @Override
    public Optional<Airport> getAirportById(Long id) {
      return repo.findById(id);

    }
}
