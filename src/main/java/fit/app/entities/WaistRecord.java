package fit.app.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.Date;

/**
 * The type Waist length record.
 *
 * @author OscarJohnson6
 */
@Entity(name = "WaistRecord")
@Table(name = "waist_records")
public class WaistRecord implements Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entryId")
    private int id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "waist")
    private int waist;

    @Column(name = "entry_date")
    private Date entryDate;

    /**
     * Instantiates a new Waist length record.
     */
    public WaistRecord() {
    }

    /**
     * Instantiates a new Waist record.
     *
     * @param waist the waist
     */
    public WaistRecord(int waist) {
        this.waist = waist;
    }

    public WaistRecord(User user, int waist) {
        this.user = user;
        this.waist = waist;
    }

    public WaistRecord(int id, User user, int waist) {
        this.id = id;
        this.user = user;
        this.waist = waist;
    }

    public WaistRecord(User user, int waist, Date entryDate) {
        this.user = user;
        this.waist = waist;
        this.entryDate = entryDate;
    }

    /**
     * Instantiates a new Waist length record.
     *
     * @param id        the id
     * @param user      the user
     * @param waist     the waist length
     * @param entryDate the entry date
     */
    public WaistRecord(int id, User user, int waist, Date entryDate) {
        this.id = id;
        this.user = user;
        this.waist = waist;
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
     * Gets waist length.
     *
     * @return the waist length
     */
    public int getWaist() {
        return waist;
    }

    /**
     * Sets waist length.
     *
     * @param waist the waist length
     */
    public void setWaist(int waist) {
        this.waist = waist;
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
        return "waistRecord{" +
                "id=" + id +
                ", waist=" + waist +
                ", entryDate=" + entryDate +
                '}';
    }
}