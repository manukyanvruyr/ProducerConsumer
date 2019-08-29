import java.util.Scanner;

class InputData {
    static int bufferMaxCount;
    static int elementsCount;
    static int producersCount;
    static int consumersCount;

    static void input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("The max count of elements which can be stored in buffer: ");
        bufferMaxCount = scanner.nextInt();

        System.out.print("Elements count to produce: ");
        elementsCount = scanner.nextInt();

        System.out.print("The count of producers: ");
        producersCount = scanner.nextInt();

        System.out.print("The count of consumers: ");
        consumersCount = scanner.nextInt();
    }

}
