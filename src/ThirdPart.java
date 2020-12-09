import java.awt.*;

public class ThirdPart {

    public static void main(String[] args) {

        /* Лямбда-выражение */
        Printable myClosure = () -> System.out.println("I love Java");

        /* Создаём фигуры для 3-ого задания */
        Rectangle rectangle = new Rectangle(3, 7);
        Square square = new Square(5);
        Circle circle = new Circle(10);

        /* Задание 1 */
        repeatTask(10, myClosure::print);

        /* Задание 2 */
        demonstrateMoving();

        /* Задание 3 */
        System.out.println("Периметр прямоугольника: " + rectangle.perimeter() + ". " +
                "Площадь прямоугольника: " + rectangle.area() + ".");

        System.out.println("Периметр квадрата: " + square.perimeter() + ". " +
                "Площадь квадрата: " + square.area() + ".");

        System.out.println("Периметр круга: " + circle.perimeter() + ". " +
                "Площадь круга: " + circle.area() + ".");
    }

    /* Функция для запуска лямбда-выражения task times раз */
    public static void repeatTask(int times, Runnable task) {
        for (int i = 0; i < times; i++) {
            task.run();
        }
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

/* Функциональный интерфейс для лятбда-выражения */
interface Printable {
    void print();
}

/* Перечисление возможных направлений движения */
enum Directions {
    UP,
    DOWN,
    LEFT,
    RIGHT
}

/* Интерфейс для вывода площади и периметра фигуры */
interface Shape {
    double perimeter();

    double area();
}

/* Класс прямоугольника */
class Rectangle implements Shape {

    private double width;
    private double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public double area() {
        return width * height;
    }
}

/* Класс квадарата */
class Square implements Shape {

    private double height;

    Square(double height) {
        this.height = height;
    }

    @Override
    public double perimeter() {
        return 4 * height;
    }

    @Override
    public double area() {
        return Math.pow(height, 2);
    }
}

/* Класс круга */
class Circle implements Shape {

    private double diameter;

    Circle(double diameter) {
        this.diameter = diameter;
    }

    @Override
    public double perimeter() {
        return diameter * Math.PI;
    }

    @Override
    public double area() {
        return 0.25 * Math.pow(diameter, 2) * Math.PI;
    }
}