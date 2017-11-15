package com.nick.love.myra;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;

public class TestTime {

	public static void main(String[] args) {
       /*****   LocalDate 示例    ********/
	   System.out.println("========= LocalDate 示例  ==============");
	   // 1.通过 now 方法获取一个表示当前日期的对象
	   LocalDate date1 = LocalDate.now();
	   System.out.println("Current Date : " + date1);
	   
	   // 2.通过 now 方法获取一个表示指定时区当前日期的对象
	   LocalDate date2 = LocalDate.now(ZoneId.of("Asia/Shanghai"));
	   System.out.println("Current Date in Zone : " + date2);
	   
	   // 3.根据传入的年月日信息构造一个日期对象
	   LocalDate date3 = LocalDate.of(2010, 9, 18);
	   System.out.println("Specific Date of Year : " + date3);
	   
	   // 4.将传入的 yyyy-mm-dd 格式字符串解析成一个日期对象
	   LocalDate date4 = LocalDate.parse("2011-11-11");
	   System.out.println("ParseString Date : " + date4);
	   
	   /*****   LocalTime 示例    ********/
	   System.out.println("========= LocalTime 示例  ==============");
	   // 1.当前时间
	   LocalTime time1 = LocalTime.now();
	   System.out.println("Current Time : " + time1);
	   
	   // 2.指定时分秒毫秒
	   LocalTime time2 = LocalTime.of(10, 22, 25, 100);
	   System.out.println("Specific Time of Day : " + time2);
	   
	   // 3.指定时区
	   LocalTime time3 = LocalTime.now(ZoneId.of("Asia/Kolkata"));
	   System.out.println("Current Time in IST : " + time3);
	   
	   // 4.指定距离 00:00:00 的秒数
	   LocalTime time4 = LocalTime.ofSecondOfDay(10000);
	   System.out.println("10000th Second Time : " + time4);
	   
	   // 5.通过解析字符串得到一个 LocalTime 时间对象
	   LocalTime time5 = LocalTime.parse("08:30:12");
	   System.out.println("ParseString Time : " + time5);
	   
	   /*****   LocalDateTime 示例    ********/
	   System.out.println("========= LocalDateTime 示例  =============");
	   // 1.当前日期时间
	   LocalDateTime dateTime1 = LocalDateTime.now();
	   System.out.println("Current DateTime : " + dateTime1);
	   
	   // 2.指定日期时间
	   LocalDateTime dateTime2 = LocalDateTime.of(date2, time5);
	   System.out.println("Specific DateTime : " + dateTime2);
	   
	   /*****   Instant 示例    ********/
	   System.out.println("========= Instant 示例  =============");
	   // 1.当前日期时间
	   Instant instant1 = Instant.now();
	   System.out.println("Current Instant : " + instant1);
	   
	   /*****   日期 API 工具 示例    ********/
	   System.out.println("========= 日期 API 工具  示例  =============");
	   // 1.返回一个 LocalDateTime 对象，表示当天的凌晨 00:00
	   LocalDate date = LocalDate.now();
	   System.out.println("DateTime of Start: " + date.atStartOfDay());
	   System.out.println("Date at Time: " + date.atTime(12, 30, 11, 16));
	   
	   // 2.直接通过 LocalDate 对象提供的接口即可进行格式化
	   // DateTimeFormatter 中定义了很多预定义的格式可直接引用
	   System.out.println("DateTimeFormatter : " + date.format(DateTimeFormatter.ofPattern("yyyy/MM/dd")));
	   
	   // 3.直接通过 LocalDate 对象提供的接口获取月份信息
	   // 可以获取年、月份中的日、年中的日、星期中的日等
	   System.out.println("Date get month : " + date.getMonth());
	   
	   // 4.直接通过 LocalDate 对象提供的接口比较两个时间
	   System.out.println("Date is before : " + date.isBefore(LocalDate.of(2018, 01, 01)));
	   
	   // 5.直接通过 LocalDate 对象提供的接口调整时间的值
	   // ChronoUnit 是一个枚举类型，表示时间的单位
	   System.out.println("Date minus 1 day : " + date.minus(1, ChronoUnit.DAYS));
	   System.out.println("Date plus 1 month : " + date.plusMonths(1));
	   
	   // 6.直接通过 LocalDate 对象提供的接口计算两个时间之间的间隔
	   System.out.println("Date to 2014-01-01 : " + date.until(LocalDate.of(2014, 01, 01)));
	   // 计算间隔多少月
	   System.out.println("Month to 2888-01-01 : " + date.until(LocalDate.of(2888, 01, 01), ChronoUnit.MONTHS));
	   
	   // 7.直接通过 LocalDate 对象提供的接口为日期中的年、月、日设置新值
	   System.out.println("Date Day of Month 1 : " + date.with(ChronoField.DAY_OF_MONTH, 1));
	   System.out.println("Date Day of Month 2 : " + date.withDayOfMonth(2));
	   System.out.println("Date with : " + date.with(LocalDate.of(1990, 10, 28)));
	   
	   /*****   对旧的日期 时间API的支持 示例    ********/
	   System.out.println("========= 对旧的日期 时间API的支持 示例 =============");
	   // 1.Date 转 Instant
	   Instant timestamp1 = new Date().toInstant();
	   // 转成 Instant 类型后可以转成其他像 LocalDate、LocalTime 等对象
	   LocalDateTime localDateTime = LocalDateTime.ofInstant(timestamp1, ZoneId.of(ZoneId.SHORT_IDS.get("PST")));
	   System.out.println("Old Date to LocalDateTime : " + localDateTime);
	   
	   // 2.Calendar 转 Instant
	   Instant timestamp2 = Calendar.getInstance().toInstant();
	   System.out.println("Calendar to Instant : " + timestamp2);
	   
	   // 3.TimeZone 转 ZoneId
	   ZoneId zoneId = TimeZone.getDefault().toZoneId();
	   System.out.println("TimeZone to ZoneId : " + zoneId);
	   
	   // 4.ZonedDateTime 通过 GregorianCalendar 构造
	   ZonedDateTime zonedDateTime = new GregorianCalendar().toZonedDateTime();
	   System.out.println("ZonedDateTime by GregorianCalendar : " + zonedDateTime);
	   
	   // 5.Date API 转成传统时间类
	   Date dt = Date.from(Instant.now());
	   System.out.println("Date from Instant : " + dt);
	   
	   TimeZone tz = TimeZone.getTimeZone(zoneId);
	   System.out.println("TimeZone from ZoneId : " + tz);
	   
	   GregorianCalendar gc = GregorianCalendar.from(zonedDateTime);
	   System.out.println("GregorianCalendar from ZonedDateTime : " + gc);
	}

}
