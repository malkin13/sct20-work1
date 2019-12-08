package lesson07;


public class Threads implements Runnable {

    Task01 lession07task01 = new Task01();

    @Override
    public void run() {


        Long factorial = calculateFactorial(5);
        System.out.println("factorial - "+factorial);
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("---- start -----");

        Long factorial = calculateFactorial(15);
        System.out.println(factorial);

        CustomThreadPool customThreadPool = new CustomThreadPool(2);

        for (int i = 1; i <= 5; i++)
        {
            Task task = new Task("Task " + i);
            System.out.println("Created : " + task.getName());

            customThreadPool.execute(task);
        }

        System.out.println("---- end -----");
    }

    public static Long calculateFactorial(int n){
        Long result = 1L;
        for (int i = 1; i <=n; i ++){
            result = result*i;
        }
        return result;
    }
}
