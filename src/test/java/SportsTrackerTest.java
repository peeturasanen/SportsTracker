import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SportsTrackerTest {

    private ByteArrayOutputStream outContent;

    @BeforeEach
    public void setUp() {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        SportsTracker.activities.clear();
    }

    @Test
    public void testLogActivity() {
        String input = "Running\n30\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        SportsTracker.logActivity(new Scanner(System.in));

        List<SportsTracker.Activity> activities = SportsTracker.activities;
        assertEquals(1, activities.size());
        assertEquals("Running", activities.get(0).name);
        assertEquals(30, activities.get(0).duration);
    }

    @Test
    public void testViewActivities() {
        SportsTracker.activities.add(new SportsTracker.Activity("Running", 30));
        SportsTracker.viewActivities();

        String output = outContent.toString();
        assertTrue(output.contains("Running: 30 minutes"));
    }

    @Test
    public void testCalculateTotalTime() {
        SportsTracker.activities.add(new SportsTracker.Activity("Running", 30));
        SportsTracker.activities.add(new SportsTracker.Activity("Swimming", 45));
        SportsTracker.calculateTotalTime();

        String output = outContent.toString();
        assertTrue(output.contains("Total time spent on sports: 75 minutes"));
    }
}