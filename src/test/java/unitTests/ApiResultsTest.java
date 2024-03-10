package unitTests;

import fit.app.api.ApiNinjas;
import fit.app.api.ExerciseDb;
import fit.app.pojo.ExerciseDbJson;
import org.junit.jupiter.api.BeforeEach;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
     * CAUTION: This is connected to a limited (500 uses) API.
     */
//    @Test
    void testAPIResultsAll() {
        ApiNinjas ninjasExercise = new ApiNinjas();
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

    /**
     * CAUTION: This is connected to a limited (500 uses) API.
     */
//    @Test
    void testExerciseDb() {
        ExerciseDb exerciseDb = new ExerciseDb();
        ArrayList<ExerciseDbJson> exerciseArray = exerciseDb.createApiResponse(0, 0);

        assertNotNull(exerciseArray);
        assertEquals(10, exerciseArray.size());

        ExerciseDbJson exercise0 = exerciseArray.get(0);
        assertEquals("waist", exercise0.getBodyPart());
        assertEquals("body weight", exercise0.getEquipment());
        assertEquals("3/4 sit-up", exercise0.getName());
        assertEquals("abs", exercise0.getTarget());
        assertEquals(testInstructions(), exercise0.getInstructions());

    }

    private List<String> testInstructions() {
        List<String> testList = new ArrayList<>();
        testList.add("Lie flat on your back with your knees bent and feet flat on the ground.");
        testList.add("Place your hands behind your head with your elbows pointing outwards.");
        testList.add("Engaging your abs, slowly lift your upper body off the "
                + "ground, curling forward until your torso is at a 45-degree angle.");
        testList.add("Pause for a moment at the top, then slowly lower your "
                + "upper body back down to the starting position.");
        testList.add("Repeat for the desired number of repetitions.");
        return testList;
    }
}
