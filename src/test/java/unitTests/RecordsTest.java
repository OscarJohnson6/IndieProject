package unitTests;

import fit.app.dao.HeightRecord;
import fit.app.dao.User;
import fit.app.database.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Records test.
 */
public class RecordsTest {

    private HeightRecord heightRecord;
    private GenericDao<HeightRecord> heightDao;
    private User user;


    /**
     * Create a new ExerciseNinjas object before each test is run.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        heightDao = new GenericDao<>(HeightRecord.class);
    }

    /**
     * Test database.
     */
    @Test
    void testDatabase() {
        heightRecord = new HeightRecord(123);
    }

    /**
     * Test database insert.
     */
    @Test
    void testDatabaseInsert() {
        user = new User(4);
        heightRecord = new HeightRecord(user, 88);
        int id = heightDao.insert(heightRecord);
        heightRecord = heightDao.getById(id);

        assertEquals(id, heightRecord.getId());
        assertEquals(4, heightRecord.getUser().getId());
        assertEquals(88, heightRecord.getHeight());
    }

    /**
     * Test database update.
     */
    @Test
    void testDatabaseUpdate() {
        user = new User(1);
        heightRecord = new HeightRecord(1, user, 112);
        heightDao.update(heightRecord);
        heightRecord = heightDao.getById(1);

        assertEquals(1, heightRecord.getId());
        assertEquals(1, heightRecord.getUser().getId());
        assertEquals(112, heightRecord.getHeight());
    }

    /**
     * Test database all.
     */
    @Test
    void testDatabaseAll() {
        assertNotNull(heightDao.getAll());
        assertEquals(3, heightDao.getAll().size());
    }

    /**
     * Test database delete.
     */
    @Test
    void testDatabaseDelete() {
        user = new User(1);
        heightRecord = new HeightRecord(2, user, 123);
        heightDao.delete(heightRecord);

        assertNull(heightDao.getById(2));
    }

    /**
     * Test database delete again.
     */
    @Test
    void testDatabaseDeleteAgain() {
        heightRecord = heightDao.getById(3);
        heightDao.delete(heightRecord);

        assertNull(heightDao.getById(3));
    }
}
