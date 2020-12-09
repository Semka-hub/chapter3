import java.awt.*;

public class ThirdPart {

    public static void main(String[] args) {

        /* Написать простое лямба-выражение в переменной myClosure,
        лямба-выражение должно выводить в консоль фразу "I love Java".
        Вызвать это лямба-выражение. Далее написать функцию, которая
        будет запускать заданное лямба-выражение заданное количество
        раз. Объявить функцию так: public void
        repeatTask (int times, Runnable task). Функция должна запускать
        times раз лямба-выражение task . Используйте эту функцию для
        печати «I love Java 10 раз. */
        /* Лямбда-выражение */
        Printable myClosure = () -> System.out.println("I love Java");
        repeatTask(10, myClosure::print);


        /* Задание 2 */
        demonstrateMoving();
    }

    /* Функция для запуска лямбда-выражения task times раз */
    public static void repeatTask(int times, Runnable task) {
        for (int i = 0; i < times; i++) {
            task.run();
        }
    }

    /* Функциональный интерфейс для лятбда-выражения */
    interface Printable {
        void print();
    }

    /* Метод, осуществлящий несколько переходов от первоначальной
     координаты и выводящий координату после каждого перехода. */
    public static void demonstrateMoving() {

        Point location = new Point(0, 0);
        Directions[] directions =
                new Directions[]{Directions.UP, Directions.UP,
                        Directions.LEFT, Directions.DOWN,
                        Directions.LEFT, Directions.DOWN,
                        Directions.DOWN, Directions.RIGHT,
                        Directions.RIGHT, Directions.DOWN, Directions.RIGHT};

        for (Directions dir :
                directions) {
            location = move(location, dir);
            System.out.println("Движение: " + dir +
                    ". Текущая координата (" + location.x + ", " + location.y + ")");
        }
    }

    /* Метод, принимающий координаты и направление поворота */
    public static Point move(Point loc, Directions direction) {
        switch (direction) {
            case UP:
                loc.y++;
                break;
            case DOWN:
                loc.y--;
                break;
            case LEFT:
                loc.x--;
                break;
            case RIGHT:
                loc.x++;
                break;
        }

        return loc;
    }
}

/* Перечисление возможных направлений движения */
enum Directions {
    UP,
    DOWN,
    LEFT,
    RIGHT
}