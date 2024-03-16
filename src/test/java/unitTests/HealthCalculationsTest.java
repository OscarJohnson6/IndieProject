package unitTests;

import fit.app.entities.User;
import fit.app.database.GenericDao;
import fit.app.health.formulas.HealthCalculations;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HealthCalculationsTest {
    private HealthCalculations test1User;
    private HealthCalculations emptyUser;

    @BeforeEach
    void setUp() {
        GenericDao<User> userDao = new GenericDao<>(User.class);
        test1User = new HealthCalculations(userDao.getById(2));
        emptyUser = new HealthCalculations(new User());
    }

    @Test
    void getBMItest() {
        Double bmi = 101.01;

        assertNotNull(test1User.getBMI());
        assertEquals(bmi, test1User.getBMI());
    }

    @Test
    void getWHRtest() {
        Double whr = 1.0;

        assertNotNull(test1User.getWHR());
        assertEquals(whr, test1User.getWHR());
    }

    @Test
    void getBFPtest() {
        Double bfp = 111.91;

        assertNotNull(test1User.getBFP());
        assertEquals(bfp, test1User.getBFP());
    }

    @Test
    void getBMRtest() {
        Double bmr = 1719.46;

        assertNotNull(test1User.getBMR());
        assertEquals(bmr, test1User.getBMR());
    }

    @Test
    void getTDEEtest() {
        Double tdee = 859.73;

        assertNotNull(test1User.getTDEE());
        assertEquals(tdee, test1User.getTDEE());
    }

    @Test
    void getIBWtest() {
        Double ibw = 1.65;

        assertNotNull(test1User.getIBW());
        assertEquals(ibw, test1User.getIBW());
    }

    @Test
    void getLBMtest() {
        Double lbm = 47.53;

        assertNotNull(test1User.getLBM());
        assertEquals(lbm, test1User.getLBM());
    }

    @Test
    void getWHTRtest() {
        Double whtr = 1.0;

        assertNotNull(test1User.getWHTR());
        assertEquals(whtr, test1User.getWHTR());
    }


    // NULL

    @Test
    void getBMItestNull() {
        assertNull(emptyUser.getBMI());
    }

    @Test
    void getWHRtestNull() {
        assertNull(emptyUser.getWHR());
    }

    @Test
    void getBFPtestNull() {
        assertNull(emptyUser.getBFP());
    }

    @Test
    void getBMRtestNull() {
        assertNull(emptyUser.getBMR());
    }

    @Test
    void getTDEEtestNull() {
        assertNull(emptyUser.getTDEE());
    }

    @Test
    void getIBWtestNull() {
        assertNull(emptyUser.getIBW());
    }

    @Test
    void getLBMtestNull() {
        assertNull(emptyUser.getLBM());
    }

    @Test
    void getWHTRtestNull() {
        assertNull(emptyUser.getWHTR());
    }
}