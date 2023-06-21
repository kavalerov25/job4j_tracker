package ru.job4j.tracker;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

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

    private static String loadSysEnvIfNullThenConfig(String sysEnv, String key, Properties config) {
        String value = System.getenv(sysEnv);
        if (value == null) {
            value = config.getProperty(key);
        }
        return value;
    }

    private static Connection loadConnection() throws ClassNotFoundException, SQLException {
        var config = new Properties();
        try (InputStream in = StartUI.class.getClassLoader()
                .getResourceAsStream("app.properties")) {
            config.load(in);
        } catch (IOException e) {
            throw new IllegalStateException(e);
        }
        String url = loadSysEnvIfNullThenConfig("JDBC_URL", "url", config);
        String username = loadSysEnvIfNullThenConfig("JDBC_USERNAME", "username", config);
        String password = loadSysEnvIfNullThenConfig("JDBC_PASSWORD", "password", config);
        String driver = loadSysEnvIfNullThenConfig("JDBC_DRIVER", "driver-class-name", config);
        System.out.println("url=" + url);
        Class.forName(driver);
        return DriverManager.getConnection(
                url, username, password
        );
    }

        public static void main(String[] args) {

            Output output = new ConsoleOutput();
            Input input = new ValidateInput(output, new ConsoleInput());
            try (Connection connection = loadConnection()) {
                ArrayList<UserAction> actions = new ArrayList<>();
            actions.add(new CreateAction(output));
            actions.add(new DeleteAction(output));
            actions.add(new FindAllAction(output));
            actions.add(new ReplaceAction(output));
            actions.add(new FindByIdAction(output));
            actions.add(new FindByNameAction(output));
            actions.add(new ExitAction(output));
                Store tracker = new MemTracker();
                new StartUI(output).init(input, tracker, actions);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
