package dao;

import javax.persistence.*;

/**
 * The type Neck length record.
 *
 * @author OscarJohnson6
 */
@Entity
@Table(name = "neck_length_records")
public class NeckLengthRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "neck_length")
    private int neckLength;

    @Embedded
    private EntryDate entryDate;

    /**
     * Instantiates a new Neck length record.
     */
    public NeckLengthRecord() {
    }

    public NeckLengthRecord(int neckLength) {
        this.neckLength = neckLength;
    }

    /**
     * Instantiates a new Neck length record.
     *
     * @param id         the id
     * @param user       the user
     * @param neckLength the neck length
     * @param entryDate  the entry date
     */
    public NeckLengthRecord(int id, User user, int neckLength, EntryDate entryDate) {
        this.id = id;
        this.user = user;
        this.neckLength = neckLength;
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
    public int getNeckLength() {
        return neckLength;
    }

    /**
     * Sets neck length.
     *
     * @param neckLength the neck length
     */
    public void setNeckLength(int neckLength) {
        this.neckLength = neckLength;
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
        return "NeckLengthRecord{" +
                "id=" + id +
                ", user=" + user +
                ", neckLength=" + neckLength +
                ", entryDate=" + entryDate +
                '}';
    }
}
