package unitTests;

import fit.app.entities.HeightRecord;
import fit.app.entities.User;
import fit.app.database.GenericDao;
import fit.app.health.formulas.HealthCalculations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Health calculations test.
 */
class HealthCalculationsTest {
    private HealthCalculations test1User;
    private HealthCalculations testFemaleUser;
    private HealthCalculations emptyUser;

    /**
     * Sets up.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");

        GenericDao<User> userDao = new GenericDao<>(User.class);
        emptyUser = new HealthCalculations(new User());
        test1User = new HealthCalculations(userDao.getById(2));

        database.runSQL("updateTestUser.sql");
        testFemaleUser = new HealthCalculations(userDao.getById(6));
    }

    /**
     * Gets tdee medium male test.
     */
    @Test
    void getTDEEMediumMaleTest() {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        User user1 = userDao.getById(2);
        user1.setActivityLevel("medium");
        test1User = new HealthCalculations(user1);
        Double tdee = 1719.46;

        assertNotNull(test1User.getTDEE());
        assertEquals(tdee, test1User.getTDEE());
    }

    // Male Tests

    /**
     * Gets bmi male test.
     */
    @Test
    void getBMIMaleTest() {
        Double bmi = 101.01;

        assertNotNull(test1User.getBMI());
        assertEquals(bmi, test1User.getBMI());
    }

    /**
     * Gets whr male test.
     */
    @Test
    void getWHRMaleTest() {
        Double whr = 1.0;

        assertNotNull(test1User.getWHR());
        assertEquals(whr, test1User.getWHR());
    }

    /**
     * Gets bfp male test.
     */
    @Test
    void getBFPMaleTest() {
        Double bfp = 111.91;

        assertNotNull(test1User.getBFP());
        assertEquals(bfp, test1User.getBFP());
    }

    /**
     * Gets bmr male test.
     */
    @Test
    void getBMRMaleTest() {
        Double bmr = 1719.46;

        assertNotNull(test1User.getBMR());
        assertEquals(bmr, test1User.getBMR());
    }

    /**
     * Gets tdee male test.
     */
    @Test
    void getTDEEMaleTest() {
        Double tdee = 859.73;

        assertNotNull(test1User.getTDEE());
        assertEquals(tdee, test1User.getTDEE());
    }

    /**
     * Gets ibw male test.
     */
    @Test
    void getIBWMaleTest() {
        Double ibw = 1.65;

        assertNotNull(test1User.getIBW());
        assertEquals(ibw, test1User.getIBW());
    }

    /**
     * Gets lbm male test.
     */
    @Test
    void getLBMMaleTest() {
        Double lbm = 47.53;

        assertNotNull(test1User.getLBM());
        assertEquals(lbm, test1User.getLBM());
    }

    /**
     * Gets whtr male test.
     */
    @Test
    void getWHTRMaleTest() {
        Double whtr = 1.0;

        assertNotNull(test1User.getWHTR());
        assertEquals(whtr, test1User.getWHTR());
    }


    // Female Tests

    /**
     * Gets bmi female test.
     */
    @Test
    void getBMIFemaleTest() {
        Double bmi = 20.0;

        assertNotNull(testFemaleUser.getBMI());
        assertEquals(bmi, testFemaleUser.getBMI());
    }

    /**
     * Gets whr female test.
     */
    @Test
    void getWHRFemaleTest() {
        Double whr = 1.12;

        assertNotNull(testFemaleUser.getWHR());
        assertEquals(whr, testFemaleUser.getWHR());
    }

    /**
     * Gets bfp female test.
     */
    @Test
    void getBFPFemaleTest() {
        Double bfp = 24.12;

        assertNotNull(testFemaleUser.getBFP());
        assertEquals(bfp, testFemaleUser.getBFP());
    }

    /**
     * Gets bmr female test.
     */
    @Test
    void getBMRFemaleTest() {
        Double bmr = 1224.49;

        assertNotNull(testFemaleUser.getBMR());
        assertEquals(bmr, testFemaleUser.getBMR());
    }

    /**
     * Gets tdee female test.
     */
    @Test
    void getTDEEFemaleTest() {
        Double tdee = 1836.74;

        assertNotNull(testFemaleUser.getTDEE());
        assertEquals(tdee, testFemaleUser.getTDEE());
    }

    /**
     * Gets ibw female test.
     */
    @Test
    void getIBWFemaleTest() {
        Double ibw = 43.33;

        assertNotNull(testFemaleUser.getIBW());
        assertEquals(ibw, testFemaleUser.getIBW());
    }

    /**
     * Gets lbm female test.
     */
    @Test
    void getLBMFemaleTest() {
        Double lbm = 33.99;

        assertNotNull(testFemaleUser.getLBM());
        assertEquals(lbm, testFemaleUser.getLBM());
    }

    /**
     * Gets whtr female test.
     */
    @Test
    void getWHTRFemaleTest() {
        Double whtr = 0.37;

        assertNotNull(testFemaleUser.getWHTR());
        assertEquals(whtr, testFemaleUser.getWHTR());
    }


    // NULL Tests

    /**
     * Gets bmi test null.
     */
    @Test
    void getBMItestNull() {
        assertNull(emptyUser.getBMI());
    }

    /**
     * Gets whr test null.
     */
    @Test
    void getWHRtestNull() {
        assertNull(emptyUser.getWHR());
    }

    /**
     * Gets bfp test null.
     */
    @Test
    void getBFPtestNull() {
        assertNull(emptyUser.getBFP());
    }

    /**
     * Gets bmr test null.
     */
    @Test
    void getBMRtestNull() {
        assertNull(emptyUser.getBMR());
    }

    /**
     * Gets tdee test null.
     */
    @Test
    void getTDEEtestNull() {
        assertNull(emptyUser.getTDEE());
    }

    /**
     * Gets ibw test null.
     */
    @Test
    void getIBWtestNull() {
        assertNull(emptyUser.getIBW());
    }

    /**
     * Gets lbm test null.
     */
    @Test
    void getLBMtestNull() {
        assertNull(emptyUser.getLBM());
    }

    /**
     * Gets whtr test null.
     */
    @Test
    void getWHTRtestNull() {
        assertNull(emptyUser.getWHTR());
    }
}