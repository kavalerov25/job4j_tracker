package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ReplaceActionTest {

    @Test
    public void execute() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        ReplaceAction rep = new ReplaceAction(out);

        Input input = mock(Input.class);

/**
 * when(input.askInt(any(String.class))).thenReturn(1);
 * when(input.askStr(any(String.class))).thenReturn(replacedName);
 * Проблем при выполнении не возникло.
 * Если мы уберем строки настройки нашей заглушки (использование метода when()),
 * изменим немного сравниваемые значения в assertThat():
 */

        rep.execute(input, tracker);
        String ln = System.lineSeparator();
        /**
         *  assertThat(out.toString(), is("=== Edit item ===" + ln + "Edit item is done." + ln));
         *  assertThat(tracker.findAll().get(0).getName(), is(replacedName));
         */

        assertThat(out.toString(), is("=== Edit item ===" + ln + "Item with id=0 not found." + ln));
        assertThat(tracker.findAll().get(0).getName(), is("Replaced item"));

    }
}