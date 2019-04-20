package cn.boommanpro;

/**
 * @author BoomManPro
 *
 * from https://github.com/junit-team/junit4/wiki/Getting-started
 */
public class Calculator {
    public int evaluate(String expression) {
        int sum = 0;
        for (String summand: expression.split("\\+")) {
            sum += Integer.valueOf(summand);
        }
        return sum;
    }
}
