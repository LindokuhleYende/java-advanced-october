package Chap13.exercise;

public class TestExceptions {
    public static void main(String[] args) {
        String test = "yes";
        try {
            System.out.println("Start try");
            doRisky(test);
            System.out.println("End try");

        } catch (ScaryException e) {
            System.out.println("Scary Exception");
        } finally {
            System.out.println("Finally");
        }
        System.out.println("Done");
    }
    static void doRisky(String test) throws ScaryException {
        System.out.println("Start Risky");
        if ("yes".equals(test)) {
            throw new ScaryException();
        }
        System.out.println("End Risky");
    }
}

class ScaryException extends Exception {}
