
/**
 * Created by io.xhinliang on 16-1-30.
 *
 * @author XhinLiang 2016-02-06
 */
public class TextUtils {

    private TextUtils() {}

    private static final String[] LUNAR_HEADER = {"�?", "�?", "�?", "�?", "�?", "�?", "�?", "�?"};
    private static final String[] NUMBER_CAPITAL = {"�?", "�?", "�?", "�?", "�?", "�?", "�?", "�?", "�?", "�?", "�?"};

    public static boolean isEmpty(String string) {
        return string == null || string.length() == 0;
    }

    /**
     * 从数字转换成中文大写
     *
     * @param number 原数�?
     * @return 中文大写
     */
    public static String getChineseNumber(int number) {
        StringBuilder builder = new StringBuilder();
        int bit = getBit(number);
        int temp = (int) Math.pow(10, bit - 1);
        for (int i = 0; i < bit; ++i) {
            int num = number / temp;
            builder.append(NUMBER_CAPITAL[num]);
            number %= temp;
            temp /= 10;
        }
        return builder.toString();
    }

    /**
     * 获取十进制的位数
     *
     * @param number �?
     * @return 位数
     */
    private static int getBit(int number) {
        int temp = 10;
        int bit = 1;
        while (number / temp != 0) {
            temp *= 10;
            ++bit;
        }
        return bit;
    }

    /**
     * �?维数组转换为二维数组
     *
     * @param src    原一维数�?
     * @param column 要转换成的二维数组的子数组的长度
     * @return 二维数组
     */
    static String[][] arraysConvert(String[] src, int column) {
        int row = src.length / column;
        String[][] tmp = new String[row][src.length / row];
        for (int i = 0; i < row; i++) {
            tmp[i] = new String[column];
            System.arraycopy(src, i * column, tmp[i], 0, column);
        }
        return tmp;
    }

    public static String lunarNumToStr(char[] c) {
        String result = "";
        if (c.length == 1) {
            for (int i = 1; i < 10; i++) {
                if (c[0] == String.valueOf(i).charAt(0)) {
                    result = LUNAR_HEADER[0] + NUMBER_CAPITAL[i];
                }
            }
        } else {
            if (c[0] == '1') {
                if (c[1] == '0') {
                    result = LUNAR_HEADER[0] + LUNAR_HEADER[1];
                } else {
                    for (int i = 1; i < 10; i++) {
                        if (c[1] == String.valueOf(i).charAt(0)) {
                            result = LUNAR_HEADER[1] + NUMBER_CAPITAL[i];
                        }
                    }
                }
            } else if (c[0] == '2') {
                if (c[1] == '0') {
                    result = LUNAR_HEADER[2] + LUNAR_HEADER[1];
                } else {
                    for (int i = 1; i < 10; i++) {
                        if (c[1] == String.valueOf(i).charAt(0)) {
                            result = LUNAR_HEADER[2] + NUMBER_CAPITAL[i];
                        }
                    }
                }
            } else {
                if (c[1] == '0') {
                    result = LUNAR_HEADER[3] + LUNAR_HEADER[1];
                } else {
                    for (int i = 1; i < 10; i++) {
                        if (c[1] == String.valueOf(i).charAt(0)) {
                            result = LUNAR_HEADER[3] + NUMBER_CAPITAL[i];
                        }
                    }
                }
            }
        }
        return result;
    }
}
