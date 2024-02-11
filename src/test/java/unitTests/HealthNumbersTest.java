package unitTests;

import Database.UserDao;
import api.ExerciseNinjas;
import dao.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Health numbers test.
 *
 * @author OscarJohnson6
 */
public class HealthNumbersTest {

    /**
     * The Ninjas exercise.
     */
    ExerciseNinjas ninjasExercise;
    User user;
    UserDao userDao;


    /**
     * Create a new ExerciseNinjas object before each test is run.
     */
    @BeforeEach
    void setUp() {
        ninjasExercise = new ExerciseNinjas();
        user = new User();
        userDao = new UserDao();
    }

    @Test
    void testDatabase() {

        user = new User("Oscar", "Johnson", "@email",
                new ArrayList<WeightRecord>(),
                new ArrayList<HeightRecord>(),
                new ArrayList<NeckLengthRecord>(),
                new ArrayList<WaistLengthRecord>(),
                1);
        userDao.insert(user);
        userDao.update(user);
        assertNotNull(userDao.getAll());
        assertEquals(1, userDao.insert(user));
    }

    @Test
    void testDatabaseInsert() {

        user = new User("Oscar", "Johnson", "@email",
                new ArrayList<WeightRecord>(),
                new ArrayList<HeightRecord>(),
                new ArrayList<NeckLengthRecord>(),
                new ArrayList<WaistLengthRecord>(),
                1);
        userDao.insert(user);

        assertEquals(1, userDao.insert(user));
    }

    @Test
    void testDatabaseUpdate() {

        user = new User("Oscar", "Johnson", "@email",
                new ArrayList<WeightRecord>(),
                new ArrayList<HeightRecord>(),
                new ArrayList<NeckLengthRecord>(),
                new ArrayList<WaistLengthRecord>(),
                1);

        userDao.update(user);
    }

    @Test
    void testDatabaseAll() {
        assertNotNull(userDao.getAll());
    }

    /**
     * Determine the sum for your puzzle input, which is passed in as a file location
     * CAUTION: This is connected to a limited (500 uses) API.
     */
    @Test
    void testAPIResultsAll() {
//        List<TreeMap<String, String>> result = ninjasExercise.createApiResponse(
//                "",
//                "",
//                "",
//                "",
//                5);
//
//        assertNotNull(result);
//        assertFalse(result.isEmpty());
//        assertEquals(10, result.size());
    }
}
