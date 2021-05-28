package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"one", "1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenCorrectInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu:");
        assertThat(selected, is(1));
    }

    @Test
    public void whenMultipleCorrectInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "2", "4"});
        ValidateInput input = new ValidateInput(out, in);
        int selected =  0;
        for (int i = 0; i < 3; i++) {
            selected = input.askInt("Enter menu:");
        }
        assertThat(selected, is(4));
    }

    @Test
    public void whenNegativeNumberInput() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1", "2", "-4"});
        ValidateInput input = new ValidateInput(out, in);
        int selected =  0;
        for (int i = 0; i < 3; i++) {
            selected = input.askInt("Enter menu:");
        }
        assertThat(selected, is(-4));
    }
}