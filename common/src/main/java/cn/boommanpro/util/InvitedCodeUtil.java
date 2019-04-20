package cn.boommanpro.util;

        import java.util.Random;

public class InvitedCodeUtil {

    private static final int MAX_VALUE = 1000000;

    private static final  Random random;
    static {
        random = new Random();
    }

    public static String generator() {
        int randomNum = random.nextInt(MAX_VALUE);
        return String.format("%06d", randomNum);
    }
}
