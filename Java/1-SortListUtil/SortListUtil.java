package com.ouc.cs;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * 用到了 Java 反射机制
 * 自定义的排序类，专门针对列表(List)中的数据进行排序; 可按指定方法进行.
 * 已实现对字符串(String)、日期(Date)、整型(Integer)、长整型(Long)等四种对象进行排序。
 * @author wuping
 */

public class SortListUtil<E> {
	// 对列表中的数据按指定字段进行排序。
	// 要求类必须有相关的方法返回字符串、整型、日期等值以进行比较。
	public void sortByMethod(List<E> list, final String method, final boolean reverseFlag) {
        Collections.sort(list, new Comparator<Object>() {
            @SuppressWarnings("unchecked")
			public int compare(Object arg1, Object arg2) {
                int result = 0;
                try {
                    Method m1 = ((E) arg1).getClass().getMethod(method, null);
                    Method m2 = ((E) arg2).getClass().getMethod(method, null);
                    Object obj1 = m1.invoke(((E)arg1), null);
                    Object obj2 = m2.invoke(((E)arg2), null);
                    if(obj1 instanceof String) {
                        // 字符串
                        result = obj1.toString().compareTo(obj2.toString());
                    }else if(obj1 instanceof Date) {
                        // 日期
                        long l = ((Date)obj1).getTime() - ((Date)obj2).getTime();
                        if(l > 0) {
                            result = 1;
                        }else if(l < 0) {
                            result = -1;
                        }else {
                            result = 0;
                        }
                    }else if(obj1 instanceof Integer) {
                        // 整型(Method的返回参数可以是int的，因为JDK1.5之后，Integer与int可以自动转换了)
                        result = (Integer)obj1 - (Integer)obj2;
                    }else if(obj1 instanceof Long) {
                        // 长整型
                        result = (int) ((Long) obj1 - (Long)obj2);
                    }else {
                        // 目前尚不支持的对象，直接转换为String，然后比较，后果未知
                        result = obj1.toString().compareTo(obj2.toString());
                        
                        System.err.println("SortListUtil.sortByMethod方法接收到不可识别的对象类型，转换为字符串后比较返回。");
                    }
                    
                    if (reverseFlag) {
                        // 倒序
                        result = -result;
                    }
                } catch (NoSuchMethodException nsme) {
                    nsme.printStackTrace();
                } catch (IllegalAccessException iae) {
                    iae.printStackTrace();
                } catch (InvocationTargetException ite) {
                    ite.printStackTrace();
                }

                return result;
            }
        });
	}
}
