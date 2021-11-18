package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
        private  final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

        public static void createItem(Input input, MemTracker tracker) {
            System.out.println("=== Create a new Item ====");
            String name = input.askStr("Enter name: ");
            Item item = new Item(name);
            tracker.add(item);
        }

        public static void showAllItems(MemTracker tracker) {
            System.out.println("=== Show all items ====");
            List<Item> array = tracker.findAll();
            for (Item item : array) {
                System.out.println(item);
            }
        }

        public static void editItem(Input input, MemTracker tracker) {
            System.out.println("=== Edit item ===");
            int id = input.askInt("Enter id: ");
            String name = input.askStr("Enter name: ");
            Item item = new Item(name);
            if (tracker.replace(id, item)) {
                System.out.println("Item edit success");
            } else {
                System.out.println("System error");
            }
        }

        public static void deleteItem(Input input, MemTracker tracker) {
            System.out.println("=== Delete item ====");
            int id = input.askInt("Enter id: ");
            if (tracker.delete(id)) {
                System.out.println("Item delete success");
            } else {
                System.out.println("System error");
            }
        }

        public static void findById(Input input, MemTracker tracker) {
            System.out.println("=== Find item by Id ====");
            int id = input.askInt("Enter id: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item);
            } else {
                System.out.println("Заявка с таким id не найдена");
            }
        }

        public static void findByName(Input input, MemTracker tracker) {
            System.out.println("=== Find items by name ===");
            String name = input.askStr("Enter name: ");
            List<Item> array = tracker.findByName(name);
            if (array.size() > 0) {
                for (int i = 0; i < array.size(); i++) {
                    System.out.println(array.get(i));
                }
            } else {
                System.out.println("Заявки с таким именем не найдены");
            }
        }

        public void init(Input input, Store tracker, List<UserAction> actions) {
        tracker.init();
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

        private void showMenu(List<UserAction> actions) {
            out.println("Menu.");
            for (int index = 0; index < actions.size(); index++) {
                out.println(index + ". " + actions.get(index).name());
            }
        }

        public static void main(String[] args) {
            Output output = new ConsoleOutput();
            Input input = new ValidateInput(output, new ConsoleInput());
            try (Store tracker = new SqlTracker()) {
                ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new CreateAction(output));
            actions.add(new DeleteAction(output));
            actions.add(new FindAllAction(output));
            actions.add(new ReplaceAction(output));
            actions.add(new FindByIdAction(output));
            actions.add(new FindByNameAction(output));
            actions.add(new ExitAction(output));
                new StartUI(output).init(input, tracker, actions);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
