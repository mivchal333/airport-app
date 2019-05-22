package pl.edu.pb.airportapp.domain;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer distance;
    @OneToMany
    @JoinColumn(name = "route_id")
    private Set<Airport> airports;
    @OneToOne
    @JoinColumn
    private Flight flight;

    public Route(Integer distance, Set<Airport> airports, Flight flight) {
        this.distance = distance;
        this.airports = airports;
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public Set<Airport> getAirports() {
        return airports;
    }

    public void setAirports(Set<Airport> airports) {
        this.airports = airports;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Route() {
    }
}
