// 正则表达式的使用
// Pattern类 提供了compile方法编译了正则表达式，提供了匹配方法matcher生成Matcher类的对象
// Matcher类 提供了group()方法返回一组匹配正则表达式的字符串String，提供了start(), end()方法返回一组匹配串的首末位置
// 有关String[] args: java 可执行文件名 串 正则表达式1 正则表达式2 ... 
// 其中args[0]表示的是串
// 第一次循环把串本身当成了一个正则表达式
// 加入了java.io的使用
package pattern_try;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class NormalPattern 
{
	public static void main(String[] args) throws IOException
	{
		if (args.length < 2)
		{
			System.out.println("Usage:\njava NormalPattern " + "characterSequence regularExpression+");
			System.exit(0);
		}
		System.out.println("Please input a line!");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		System.out.println("Input: \"" + str + "\"");
		for (String arg : args)
		{
			System.out.println("Regular expression: \"" + arg + "\"");
			Pattern p = Pattern.compile(arg);
			Matcher m = p.matcher(str);
			while (m.find())
			{
				System.out.println("Match \"" + m.group() + "\" at positions " + m.start() + "-" + (m.end() - 1));
			}
		}
	}
}
