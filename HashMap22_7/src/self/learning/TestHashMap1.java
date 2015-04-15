// HashMap的put containKey方法的使用
// 读取个数不定的整数，然后查找其中出现频率最高的数字，当输入为0时表示输入结束
// Map.Entry<K, V>表示键值对
// 使用Scanner输入
// 当参数是抽象类时要实现相关的抽象方法
// 使用printf输出指定格式的内容

package self.learning;

import java.util.Comparator;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class TestHashMap1 {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		Map<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		System.out.println("Please input a line (exit with 0): ");
		int number = 0;
		while (true)
		{
			try
			{
				// 输入一行一个数字, 不然报错
				number = Integer.parseInt(sc.nextLine());
				
				if (number == 0)
				{
					break;
				}
				else
				{
					if (hashMap.containsKey(number))
					{
						hashMap.put(number, hashMap.get(number) + 1);
					}
					else
					{
						hashMap.put(number, 1);
					}
				}
			}
			catch (Exception e)
			{
				System.out.println("Input Error: reinput!");
				continue;
			}
		}
		
//		The type new Comparator<Map.Entry<Integer,Integer>>(){} 
//		must implement the inherited abstract method 
//		Comparator<Map.Entry<Integer,Integer>>.compare(Map.Entry<Integer,Integer>, Map.Entry<Integer,Integer>)
		List<Map.Entry<Integer, Integer>> list = new ArrayList(hashMap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>(){

			@Override
			public int compare(Entry<Integer, Integer> o1,
					Entry<Integer, Integer> o2) {
				// TODO Auto-generated method stub
				return o2.getValue().compareTo(o1.getValue());
			}} );
		int max = list.get(0).getValue();
		for (Map.Entry<Integer, Integer> e: list)
		{
			if (e.getValue() == max)
			{
				System.out.printf("name = %d, times = %d\n", e.getKey(), e.getValue());
			}
		}
	}
}
