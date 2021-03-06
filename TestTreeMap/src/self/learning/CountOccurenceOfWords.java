// 统计一个文本中单词出现的次数并按字典序输出
package self.learning;

import java.util.Map.Entry;
import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.TreeSet;

public class CountOccurenceOfWords {
	public static void main(String[] args)
	{
		String text = "Good morning. Have a good class. " + "Have a good visit. Have fun!";
		TreeMap<String, Integer> map = new TreeMap<String, Integer>();
		String[] words = text.split("[ \n\t\r.,;:!?(){]");
		for (int i = 0; i < words.length; i++)
		{
			// 大小写无关
			String key = words[i].toLowerCase();
			if (key.length() > 0)
			{
				// 对应的key没有查到值, 返回null
				if (map.get(key) == null)
				{
					map.put(key, 1);
				}
				else
				{
					// Integer -> int
					map.put(key, map.get(key).intValue() + 1);
				}
			}
		}
		
		//直接打印输出Map里面的键值对, 按关键字的升序排列
//		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//		
//		for (Map.Entry<String, Integer> entry: entrySet)
//		{
//			System.out.println(entry.getValue() + "\t" + entry.getKey());
//		}
		
		// 使用一个新的匿名类实现Comparable接口, 并显示结果
//		ArrayList<Map.Entry<String, Integer>> arrayList = new ArrayList(map.entrySet());
//		Collections.sort(arrayList, new Comparator<Map.Entry<String, Integer>>(){
//
//			@Override
//			public int compare(Entry<String, Integer> o1,
//					Entry<String, Integer> o2) {
//				// TODO Auto-generated method stub
//				return o1.getValue().compareTo(o2.getValue());
//			}});
//		for (Map.Entry<String, Integer> entry : arrayList)
//		{
//			System.out.println(entry.getValue() + "\t" + entry.getKey());
//		}
		
		// 创建一个新的类实现了Comparable接口， 使用CompareTo方法比较单词的出现次数
		// 如果将WordOccurrence放到树形集合里面则无法存放重复count的WordOccurrence对象
		ArrayList<WordOccurrence> arrayList = new ArrayList();
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//		TreeSet<WordOccurrence> tree = new TreeSet();
		for (Map.Entry<String, Integer> entry : entrySet)
		{
			arrayList.add(new WordOccurrence(entry));
//			tree.add(new WordOccurrence(entry));
		}
		Collections.sort(arrayList);
//		for (WordOccurrence w : tree)
		for (WordOccurrence w : arrayList)
		{
			System.out.println(w);
		}	
	}
}
