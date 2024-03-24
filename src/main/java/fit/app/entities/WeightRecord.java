package fit.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import java.util.Date;

/**
 * The type Weight record.
 *
 * @author OscarJohnson6
 */
@Entity(name = "WeightRecord")
@Table(name = "weight_records")
public class WeightRecord implements Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entryId")
    private int id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "weight")
    private int weight;

    @Column(name = "entry_date")
    private Date entryDate;

    /**
     * Instantiates a new Weight record.
     */
    public WeightRecord() {
    }

    /**
     * Instantiates a new Weight record.
     *
     * @param weight the weight
     */
    public WeightRecord(int weight) {
        this.weight = weight;
    }

    public WeightRecord(User user, int weight) {
        this.user = user;
        this.weight = weight;
    }

    public WeightRecord(int id, User user, int weight) {
        this.id = id;
        this.user = user;
        this.weight = weight;
    }

    /**
     * Instantiates a new Weight record.
     *
     * @param id        the id
     * @param user      the user
     * @param weight    the weight
     * @param entryDate the entry date
     */
    public WeightRecord(int id, User user, int weight, Date entryDate) {
        this.id = id;
        this.user = user;
        this.weight = weight;
        this.entryDate = entryDate;
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets user.
     *
     * @return the user
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets user.
     *
     * @param user the user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    /**
     * Gets entry date.
     *
     * @return the entry date
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * Sets entry date.
     *
     * @param entryDate the entry date
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "WeightRecord{" +
                "id=" + id +
                ", weight=" + weight +
                ", entryDate=" + entryDate +
                '}';
    }
}
