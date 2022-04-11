import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间与日期转换
 */
public class DataFormat {

    public static String transferToDate(long curTime) {
        //将毫秒级long值转换成日期格式
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(curTime);
    }

    public static long transferToTime(String dataStr) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = dateFormat.parse(dataStr);
            return date.getTime();
        } catch (ParseException e) {
            return 0L;
        }
    }

    public static void main(String[] args) {
        long curTime = System.currentTimeMillis();
        System.out.println(transferToDate(1649250763460L));
    }
}
