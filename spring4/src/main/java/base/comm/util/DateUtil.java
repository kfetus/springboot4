package base.comm.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
/**
 * 일자 관련 유틸 클래스
 * 
 * @author ojh
 *
 */
public class DateUtil {

	/**
	 * 오늘 일자 
	 * @return ex:20191231
	 */
	public static String getToday() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		Calendar calendar = Calendar.getInstance(Locale.KOREA); 
		return sdf.format(calendar.getTime());
	}
}
