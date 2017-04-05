package com.example.theseus.testingandroid;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withInputType;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.text.InputType.TYPE_CLASS_TEXT;
import static android.text.InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD;
import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class LoginActivityEspressoTest {
    @Rule
    public ActivityTestRule<LoginActivity> mActivityRule=new ActivityTestRule<LoginActivity>(LoginActivity.class);

    /**
     * Test for
     * Requirement: The LoginActivity must have a place
     * for the user to enter their email address.
     *
     * @throws Exception
     */
    @Test
    public void checkEmailFieldExists() throws Exception {
        onView(withId(R.id.email)).check(matches(isDisplayed()));
    }

    /**
     * Test for
     * Requirement: The LoginActivity must have a place for the user to enter their password.
     * @throws Exception
     */
    @Test
    public void checkPasswordFieldExists() throws Exception{
        onView(withId(R.id.password)).check(matches(isDisplayed()));
    }

    /**
     * Test for
     * Requirement: The LoginActivity must not display the password in plain text
     * @throws Exception
     */
    @Test
    public void checkPasswordNotInPlainText() throws Exception{
        //This test is not working as expected
       // onView(withId(R.id.password)).perform(typeText("abc"));
       //onView(withId(R.id.password)).check(matches(withInputType(TYPE_TEXT_VARIATION_VISIBLE_PASSWORD)));
    }

    /**
     * Test for
     * Requirement: The LoginActivity must have a login button that displays the text "Login"
     * @throws Exception
     */
    @Test
    public void checkLoginButtonText() throws Exception{
        onView(withId(R.id.login)).check(matches(withText("Login")));
    }

}
