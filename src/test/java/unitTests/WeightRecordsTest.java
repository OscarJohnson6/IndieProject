package unitTests;

import fit.app.dao.WeightRecord;
import fit.app.dao.User;
import fit.app.database.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Records test.
 */
public class WeightRecordsTest {

    private WeightRecord weightRecord;
    private GenericDao<WeightRecord> weightDao;
    private User user;


    /**
     * Create a new ExerciseNinjas object before each test is run.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        weightDao = new GenericDao<>(WeightRecord.class);
    }

    /**
     * Test database.
     */
    @Test
    void testDatabase() {
        weightRecord = new WeightRecord(123);
    }

    /**
     * Test database insert.
     */
    @Test
    void testDatabaseInsert() {
        user = new User(4);
        weightRecord = new WeightRecord(user, 88);
        int id = weightDao.insert(weightRecord);
        weightRecord = weightDao.getById(id);

        assertEquals(id, weightRecord.getId());
        assertEquals(4, weightRecord.getUser().getId());
        assertEquals(88, weightRecord.getWeight());
    }

    /**
     * Test database update.
     */
    @Test
    void testDatabaseUpdate() {
        user = new User(1);
        weightRecord = new WeightRecord(1, user, 112);
        weightDao.update(weightRecord);
        weightRecord = weightDao.getById(1);

        assertEquals(1, weightRecord.getId());
        assertEquals(1, weightRecord.getUser().getId());
        assertEquals(112, weightRecord.getWeight());
    }

    /**
     * Test database all.
     */
    @Test
    void testDatabaseAll() {
        assertNotNull(weightDao.getAll());
        assertEquals(3, weightDao.getAll().size());
    }

    /**
     * Test database delete.
     */
    @Test
    void testDatabaseDelete() {
        user = new User(1);
        weightRecord = new WeightRecord(2, user, 123);
        weightDao.delete(weightRecord);

        assertNull(weightDao.getById(2));
    }

    /**
     * Test database delete again.
     */
    @Test
    void testDatabaseDeleteAgain() {
        weightRecord = weightDao.getById(3);
        weightDao.delete(weightRecord);

        assertNull(weightDao.getById(3));
    }
}
