package sb.code.codewithquarkus.model;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "actor", schema = "sakila")
public class Actor {

    @Id
    @Column(name = "actor_id",nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short actorId;

    @Column(name = "first_name",nullable = false, length = 45)
    @Basic
    private String firstName;

    @Column(name = "last_name",nullable = false, length = 45)
    @Basic
    private String lastName;

    @Column(name = "last_update",nullable = false)
    @Basic
    private OffsetDateTime lastUpdate;

    @ManyToMany(mappedBy = "actors")
    private Set<Film> films = new HashSet<>();

    public short getActorId() {
        return actorId;
    }

    public void setActorId(final short actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Set<Film> getFilms() {
        return films;
    }

    public void setFilms(Set<Film> films) {
        this.films = films;
    }
}
