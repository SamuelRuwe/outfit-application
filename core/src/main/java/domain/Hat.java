package domain;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "hat")
public class Hat {

    // == fields ==

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idHat;
    private int idPerson;
    @Column(name = "formal", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean formal;
    private String color;
    private int minTemp;
    private int maxTemp;
    @Column(name = "clean", nullable = false)
    @Type(type = "org.hibernate.type.NumericBooleanType")
    private boolean clean;
    private int lastWorn;

    // constructors ==

    public Hat() {}

    public int getIdHat() {
        return idHat;
    }

    public void setIdHat(int idHat) {
        this.idHat = idHat;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public boolean isFormal() {
        return formal;
    }

    public void setFormal(boolean formal) {
        this.formal = formal;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(int minTemp) {
        this.minTemp = minTemp;
    }

    public int getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(int maxTemp) {
        this.maxTemp = maxTemp;
    }

    public boolean isClean() {
        return clean;
    }

    public void setClean(boolean clean) {
        this.clean = clean;
    }

    public int getLastWorn() {
        return lastWorn;
    }

    public void setLastWorn(int lastWorn) {
        this.lastWorn = lastWorn;
    }
}
