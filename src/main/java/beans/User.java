package beans;


/**
 * The type User.
 *
 * @author OscarJohnson6
 */
public class User {
    private String firstName;
    private String lastName;
    private String userEmail;
    private int weight;
    private int height;
    private int neckLength;
    private int waistLength;
    private int id;


    /**
     * Instantiates a new User.
     */
    public User() {
    }

    /**
     * Instantiates a new User.
     *
     * @param firstName the first name
     * @param lastName  the last name
     * @param userEmail the user email
     * @param id        the id
     */
    public User(String firstName, String lastName, String userEmail, int id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userEmail = userEmail;
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
    public String getUserName() {
        return userEmail;
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
     * Sets user email.
     *
     * @param userEmail the user email
     */
    public void setUserName(String userEmail) {
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

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userEmail='" + userEmail + '\'' +
                ", weight='" + weight + '\'' +
                ", height='" + height + '\'' +
                ", neckLength='" + neckLength + '\'' +
                ", waistLength='" + waistLength + '\'' +
                ", id=" + id + '}';
    }
}