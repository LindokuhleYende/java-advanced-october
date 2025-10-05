package Tutorials;

public class Tut1 {
    public void log(int[] numbers){
        System.out.println(numbers[0]);
    }
    public static void main(String[] args){
        Tut1 tutorial1 = new Tut1();
        tutorial1.log(new int[]{1,2,3,4,5,6,7,8,9,10});

        int num[] = {1,2,3};
        System.out.println(num[0]);
    }
}
