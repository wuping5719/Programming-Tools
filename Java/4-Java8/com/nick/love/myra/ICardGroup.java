package com.nick.love.myra;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public interface ICardGroup {
   List<ICard> getCards();
   List<ICard> sort();
   
   // 新增接口方法，不修改已有的实现类
   // 新增的默认方法，可以按照用户自己传入的 Comparator 对象来对 CardList 排序，在接口的实现类中无需实现该方法
   default List<ICard> sort(Comparator<ICard> com) {
	   Collections.sort(getCards(), com);
	   return getCards();
   }
}
