package unitTests;

import api.ExerciseNinjas;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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


    /**
     * Create a new ExerciseNinjas object before each test is run.
     */
    @BeforeEach
    void setUp() {
        ninjasExercise = new ExerciseNinjas();
    }

    /**
     * Determine the sum for your puzzle input, which is passed in as a file location
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
