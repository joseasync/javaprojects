package com.josecruzio.springdatarefact.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Flight {
    @Id
    @GeneratedValue
    private long id;
    private String origin;
    private String destination;
    private LocalDateTime sheduleAt;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getSheduleAt() {
        return sheduleAt;
    }

    public void setSheduleAt(LocalDateTime sheduleAt) {
        this.sheduleAt = sheduleAt;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", origin='" + origin + '\'' +
                ", destination='" + destination + '\'' +
                ", sheduleAt=" + sheduleAt +
                '}';
    }
}
