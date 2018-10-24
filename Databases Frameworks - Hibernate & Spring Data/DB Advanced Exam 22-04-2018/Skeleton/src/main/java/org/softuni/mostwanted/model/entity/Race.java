package org.softuni.mostwanted.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "races")
public class Race {

    private Integer id;
    private Integer laps;
    private District district;
    private Set<RaceEntry> entries;

    public Race() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false, columnDefinition = "INT default 0")
    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    @NotNull
    @ManyToOne
    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }

    @OneToMany(mappedBy = "race", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<RaceEntry> getEntries() {
        return entries;
    }

    public void setEntries(Set<RaceEntry> entries) {
        this.entries = entries;
    }
}
