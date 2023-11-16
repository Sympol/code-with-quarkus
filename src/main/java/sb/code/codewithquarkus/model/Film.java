package sb.code.codewithquarkus.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "film", schema = "sakila")
public class Film {

    @Id
    @Column(nullable = false, updatable = false)
    @SequenceGenerator(
            name = "primary_sequence",
            sequenceName = "primary_sequence",
            allocationSize = 1,
            initialValue = 10000
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "primary_sequence"
    )
    private Integer filmId;

    @Column(nullable = false)
    @Basic
    private String title;

    @Column(columnDefinition = "text")
    @Basic
    private String description;

    @Column
    @Basic
    private Integer releaseYear;

    @Column(nullable = false)
    @Basic
    private Integer rentalDuration;

    @Column(nullable = false, precision = 6, scale = 2)
    @Basic
    private BigDecimal rentalRate;

    @Column
    @Basic
    private Integer length;

    @Column(nullable = false, precision = 7, scale = 2)
    @Basic
    private BigDecimal replacementCost;

    @Column(columnDefinition = "enum('G','PG','PG-13','R','NC-17)")
    @Basic
    private String rating;

    @Column(columnDefinition = "enum('Trailers','Commentaires','Deleted Scenes', 'Behind the Scenes')")
    @Basic
    private String specialFeatures;

    @Column(nullable = false)
    @Basic
    private OffsetDateTime lastUpdate;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "actor_film",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private List<Actor> actors = new ArrayList<>();

    public Integer getFilmId() {
        return filmId;
    }

    public void setFilmId(final Integer filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(final Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Integer getRentalDuration() {
        return rentalDuration;
    }

    public void setRentalDuration(final Integer rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(final BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(final Integer length) {
        this.length = length;
    }

    public BigDecimal getReplacementCost() {
        return replacementCost;
    }

    public void setReplacementCost(final BigDecimal replacementCost) {
        this.replacementCost = replacementCost;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(final String rating) {
        this.rating = rating;
    }

    public String getSpecialFeatures() {
        return specialFeatures;
    }

    public void setSpecialFeatures(final String specialFeatures) {
        this.specialFeatures = specialFeatures;
    }

    public OffsetDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(final OffsetDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}