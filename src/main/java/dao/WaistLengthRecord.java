package dao;

import javax.persistence.*;

/**
 * The type Waist length record.
 *
 * @author OscarJohnson6
 */
@Entity
@Table(name = "waist_length_records")
public class WaistLengthRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "waist_length")
    private int waistLength;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "entry_date", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private EntryDate entryDate;

    /**
     * Instantiates a new Waist length record.
     */
    public WaistLengthRecord() {
    }

    public WaistLengthRecord(int waistLength) {
        this.waistLength = waistLength;
    }

    /**
     * Instantiates a new Waist length record.
     *
     * @param id          the id
     * @param user        the user
     * @param waistLength the waist length
     * @param entryDate   the entry date
     */
    public WaistLengthRecord(int id, User user, int waistLength, EntryDate entryDate) {
        this.id = id;
        this.user = user;
        this.waistLength = waistLength;
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
    public int getWaistLength() {
        return waistLength;
    }

    /**
     * Sets waist length.
     *
     * @param waistLength the waist length
     */
    public void setWaistLength(int waistLength) {
        this.waistLength = waistLength;
    }

    /**
     * Gets entry date.
     *
     * @return the entry date
     */
    public EntryDate getEntryDate() {
        return entryDate;
    }

    /**
     * Sets entry date.
     *
     * @param entryDate the entry date
     */
    public void setEntryDate(EntryDate entryDate) {
        this.entryDate = entryDate;
    }

    @Override
    public String toString() {
        return "WaistLengthRecord{" +
                "id=" + id +
                ", user=" + user +
                ", waistLength=" + waistLength +
                ", entryDate=" + entryDate +
                '}';
    }
}