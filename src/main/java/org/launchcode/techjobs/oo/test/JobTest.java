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
        Job job1 = new Job();
        Job job2 = new Job();

        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                   new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //Check class assignments
        assertTrue(job3 instanceof Job);
        assertTrue(job3.getEmployer() instanceof Employer);
        assertTrue(job3.getLocation() instanceof Location);
        assertTrue(job3.getPositionType() instanceof PositionType);
        assertTrue(job3.getCoreCompetency() instanceof CoreCompetency);
        //Check value assignments
        assertEquals(job3.getName(), "Product tester");
        assertEquals(job3.getEmployer().getValue(), "ACME");
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertEquals(job3.getPositionType().getValue(), "Quality control");
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job job4 = new Job("Product designer", new Employer("General Electric"), new Location("San Francisco"),
                   new PositionType("Engineering"), new CoreCompetency("Innovation"));
        Job job5 = new Job("Product designer", new Employer("General Electric"), new Location("San Francisco"),
                   new PositionType("Engineering"), new CoreCompetency("Innovation"));

        assertFalse(job4.equals(job5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job job6 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                   new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(job6.toString().charAt(0), '\n');
        assertEquals(job6.toString().charAt(job6.toString().length() - 1), '\n');
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job7 = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                   new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job7.toString().contains('\n' + "ID: " + job7.getId() + '\n'));
        assertTrue(job7.toString().contains("Name: " + job7.getName() + '\n'));
        assertTrue(job7.toString().contains("Employer: " + job7.getEmployer() + '\n'));
        assertTrue(job7.toString().contains("Location: " + job7.getLocation() + '\n'));
        assertTrue(job7.toString().contains("Position Type: " + job7.getPositionType() + '\n'));
        assertTrue(job7.toString().contains("Core Competency: " + job7.getCoreCompetency() + '\n'));
        assertEquals(job7.toString(), "\nID: 4\nName: Product tester\nEmployer: ACME\nLocation: Desert\nPosition" +
                " Type: Quality control\nCore Competency: Persistence\n");
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job8 = new Job("Product designer", new Employer(""), new Location("San Francisco"),
                new PositionType("Engineering"), new CoreCompetency("Innovation"));
        String stringedJob8 = job8.toString();

        assertEquals(job8.getEmployer().getValue(), "");
        assertEquals(stringedJob8,"\nID: 3\nName: Product designer\nEmployer: Data not available\nLocation: " +
                "San Francisco\nPosition Type: Engineering\nCore Competency: Innovation\n");
    }
}
