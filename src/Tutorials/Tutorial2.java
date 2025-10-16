package Tutorials;

public class Tutorial2 {

    public static void main(String[] args) {
        int i = 2;
        int j = 0;
        int[] nums = new int[5];
        String str =  null;

        try{
            j = 10 / i;


            System.out.println("j = " + j);
            System.out.println(str.length());
            System.out.println("BYE");

            System.out.println(nums[0]);
            System.out.println(nums[6]);
            System.out.println("BYE");

        } catch (ArithmeticException e){
            System.out.println("You cannot divide by zero");
        }
        catch (ArrayIndexOutOfBoundsException e){
            System.out.println("You cannot access an array element that does not exist");
        }
        catch (Exception e){
            System.out.println("Something went wrong "+ e);
        }
    }
}
