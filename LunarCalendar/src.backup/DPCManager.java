
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * 日期管理�?
 * The manager of date picker.
 *
 * @author AigeStudio 2015-06-12
 * @author XhinLiang 2016-02-06
 */
class DPCManager {
    private static final Map<Integer, Map<Integer, LunarCalendar[][]>> DATE_CACHE = new WeakHashMap<Integer, Map<Integer, LunarCalendar[][]>>();

    private static DPCManager sManager;


    /**
     * 获取月历管理�?
     * Get DPCNCalendar manager
     *
     * @return 月历管理�?
     */
    static DPCManager getInstance() {
        if (null == sManager) {
            sManager = new DPCManager();
        }
        return sManager;
    }

    /**
     * 获取指定年月的日历对象数�?
     *
     * @param year  公历�?
     * @param month 公历�?
     * @return 日历对象数组 该数组长度恒�?6x7 如果某个下标对应无数据则填充为null
     */
    LunarCalendar[][] obtainDPInfo(int year, int month) {
        Map<Integer, LunarCalendar[][]> dataOfYear = DATE_CACHE.get(year);
        if (null != dataOfYear && dataOfYear.size() != 0) {
            LunarCalendar[][] dataOfMonth = dataOfYear.get(month);
            if (dataOfMonth != null) {
                return dataOfMonth;
            }
            dataOfMonth = buildDPInfo(year, month);
            dataOfYear.put(month, dataOfMonth);
            return dataOfMonth;
        }
        if (null == dataOfYear) {
            dataOfYear = new HashMap<Integer, LunarCalendar[][]>();
        }
        LunarCalendar[][] dataOfMonth = buildDPInfo(year, month);
        dataOfYear.put(month, dataOfMonth);
        DATE_CACHE.put(year, dataOfYear);
        return dataOfMonth;
    }

    private LunarCalendar[][] buildDPInfo(int year, int month) {
        LunarCalendar[][] info = new LunarCalendar[6][7];
        int[][] monthGregorian = DPCNCalendar.buildMonthGregorian(year, month);
        Festivals[][] strF = DPCNCalendar.buildMonthFestivals(year, month);
        Set<Integer> weekends = DPCNCalendar.buildMonthWeekend(year, month);

        for (int i = 0; i < info.length; i++) {
            for (int j = 0; j < info[i].length; j++) {
                // 如果这天不存�?
                if (monthGregorian[i][j] == DPCNCalendar.NOT_A_DAY) {
                    continue;
                }
                LunarCalendar tmp = new LunarCalendar(year, month, monthGregorian[i][j]);
                String strG = tmp.getDay() + "";
                tmp.setFestivals(strF[i][j]);
                tmp.setIsToday(DPCNCalendar.isToday(tmp));
                if (weekends.contains(tmp.getDay())) {
                    tmp.setIsWeekend(true);
                }
                if (!TextUtils.isEmpty(strG)) {
                    tmp.setSolarTerm(DPCNCalendar.getSolarTerm(year, month, tmp.getDay()));
                }
                info[i][j] = tmp;
            }
        }
        return info;
    }

    LunarCalendar getDPInfo(int year, int month, int day) {
        LunarCalendar[][] monthInfo = obtainDPInfo(year, month);
        for (LunarCalendar[] items : monthInfo) {
            for (LunarCalendar item : items) {
                if (item != null && item.getDay() == day)
                    return item;
            }
        }
        throw new RuntimeException("This day is NOT FOUND!");
    }
}
