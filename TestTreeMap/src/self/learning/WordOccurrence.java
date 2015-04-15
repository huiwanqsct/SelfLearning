package self.learning;

import java.util.Map;

public class WordOccurrence implements Comparable{
	private String word;
	private Integer count;
	public WordOccurrence()
	{
		word = null;
		count = null;
	}
	public WordOccurrence(String word, Integer count)
	{
		this.word = word;
		this.count = count;
	}
	public WordOccurrence(Map.Entry<String, Integer> entry)
	{
		this.word = entry.getKey();
		this.count = entry.getValue();
	}
	
	// 对这个compareTo方法进行重载根本不会被执行！
	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		if (!(o instanceof WordOccurrence)) 
		{
			return 2;
		}
		else
		{
			WordOccurrence temp = (WordOccurrence) o;
			return this.count.compareTo(temp.count);
		}
	}
	
	public String toString()
	{
		return this.count + "\t" + this.word;
	}
}

//1	class
//1	fun
//1	morning
//1	visit
//2	a
//3	good
//3	have

