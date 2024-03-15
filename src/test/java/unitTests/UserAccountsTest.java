package unitTests;

import fit.app.dao.*;
import fit.app.database.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Health numbers test.
 *
 * @author OscarJohnson6
 */
public class UserAccountsTest {
    private GenericDao<User> userDao;

    /**
     * Create a new ExerciseNinjas object before each test is run.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        userDao = new GenericDao<>(User.class);
    }

    /**
     * Test database update.
     */
    @Test
    void testUserAge() {
        User user = userDao.getById(1);
        LocalDate age = LocalDate.of(2004, 1, 27);

        assertEquals(1, user.getId());
        assertEquals("Oscar", user.getFirstName());
        assertEquals("Johnson", user.getLastName());
        assertEquals("male", user.getGender());
        assertEquals(age, user.getAge());
        Integer testAge = 20;
        assertEquals(testAge, user.getAgeNumber());
    }

    /**
     * Test database insert.
     */
    @Test
    void testDatabaseInsert() {
        User user = new User("Oscar@email");
        int id = userDao.insert(user);
        User userReturn = userDao.getById(id);

        assertEquals(id, userReturn.getId());
        assertEquals("Oscar@email", userReturn.getUserEmail());
    }

    /**
     * Test database update.
     */
    @Test
    void testDatabaseUpdate() {
        User user = userDao.getById(1);
        user.setFirstName("Test");
        user.setLastName("Update");

        userDao.update(user);

        User userUpdated = userDao.getById(1);
        assertEquals("Test", userUpdated.getFirstName());
        assertEquals("Update", userUpdated.getLastName());
    }

    /**
     * Test database delete.
     */
    @Test
    void testDatabaseDelete() {
        User user = userDao.getById(1);
        GenericDao<WeightRecord> weightDao = new GenericDao<>(WeightRecord.class);
        GenericDao<HeightRecord> heightDao = new GenericDao<>(HeightRecord.class);
        GenericDao<WaistRecord> waistDao = new GenericDao<>(WaistRecord.class);
        GenericDao<HipRecord> hipDao = new GenericDao<>(HipRecord.class);
        userDao.delete(user);

        assertNull(userDao.getById(1));

        assertNull(weightDao.getById(1));
        assertNull(weightDao.getById(2));

        assertNull(heightDao.getById(1));
        assertNull(heightDao.getById(2));

        assertNull(waistDao.getById(1));
        assertNull(waistDao.getById(2));

        assertNull(hipDao.getById(1));
        assertNull(hipDao.getById(2));
    }

    /**
     * Test database all.
     */
    @Test
    void testDatabaseAll() {
        List<User> userList = userDao.getAll();

        assertNotNull(userList);
        assertEquals(9, userList.size());
    }
}
