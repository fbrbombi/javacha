package utils;

/**
 * This class generates random data for each field
 */
public class Generator {

    public static String randomName() {
        return Random.generateRandomString(4);
    }

    public static int randomAge() {
        return ((int) (Math.random() * 80) + 10);
    }

    public static int randomCC() {
        return ((int) (Math.random() * 1000000) + 1000000);
    }

    public static String randomMail() {
        return null;
    }

    public static long randomPhone() {
        return ((long) (Math.random() * 1000000) + 1000000);
    }

    public static int randomIssue() {
        return ((int) (Math.random() * 3) + 1);
    }
    public static String randomComment(){
        return null;

    }

}
