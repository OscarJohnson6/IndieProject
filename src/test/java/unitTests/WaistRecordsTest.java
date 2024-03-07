package unitTests;

import fit.app.dao.User;
import fit.app.dao.WaistRecord;
import fit.app.database.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Records test.
 */
public class WaistRecordsTest {

    private WaistRecord waistRecord;
    private GenericDao<WaistRecord> waistDao;
    private User user;


    /**
     * Create a new ExerciseNinjas object before each test is run.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        waistDao = new GenericDao<>(WaistRecord.class);
    }

    /**
     * Test database.
     */
    @Test
    void testDatabase() {
        waistRecord = new WaistRecord(123);
    }

    /**
     * Test database insert.
     */
    @Test
    void testDatabaseInsert() {
        user = new User(4);
        waistRecord = new WaistRecord(user, 88);
        int id = waistDao.insert(waistRecord);
        waistRecord = waistDao.getById(id);

        assertEquals(id, waistRecord.getId());
        assertEquals(4, waistRecord.getUser().getId());
        assertEquals(88, waistRecord.getWaist());
    }

    /**
     * Test database update.
     */
    @Test
    void testDatabaseUpdate() {
        user = new User(1);
        waistRecord = new WaistRecord(1, user, 112);
        waistDao.update(waistRecord);
        waistRecord = waistDao.getById(1);

        assertEquals(1, waistRecord.getId());
        assertEquals(1, waistRecord.getUser().getId());
        assertEquals(112, waistRecord.getWaist());
    }

    /**
     * Test database all.
     */
    @Test
    void testDatabaseAll() {
        assertNotNull(waistDao.getAll());
        assertEquals(3, waistDao.getAll().size());
    }

    /**
     * Test database delete.
     */
    @Test
    void testDatabaseDelete() {
        user = new User(1);
        waistRecord = new WaistRecord(2, user, 123);
        waistDao.delete(waistRecord);

        assertNull(waistDao.getById(2));
    }

    /**
     * Test database delete again.
     */
    @Test
    void testDatabaseDeleteAgain() {
        waistRecord = waistDao.getById(3);
        waistDao.delete(waistRecord);

        assertNull(waistDao.getById(3));
    }
}
