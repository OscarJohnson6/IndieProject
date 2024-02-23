package unitTests;

import fit.app.api.ExerciseNinjas;
import org.junit.jupiter.api.BeforeEach;

import java.util.List;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type Api results test.
 */
public class ApiResultsTest {

    /**
     * Create a new ExerciseNinjas object before each test is run.
     */
    @BeforeEach
    void setUp() {
    }

    /**
     *
     * CAUTION: This is connected to a limited (500 uses) API.
     */
//    @Test
    void testAPIResultsAll() {
        ExerciseNinjas ninjasExercise = new ExerciseNinjas();
        List<TreeMap<String, String>> result = ninjasExercise.createApiResponse(
                "",
                "",
                "",
                "",
                5);

        assertNotNull(result);
        assertFalse(result.isEmpty());
        assertEquals(10, result.size());
    }
}
