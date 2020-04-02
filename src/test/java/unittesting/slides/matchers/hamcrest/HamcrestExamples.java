package unittesting.slides.matchers.hamcrest;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import unittesting.slides.matchers.Person;
import unittesting.slides.matchers.hamcrest.matchers.IsNotANumber;
import unittesting.slides.matchers.hamcrest.matchers.PersonMatcher;

import java.util.Arrays;
import java.util.List;

import static java.lang.Math.sqrt;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class HamcrestExamples {

    private int size = 3;
    private int x = 3;
    private List<Integer> myList = Arrays.asList(1, 2, 3);
    private String responseString = "color";
    private Cookie cookie = new Cookie();

    @Test
    void someCoolTests() {
        assertEquals(x, 3);
        assertThat(x, is(3)); // ham
        org.assertj.core.api.Assertions.assertThat(x).isEqualTo(3); // AssertJ

        assertNotEquals(x, 4);
        assertThat(x, is(not(4)));

        assertThat(myList, hasItem(3));
        assertThat(myList, allOf(hasItem(1), not(hasItem(4))));
        assertThat(responseString, either(containsString("color")).or(containsString("colour")));

        assertThat("Size must be greater than 1.", size, is(greaterThan(1)));
        assertThat("Not enough choco chips.", cookie.chocoChipCount(), is(10));
    }

    @Test
    void testSquareRootOfMinusOneIsNotANumber() {
        MatcherAssert.assertThat(sqrt(-1), CoreMatchers.is(IsNotANumber.notANumber()));
    }

    @Test
    void multipleCustomChecks() {
        Person ams = new Person(1, "Klaas", "Adam");
        Person rot = new Person(2, "Klaas", "Rotterdam");

        MatcherAssert.assertThat(sqrt(-1), CoreMatchers.is(IsNotANumber.notANumber()));
        MatcherAssert.assertThat(ams, CoreMatchers.is(CoreMatchers.not(PersonMatcher.person(rot))));
    }

    private class Cookie {
        int chocoChipCount() { return 10; }
    }
}
