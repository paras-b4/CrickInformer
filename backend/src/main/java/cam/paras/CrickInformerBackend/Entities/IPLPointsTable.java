package cam.paras.CrickInformerBackend.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class IPLPointsTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private int played;
    private int won;
    private int lost;
    private int tied;
    private int noResult;
    private int points;
    private Double netRunRate;

    // Constructors
    public IPLPointsTable() {}

    public IPLPointsTable(String teamName, int played, int won, int lost, int tied, int noResult, int points, Double netRunRate) {
        this.teamName = teamName;
        this.played = played;
        this.won = won;
        this.lost = lost;
        this.tied = tied;
        this.noResult = noResult;
        this.points = points;
        this.netRunRate = netRunRate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getTied() {
        return tied;
    }

    public void setTied(int tied) {
        this.tied = tied;
    }

    public int getNoResult() {
        return noResult;
    }

    public void setNoResult(int noResult) {
        this.noResult = noResult;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Double getNetRunRate() {
        return netRunRate;
    }

    public void setNetRunRate(Double netRunRate) {
        this.netRunRate = netRunRate;
    }
}
