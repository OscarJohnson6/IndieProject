package dao;

import org.hibernate.annotations.GenericGenerator;
import java.util.*;

import javax.persistence.*;

/**
 * The type User.
 *
 * @author OscarJohnson6
 */
@Entity
@Table(name = "user_profiles")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "userEmail")
    private String userEmail;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<WeightRecord> weightRecords = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<HeightRecord> heightRecord = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<NeckLengthRecord> neckLengthRecord = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<WaistLengthRecord> waistLengthRecord = new ArrayList<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName         the first name
     * @param lastName          the last name
     * @param userEmail         the user email
     * @param weightRecords     the weight records
     * @param heightRecord      the height record
     * @param neckLengthRecord  the neck length record
     * @param waistLengthRecord the waist length record
     * @param id                the id
     */
    public User(String firstName,
                String lastName,
                String userEmail,
                List<WeightRecord> weightRecords,
                List<HeightRecord> heightRecord,
                List<NeckLengthRecord> neckLengthRecord,
                List<WaistLengthRecord> waistLengthRecord,
                int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
        this.weightRecords = weightRecords;
        this.heightRecord = heightRecord;
        this.neckLengthRecord = neckLengthRecord;
        this.waistLengthRecord = waistLengthRecord;
        this.id = id;
    }


    /**
     * Gets first name.
     *
     * @return the first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets first name.
     *
     * @param firstName the first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Gets last name.
     *
     * @return the last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets last name.
     *
     * @param lastName the last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Gets user email.
     *
     * @return the user email
     */
    public String getUserEmail() {
        return userEmail;
    }

    /**
     * Sets user email.
     *
     * @param userEmail the user email
     */
    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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
     * Gets weight records.
     *
     * @return the weight records
     */
    public List<WeightRecord> getWeightRecords() {
        return weightRecords;
    }

    /**
     * Sets weight records.
     *
     * @param weightRecords the weight records
     */
    public void setWeightRecords(List<WeightRecord> weightRecords) {
        this.weightRecords = weightRecords;
    }

    /**
     * Gets height record.
     *
     * @return the height record
     */
    public List<HeightRecord> getHeightRecord() {
        return heightRecord;
    }

    /**
     * Sets height record.
     *
     * @param heightRecord the height record
     */
    public void setHeightRecord(List<HeightRecord> heightRecord) {
        this.heightRecord = heightRecord;
    }

    /**
     * Gets neck length record.
     *
     * @return the neck length record
     */
    public List<NeckLengthRecord> getNeckLengthRecord() {
        return neckLengthRecord;
    }

    /**
     * Sets neck length record.
     *
     * @param neckLengthRecord the neck length record
     */
    public void setNeckLengthRecord(List<NeckLengthRecord> neckLengthRecord) {
        this.neckLengthRecord = neckLengthRecord;
    }

    /**
     * Gets waist length record.
     *
     * @return the waist length record
     */
    public List<WaistLengthRecord> getWaistLengthRecord() {
        return waistLengthRecord;
    }

    /**
     * Sets waist length record.
     *
     * @param waistLengthRecord the waist length record
     */
    public void setWaistLengthRecord(List<WaistLengthRecord> waistLengthRecord) {
        this.waistLengthRecord = waistLengthRecord;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", weight='" + weightRecords + '\'' +
                ", height='" + heightRecord + '\'' +
                ", neckLength='" + neckLengthRecord + '\'' +
                ", waistLength='" + waistLengthRecord + '\'' +
                ", id=" + id + '}';
    }
}