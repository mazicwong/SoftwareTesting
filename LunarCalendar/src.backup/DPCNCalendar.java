
import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * 中国月历
 * Calendar of China
 *
 * @author AigeStudio 2015-06-16
 * @author XhinLiang 2016-02-06
 */
class DPCNCalendar {

    private DPCNCalendar() {
    }

    static final int NOT_A_DAY = -1;

    private static final int[] FIRST_DAY_OF_LUNAR_IN_GREGORIAN = {1897, 0x75aa, 0x156a, 0x1096d, 0x95c, 0x14ae, 0xaa4d, 0x1a4c, 0x1b2a, 0x8d55, 0xad4, 0x135a, 0x495d, 0x95c, 0xd49b, 0x149a, 0x1a4a, 0xbaa5, 0x16a8, 0x1ad4, 0x52da, 0x12b6, 0xe937, 0x92e, 0x1496, 0xb64b, 0xd4a, 0xda8, 0x95b5, 0x56c, 0x12ae, 0x492f, 0x92e, 0xcc96, 0x1a94, 0x1d4a, 0xada9, 0xb5a, 0x56c, 0x726e, 0x125c, 0xf92d, 0x192a, 0x1a94, 0xdb4a, 0x16aa, 0xad4, 0x955b, 0x4ba, 0x125a, 0x592b, 0x152a, 0xf695, 0xd94, 0x16aa, 0xaab5, 0x9b4, 0x14b6, 0x6a57, 0xa56, 0x1152a, 0x1d2a, 0xd54, 0xd5aa, 0x156a, 0x96c, 0x94ae, 0x14ae, 0xa4c, 0x7d26, 0x1b2a, 0xeb55, 0xad4, 0x12da, 0xa95d, 0x95a, 0x149a, 0x9a4d, 0x1a4a, 0x11aa5, 0x16a8, 0x16d4, 0xd2da, 0x12b6, 0x936, 0x9497, 0x1496, 0x1564b, 0xd4a, 0xda8, 0xd5b4, 0x156c, 0x12ae, 0xa92f, 0x92e, 0xc96, 0x6d4a, 0x1d4a, 0x10d65, 0xb58, 0x156c, 0xb26d, 0x125c, 0x192c, 0x9a95, 0x1a94, 0x1b4a, 0x4b55, 0xad4, 0xf55b, 0x4ba, 0x125a, 0xb92b, 0x152a, 0x1694, 0x96aa, 0x15aa, 0x12ab5, 0x974, 0x14b6, 0xca57, 0xa56, 0x1526, 0x8e95, 0xd54, 0x15aa, 0x49b5, 0x96c, 0xd4ae, 0x149c, 0x1a4c, 0xbd26, 0x1aa6, 0xb54, 0x6d6a, 0x12da, 0x1695d, 0x95a, 0x149a, 0xda4b, 0x1a4a, 0x1aa4, 0xbb54, 0x16b4, 0xada, 0x495b, 0x936, 0xf497, 0x1496, 0x154a, 0xb6a5, 0xda4, 0x15b4, 0x6ab6, 0x126e, 0x1092f, 0x92e, 0xc96, 0xcd4a, 0x1d4a, 0xd64, 0x956c, 0x155c, 0x125c, 0x792e, 0x192c, 0xfa95, 0x1a94, 0x1b4a, 0xab55, 0xad4, 0x14da, 0x8a5d, 0xa5a, 0x1152b, 0x152a, 0x1694, 0xd6aa, 0x15aa, 0xab4, 0x94ba, 0x14b6, 0xa56, 0x7527, 0xd26, 0xee53, 0xd54, 0x15aa, 0xa9b5, 0x96c, 0x14ae, 0x8a4e, 0x1a4c, 0x11d26, 0x1aa4, 0x1b54, 0xcd6a, 0xada, 0x95c, 0x949d, 0x149a, 0x1a2a, 0x5b25, 0x1aa4, 0xfb52};
    private static final int[] DAYS_AND_LEAP_MONTH_OF_LUNAR = {1897, 0xed436, 0xed64a, 0xed83f, 0xeda53, 0xedc48, 0xede3d, 0xee050, 0xee244, 0xee439, 0xee64d, 0xee842, 0xeea36, 0xeec4a, 0xeee3e, 0xef052, 0xef246, 0xef43a, 0xef64e, 0xef843, 0xefa37, 0xefc4b, 0xefe41, 0xf0054, 0xf0248, 0xf043c, 0xf0650, 0xf0845, 0xf0a38, 0xf0c4d, 0xf0e42, 0xf1037, 0xf124a, 0xf143e, 0xf1651, 0xf1846, 0xf1a3a, 0xf1c4e, 0xf1e44, 0xf2038, 0xf224b, 0xf243f, 0xf2653, 0xf2848, 0xf2a3b, 0xf2c4f, 0xf2e45, 0xf3039, 0xf324d, 0xf3442, 0xf3636, 0xf384a, 0xf3a3d, 0xf3c51, 0xf3e46, 0xf403b, 0xf424e, 0xf4443, 0xf4638, 0xf484c, 0xf4a3f, 0xf4c52, 0xf4e48, 0xf503c, 0xf524f, 0xf5445, 0xf5639, 0xf584d, 0xf5a42, 0xf5c35, 0xf5e49, 0xf603e, 0xf6251, 0xf6446, 0xf663b, 0xf684f, 0xf6a43, 0xf6c37, 0xf6e4b, 0xf703f, 0xf7252, 0xf7447, 0xf763c, 0xf7850, 0xf7a45, 0xf7c39, 0xf7e4d, 0xf8042, 0xf8254, 0xf8449, 0xf863d, 0xf8851, 0xf8a46, 0xf8c3b, 0xf8e4f, 0xf9044, 0xf9237, 0xf944a, 0xf963f, 0xf9853, 0xf9a47, 0xf9c3c, 0xf9e50, 0xfa045, 0xfa238, 0xfa44c, 0xfa641, 0xfa836, 0xfaa49, 0xfac3d, 0xfae52, 0xfb047, 0xfb23a, 0xfb44e, 0xfb643, 0xfb837, 0xfba4a, 0xfbc3f, 0xfbe53, 0xfc048, 0xfc23c, 0xfc450, 0xfc645, 0xfc839, 0xfca4c, 0xfcc41, 0xfce36, 0xfd04a, 0xfd23d, 0xfd451, 0xfd646, 0xfd83a, 0xfda4d, 0xfdc43, 0xfde37, 0xfe04b, 0xfe23f, 0xfe453, 0xfe648, 0xfe83c, 0xfea4f, 0xfec44, 0xfee38, 0xff04c, 0xff241, 0xff436, 0xff64a, 0xff83e, 0xffa51, 0xffc46, 0xffe3a, 0x10004e, 0x100242, 0x100437, 0x10064b, 0x100841, 0x100a53, 0x100c48, 0x100e3c, 0x10104f, 0x101244, 0x101438, 0x10164c, 0x101842, 0x101a35, 0x101c49, 0x101e3d, 0x102051, 0x102245, 0x10243a, 0x10264e, 0x102843, 0x102a37, 0x102c4b, 0x102e3f, 0x103053, 0x103247, 0x10343b, 0x10364f, 0x103845, 0x103a38, 0x103c4c, 0x103e42, 0x104036, 0x104249, 0x10443d, 0x104651, 0x104846, 0x104a3a, 0x104c4e, 0x104e43, 0x105038, 0x10524a, 0x10543e, 0x105652, 0x105847, 0x105a3b, 0x105c4f, 0x105e45, 0x106039, 0x10624c, 0x106441, 0x106635, 0x106849, 0x106a3d};

    private static final Calendar calendar = Calendar.getInstance();

    private static final String[][] FESTIVAL_GREGORIAN = {
            {"元旦"},
            {"世界湿地�?", "情人�?"},
            {"全国爱�?�日", "青年志愿者服务日", "国际妇女�?", "保护母亲河日", "中国植树�?", "白色情人�?&国际警察�?", "世界消费者权益日", "世界森林�?&世界睡眠�?", "世界水日", "世界气象�?", "世界防治结核病日"},
            {"愚人�?", "清明�?", "世界卫生�?", "世界地球�?", "世界知识产权�?"},
            {"国际劳动�?", "世界哮喘�?", "中国青年�?", "世界红十字日", "国际护士�?", "国际家庭�?", "世界电信�?", "全国学生营养�?", "国际生物多样性日", "国际牛奶�?", "世界无烟�?"},
            {"国际儿童�?", "世界环境�?", "全国爱眼�?", "世界防治荒漠化日", "国际奥林匹克�?", "全国土地�?", "国际禁毒�?"},
            {"中国共产党诞生日&国际建筑�?", "中国抗战纪念�?", "世界人口�?"},
            {"中国解放军建军节", "国际青年�?"},
            {"抗战胜利�?", "国际扫盲�?", "中国教师�?", "中国脑健康日&臭氧层保护日", "全国爱牙�?", "世界停火�?", "世界旅游�?"},
            {"国庆�?&国际老年人日", "世界动物�?", "世界教师�?", "全国高血压日", "世界邮政�?", "世界精神卫生�?", "世界标准�?", "国际盲人�?&世界农村妇女�?", "世界粮食�?", "国际消除贫困�?", "联合国日&世界发展新闻�?", "中国男�?�健康日", "万圣�?"},
            {"中国记�?�节", "消防宣传�?", "世界糖尿病日", "国际大学生节", "消除对妇女暴力日"},
            {"世界爱滋病日", "世界残疾人日", "全国法制宣传�?", "世界足球�?", "圣诞�?"}};

    private static final int[][] FESTIVAL_G_DATE = {
            {1},
            {2, 14},
            {3, 5, 8, 9, 12, 14, 15, 21, 22, 23, 24},
            {1, 5, 7, 22, 26},
            {1, 3, 4, 8, 12, 15, 17, 20, 22, 23, 31},
            {1, 5, 6, 17, 23, 25, 26},
            {1, 7, 11},
            {1, 12},
            {3, 8, 10, 16, 20, 21, 27},
            {1, 4, 5, 8, 9, 10, 14, 15, 16, 17, 24, 29, 31},
            {8, 9, 14, 17, 25},
            {1, 3, 4, 9, 25}};

    //在农历的节日的节点的名字，与下一个二位数组一�?对应
    private static final String[][] FESTIVAL_L = {
            {"春节", "元宵"},
            {},
            {},
            {},
            {"端午"},
            {},
            {"乞巧"},
            {"中秋"},
            {"重阳"},
            {},
            {},
            {"腊八", "扫房"}};

    //在农历的节日的节�?
    private static final int[][] FESTIVAL_LUNAR_DATE = {
            {1, 15},
            {},
            {},
            {},
            {5},
            {},
            {7},
            {15},
            {9},
            {},
            {},
            {8, 24}};

    private static final String[][] SOLAR_TERM = {
            {"小寒", "大寒"},
            {"立春", "雨水"},
            {"惊蛰", "春分"},
            {"清明", "谷雨"},
            {"立夏", "小满"},
            {"芒种", "夏至"},
            {"小暑", "大暑"},
            {"立秋", "处暑"},
            {"白露", "秋分"},
            {"寒露", "霜降"},
            {"立冬", "小雪"},
            {"大雪", "冬至"}
    };

    // 计算二十四节气需要运算量太大，将前面的结果保存起来，加�?�后面的计算
    private static final HashMap<Integer, String[][]> CACHE_SOLAR_TERM = new HashMap<Integer, String[][]>();

    private static final SolarTerm mSolarTerm = new SolarTerm();

    /**
     * 获得农历
     *
     * @param year  公历�?
     * @param month �?
     * @param day   �?
     * @return 农历
     */
    static Lunar getLunar(int year, int month, int day) {
        Gregorian gregorian = new Gregorian(year, month, day);
        return gregorianToLunar(gregorian);
    }

    /**
     * 获取某年某月的节日列�?
     *
     * @param year  �?
     * @param month �?
     * @return 节日Set
     */
    static Festivals[][] buildMonthFestivals(int year, int month) {
        int[][] gregorianMonth = buildMonthGregorian(year, month);
        Gregorian gregorian = new Gregorian(2000, 1, 1);
        Festivals[][] tmp = new Festivals[6][7];
        for (int i = 0; i < tmp.length; i++) {
            for (int j = 0; j < tmp[0].length; j++) {
                if (gregorianMonth[i][j] == NOT_A_DAY)
                    continue;
                tmp[i][j] = new Festivals();
                gregorian.reset(year, month, gregorianMonth[i][j]);
                Lunar lunar = gregorianToLunar(gregorian);
                // 农历节日
                String result = getFestivalLunar(lunar);
                if (!TextUtils.isEmpty(result)) {
                    tmp[i][j].add(result);
                }
                // 公立节日
                result = getFestivalGregorian(gregorian);
                if (!TextUtils.isEmpty(result)) {
                    tmp[i][j].add(result);
                }
                // 二十四节�?
                result = getSolarTerm(year, month, gregorian.day);
                if (!TextUtils.isEmpty(result)) {
                    tmp[i][j].add(result);
                }
            }
        }
        return tmp;
    }

    /**
     * 获取某年某月的节日列�?
     *
     * @param year  �?
     * @param month �?
     * @return 节日Set
     */
    static Festivals buildDayFestivals(int year, int month, int day) {
        Gregorian gregorian = new Gregorian(year, month, day);
        Festivals festivals = new Festivals();
        gregorian.reset(year, month, day);
        Lunar lunar = gregorianToLunar(gregorian);
        // 农历节日
        String result = getFestivalLunar(lunar);
        if (!TextUtils.isEmpty(result)) {
            festivals.add(result);
        }
        // 公立节日
        result = getFestivalGregorian(gregorian);
        if (!TextUtils.isEmpty(result)) {
            festivals.add(result);
        }
        // 二十四节�?
        result = getSolarTerm(year, month, gregorian.day);
        if (!TextUtils.isEmpty(result)) {
            festivals.add(result);
        }
        return festivals;
    }

    /**
     * 获取农历二十四节�?
     *
     * @param year  �?
     * @param month �?
     * @param day   �?
     * @return 节气名字
     */
    static String getSolarTerm(int year, int month, int day) {
        String[][] tmp = CACHE_SOLAR_TERM.get(year);
        if (null == tmp) {
            tmp = mSolarTerm.buildSolarTerm(year);
            CACHE_SOLAR_TERM.put(year, tmp);
        }
        String[] stOfMonth = tmp[month - 1];
        if (Integer.valueOf(stOfMonth[0]) == day) {
            return SOLAR_TERM[month - 1][0];
        }
        if (Integer.valueOf(stOfMonth[1]) == day) {
            return SOLAR_TERM[month - 1][1];
        }
        return null;
    }

    /**
     * 获取农历节日
     *
     * @param lunar 农历
     * @return 节日名称
     */
    private static String getFestivalLunar(Lunar lunar) {
        int[] daysInMonth = FESTIVAL_LUNAR_DATE[lunar.month - 1];
        for (int i = 0; i < daysInMonth.length; i++)
            if (lunar.day == daysInMonth[i])
                return FESTIVAL_L[lunar.month - 1][i];
        return null;
    }

    /**
     * 获取公历节日
     *
     * @param gregorian 公历
     * @return 节日�?
     */
    private static String getFestivalGregorian(Gregorian gregorian) {
        int[] daysInMonth = FESTIVAL_G_DATE[gregorian.month - 1];
        for (int i = 0; i < daysInMonth.length; i++)
            if (gregorian.day == daysInMonth[i])
                return FESTIVAL_GREGORIAN[gregorian.month - 1][i];
        return null;
    }

    /**
     * 将公历转成农�?
     *
     * @param gregorian 公历
     * @return 农历
     */
    private static Lunar gregorianToLunar(Gregorian gregorian) {
        int index = gregorian.year - DAYS_AND_LEAP_MONTH_OF_LUNAR[0];
        int data = (gregorian.year << 9) | (gregorian.month << 5) | (gregorian.day);
        if (DAYS_AND_LEAP_MONTH_OF_LUNAR[index] > data) {
            index--;
        }
        int lunarFirstDayInGregorian = DAYS_AND_LEAP_MONTH_OF_LUNAR[index];
        int y = getBitInt(lunarFirstDayInGregorian, 12, 9);
        int m = getBitInt(lunarFirstDayInGregorian, 4, 5);
        int d = getBitInt(lunarFirstDayInGregorian, 5, 0);

        long offset = gregorianToNum(gregorian.year, gregorian.month, gregorian.day) - gregorianToNum(y, m, d);
        int days = FIRST_DAY_OF_LUNAR_IN_GREGORIAN[index];
        int leap = getBitInt(days, 4, 13);

        int lunarY = index + DAYS_AND_LEAP_MONTH_OF_LUNAR[0];
        int lunarM = 1;
        int lunarD;
        offset += 1;

        for (int i = 0; i < 13; i++) {
            int dm = getBitInt(days, 1, 12 - i) == 1 ? 30 : 29;
            if (offset <= dm)
                break;
            lunarM++;
            offset -= dm;
        }
        lunarD = (int) offset;
        Lunar lunar = new Lunar(lunarY, lunarM, lunarD);
        lunar.isLeap = false;
        if (leap != 0 && lunarM > leap) {
            lunar.month = lunarM - 1;
            if (lunarM == leap + 1) {
                lunar.isLeap = true;
            }
        }
        return lunar;
    }


    /**
     * 判断某年是否为闰�?
     *
     * @param year ...
     * @return true表示闰年
     */
    private static boolean isLeapYear(int year) {
        return ((year % 4 == 0) && (year % 100 != 0)) || (year % 400 == 0);
    }

    /**
     * 判断给定日期是否为今�?
     *
     * @param day 某天
     * @return ...
     */
    static boolean isToday(LunarCalendar day) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        //January = 0
        //noinspection MagicConstant
        c1.set(day.getYear(), day.getMonth() - 1, day.getDay());
        return (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) &&
                (c1.get(Calendar.MONTH) == (c2.get(Calendar.MONTH))) &&
                (c1.get(Calendar.DAY_OF_MONTH) == c2.get(Calendar.DAY_OF_MONTH));
    }

    /**
     * 生成某年某月的公历天数数�?
     * 数组�?6x7的二维数组因为一个月的周数永远不会超过六�?
     * 天数填充对应相应的二维数组下�?
     * 如果某个数组下标中没有对应天数那么则填充�?个空字符�?
     *
     * @param year  某年
     * @param month 某月
     * @return 某年某月的公历天数数�?
     */
    static int[][] buildMonthGregorian(int year, int month) {
        calendar.clear();
        int[][] tmp = new int[6][7];
        //Calender.January = 0
        //noinspection MagicConstant
        calendar.set(year, month - 1, 1);
        int daysInMonth = getDaysInMonth(year, month);
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - Calendar.SUNDAY;
        int day = 1;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < Calendar.DAY_OF_WEEK; j++) {
                tmp[i][j] = NOT_A_DAY;
                if (i == 0 && j >= dayOfWeek) {
                    tmp[i][j] = day;
                    day++;
                    continue;
                }
                if (i > 0 && day <= daysInMonth) {
                    tmp[i][j] = day;
                    day++;
                }
            }
        }
        return tmp;
    }

    /**
     * 返回某年某月的天�?
     *
     * @param year  �?
     * @param month �?
     * @return 天数
     */
    private static int getDaysInMonth(int year, int month) {
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        }
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            }
            return 28;
        }
        // 其他全是大月
        return 31;
    }

    /**
     * 生成公历某年某月的周末日期集�?
     *
     * @param year  某年
     * @param month 某月
     * @return 某年某月的周末日期集�?
     */
    static Set<Integer> buildMonthWeekend(int year, int month) {
        Set<Integer> set = new HashSet<Integer>();
        calendar.clear();
        //noinspection MagicConstant
        calendar.set(year, month - 1, 1);
        do {
            int day = calendar.get(Calendar.DAY_OF_WEEK);
            if (day == Calendar.SATURDAY || day == Calendar.SUNDAY) {
                set.add(calendar.get(Calendar.DAY_OF_MONTH));
            }
            calendar.add(Calendar.DAY_OF_YEAR, 1);
        } while (calendar.get(Calendar.MONTH) == month - 1);
        return set;
    }

    /**
     * 将公立日期转成long格式的时间戳
     *
     * @param year  �?
     * @param month �?
     * @param day   �?
     * @return 时间
     */
    private static long gregorianToNum(int year, int month, int day) {
        month = (month + 9) % 12;
        year = year - month / 10;
        return 365 * year + year / 4 - year / 100 + year / 400 + (month * 306 + 5) / 10 + (day - 1);
    }

    /**
     * 将原来的二进制数截取�?部分之后，向�?低位位移
     *
     * @param data   原来的二进制�?
     * @param length 要截取的二进制数长度
     * @param shift  要截取的二进制数从低位向高位的偏移量
     * @return 截取到的二进制数
     */
    private static int getBitInt(int data, int length, int shift) {
        return (data & (((1 << length) - 1) << shift)) >> shift;
    }

}
