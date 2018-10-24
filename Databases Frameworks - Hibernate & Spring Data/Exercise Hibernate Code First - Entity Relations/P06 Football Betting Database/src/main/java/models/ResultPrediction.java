package models;

import javax.persistence.*;

@Entity
@Table(name = "results_prediction")
public class ResultPrediction {

    private Long id;
    private String prediction;

    public ResultPrediction() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    public String getPrediction() {
        return prediction;
    }

    public void setPrediction(String prediction) {
        this.prediction = prediction;
    }
}
