package unitTests;

import fit.app.dao.HipRecord;
import fit.app.dao.User;
import fit.app.database.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Records test.
 */
public class HipRecordsTest {

    private HipRecord hipRecord;
    private GenericDao<HipRecord> hipDao;
    private User user;


    /**
     * Create a new ExerciseNinjas object before each test is run.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        hipDao = new GenericDao<>(HipRecord.class);
    }

    /**
     * Test database.
     */
    @Test
    void testDatabase() {
        hipRecord = new HipRecord(123);
    }

    /**
     * Test database insert.
     */
    @Test
    void testDatabaseInsert() {
        user = new User(4);
        hipRecord = new HipRecord(user, 88);
        int id = hipDao.insert(hipRecord);
        hipRecord = hipDao.getById(id);

        assertEquals(id, hipRecord.getId());
        assertEquals(4, hipRecord.getUser().getId());
        assertEquals(88, hipRecord.getHip());
    }

    /**
     * Test database update.
     */
    @Test
    void testDatabaseUpdate() {
        user = new User(1);
        hipRecord = new HipRecord(1, user, 112);
        hipDao.update(hipRecord);
        hipRecord = hipDao.getById(1);

        assertEquals(1, hipRecord.getId());
        assertEquals(1, hipRecord.getUser().getId());
        assertEquals(112, hipRecord.getHip());
    }

    /**
     * Test database all.
     */
    @Test
    void testDatabaseAll() {
        assertNotNull(hipDao.getAll());
        assertEquals(3, hipDao.getAll().size());
    }

    /**
     * Test database delete.
     */
    @Test
    void testDatabaseDelete() {
        user = new User(1);
        hipRecord = new HipRecord(2, user, 123);
        hipDao.delete(hipRecord);

        assertNull(hipDao.getById(2));
    }

    /**
     * Test database delete again.
     */
    @Test
    void testDatabaseDeleteAgain() {
        hipRecord = hipDao.getById(3);
        hipDao.delete(hipRecord);

        assertNull(hipDao.getById(3));
    }
}
