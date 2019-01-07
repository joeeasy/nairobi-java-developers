package com.javadevnairobi;

import android.content.Intent;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.javadevnairobi.view.DetailView;

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
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class DetailActivityTest {
    public static final String EXTRA_MESSAGE = "com.javadevnairobi.MESSAGE";

    @Rule
    public ActivityTestRule<DetailView> detailViewActivityTestRule = new ActivityTestRule<>(DetailView.class, false, false);

    @Before
    public void launchDetailActivity() {
        Intent intent = new Intent();
        intent.putExtra(EXTRA_MESSAGE, "kioko");
        detailViewActivityTestRule.launchActivity(intent);

        sleep(8000);
    }

    @Test
    public void onLaunchSuccess() {
        onView(withId(R.id.scrollView)).check(matches(isDisplayed()));
        onView(withId(R.id.username)).check(matches(withText("kioko")));
    }


}
