package lambda;

/**
 * @ClassName:   Formula
 * @Description: TODO
 * @author:      jkcho
 * @date:        2018年2月5日下午4:15:13
 */
public interface Formula {
    double calculate(int a);

    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}
