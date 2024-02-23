package fit.app.dao;

import jakarta.persistence.*;
import java.util.Date;

/**
 * The type Height record.
 *
 * @author OscarJohnson6
 */
@Entity(name = "HeightRecord")
@Table(name = "height_records")
public class HeightRecord implements Identity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entryId")
    private int id;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Column(name = "height")
    private int height;

    @Column(name = "entry_date")
    private Date entryDate;

    /**
     * Instantiates a new Height record.
     */
    public HeightRecord() {
    }

    /**
     * Instantiates a new Height record.
     *
     * @param height the height
     */
    public HeightRecord(int height) {
        this.height = height;
    }

    /**
     * Instantiates a new Height record.
     *
     * @param user   the user
     * @param height the height
     */
    public HeightRecord(User user, int height) {
        this.user = user;
        this.height = height;
    }

    /**
     * Instantiates a new Height record.
     *
     * @param id     the id
     * @param user   the user
     * @param height the height
     */
    public HeightRecord(int id, User user, int height) {
        this.id = id;
        this.user = user;
        this.height = height;
    }

    /**
     * Instantiates a new Height record.
     *
     * @param id        the id
     * @param user      the user
     * @param height    the height
     * @param entryDate the entry date
     */
    public HeightRecord(int id, User user, int height, Date entryDate) {
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
        return "HeightRecord{" +
                "id=" + id +
                ", height=" + height +
                ", entryDate=" + entryDate +
                '}';
    }
}
