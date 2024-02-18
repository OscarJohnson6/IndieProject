package fit.app.dao;

import javax.persistence.*;
import java.util.Date;

/**
 * The type Waist length record.
 *
 * @author OscarJohnson6
 */
@Entity(name = "WaistRecord")
@Table(name = "waist_records")
public class WaistRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
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

    public WaistRecord(int waist) {
        this.waist = waist;
    }

    /**
     * Instantiates a new Waist length record.
     *
     * @param id          the id
     * @param user        the user
     * @param waist the waist length
     * @param entryDate   the entry date
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
    public int getwaist() {
        return waist;
    }

    /**
     * Sets waist length.
     *
     * @param waist the waist length
     */
    public void setwaist(int waist) {
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
                ", user=" + user +
                ", waist=" + waist +
                ", entryDate=" + entryDate +
                '}';
    }
}