// 使用链表类实现两个链表的交、并、差运算
// 实现发现方法大体和HashSet类似，只是线性表允许重复的元素
package self.learning;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class TestArrayList1 {
	public static void main(String[] args)
	{
//		mainList();
		mainArray();
	}
	public static void mainArray()
	{
		List<String> listA = new ArrayList<String>();
		List<String> listB = new ArrayList<String>();
		listA.add("George");
		listA.add("Jim");
		listA.add("John");
		listA.add("Blake");
		listA.add("Kevin");
		listA.add("Mechael");
		
		listB.add("George");
		listB.add("Katie");
		listB.add("Kevin");
		listB.add("Michelle");
		listB.add("Ryan");
		
		List<String> tempA = new ArrayList<String>();
		List<String> tempB = new ArrayList<String>();
		tempA.addAll(listA);
		tempB.addAll(listB);
		System.out.println("原:listA " + listA);
		System.out.println("原:listB " + listB);
		
		// 交
		listA.retainAll(listB);
		System.out.println("交: " + listA);
		
		// 并
		listA.clear();
		listA.addAll(tempA);
		listA.addAll(listB);
		System.out.println("并: " + listA);
		
		// 差
		listA.clear();
		listA.addAll(tempA);
		listA.removeAll(listB);
		System.out.println("差: " + listA);
		
		// 恢复
		listA.clear();
		listA.addAll(tempA);
		System.out.println("原: " + listA);
	}
	
	public static void mainList()
	{
		List<String> listA = new LinkedList<String>();
		List<String> listB = new LinkedList<String>();
		listA.add("George");
		listA.add("Jim");
		listA.add("John");
		listA.add("Blake");
		listA.add("Kevin");
		listA.add("Mechael");
		
		listB.add("George");
		listB.add("Katie");
		listB.add("Kevin");
		listB.add("Michelle");
		listB.add("Ryan");
		
		List<String> tempA = new LinkedList<String>();
		List<String> tempB = new LinkedList<String>();
		tempA.addAll(listA);
		tempB.addAll(listB);
		System.out.println("原:listA " + listA);
		System.out.println("原:listB " + listB);
		
		// 交
		listA.retainAll(listB);
		System.out.println("交: " + listA);
		
		// 并
		listA.clear();
		listA.addAll(tempA);
		listA.addAll(listB);
		System.out.println("并: " + listA);
		
		// 差
		listA.clear();
		listA.addAll(tempA);
		listA.removeAll(listB);
		System.out.println("差: " + listA);
		
		// 恢复
		listA.clear();
		listA.addAll(tempA);
		System.out.println("原: " + listA);
	}
}

//原:setA [Kevin, George, Blake, Mechael, John, Jim]
//原:setB [Michelle, Kevin, Ryan, George, Katie]
//交: [Kevin, George]
//并: [Michelle, Kevin, Ryan, George, Katie, Blake, Mechael, John, Jim]
//差: [Blake, Mechael, John, Jim]
//原: [Kevin, George, Blake, Mechael, John, Jim]

//原:listA [George, Jim, John, Blake, Kevin, Mechael]
//原:listB [George, Katie, Kevin, Michelle, Ryan]
//交: [George, Kevin]
//并: [George, Jim, John, Blake, Kevin, Mechael, George, Katie, Kevin, Michelle, Ryan]
//差: [Jim, John, Blake, Mechael]
//原: [George, Jim, John, Blake, Kevin, Mechael]

