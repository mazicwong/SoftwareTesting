
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * æ¥æç®¡çå?
 * The manager of date picker.
 *
 * @author AigeStudio 2015-06-12
 * @author XhinLiang 2016-02-06
 */
class DPCManager {
    private static final Map<Integer, Map<Integer, LunarCalendar[][]>> DATE_CACHE = new WeakHashMap<Integer, Map<Integer, LunarCalendar[][]>>();

    private static DPCManager sManager;


    /**
     * è·åæåç®¡çå?
     * Get DPCNCalendar manager
     *
     * @return æåç®¡çå?
     */
    static DPCManager getInstance() {
        if (null == sManager) {
            sManager = new DPCManager();
        }
        return sManager;
    }

    /**
     * è·åæå®å¹´æçæ¥åå¯¹è±¡æ°ç»?
     *
     * @param year  å¬åå¹?
     * @param month å¬åæ?
     * @return æ¥åå¯¹è±¡æ°ç» è¯¥æ°ç»é¿åº¦æä¸?6x7 å¦ææä¸ªä¸æ å¯¹åºæ æ°æ®åå¡«åä¸ºnull
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
                // å¦æè¿å¤©ä¸å­å?
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
