package ru.job4j.collection;

import java.util.Objects;

public class Order {
    private String number;
    private String name;

    public Order(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    @Override
    public String toString() {
        return "number='" + "Order{" + number + '\'' + ", name='" + name + '\'' + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o != null && getClass() == o.getClass()) {
            Order order = (Order) o;
            return Objects.equals(number, order.number)
                    && Objects.equals(name, order.name);
        } else {
            return false;
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name);
    }
}