package dao;

import javax.persistence.*;

/**
 * The type Height record.
 *
 * @author OscarJohnson6
 */
@Entity
@Table(name = "height_records")
public class HeightRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "height")
    private int height;

    @Embedded
    private EntryDate entryDate;

    /**
     * Instantiates a new Height record.
     */
    public HeightRecord() {
    }

    /**
     * Instantiates a new Height record.
     *
     * @param id        the id
     * @param user      the user
     * @param height    the height
     * @param entryDate the entry date
     */
    public HeightRecord(int id, User user, int height, EntryDate entryDate) {
        this.id = id;
        this.user = user;
        this.height = height;
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
     * Gets height.
     *
     * @return the height
     */
    public int getHeight() {
        return height;
    }

    /**
     * Sets height.
     *
     * @param height the height
     */
    public void setHeight(int height) {
        this.height = height;
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
        return "HeightRecord{" +
                "id=" + id +
                ", user=" + user +
                ", height=" + height +
                ", entryDate=" + entryDate +
                '}';
    }
}
