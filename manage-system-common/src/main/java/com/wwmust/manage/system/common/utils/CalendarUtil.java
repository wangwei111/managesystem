package com.wwmust.manage.system.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class CalendarUtil {
    public static final String DateFormat = "MM-dd";// 日期格式

    /**
     *
     * 方法名 ：getCalendar<br>
     * 方法描述 ：返回固定条件设置的Calendar对象。<br>
     * Calendar对象设置项：设置每周的第一天为周一；设置每周从周一开始；设置每周至少7天<br>
     * 创建者 ：@author wangzm<br>
     * 创建时间 ：2015-1-20上午10:51:49 <br>
     *
     * @return 返回类型 ：Calendar
     */
    public static Calendar getCalendar() {
        Calendar cal = new GregorianCalendar();
        Locale.setDefault(Locale.CHINESE);
        cal.setFirstDayOfWeek(Calendar.MONDAY);// 设置每周的第一天为周一
        cal.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY);// 设置每周从周一开始
        cal.setMinimalDaysInFirstWeek(7);// 设置每周至少7天
        return cal;
    }
    /**  
     * 获得当前年份  
     *   
     * @return  
     */    
    public static int getYear() {    
        return getCalendar().get(Calendar.YEAR);    
    }    
    
    /**  
     * 获得当前月份  
     *   
     * @return  
     */    
    public static int getMonth() {    
        return getCalendar().get(Calendar.MONTH) + 1;    
    } 
    
    /**  
     * 获得当前日  
     *   
     * @return  
     */    
    public static int getDay() {    
        return getCalendar().get(Calendar.DATE);    
    } 
    
    
    /**
     * 方法名：getWeekOfYear
     * * 创建者 ：@author wangzm<br>
     * @Description 获取当期日期是当前年份的第几周
     * @return 返回类型:int 
     */
    public static int getWeekOfYear(){
       Calendar cal = getCalendar();
       cal.setTime(new Date());
       return cal.get(Calendar.WEEK_OF_YEAR);
    }
    /**  
     * 获得当前时间是一周中的第几天  
     *   
     * @return  
     */  
    public static int getDayOfWeek(){
      Calendar now =  getCalendar();  
      now.setTime(new Date());
      //一周第一天是否为星期一  
      boolean isFirstSunday = (now.getFirstDayOfWeek() == Calendar.MONDAY);  
      //获取周几  
      int weekDay = now.get(Calendar.DAY_OF_WEEK);  
      //若一周第一天为星期一，则-1  
      if(isFirstSunday){  
          weekDay = weekDay - 1;  
          if(weekDay == 0){  
              weekDay = 7;  
          }  
      }  
      return weekDay;
    }
    
    /**
     *
     * 方法名 ：getWeekDays<br>
     * 方法描述 ：输入年、周，计算本周7天的日期<br>
     * 创建者 ：@author wangzm<br>
     *
     * @param year
     *            ：年份
     * @param yearWeek
     *            ：周数
     * @return 返回类型 ：String[]
     */
    public static String[] getWeekDays(int year, int yearWeek) {
        String[] str = new String[7];
        Calendar cal = getCalendar();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.WEEK_OF_YEAR, yearWeek);
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        cal.add(Calendar.DATE, cal.getActualMinimum(Calendar.DAY_OF_WEEK)
                - dayOfWeek);
        for (int i = 0; i < str.length; i++) {
            cal.add(Calendar.DATE, 1);
            Date d = cal.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd");
            str[i] = sdf.format(d);
        }
        return str;
    }

    /**
     *
     * 方法名 ：getYearWeekFirstDay<br>
     * 方法描述 ：输入年、周，计算本周第一天的日期<br>
     * 创建者 ：@author wangzm<br>
     *
     * @param year
     *            ：年份
     * @param yearWeek
     *            ：周数
     * @return 返回类型 ：String
     */
    public static String getYearWeekFirstDay(int year, int yearWeek) {
        Calendar calendar = getCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.WEEK_OF_YEAR, yearWeek);
        return getFormatDate(calendar.getTime());
    }

    /**
     *
     * 方法名 ：getYearWeekEndDay<br>
     * 方法描述 ：输入年、周，计算本周最后一天的日期<br>
     * 创建者 ：@author wangzm<br>
     * 创建时间 ：2015-1-20上午10:56:41 <br>
     *
     * @param year
     *            ：年份
     * @param yearWeek
     *            ：周数
     * @return 返回类型 ：String
     */
    public static String getYearWeekEndDay(int year, int yearWeek) {
        Calendar calendar = Calendar.getInstance();
        // 下面两句代码配合，才能实现，每年度的第一个周，是包含第一个星期一的那个周。
        calendar.setFirstDayOfWeek(Calendar.MONDAY);// 设置每周的第一天为周一
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);// 设置每周从周一开始
        calendar.setMinimalDaysInFirstWeek(7);// 设置每周至少7天
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.WEEK_OF_YEAR, yearWeek);
        return getFormatDate(calendar.getTime());
    }

    /**
     *
     * 方法名 ：getWeekNumByYear<br>
     * 方法描述 ：输入年份，获取一年有多少个周<br>
     * 创建者 ：@author wangzm<br>
     * 创建时间 ：2015-1-20上午10:57:08 <br>
     *
     * @param year
     * @return 返回类型 ：int
     */
    public static int getWeekNumByYear(final int year) {
        int result = 52;// 每年至少有52个周 ，最多有53个周。
        String date = getYearWeekFirstDay(year, 53);
        if (date.substring(0, 4).equals(year + "")) {
            // 判断年度是否相符，如果相符说明有53个周。
            result = 53;
        }
        return result;

    }

    /**
     *
     * 方法名 ：getWeeksByYear<br>
     * 方法描述 ：输入年份，计算该年份每周的开始日期到结束日期<br>
     * 创建者 ：@author wangzm<br>
     * 创建时间 ：2015-1-20上午10:58:04 <br>
     *
     * @param year
     * @return 返回类型 ：List<String[]>
     */
    public static Map<String,String> getWeeksByYear(final int year) {
        int weeks = getWeekNumByYear(year);
        Map<String,String> result = new HashMap<>(weeks);
        for (int i = 1; i <= weeks; i++) {
            result.put("startDay",getYearWeekFirstDay(year, i));
            result.put("endDay",getYearWeekEndDay(year, i));
        }
        return result;
    }

    /**
     *
     * 方法名 ：getDaysOfMonth<br>
     * 方法描述 ：输入年份，月数，获取有多少天<br>
     * 创建者 ：@author wangzm<br>
     *
     * @param year
     * @param month
     * @return 返回类型 ：int
     */
    public static int getDaysOfMonth(int year, int month) {
        Calendar calendar = getCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);// 月份从0开始
        return calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    }

    /**
     *
     * 方法名 ：getWeeksOfMonth<br>
     * 方法描述 ：输入年份，月数，获取有多少周<br>
     * 创建者 ：@author wangzm<br>
     *
     * @param year
     *            ：年份
     * @param month
     *            ：月份
     * @return 返回类型 ：int
     */
    public static int getWeeksOfMonth(int year, int month) {
        Calendar calendar = getCalendar();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month-1);// 月份从0开始
        return calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
    }

    /**
     *
     * 方法名 ：getFormatDate<br>
     * 方法描述 ：格式化转换日期类型<br>
     * 创建者 ：@author wangzm<br>
     *
     * @param date
     * @return 返回类型 ：String
     */
    public static String getFormatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat(DateFormat);
        String dateStr=dateFormat.format(date);
        String str= dateStr.replaceFirst("-", "月")+"日";
        return str;
    }
    
    public static boolean getCurTimeLessThanCurTwelveTime(){
        boolean bool=false;
        Calendar cal = getCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateStr=sdf.format(new Date());
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String dateTimeStr=dateStr+" 11:59:59";
        try {
           Date dateTime= sdf1.parse(dateTimeStr);
           cal.setTime(dateTime);
           int curTime= Math.round(new Date().getTime()/1000);
           int time=Math.round(cal.getTimeInMillis()/1000);
           if(curTime<=time){
               bool=true;
               return bool;
           }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return bool;
    }
}
