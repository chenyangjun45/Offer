package com.cyj.tmp3;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.cyj.java_primary.DateGenerate;

public class DateUtils {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/**
	* 获取时间 小时:分;秒 HH:mm:ss
	*
	* @return
	*/
	public static String getTimeShort() {
		SimpleDateFormat formatter = new SimpleDateFormat("HH:mm");
	    Date currentTime = new Date();
	    String dateString = formatter.format(currentTime);
	    return dateString;
	}
	/**
	* 判断是否为整点，输入为字符串"HH:mm"
	*
	* @return
	*/
	public static boolean ifOnTheHour(String time) {
		String times[] = time.split(":");
		if(times[1].equals("00")){
			return true;
		}
		else{
			return false;
		}
	}
	/**
	* 计算时间差，输入为字符串time1="HH:mm",time2="HH:mm"
	*
	* @return
	*/
	public static boolean ifTimeOneIsSmall(String time1,String time2) {
		String times1[] = time1.split(":");
		String times2[] = time2.split(":");
		int t1 = Integer.valueOf(times1[0]);
		int t2 = Integer.valueOf(times2[0]);
		if(t1>=t2){
			return false;
		}
		return true;

	}
	/**
	* 将长时间格式时间转换为字符串 yyyy-MM-dd HH:mm
	*
	* @return
	*/
	public static String dateToStrLong(Date dateDate) {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    String dateString = formatter.format(dateDate);
	    return dateString;
	}
	/**
	* 将长时间格式时间转换为字符串 yyyy-MM-dd
	*
	* @return
	*/
	public static String dateToStrDay(Date dateDate) {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	    String dateString = formatter.format(dateDate);
	    return dateString;
	}
	/**
	* 将长时间格式时间转换为字符串 只返回小时HH
	*
	* @return
	*/
	public static String dateToStrHour(Date dateDate) {
	    SimpleDateFormat formatter = new SimpleDateFormat("HH");
	    String dateString = formatter.format(dateDate);
	    return dateString;
	}
	/**
	* 将长时间格式字符串转换为时间 yyyy-MM-dd HH:mm
	*
	* @return
	*/
	public static Date strToDateLong(String strDate) {
	    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	    ParsePosition pos = new ParsePosition(0);
	    Date strtodate = formatter.parse(strDate, pos);
	    return strtodate;
	}
	/**
	* 根据一个日期，返回是星期几的字符串
	*
	* @return
	*/
	public static int getWeek(Date date) {
	  // 再转换为时间
	    Calendar c = Calendar.getInstance();
	    c.setTime(date);
	     int week=c.get(Calendar.DAY_OF_WEEK);
	    // week中存的就是星期几了，其范围 1~7
	    // 1=星期日 7=星期六，其他类推
	    //
	    //return new SimpleDateFormat("EEEE").format(c.getTime());
	     return week;
	}
}
