package fit.app.dao;

import org.hibernate.annotations.GenericGenerator;
import java.util.*;

import javax.persistence.*;

/**
 * The type User.
 *
 * @author OscarJohnson6
 */
@Entity(name = "User")
@Table(name = "user_profiles")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private int id;

    @Column(name = "userEmail")
    private String userEmail;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "gender")
    private String gender;

    @Column(name = "date_of_birth")
    private Date age;

    @Column(name = "activity_level")
    private String activityLevel;

    @Column(name = "entry_date")
    private String entry_date;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<WeightRecord> weightRecords = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<HeightRecord> heightRecord = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<HipRecord> hipRecord = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<WaistRecord> waistRecord = new ArrayList<>();

    /**
     * Instantiates a new User.
     */
    public User() {
    }

    public User(String userEmail) {
        this.userEmail = userEmail;
    }

    /**
     * Instantiates a new User.
     *
     * @param userEmail the user email
     * @param firstName the first name
     * @param lastName  the last name
     * @param gender    the gender
     * @param age       the age
     */
    public User(String userEmail, String firstName, String lastName, String gender, Date age) {
        this.userEmail = userEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
    }

    /**
     * Instantiates a new User.
     *
     * @param id            the id
     * @param userEmail     the user email
     * @param firstName     the first name
     * @param lastName      the last name
     * @param gender        the gender
     * @param age           the age
     * @param activityLevel the activity level
     * @param entry_date    the entry date
     */
    public User(int id,
                String userEmail,
                String firstName,
                String lastName,
                String gender,
                Date age,
                String activityLevel,
                String entry_date) {
        this.id = id;
        this.userEmail = userEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.activityLevel = activityLevel;
        this.entry_date = entry_date;
    }

    /**
     * Instantiates a new User.
     *
     * @param id            the id
     * @param userEmail     the user email
     * @param firstName     the first name
     * @param lastName      the last name
     * @param gender        the gender
     * @param age           the age
     * @param activityLevel the activity level
     * @param entry_date    the entry date
     * @param weightRecords the weight records
     * @param heightRecord  the height record
     * @param hipRecord     the hip record
     * @param waistRecord   the waist record
     */
    public User(int id,
                String userEmail,
                String firstName,
                String lastName,
                String gender,
                Date age,
                String activityLevel,
                String entry_date,
                List<WeightRecord> weightRecords,
                List<HeightRecord> heightRecord,
                List<HipRecord> hipRecord,
                List<WaistRecord> waistRecord) {
        this.id = id;
        this.userEmail = userEmail;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.activityLevel = activityLevel;
        this.entry_date = entry_date;
        this.weightRecords = weightRecords;
        this.heightRecord = heightRecord;
        this.hipRecord = hipRecord;
        this.waistRecord = waistRecord;
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
     * Gets gender.
     *
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * Sets gender.
     *
     * @param gender the gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets age.
     *
     * @return the age
     */
    public Date getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(Date age) {
        this.age = age;
    }

    /**
     * Gets activity level.
     *
     * @return the activity level
     */
    public String getActivityLevel() {
        return activityLevel;
    }

    /**
     * Sets activity level.
     *
     * @param activityLevel the activity level
     */
    public void setActivityLevel(String activityLevel) {
        this.activityLevel = activityLevel;
    }

    /**
     * Gets entry date.
     *
     * @return the entry date
     */
    public String getEntry_date() {
        return entry_date;
    }

    /**
     * Sets entry date.
     *
     * @param entry_date the entry date
     */
    public void setEntry_date(String entry_date) {
        this.entry_date = entry_date;
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
    public List<HipRecord> getNeckLengthRecord() {
        return hipRecord;
    }

    /**
     * Sets neck length record.
     *
     * @param hipRecord the neck length record
     */
    public void setNeckLengthRecord(List<HipRecord> hipRecord) {
        this.hipRecord = hipRecord;
    }

    /**
     * Gets waist length record.
     *
     * @return the waist length record
     */
    public List<WaistRecord> getWaistLengthRecord() {
        return waistRecord;
    }

    /**
     * Sets waist length record.
     *
     * @param waistRecord the waist length record
     */
    public void setWaistLengthRecord(List<WaistRecord> waistRecord) {
        this.waistRecord = waistRecord;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", userEmail='" + userEmail + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", activityLevel='" + activityLevel + '\'' +
                ", entry_date='" + entry_date + '\'' +
                ", weightRecords=" + weightRecords +
                ", heightRecord=" + heightRecord +
                ", hipRecord=" + hipRecord +
                ", waistRecord=" + waistRecord +
                '}';
    }
}