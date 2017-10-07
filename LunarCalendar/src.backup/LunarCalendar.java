
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 日历数据实体
 * 封装日历绘制时需要的数据
 *
 * @author AigeStudio 2015-03-26
 * @author XhinLiang 2016-02-06
 */
@SuppressWarnings({})
public class LunarCalendar {
    private static final String[] MONTH_NAME = {"�?", "�?", "�?", "�?", "�?", "�?", "�?", "�?", "�?", "�?", "�?", "�?", "�?"};

    private boolean isToday, isWeekend;
    private String solarTerm;
    private Festivals festivals;
    private int year, month, day;
    private Lunar lunar;

    public Lunar getLunar() {
        if (lunar == null)
            lunar = DPCNCalendar.getLunar(year, month, day);
        return lunar;
    }

    LunarCalendar(int year, int month, int day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public static LunarCalendar obtainCalendar(int year, int month, int day) {
        return DPCManager.getInstance().getDPInfo(year, month, day);
    }

    void setFestivals(Festivals festivals) {
        this.festivals = festivals;
    }

    void setIsToday(boolean isToday) {
        this.isToday = isToday;
    }

    void setSolarTerm(String solarTerm) {
        this.solarTerm = solarTerm;
    }

    void setIsWeekend(boolean isWeekend) {
        this.isWeekend = isWeekend;
    }

    public Festivals getFestivals() {
        if (festivals == null) {
            festivals = DPCNCalendar.buildDayFestivals(year, month, day);
        }
        return festivals;
    }

    public String getSolarTerm() {
        return solarTerm;
    }

    public Date getDate() {
        Calendar calendar = new GregorianCalendar(year, month - 1, day);
        return calendar.getTime();
    }

    public long getMillis() {
        return getDate().getTime();
    }

    /**
     * 获取指定年月的日历对象数�?
     *
     * @param year  公历�?
     * @param month 公历�?
     * @return 日历对象数组 该数组长度恒�?6x7 如果某个下标对应无数据则填充为null
     */
    public static LunarCalendar[][] obtainCalendar(int year, int month) {
        return DPCManager.getInstance().obtainDPInfo(year, month);
    }

    /**
     * @return 是否周末
     */
    public boolean isWeekend() {
        return isWeekend;
    }

    /**
     * @return 是否今天
     */
    public boolean isToday() {
        return isToday;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public String getLunarDay() {
        checkLunar();
        char[] c = String.valueOf(lunar.day).toCharArray();
        return TextUtils.lunarNumToStr(c);
    }

    private void checkLunar() {
        if (lunar == null) {
            lunar = getLunar();
        }
    }

    public String getLunarMonth() {
        checkLunar();
        return MONTH_NAME[lunar.month];
    }

    public String getLunarYear() {
        checkLunar();
        return TextUtils.getChineseNumber(lunar.year);
    }

    public String getFullLunarStr() {
        checkLunar();
        return String.format("%s�?%s�?%s", getLunarYear(), getLunarMonth(), getLunarDay());
    }

    public String getSubTitle() {
        if (!festivals.getSet().isEmpty())
            return festivals.getSet().iterator().next();
        if (solarTerm != null)
            return solarTerm;
        return getLunarDay();
    }

    @Override
    public String toString() {
        return "LunarCalendar{" +
                "isToday=" + isToday +
                ", isWeekend=" + isWeekend +
                ", solarTerm='" + solarTerm + '\'' +
                ", festivals=" + festivals +
                ", year=" + year +
                ", month=" + month +
                ", day=" + day +
                '}';
    }
}
