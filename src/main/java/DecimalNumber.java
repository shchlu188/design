import java.util.Scanner;
import static java.lang.System.*;
/**
 * @author scl
 * @Date 2020/6/29
 * @Description 判断一个数字是否为十进制的数字
 */
public class DecimalNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true){
            out.println("请输入数字：");
            String str = scanner.nextLine();
            if (" ".equals(str)||str.contains(" ")){
                out.println("不能含有空格");
                continue;
            }
            boolean bool = isNumber(str);
            if (bool){
                out.println(str+" is number");
            }else {
                out.println(str+ " is not number");
            }


        }

    }


    public static boolean isNumber(String str) {
        char[] chars = str.toCharArray();
        // 记录特殊字符的数量
        int count = 0;
        // 排除e+重复的标志位，默认为false，表示从未出现e+
        boolean flag = false;
        // 判断长度为1的情况
        if (chars.length == 1) {
            return chars[0] >= '0' && chars[0] <= '9';

        } else if (chars.length == 2) {
            return (chars[0] > '0' && chars[0] <= '9') && (chars[1] >= '0' && chars[1] <= '9');
        }
        // 判断第一位为数字且不为0
        if (chars[0] == '-' || (chars[0] > '0' && chars[0] <= '9')) {
            for (int i = 1; i < chars.length; i++) {
                // 字符串中不属于十进制的字符进行判断
                if (!((chars[i] >= '0' && chars[i] <= '9') || chars[i] == '+' || chars[i] == '-' || chars[i] == '.' || chars[i] == 'E' || chars[i] == 'e')) {
                    return false;
                }

                if (count > 1) {
                    // 判断e+是否存在
                    if (flag){
                        return false;
                    }
                    // 对科学计数法的判断是否符合
                    if ((chars[i - 1] == 'E' || chars[i - 1] == 'e') && chars[i] == '+') {
                        // 对+后面必须为1-9之间的数进行判断和E前面的字符必须是数字
                        if (i-2>0&& chars[i - 2] >= '1' && chars[i - 2] <= '9'&&i + 1 < chars.length && chars[i + 1] >= '1' && chars[i + 1] <= '9') {
                            // 满足就将减去两个字符串
                            count -= 2;
                            // 将flag置为true,表示已经存在e+
                            flag = true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
                if (chars[i] == '+' || chars[i] == '-' || chars[i] == '.' || chars[i] == 'E' || chars[i] == 'e') {
                    count++;
                }
            }
            return true;
        } else {
            return false;
        }
    }

}
