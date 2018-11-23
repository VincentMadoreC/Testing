package com.example.vincent.testing;

import com.example.vincent.testing.ScheduleManager.DailySchedule;
import com.example.vincent.testing.ScheduleManager.State;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DailyScheduleTest {

    @Test
    public void isBookedBetween() {
        DailySchedule schedule = new DailySchedule(480, 960, State.BOOKED);
        assertFalse(schedule.isBookedBetween(240, 360));
        assertFalse(schedule.isBookedBetween(240, 480));
        assertTrue(schedule.isBookedBetween(240, 720));
        assertTrue(schedule.isBookedBetween(240, 960));
        assertTrue(schedule.isBookedBetween(240, 1080));
        assertTrue(schedule.isBookedBetween(480, 720));
        assertTrue(schedule.isBookedBetween(480, 960));
        assertTrue(schedule.isBookedBetween(480, 1080));
        assertTrue(schedule.isBookedBetween(720, 960));
        assertTrue(schedule.isBookedBetween(720, 1080));
        assertFalse(schedule.isBookedBetween(960, 1080));
        assertFalse(schedule.isBookedBetween(1080, 1200));

        DailySchedule schedule2 = new DailySchedule(480, 960, State.AVAILABLE);
        assertFalse(schedule2.isBookedBetween(0, 1440));
    }
}