package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByIdActionTest {
    @Test
    public void whenFindIdAction() {
        Output out = new StubOutput();
        MemTracker tracker = new MemTracker();
        Item item = new Item(1, "New Item");
        tracker.add(item);
        FindByIdAction find = new FindByIdAction(out);
        Input input = mock(Input.class);
        when(input.askInt(any(String.class))).thenReturn(1);
        find.execute(input, tracker);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find item by Id ====" + ln + item + ln));
    }
}