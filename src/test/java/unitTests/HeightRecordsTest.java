package unitTests;

import fit.app.entities.HeightRecord;
import fit.app.entities.User;
import fit.app.database.GenericDao;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import util.Database;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Records test.
 */
public class HeightRecordsTest {

    private HeightRecord heightRecord;
    private GenericDao<HeightRecord> heightDao;
    private User user;

    private GenericDao<User> userDao;


    /**
     * Create a new ExerciseNinjas object before each test is run.
     */
    @BeforeEach
    void setUp() {
        Database database = Database.getInstance();
        database.runSQL("cleandb.sql");
        heightDao = new GenericDao<>(HeightRecord.class);
        userDao = new GenericDao<>(User.class);
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
        user = userDao.getById(4);
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
        user = userDao.getById(1);
        heightRecord = new HeightRecord(1, user, 101);
        heightDao.update(heightRecord);
        heightRecord = heightDao.getById(1);

        assertEquals(1, heightRecord.getId());
        assertEquals(1, heightRecord.getUser().getId());
        assertEquals(101, heightRecord.getHeight());
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
        user = userDao.getById(1);
        heightRecord = heightDao.getById(2);
        List<HeightRecord> heightListBefore = user.getHeightRecords();

        heightDao.delete(heightRecord);
        user = userDao.getById(1);
        List<HeightRecord> heightListAfter = user.getHeightRecords();

        assertNull(heightDao.getById(2));
        assertNotSame(heightListBefore.size(), heightListAfter.size());
        assertEquals(heightListBefore.size() - 1, heightListAfter.size());
        assertEquals(2, heightListBefore.get(1).getId());
        assertThrows(IndexOutOfBoundsException.class, () -> {
                    heightListAfter.get(1);
                });
        assertSame(heightListBefore.get(0).getId(), heightListAfter.get(0).getId());
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
