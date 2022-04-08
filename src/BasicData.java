import java.math.BigDecimal;
import java.math.BigInteger;

public class BasicData {

    public static void basicDataTransfer() {
        // int -> float精度损失
        // 分析可以参考：https://blog.csdn.net/a3192048/article/details/106662693
        float b = 123456789;
        // 123456789 -> 111010110111100110100010101, float尾数位数为23，无法完全表示
        // 最小不能被精确表示的整数是：16777217
        System.out.println(b);  // 1.23456792E8
        System.out.println(123456788 + 1.f);  // 类型转换为了float

        // 数据类型之间转换：int -> float, long -> double均会产生精度损失
    }

    public static void operator() {
        int x = 1;
        x += 3.5; // 等价于：(int) (x + 3,5)
        // x = x + 3.5 会报错
    }

    public static void main(String[] args) {
//        basicDataTransfer();
    }
}