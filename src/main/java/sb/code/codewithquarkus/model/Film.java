package sb.code.codewithquarkus.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "film", schema = "sakila")
public class Film implements Serializable {

    @Id
    @Column(name = "film_id", nullable = false, updatable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short filmId;

    @Column(nullable = false)
    @Basic
    private String title;

    @Column(columnDefinition = "text")
    @Basic
    private String description;

    @Column(name = "release_year", columnDefinition = "year(4")
    @Basic
    private Year releaseYear;

    @Column(name = "language_id")
    @Basic
    private short languageId;

    @Column(name = "rental_duration",nullable = false)
    @Basic
    private short rentalDuration;

    @Column(name = "rental_rate",nullable = false, precision = 6, scale = 2)
    @Basic
    private BigDecimal rentalRate;

    @Column
    @Basic
    private short length;

    @Column(name = "replacement_cost", nullable = false, precision = 7, scale = 2)
    @Basic
    private BigDecimal replacementCost;

    @Column(columnDefinition = "enum('G','PG','PG-13','R','NC-17)")
    @Basic
    private String rating;

    @Column(name = "special_features", columnDefinition = "set('Trailers','Commentaires','Deleted Scenes', 'Behind the Scenes')")
    @Basic
    private String specialFeatures;

    @Column(name = "last_update", nullable = false)
    @Basic
    private OffsetDateTime lastUpdate;

    @ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.EAGER)
    @JoinTable(
            name = "film_actor",
            joinColumns = {@JoinColumn(name = "film_id")},
            inverseJoinColumns = {@JoinColumn(name = "actor_id")}
    )
    private List<Actor> actors = new ArrayList<>();

    public short getFilmId() {
        return filmId;
    }

    public void setFilmId(final short filmId) {
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

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public short getRentalDuration() {
        return rentalDuration;
    }

    public short getLanguageId() {
        return languageId;
    }

    public void setLanguageId(short languageId) {
        this.languageId = languageId;
    }

    public void setRentalDuration(short rentalDuration) {
        this.rentalDuration = rentalDuration;
    }

    public BigDecimal getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(final BigDecimal rentalRate) {
        this.rentalRate = rentalRate;
    }

    public short getLength() {
        return length;
    }

    public void setLength(final short length) {
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