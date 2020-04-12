package example;

/**
 * @Author: Xuan Jing
 * @Date: 2020/4/11 7:07 PM
 */
public class IncComputable implements Computable<Integer, Integer> {
    @Override
    public Integer compute(Integer o) {
        return o++;
    }
}
