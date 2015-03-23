// 自动初始化在构造器被调用之前进行
// 一个最简单的java程序，证明在构造器World()被执行之前无法妨碍自动初始化的进行
// 比如World类中word如果从来没有被初始化，应该是一个不确定的数字，这里却是0

package First;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Hello
{
	public static void main(String[] argv) throws IOException
	{
		World w = new World();
		System.out.println("HelloWorld");
		System.out.println("word is " + w.word);
		// 尝试使用输入流InputStream, 去掉注释即可用
//		System.out.println("Please input a line!");
//		BufferedReader lineOfText = new BufferedReader(new InputStreamReader(System.in));
//		String textLine = lineOfText.readLine();
//		System.out.println(textLine);
		
		// 尝试使用一个数组接受String类型的转换函数的结果
		String str = new String("Hello World!");
		char[] chr = str.toCharArray();
		System.out.println("char array length is " + chr.length);
	}
}

class World
{
//	public int word = 1000;
	public int word;
	public World()
	{
//		world = 100;
	}
}
