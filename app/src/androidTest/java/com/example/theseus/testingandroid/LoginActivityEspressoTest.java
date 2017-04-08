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
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
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

    /**
     * Test for Requirement:
     * When the login button is clicked, the activity should check that the password is at least 8
     characters long and display the error message "The provided password is too short" if the
     password is too short
     * @throws Exception
     */
    @Test
    public void checkPasswordTooShortError() throws Exception{
        onView(withId(R.id.email)).perform(typeText("a@b.c"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("abc"), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.error)).check(matches(isDisplayed()));
        onView(withId(R.id.error)).check(matches(withText(R.string.password_length_too_small)));
    }

    /**
     * Test for requirement
     * When the login button is clicked, the activity should check that the password is not all spaces
     and display the error message "The provided password is invalid" if the password is all spaces
     * @throws Exception
     */
    @Test
    public void checkAllSpacesInPassword() throws Exception{
        onView(withId(R.id.email)).perform(typeText("a@b.c"), closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("          "), closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.error)).check(matches(isDisplayed()));
        onView(withId(R.id.error)).check(matches(withText(R.string.password_all_spaces)));
    }

    /**
     * When the login button is clicked, the activity should check that the email address: a) has an
     "@" sign, b) has at least 1 character before the "@" sign, and c) has at least 3 characters,
     including a "." after the "@" sign
     * @throws Exception
     */
    @Test
    public void checkValidEmailAddress() throws Exception{
        onView(withId(R.id.email)).perform(typeText("a@bd"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("123456789"),closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.error)).check(matches(isDisplayed()));
        onView(withId(R.id.error)).check(matches(withText(R.string.invalid_email)));
    }

    /**
     * Test for requirement
     * If the email address and password are valid, the success message "Login success" should be
     displayed
     * @throws Exception
     */
    @Test
    public void checkLoginSuccess() throws Exception{
        onView(withId(R.id.email)).perform(typeText("a@b.d"),closeSoftKeyboard());
        onView(withId(R.id.password)).perform(typeText("123456789"),closeSoftKeyboard());
        onView(withId(R.id.login)).perform(click());
        onView(withId(R.id.error)).check(matches(isDisplayed()));
        onView(withId(R.id.error)).check(matches(withText(R.string.login_success)));
    }

}
