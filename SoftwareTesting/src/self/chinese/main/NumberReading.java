package self.chinese.main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import self.chinese.api.Change;

public class NumberReading 
{
	public static void main(String[] args) throws IOException
	{
		// 输入
		System.out.println("Please input a big data which contains less than 19 (include .) numbers!");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		System.out.println("It can be read as follow:");
		Change change = new Change(input);
//		Change change = new Change("");
//		System.out.println(change.outPut());
		
		// test reading4()
//		String str = "4";
//		System.out.println(change.reading1(str));
		
		// test multiple String number
//		String str = "1236578";
		
		// 计算
		change.getResult();
		
		// 输出结果
		change.outPut();	
	}
}
