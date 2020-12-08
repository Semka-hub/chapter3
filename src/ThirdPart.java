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

}


