package ru.job4j.tracker;

import org.junit.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HbmTrackerTest {
    public class TrackerHbmTest {
        private final HbmTracker tracker = new HbmTracker();

        @Test
        public void whenAddNewItemThenTrackerHasSameItem() throws Exception {
            try (var tracker = new HbmTracker()) {
                Item item = new Item();
                item.setName("test1");
                tracker.add(item);
                Item result = tracker.findById(item.getId());
                assertThat(result.getName(), is(item.getName()));
            }
        }

        @Test
        public void whenFindAll() {
            Item item = new Item("item");
            Item test = new Item("test");
            tracker.add(item);
            tracker.add(test);
            var results = tracker.findAll();
            assertThat(results.size(), is(2));
        }

        @Test
        public void delete() {
            HbmTracker tracker = new HbmTracker();
            Item item1 = new Item(1, "name1", LocalDateTime.now());
            tracker.add(item1);
            Item item2 = new Item(2, "name2", LocalDateTime.now());
            tracker.add(item2);
            List<Item> result = tracker.findAll();
            assertThat(result.size(), is(2));
            tracker.delete(2);
            List<Item> resultTwo = tracker.findAll();
            assertThat(resultTwo.size(), is(1));
        }

        @Test
        public void findById() {
            HbmTracker tracker = new HbmTracker();
            Item item1 = new Item(1, "name1", LocalDateTime.now());
            tracker.add(item1);
            Item item2 = new Item(2, "name1", LocalDateTime.now());
            tracker.add(item2);
            Item rsl1 = tracker.findById(1);
            assertThat(rsl1, is(item1));
            Item rsl2 = tracker.findById(2);
            assertThat(rsl2, is(item2));
        }
    }
}