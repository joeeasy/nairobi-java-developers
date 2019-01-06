package com.javadevnairobi;

import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.javadevnairobi.view.MainActivity;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.os.SystemClock.sleep;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {
    @Rule public ActivityTestRule<MainActivity> mainActivityMainActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Before
    public void setUp() {
        sleep(5000);
    }
    @Test
    public void launchDetailView() {
        onView(withId(R.id.recycler_view))
                .perform(RecyclerViewActions
                        .actionOnItemAtPosition(8, click()));
        sleep(5000);
    }
    @Test
    public void checkIfLayoutIsRendered() {
        onView((withId(R.id.main_activity))).check(matches(isDisplayed()));
        onView(allOf(withId(R.id.recycler_view))).check(matches(isDisplayed()));

    }

    @Test
    public void swipeWidget() {
        onView(ViewMatchers.withId(R.id.swipe)).check(matches(isDisplayed()));
        onView(withId(R.id.main_activity)).perform(ViewActions.swipeDown());
        sleep(5000);
    }
}
