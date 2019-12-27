package com.wwmust.manage.system.common.utils;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 日期操作公共类
 * 
 * @author suo.yanming 2014-12-04
 * 
 */
public class DateUtil {

	public static String defaultSimpleFormater = "yyyy-MM-dd";
	public static String secSimpleFormat = "yyyy-MM-dd hh:mm:ss";
	public static String allDayFormat = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 时间戳:yyyyMMddHHmmss
	 * 
	 * @return
	 */
	public static String getTimestampFull() {
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
		Date date = new Date();
		return format.format(date);

	}

	/**
	 * 默认简单日期字符串
	 * 
	 * @return
	 */
	public static String getDefaultSimpleFormater() {
		return defaultSimpleFormater;
	}
	/**
	 * 格式化时间和日期
	 * @param stringdDate
	 * @return
	 * @throws ParseException
	 */
	public static Date getSimpleFormate(String stringdDate) throws ParseException{
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		 Date date = format1.parse(stringdDate);
		return date; 
	}
	public static Date getdefaulSimpleFormate(String stringdDate) throws ParseException{
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); 
		 Date date = format1.parse(stringdDate);
		return date; 
	}
	public static Date getSimpleFormateAll(String stringdDate) throws ParseException{
		SimpleDateFormat format1 = new SimpleDateFormat(secSimpleFormat); 
		 Date date = format1.parse(stringdDate);
		return date; 
	}
	
	
	public static String getSimpleFormate(Date stringdDate) throws ParseException{
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd HH:mm"); 
		 String format = format1.format(stringdDate);
		return format; 
	}
	
	public static String getdefaulSimpleFormate(Date stringdDate) throws ParseException{
		SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd"); 
		 String format = format1.format(stringdDate);
		return format; 
	}

	/**
	 * 设置默认简单日期格式字符串
	 * 
	 * @param defaultFormatString
	 */
	public static void setDefaultSimpleFormater(String defaultFormatString) {
		DateUtil.defaultSimpleFormater = defaultFormatString;
	}

	/**
	 * 格式化日期
	 * @param date
	 * @param formatString
	 * @return
	 */
	public static String format(Date date, String formatString) {
		SimpleDateFormat df = new SimpleDateFormat(formatString);
		return df.format(date);
	}

	/**
	 * 格式化日期(使用默认格式)
	 * 
	 * @param date
	 * @return
	 */
	public static String format(Date date) {
		return format(date, defaultSimpleFormater);
	}
	
	/**
	 * 格式化日期(包含时分秒)
	 */
	public static String secFormat(Date date) {
		return format(date, secSimpleFormat);
	}

	/**
	 * 计算两个日期之间相差的天数（date2-date1）
	 * @param date1
	 * @param date2
	 * @return
	 * @author caizhu.rao
	 */
	public static int calDaysBetweenTwo(Date date1, Date date2){
		Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);
        
        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2) {
        	//同一年
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++) {
                if(i%4==0 && i%100!=0 || i%400==0) {
                	//闰年
                    timeDistance += 366;
                } else {
                	//不是闰年
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2-day1) ;
        } else {
        	//不同年
            System.out.println("判断day2 - day1 : " + (day2-day1));
            return day2-day1;
        }
	}
	
	/**
	 * 转换成日期
	 * 
	 * @param dateString
	 * @param formatString
	 * @return
	 */
	public static Date parse(String dateString, String formatString) {
		SimpleDateFormat df = new SimpleDateFormat(formatString);
		try {
			return df.parse(dateString);
		} catch (ParseException e) {
			return null;
		}
	}

	/**
	 * 转换成日期(使用默认格式)
	 * 
	 * @param dateString
	 * @return
	 */
	public static Date parse(String dateString) {
		return parse(dateString, defaultSimpleFormater);
	}

	/**
	 * 昨天
	 * 
	 * @return
	 */
	public static Date yesterday() {
		return addDay(-1);
	}

	/**
	 * 明天
	 * 
	 * @return
	 */
	public static Date tomorrow() {
		return addDay(1);
	}

	/**
	 * 现在
	 * 
	 * @return
	 */
	public static Date now() {
		return new Date(System.currentTimeMillis());
	}

	/**
	 * 按日加
	 * 
	 * @param value
	 * @return
	 */
	public static Date addDay(int value) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.DAY_OF_YEAR, value);
		return now.getTime();
	}

	/**
	 * 按日加,指定日期
	 * 
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addDay(Date date, int value) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.DAY_OF_YEAR, value);
		return now.getTime();
	}

	/**
	 * 按月加
	 * 
	 * @param value
	 * @return
	 */
	public static Date addMonth(int value) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MONTH, value);
		return now.getTime();
	}

	/**
	 * 按月加,指定日期
	 * 
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addMonth(Date date, int value) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MONTH, value);
		return now.getTime();
	}

	/**
	 * 按年加
	 * 
	 * @param value
	 * @return
	 */
	public static Date addYear(int value) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.YEAR, value);
		return now.getTime();
	}

	/**
	 * 按年加,指定日期
	 * 
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addYear(Date date, int value) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.YEAR, value);
		return now.getTime();
	}

	/**
	 * 按小时加
	 * 
	 * @param value
	 * @return
	 */
	public static Date addHour(int value) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.HOUR_OF_DAY, value);
		return now.getTime();
	}

	/**
	 * 按小时加,指定日期
	 * 
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addHour(Date date, int value) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.HOUR_OF_DAY, value);
		return now.getTime();
	}

	/**
	 * 按分钟加
	 * 
	 * @param value
	 * @return
	 */
	public static Date addMinute(int value) {
		Calendar now = Calendar.getInstance();
		now.add(Calendar.MINUTE, value);
		return now.getTime();
	}

	/**
	 * 按分钟加,指定日期
	 * 
	 * @param date
	 * @param value
	 * @return
	 */
	public static Date addMinute(Date date, int value) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MINUTE, value);
		return now.getTime();
	}

	/**
	 * 年份
	 * 
	 * @return
	 */
	public static int year() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.YEAR);
	}

	/**
	 * 月份
	 * 
	 * @return
	 */
	public static int month() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.MONTH);
	}
    /**
     * 根据指定时间查询月份
     * @return
     */
	public static int getMonthByDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.MONTH);
	}
	/**
	 * 日(号)
	 * 
	 * @return
	 */
	public static int day() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.DAY_OF_MONTH);
	}
	public static int getDayByDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_MONTH);
	}

	/**
	 * 小时(点)
	 * 
	 * @return
	 */
	public static int hour() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.HOUR);
	}

	/**
	 * 分钟
	 * 
	 * @return
	 */
	public static int minute() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.MINUTE);
	}

	/**
	 * 秒
	 * 
	 * @return
	 */
	public static int second() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.SECOND);
	}

	/**
	 * 星期几(礼拜几)
	 * 
	 * @return
	 */
	public static int weekday() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 根据日期取得星期几 (文字)
	 * 
	 * @param date
	 * @return
	 */
	public static String getWeekStr(Date date) {
		String[] weeks = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (week_index < 0) {
			week_index = 0;
		}
		return weeks[week_index];
	}

	/**
	 * 根据日期取得星期几 (值)
	 * 
	 * @param date
	 * @return
	 */
	public static int getWeekValue(Date date) {

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int week_index = cal.get(Calendar.DAY_OF_WEEK) - 1;
		if (week_index < 0) {
			week_index = 0;
		}
		return week_index;
	}

	// 取得日期是某年的第几周
	public static int getWeekOfYear(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setFirstDayOfWeek(Calendar.MONDAY);
		cal.setTime(date);
		int week_of_year = cal.get(Calendar.WEEK_OF_YEAR);
		return week_of_year;
	}

	/**
	 * 是上午吗?
	 * 
	 * @return
	 */
	public static boolean isAm() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.AM_PM) == 0;
	}

	/**
	 * 是下午吗?
	 * 
	 * @return
	 */
	public static boolean isPm() {
		Calendar now = Calendar.getInstance();
		return now.get(Calendar.AM_PM) == 1;
	}
	/**
	 * 判断白天还是黑夜： 0：白天，1：黑夜  ；白天黑夜的分界线为早晚6点
	 * @param date
	 * @return
	 */
	public static int isDayOrNight(String date){
//		Date date_hour = parse(date,"HH:mm");
//		Date am_six = parse("2014-12-05 06:00","HH:mm");
//		Date pm_six = parse("2014-12-05 18:00","HH:mm");
		Date date_hour = parse(date,"yy-MM-dd HH:mm");
		Date am_six = parse(DateUtil.format(date_hour)+" 06:00","yy-MM-dd HH:mm");
		Date pm_six = parse(DateUtil.format(date_hour)+" 18:00","yy-MM-dd HH:mm");
		//白天
		if(compareDate(date_hour, am_six)>=0&&compareDate(date_hour, pm_six)<=0){
			return 0;
		}else {
			//黑夜
			return 1;
		}
		 
	}
	/**
	 * 获取本周几（1-7）的日期
	 * <p>星期日-星期六：1-7</p>
	 * @param dayOfWeek
	 * @return
	 */
	public static Date getDateOfWeekDay(int dayOfWeek){
		Calendar cal = Calendar.getInstance();
		cal.set(Calendar.DAY_OF_WEEK, dayOfWeek);
		return cal.getTime();
	}
	
	/**
	 * 获取当前时间本月第几天的
	 * @param dayOfMonth
	 * @return
	 */
	public static Date getDateOfMonthDay(int dayOfMonth){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
		return calendar.getTime();
	}
	
	/**
	 * 获取指定时间所在本月的第几天 的日期
	 * @param assignDate
	 * @param days
	 * @return
	 */
	public static Date getDateByAssignDateAndDays(Date assignDate,int days){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(assignDate);
		calendar.set(Calendar.DAY_OF_MONTH, days);
		return calendar.getTime();
	}
	 /** 
     *  
     * 1 第一季度 2 第二季度 3 第三季度 4 第四季度 
     *  
     * @param date 
     * @return 
     */  
    public static int getSeason(Date date) {  
  
        int season = 0;  
  
        Calendar c = Calendar.getInstance();  
        c.setTime(date);  
        int month = c.get(Calendar.MONTH);  
        switch (month) {  
        case Calendar.JANUARY:  
        case Calendar.FEBRUARY:  
        case Calendar.MARCH:  
            season = 1;  
            break;  
        case Calendar.APRIL:  
        case Calendar.MAY:  
        case Calendar.JUNE:  
            season = 2;  
            break;  
        case Calendar.JULY:  
        case Calendar.AUGUST:  
        case Calendar.SEPTEMBER:  
            season = 3;  
            break;  
        case Calendar.OCTOBER:  
        case Calendar.NOVEMBER:  
        case Calendar.DECEMBER:  
            season = 4;  
            break;  
        default:  
            break;  
        }  
        return season;  
    }  
    
    /**
     * 获取指定时间所在年里的某月某天的日期
     * @param tomrrowDate
     * @param month
     * @param days
     * @return
     */
    public static Date getDateOfMonthAndDay(Date tomrrowDate,int month,int days){
    	 Calendar cal = Calendar.getInstance(); 
    	 cal.setTime(tomrrowDate);
    	 cal.set(Calendar.MONTH, month);
    	 cal.set(Calendar.DAY_OF_MONTH,days);
    	 return cal.getTime();
    }
    
    /**
     * 比较时间的大小
     * >0:d1晚于d2; =0:d1=d2;<0:d1早于d2
     * @param d1
     * @param d2
     * @return
     */
    public static int compareDate(Date d1,Date d2){
    	Calendar cal1= Calendar.getInstance();
	    Calendar cal2= Calendar.getInstance();
	    cal1.setTime(d1);
	    cal2.setTime(d2);
	    return cal1.compareTo(cal2);
    }
    public  static  String getTimeDifference(Date start,Date end){
		float hourOfBettwenTwoDate = getHourOfBettwenTwoDate(start, end);
		if(hourOfBettwenTwoDate >=24){
			int daysOfBettwenTwoDate = getDaysOfBettwenTwoDate(start, end);
			if(daysOfBettwenTwoDate <= 30){
				return  daysOfBettwenTwoDate+"天前";
			}else {
				int i = month() - getMonthByDate(start);
				return i+"月前";
			}
		}else {
			return hourOfBettwenTwoDate+"小时前";
		}
	}


    /**
     * 获取得两个日期间相差几天
     * @param d1
     * @param d2
     * @return
     */
    public static int getDaysOfBettwenTwoDate(Date d1,Date d2){
    	int days = 0;
    	try{
    		Calendar calendar1 = Calendar.getInstance();  
     	    Calendar calendar2 = Calendar.getInstance();  
     	    calendar1.setTime(d1);  
     	    calendar2.setTime(d2);
     	    long milliseconds1 = calendar1.getTimeInMillis();  
     	    long milliseconds2 = calendar2.getTimeInMillis();  
     	    long diff = milliseconds2 - milliseconds1;  
     	    /*long diffSeconds = diff / 1000;  
     	    long diffMinutes = diff / (60 * 1000);  
     	    long diffHours = diff / (60 * 60 * 1000);  */
     	    long diffDays = diff / (24 * 60 * 60 * 1000);  
     	   /* System.out.println("\nThe Date Different Example");  
     	    System.out.println("Time in milliseconds: " + diff + " milliseconds.");  
     	    System.out.println("Time in seconds: " + diffSeconds + " seconds.");  
     	    System.out.println("Time in minutes: " + diffMinutes + " minutes.");  
     	    System.out.println("Time in hours: " + diffHours + " hours.");  
     	    System.out.println("Time in days: " + diffDays + " days.");  */
     	    days = Integer.parseInt(String.valueOf(diffDays));
    	}catch(Exception ex){
    		ex.printStackTrace();
    	}
    	   
    	    return days;
    }
    
    /**
     * 根据开始结束时间得到时间差，以**小时**分钟**秒的字符串形式输出
     * @param start
     * @param end
     * @return
     */
    public static String getDiffTypeOfHourMinuteAndSecondByStartAndEndTime(Timestamp start,Timestamp end){
    	   String ret = "";
    	try{
    		
    	    long milliseconds1 = start.getTime();  
     	    long milliseconds2 = end.getTime();
     	    long diff = milliseconds2 - milliseconds1;  
     	    long diffHours = diff / (60 * 60 * 1000);
     	         
     	    if(diffHours>0){
     	    	ret+=diffHours+"小时";
     	    }
     	    diff = diff%(60 * 60 * 1000);
     	    long diffMinutes = diff / (60 * 1000); 
     	   if(diffMinutes>0){
    	    	ret+=diffMinutes+"分";
    	    }
     	    diff = diff % (60 * 1000); 
     	    long diffSeconds = diff / 1000;
     	    if(diffSeconds>0){
     	    	ret+=diffSeconds+"秒";
     	    }
     	  
         
     	    
    	}catch(Exception ex){
    		ex.printStackTrace();
    		return "0";
    	}
    	if("".equals(ret)){
    		return "0";
    	}
    	return ret;
    }
    
    /**
     * 获取两个时间相差几小时
     * @param d1
     * @param d2
     * @return
     */
    public static float getHourOfBettwenTwoDate(Date d1,Date d2){
    	 Calendar calendar1 = Calendar.getInstance();  
 	     Calendar calendar2 = Calendar.getInstance();  
 	     calendar1.setTime(d1);  
 	     calendar2.setTime(d2);
 	     float milliseconds1 = calendar1.getTimeInMillis();  
	     float milliseconds2 = calendar2.getTimeInMillis();  
	     float diff = milliseconds2 - milliseconds1;
	     float diffHours = diff / (60 * 60 * 1000);
	     BigDecimal b = new BigDecimal(diffHours);
	     return b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
	      
	     
    }
    /**
     *  获取两个时间相差几分钟
     * @param d1
     * @param d2
     * @return
     * @author lhl
     * @date 2018年8月6日-下午2:59:15
     */
    public static float getMinuteOfBettwenTwoDate(Date d1,Date d2){
   	 Calendar calendar1 = Calendar.getInstance();  
	     Calendar calendar2 = Calendar.getInstance();  
	     calendar1.setTime(d1);  
	     calendar2.setTime(d2);
	     float milliseconds1 = calendar1.getTimeInMillis();  
	     float milliseconds2 = calendar2.getTimeInMillis();  
	     float diff = milliseconds2 - milliseconds1;
	     float diffHours = diff / (60 * 1000);
	     BigDecimal b = new BigDecimal(diffHours);
	     return b.setScale(2, BigDecimal.ROUND_HALF_UP).floatValue();
   }
    
    /**
     * 根据当前日期获取所在周的第一天
     * @param date
     * @return
     */
    public static Date getFirstDayOfWeekByCurDate(Date date){
    	 Calendar calendar = new GregorianCalendar();
         calendar.setTime(date);
         Calendar cal =new GregorianCalendar();
     	cal.setTime(addDay(calendar.getTime(), -1));
     	calendar.setFirstDayOfWeek(Calendar.MONDAY);
     	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)-1; 
     	Calendar calFirstDayInThisWeek = (Calendar)cal.clone();
     	calFirstDayInThisWeek.add(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_WEEK)-dayOfWeek);
     	return calFirstDayInThisWeek.getTime();
    }
    
    /**
     * 获取一年有多少周的起始日期
     * @return
     */
    public static List<String> getDateDescInfoOfAllWeeks(){
    	//一年有多少周
     List<String> retList = new ArrayList<String>();
   	 Calendar cal = Calendar.getInstance();
      int year = cal.get(Calendar.YEAR);
   	 Integer weeks =DateUtil.getMaxWeekNumOfYear();
   	 for(int i=1;i<=weeks;i++){
   		 retList.add(DateUtil.format(DateUtil.getFirstDayOfWeek(year, i),"MM月dd日")+"-"+DateUtil.format(DateUtil.getLastDayOfWeek(year, i),"MM月dd日"));
   	 }
   
    	return retList;
    }
    
    /** 
     * 取得当前日期是多少周 
     * 
     * @param date 
     * @return 
     */ 
     public static int getWeeksOfYear(Date date) { 
     Calendar c = new GregorianCalendar(); 
     c.setFirstDayOfWeek(Calendar.MONDAY); 
     c.setMinimalDaysInFirstWeek(7); 
     c.setTime (date);
     return c.get(Calendar.WEEK_OF_YEAR); 
     }
     
     /** 
      * 得到某年某周的第一天 
      * 
      * @param year 
      * @param week 
      * @return 
      */ 
      public static Date getFirstDayOfWeek(int year, int week) { 
      Calendar c = new GregorianCalendar(); 
      c.set(Calendar.YEAR, year); 
      c.set (Calendar.MONTH, Calendar.JANUARY); 
      c.set(Calendar.DATE, 1);
      Calendar cal = (GregorianCalendar) c.clone(); 
      cal.add(Calendar.DATE, week * 7);
      return getFirstDayOfWeek(cal.getTime ()); 
      }
      
      /** 
       * 得到某年某周的最后一天 
       * 
       * @param year 
       * @param week 
       * @return 
       */ 
       public static Date getLastDayOfWeek(int year, int week) { 
       Calendar c = new GregorianCalendar(); 
       c.set(Calendar.YEAR, year); 
       c.set(Calendar.MONTH, Calendar.JANUARY); 
       c.set(Calendar.DATE, 1);
       Calendar cal = (GregorianCalendar) c.clone(); 
       cal.add(Calendar.DATE , week * 7);
       return getLastDayOfWeek(cal.getTime()); 
       }
      /** 
       * 取得指定日期所在周的第一天 
       * 
       * @param date 
       * @return 
       */ 
       public static Date getFirstDayOfWeek(Date date) { 
       Calendar c = new GregorianCalendar(); 
       c.setFirstDayOfWeek(Calendar.MONDAY); 
       c.setTime(date); 
       c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday 
       return c.getTime (); 
       }
       
       /** 
        * 取得指定日期所在周的最后一天 
        * 
        * @param date 
        * @return 
        */ 
        public static Date getLastDayOfWeek(Date date) { 
        Calendar c = new GregorianCalendar(); 
        c.setFirstDayOfWeek(Calendar.MONDAY); 
        c.setTime(date); 
        c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday 
        return c.getTime(); 
        } 
     /** 
      * 得到某一年周的总数 
      * 
      * @param year 
      * @return 
      */ 
      public static int getMaxWeekNumOfYear() { 
      Calendar cal = Calendar.getInstance();
      Calendar c = new GregorianCalendar(); 
      c.set(cal.get(Calendar.YEAR), Calendar.DECEMBER, 31, 23, 59, 59);
      return getWeeksOfYear(c.getTime()); 
      }
    /**
     * 获取当前日期是所在本月的第几周--输出当前周的开始结束时间
     * @param dateStr
     * @return
     */
    public static Map<String,Object> getWeekDateByMonth(Date date1){
    	Map<String,Object> map = new HashMap<String,Object>();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date1);
    	Calendar cal =new GregorianCalendar();
    	cal.setTime(addDay(calendar.getTime(), -1));
    	calendar.setFirstDayOfWeek(Calendar.MONDAY);
    	//System.out.println("第几周："+calendar.get(Calendar.WEEK_OF_MONTH));
    	Integer djz = calendar.get(Calendar.WEEK_OF_MONTH);
    	//cal.setTime(parse("2014-07-06","yyyy-MM-dd"));
    	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK)-1; 
    	
    	Calendar calFirstDayInThisWeek = (Calendar)cal.clone();
    	calFirstDayInThisWeek.add(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_WEEK)-dayOfWeek);
    	 //System.out.println("开始时间："+format(calFirstDayInThisWeek.getTime()));
    	Calendar calLastDayInThisWeek = (Calendar)cal.clone();
    	calLastDayInThisWeek.add(Calendar.DATE,cal.getActualMaximum(Calendar.DAY_OF_WEEK)-dayOfWeek);
    	 //System.out.println("结束时间："+format(calLastDayInThisWeek.getTime()));
    	map.put("djz", djz);
    	map.put("startDate", format(calFirstDayInThisWeek.getTime()));
    	map.put("endDate", format(calLastDayInThisWeek.getTime()));
    	map.put("text", "第"+djz+"周("+ (getMonthByDate(calFirstDayInThisWeek.getTime())+1)+"月"+getDayByDate(calFirstDayInThisWeek.getTime())+"日"+"-"+(getMonthByDate(calLastDayInThisWeek.getTime())+1)+"月"+getDayByDate(calLastDayInThisWeek.getTime())+"日)");
    	map.put("id", format(calFirstDayInThisWeek.getTime())+"#"+format(calLastDayInThisWeek.getTime()));
    	//System.out.println(map.get("text").toString());
    	//System.out.println(map.get("id").toString());
    	return map;

    }
    
    /**
     * 根据年月获取本月的起始日期
     * @param yearAndMonth
     * @return
     */
    public static Map getStartAndEndDateByYearAndMonth(String yearAndMonth){
    	  Date d = parse(yearAndMonth,"yyyy-MM");
    	  Calendar calendar = new GregorianCalendar();
    	  calendar.setTime(d);
    	  int start = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
    	  int end = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    	  //System.out.println(start+"^^^"+end);
    	  Calendar c1 = new GregorianCalendar();
    	  c1 = (Calendar) calendar.clone();
    	  c1.add(Calendar.DATE, start-1);
    	  String start_str = format(c1.getTime(),"yyyy-MM-dd");
    	  Calendar c2 = new GregorianCalendar();
    	  c2 = (Calendar) calendar.clone();
    	  c2.add(Calendar.DATE, end-1);
    	  String end_str = format(c2.getTime(),"yyyy-MM-dd");
    	  Map map = new HashMap();
    	  map.put("start", start_str);
    	  map.put("end", end_str);
    	  //System.out.println(start_str+"****"+end_str);
    	  return map;
    }
    
    /**
     * 根据年月获取当月有多少天
     * @param yearAndMonth
     * @return
     */
    public static Integer getTotalDaysOfMonthByYearAndMonth(String yearAndMonth){
      Date d = parse(yearAndMonth,"yyyy-MM");
   	  Calendar calendar = new GregorianCalendar();
   	  calendar.setTime(d);
   	  int total = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
   	  return total;
    }
    /**
     * 根据年月获取本月的起始日期
     * @param yearAndMonth
     * @return
     */
    public static Map getStartAndEndDateHaveHourMinutsAndSecondByYearAndMonth(String yearAndMonth){
    	  Date d = parse(yearAndMonth,"yyyy-MM");
    	  Calendar calendar = new GregorianCalendar();
    	  calendar.setTime(d);
    	  int start = calendar.getActualMinimum(Calendar.DAY_OF_MONTH);
    	  int end = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    	  //System.out.println(start+"^^^"+end);
    	  Calendar c1 = new GregorianCalendar();
    	  c1 = (Calendar) calendar.clone();
    	  c1.add(Calendar.DATE, start-1);
    	  String start_str = format(c1.getTime(),"yyyy-MM-dd HH:mm:ss");
    	  Calendar c2 = new GregorianCalendar();
    	  c2 = (Calendar) calendar.clone();
    	  c2.add(Calendar.DATE, end-1);
    	  String end_str = format(c2.getTime(),"yyyy-MM-dd");
    	  Map map = new HashMap();
    	  map.put("start", start_str);
    	  map.put("end", end_str+" 23:59:59");
    	  //System.out.println(start_str+"****"+end_str);
    	  return map;
    }
    
    /**
	 * 获取格式化当前日期时间
	*/   
	public static String getDateTime(String format){
		SimpleDateFormat fmt = new SimpleDateFormat(format);
		Date Now = new Date();
		String NDate = fmt.format(Now);
		return NDate;
	}
    
    /**
     * 当前日期是本月的第几周（周日为一周的最后一天）
     * @param date
     * @return
     */
    public static Integer weekOfMonth(Date date){
     
    	Calendar cal =new GregorianCalendar();
    	cal.setTime(addDay(date, -1));
     
    	 return cal.get(Calendar.WEEK_OF_MONTH);
    }
    
    public static void printfWeeks(String date) throws Exception {
    	
    	        //例如：String date = "2014-07";
    	        //String [] weekOfMonth = 
    	        Date date1 = parse(date, "yyyy-MM");
    	        Calendar calendar = new GregorianCalendar();
    	        calendar.setTime(date1);
    	        //当前月有多少天
    	        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    	        int count = 0;
    	        for (int i = 1; i <= days; i++) {
    	        	
    	            Date date2 =parse(date + "-" + i,"yyyy-MM-dd");
    	            calendar.clear();
    	            calendar.setTime(date2);
    	            //SUNDAY = 1;MONDAY = 2;.....
    	            int k = new Integer(calendar.get(Calendar.DAY_OF_WEEK));
    	            
    	            if (k == 1) {// 若当天是周日
    	
    	                count++;
    	
    	                System.out.println("-----------------------------------");
    	
    	                System.out.println("第" + count + "周");
    	
    	                if (i - 6 <= 1) {
    	
    	                    System.out.println("本周开始日期:" + date + "-" + 1);
    	
    	                } else {
    	
    	                    System.out.println("本周开始日期:" + date + "-" + (i - 6));
    	
    	                }
    	
    	                System.out.println("本周结束日期:" + date + "-" + i);
    	
    	                System.out.println("-----------------------------------");
    
    	            }
    
    	            if (k != 1 && i == days) {// 若是本月最好一天，且不是周日
    	
    	                count++;
    
    	                System.out.println("-----------------------------------");
    
    	                System.out.println("第" + count + "周");
    
    	                System.out.println("本周开始日期:" + date + "-" + (i - k + 2));
    
    	                System.out.println("本周结束日期:" + date + "-" + i);
    
    	                System.out.println("-----------------------------------");
    	
    	            }
    	
    	        }
    	
    	    }
    
    /** 
     * 获取过去第几天的日期 
     * 
     * @param past 
     * @return 
     */  
    public static String getPastDate(int past, String pattern) {  
        Calendar calendar = Calendar.getInstance();  
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);  
        Date today = calendar.getTime();  
        return format(today,pattern);  
    }
    
    /**
     * 获取最近几个月的一号日期
     * @param c
     * @return
     */
    public static String getLastMonthBeginDay(int c, String pattern){
    	Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.MONTH, c);
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		return format(calendar.getTime(),pattern);
    }
    
    /**
     * 获取相对于今日多少天的零点
     * @return
     */
    public static String getDateZero(int m, String pattern){
    	Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) + m);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        return format(calendar.getTime(),pattern);
    }
    
    /**
     * 获取当天的开始时间
     * @author 王志满
     * @return
     */
  	public static  Date getDayBegin() {
           Calendar cal = new GregorianCalendar();
            cal.set(Calendar.HOUR_OF_DAY, 0);
            cal.set(Calendar.MINUTE, 0);
             cal.set(Calendar.SECOND, 0);
             cal.set(Calendar.MILLISECOND, 0);
             return cal.getTime();
    }
  	
  	 /**
     * 获取当天的结束时间
     * @author 王志满
     * @return
     */
    public static Date getDayEnd() {
            Calendar cal = new GregorianCalendar();
            cal.set(Calendar.HOUR_OF_DAY, 23);
          cal.set(Calendar.MINUTE, 59);
          cal.set(Calendar.SECOND, 59);
            return cal.getTime();
    }
    
    /**
     * 获取昨天的开始时间
     * @author 王志满
     * @return
     */
    public static Date getBeginDayOfYesterday() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(getDayBegin());
         cal.add(Calendar.DAY_OF_MONTH, -1);
      return cal.getTime();
    }
    
    /**
     * 获取昨天的结束时间
     * @author 王志满
     * @return
     */
    public static Date getEndDayOfYesterDay() {
     Calendar cal = new GregorianCalendar();
     cal.setTime(getDayEnd());
     cal.add(Calendar.DAY_OF_MONTH, -1);
     return cal.getTime();
    }
    
    /**
     * 获取明天的开始时间
     * @author 王志满
     * @return
     */
    public static Date getBeginDayOfTomorrow() {
       Calendar cal = new GregorianCalendar();
       cal.setTime(getDayBegin());
       cal.add(Calendar.DAY_OF_MONTH, 1);
      return cal.getTime();
    }
    
    /**
     * 获取明天的结束时间
     * @author 王志满
     * @return
     */
    public static Date getEndDayOfTomorrow() {
       Calendar cal = new GregorianCalendar();
       cal.setTime(getDayEnd());
      cal.add(Calendar.DAY_OF_MONTH, 1);
       return cal.getTime();
    }
  	 
    /**
     * 获取本月第一天和昨天的日期
     * @return
     */
    public static List<String> getThisMonthBeginAndYest(){
    	Calendar cal = new GregorianCalendar();
    	cal.set(Calendar.DAY_OF_MONTH,1);
    	Calendar cal1 = new GregorianCalendar();
    	cal1.setTime(new Date());
    	cal1.add(cal1.DATE, -1);
    	List<String> result = new ArrayList<>();
    	result.add(new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime()));
    	result.add(new SimpleDateFormat("yyyy-MM-dd").format(cal1.getTime()));
    	
    	return result;
    }
    /**
     * 当前年是平年，还是闰年
     * @param year
     * @return true：该年是闰年  false:该年是平年
     * @author lhl
     * @date 2018年3月13日-上午11:06:30
     */
    public static boolean getSpecialParticularYear(int year){
    	 if(year%4==0&&year%100!=0||year%400==0){  
    		 //System.out.println("该年是闰年");  
             return true;
         }else{  
        	 //System.out.println("该年是平年");  
        	 return false;
         }  
    }
    
    
    //测试
	public static void main(String[] args) {
		getSpecialParticularYear(2000);
	}
	
}