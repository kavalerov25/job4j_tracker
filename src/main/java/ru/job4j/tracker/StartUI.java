package ru.job4j.tracker;
    public class StartUI {
        private  final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

        public static void createItem(Input input, Tracker tracker) {
            System.out.println("=== Create a new Item ====");
            String name = input.askStr("Enter name: ");
            Item item = new Item(name);
            tracker.add(item);
        }

        public static void showAllItems(Tracker tracker) {
            System.out.println("=== Show all items ====");
            Item[] array = tracker.findAll();
            for (Item item : array) {
                System.out.println(item);
            }
        }

        public static void editItem(Input input, Tracker tracker) {
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

        public static void deleteItem(Input input, Tracker tracker) {
            System.out.println("=== Delete item ====");
            int id = input.askInt("Enter id: ");
            if (tracker.delete(id)) {
                System.out.println("Item delete success");
            } else {
                System.out.println("System error");
            }
        }

        public static void findById(Input input, Tracker tracker) {
            System.out.println("=== Find item by Id ====");
            int id = input.askInt("Enter id: ");
            Item item = tracker.findById(id);
            if (item != null) {
                System.out.println(item);
            } else {
                System.out.println("Заявка с таким id не найдена");
            }
        }

        public static void findByName(Input input, Tracker tracker) {
            System.out.println("=== Find items by name ===");
            String name = input.askStr("Enter name: ");
            Item[] array = tracker.findByName(name);
            if (array.length > 0) {
                for (int i = 0; i < array.length; i++) {
                    System.out.println(array[i]);
                }
            } else {
                System.out.println("Заявки с таким именем не найдены");
            }
        }

        public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }

        private void showMenu(UserAction[] actions) {
            out.println("Menu.");
            for (int index = 0; index < actions.length; index++) {
                out.println(index + ". " + actions[index].name());
            }
        }

        public static void main(String[] args) {
            Output output = new ConsoleOutput();
            Input input = new ValidateInput(output, new ConsoleInput());
            Tracker tracker = new Tracker();
            UserAction[] actions = {
                    new CreateAction(output),
                    new FindAllAction(output),
                    new ReplaceAction(output),
                    new DeleteAction(output),
                    new FindByIdAction(output),
                    new FindByNameAction(output),
                    new ExitAction(output)
            };
            new StartUI(output).init(input, tracker, actions);
        }
    }
