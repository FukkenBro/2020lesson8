import java.util.Random;

public class task1 {
    //    1) Число Фибоначи
//    написать метод который возвращает N-ное число фибоначи, по правилу:
//    F(0) = 0, F(1) = 1
//    F(N) = F(N - 1) + F(N - 2)
    private static final Random RANDOM = new Random();
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            int n = RANDOM.nextInt(20);
            System.out.print("N = "+n);
            System.out.println(" fibonacci number is "+fibonacci(n));
        }
    }

    public static int fibonacci(int number) {
        if (number==0){
            return 0;
        }
        if (number == 1 || number == 2) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }
}
