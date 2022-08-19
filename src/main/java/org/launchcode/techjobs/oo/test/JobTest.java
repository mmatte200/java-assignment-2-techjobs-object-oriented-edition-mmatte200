package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Web Developer", new Employer("LaunchCode"), new Location("St. Louis"), new PositionType("Front-end developer"), new CoreCompetency("JavaScript"));
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertTrue(job2.getName() instanceof String);
        assertTrue(job2.getEmployer() instanceof Employer);
        assertTrue(job2.getLocation() instanceof Location);
        assertTrue(job2.getPositionType() instanceof PositionType);
        assertTrue(job2.getCoreCompetency() instanceof CoreCompetency);

        assertEquals(job2.getName(), "Product tester");
        assertEquals(job2.getEmployer().getValue(), "ACME");
        assertEquals(job2.getLocation().getValue(), "Desert");
        assertEquals(job2.getPositionType().getValue(), "Quality control");
        assertEquals(job2.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String jobString = job1.toString();
        int lastChar = jobString.length() - 1;
        assertEquals(jobString.charAt(0), '\n');
        assertEquals(jobString.charAt(lastChar), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals(job1.toString() , "\n" +
                        "ID: " + job1.getId() + "\n" +
                        "Name: Product tester\n" +
                        "Employer: ACME\n" +
                        "Location: Desert\n" +
                        "Position Type: Quality control\n" +
                        "Core Competency: Persistence" +
                        "\n");


    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job job1 = new Job("Product tester", new Employer(null), new Location(""), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("\n" + "ID: " + job1.getId() + "\n" +
                "Name: " + "Product tester" + "\n" +
                "Employer: " + "Data not available" + "\n" +
                "Location: " + "Data not available" + "\n" +
                "Position Type: " + "Quality control" + "\n" +
                "Core Competency: " + "Persistence" +
                "\n", job1.toString());

    }
}