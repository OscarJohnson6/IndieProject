package unitTests;

import fit.app.dao.User;
import fit.app.database.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.Date;
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
                new Date());
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
