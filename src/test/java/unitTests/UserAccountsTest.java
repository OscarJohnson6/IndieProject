package unitTests;

import fit.app.dao.User;
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

    private User user;
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
     * Test database.
     */
    @Test
    void testDatabase() {
        user = new User(
                "@email",
                "Oscar",
                "Johnson",
                "male",
                null);
    }

    /**
     * Test database update.
     */
    @Test
    void testUserAge() {
        user = userDao.getById(1);
        LocalDate age = LocalDate.of(2004, 1, 26);

        assertEquals(1, user.getId());
        assertEquals("Oscar", user.getFirstName());
        assertEquals("Johnson", user.getLastName());
        assertEquals("male", user.getGender());
        assertEquals(age, user.getAge());
        assertEquals(20, user.getAgeNumber());
    }

    /**
     * Test database insert.
     */
    @Test
    void testDatabaseInsert() {
        user = new User("Oscar@email");
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
        user = userDao.getById(1);
        user.setFirstName("Test");
        user.setLastName("Update");

        userDao.update(user);

        User userUpdated = userDao.getById(1);
        assertEquals("Test", userUpdated.getFirstName());
        assertEquals("Update", userUpdated.getLastName());
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
