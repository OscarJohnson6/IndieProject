package fit.app.entities;

import jakarta.persistence.*;
import java.util.Date;

/**
 * The type Neck length record.
 *
 * @author OscarJohnson6
 */
@Entity(name = "hipRecord")
@Table(name = "hip_records")
public class HipRecord implements Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entryId")
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "hip")
    private int hip;

    @Column(name = "entry_date")
    private Date entryDate;

    /**
     * Instantiates a new Neck length record.
     */
    public HipRecord() {
    }

    /**
     * Instantiates a new Hip record.
     *
     * @param hip the hip
     */
    public HipRecord(int hip) {
        this.hip = hip;
    }

    public HipRecord(User user, int hip) {
        this.user = user;
        this.hip = hip;
    }

    public HipRecord(int id, User user, int hip) {
        this.id = id;
        this.user = user;
        this.hip = hip;
    }

    /**
     * Instantiates a new Neck length record.
     *
     * @param id        the id
     * @param user      the user
     * @param hip       the neck length
     * @param entryDate the entry date
     */
    public HipRecord(int id, User user, int hip, Date entryDate) {
        this.id = id;
        this.user = user;
        this.hip = hip;
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
     * Gets neck length.
     *
     * @return the neck length
     */
    public int getHip() {
        return hip;
    }

    /**
     * Sets neck length.
     *
     * @param hip the neck length
     */
    public void setHip(int hip) {
        this.hip = hip;
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
        return "hipRecord{" +
                "id=" + id +
                ", hip=" + hip +
                ", entryDate=" + entryDate +
                '}';
    }
}
