package self.chinese.api;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Change {
	private String result;
	private String input;
	public final String X = "(0|1|2|3|4|5|6|7|8|9)";
	public final String Y = "(1|2|3|4|5|6|7|8|9)";
	
	// 构造器
	public Change ()
	{
		this.result = "";
	}
	public Change (String input)
	{
		this.result = "";
		this.input = input;
	}
	
	// 传入一个字符串， 如果匹配正则表达式regular则返回true, 反之返回false
	public boolean matching(String str, String regular)
	{
		boolean result = false;
		Pattern p = Pattern.compile(regular);
		Matcher m = p.matcher(str);
		
		if (m.find())
		{
			result = true;
		}
		return result;
	}
	
	// 检查输入的正则合法性和位数
	public boolean checkInput(String str)
	{
		boolean result = false;
		int length = str.length();
		if (length == 0 || length > 16)
		{
			System.out.println("Error:Input more or less numbers!");
			return result;
		}
		if (matching(str, Y + "|" + X + "*"))
		{
			result = true;
		}
		return result;
	}
	
	// 把输入长度大于4位的串进行切分，结果放到数组里;
	// 分类方法： 串的长度能否被4整除
	public String[] cuttingIntoPieces(String str)
	{
		String[] pieces = null;
		int i = 0;
		int numberFirstString = str.length()%4;
		int numberOfPieces = str.length()/4;
//		System.out.println("numberFirstString is " + numberFirstString);
//		System.out.println("numberOfPieces is " + numberOfPieces);
		if (numberFirstString == 0)
		{
			switch (numberOfPieces)
			{
			case 1: pieces = new String[1]; 
					pieces[0] = str.substring(0, 4); 
					break;
			case 2: pieces = new String[2]; 
					for (i = 0; i < 2; i++)
					{
						pieces[i] = str.substring(4 * i, 4 + 4 * i);
					}
					break;
			case 3: pieces = new String[3]; 
					for (i = 0; i < 3; i++)
					{
						pieces[i] = str.substring(4 * i, 4 + 4 * i);
					}
					break;
			case 4: pieces = new String[4]; 
					for (i = 0; i < 4; i++)
					{
						pieces[i] = str.substring(4 * i, 4 + 4 * i);
					}
					break;
			default: 
				 	System.out.println("Error: The number can not be cutted into pieces!");
				 	System.exit(-1);
				 	break;
			}
		}
		else
		{
//			System.out.println("firstStringEnd is " + firstStringEnd);
			switch(numberOfPieces)
			{
			case 0: pieces = new String[1]; 
					pieces[0] = str.substring(0, numberFirstString);					
					break;
			case 1: pieces = new String[2]; 
					pieces[0] = str.substring(0, numberFirstString);
//					System.out.println("FirstString is " + pieces[0]);
				 	for (i = 1; i < 2; i++)
				 	{
				 		pieces[i] = str.substring(numberFirstString + 4 * i - 4, numberFirstString + 4 * i);
				 	}
				 	break;
			case 2: pieces = new String[3]; 
					pieces[0] = str.substring(0, numberFirstString);
					for (i = 1; i < 3; i++)
					{
						pieces[i] = str.substring(numberFirstString + 4 * i - 4, numberFirstString + 4 * i);
					}
					break;
			case 3: pieces = new String[4]; 
					pieces[0] = str.substring(0, numberFirstString);
					for (i = 1; i < 4; i++)
					{
						pieces[i] = str.substring(numberFirstString + 4 * i - 4, numberFirstString + 4 * i);
					}
					break;
			}
		}
//		System.out.println("Pieces[0] " + pieces[0]);
//		System.out.println("Pieces[1] " + pieces[1]);
//		System.out.println("Pieces[2] " + pieces[2]);
		return pieces;
	}
	
	// 读入一个一位串， 输出中文读法
	public String reading1(String str)
	{
		String reading = "";
		char[] chr;
		if (str.length() != 1)
		{
			System.out.println("Error:Input not 2 letters!");
			return null;
		}
		chr = str.toCharArray();
		reading = Number0_9.getName(chr[0] - '0');
		return reading;
	}
	
	// 读入一个两位串， 输出中文读法
	public String reading2(String str)
	{
		String reading = "";
		char[] chr;
		if (str.length() != 2)
		{
			System.out.println("Error:Input not 2 letters!");
			return null;
		}	
		chr = str.toCharArray();
		if (chr[1] == '0')
		{
			reading = Number0_9.getName(chr[0] - '0');
			reading += "拾";
		}
		else
		{
			reading = Number0_9.getName(chr[0] - '0');
			reading += "拾";
			reading += Number0_9.getName(chr[1] - '0');
		}
		return reading;
	}
	
	// 读入一个叁位串， 输出中文读法
	public String reading3(String str)
	{
		String reading = "";
		char[] chr;
//		System.out.println("Reading3 " + str);
		if (str.length() != 3)
		{
			System.out.println("Error:Input not 3 letters!");
			return null;
		}
		if (matching(str, Y + "00"))
		{
			chr = str.toCharArray();
			reading += Number0_9.getName(chr[0] - '0');
			reading += "佰";
		}
		else if (matching(str, Y + Y + "0"))
		{
			chr = str.toCharArray();
			int i;
			for (i = 0; i < 2; i++)
			{
				if (chr[i] == '0')
				{
					reading += Number0_9.getName(chr[i] - '0');
				}
				else
				{
					reading += Number0_9.getName(chr[i] - '0');
					reading += ChineseRead.getName(i + 1);
				}
			}
		}
		else
		{
			chr = str.toCharArray();
			int i = 0;
			for (i = 0; i < 3; i++)
			{
				if (chr[i] == '0')
				{
					reading += Number0_9.getName(chr[i] - '0');
				}
				else
				{
					reading += Number0_9.getName(chr[i] - '0');
					reading += ChineseRead.getName(i + 1);
				}
			}
		}
		return reading;
	}
	
	// 读入一个肆位正则串， 输出中文读法 (仅仅4个连续的0， 仅仅3个连续的0 ...)
	public String reading4(String str)
	{
		String reading = "";
		char[] chr;
		if (str.compareTo("0000") == 0)
		{
			;
		}
		else if (matching(str, Y + "000"))
		{
			chr = str.toCharArray();
			reading += Number0_9.getName(chr[0] - '0');
			reading += "仟";
		}
		else if (matching(str, "000" + Y))
		{
			chr = str.toCharArray();
			reading += "零";
			reading += Number0_9.getName(chr[3] - '0');
		}
		else if (matching(str, "00" + Y + X))
		{
			chr = str.toCharArray();
			reading += "零";
			reading += Number0_9.getName(chr[2] - '0');
			reading += "拾";
			if (chr[3] != '0')
			{
				reading += Number0_9.getName(chr[3] - '0');
			}
		}
		else if (matching(str, Y + "00" + Y))
		{
			chr = str.toCharArray();
			reading += Number0_9.getName(chr[0] - '0');
			reading += "仟零";
			reading += Number0_9.getName(chr[3] - '0');
		}
		else if (matching(str, X + Y + "00"))
		{
			chr = str.toCharArray();
			if (chr[0] == '0')
			{
				reading += "零";
			}
			else
			{
				reading += Number0_9.getName(chr[0] - '0');
				reading += "仟";
			}
			reading += Number0_9.getName(chr[1] - '0');
			reading += "佰";
		}
		else if (matching(str, X + X + X + "0"))
		{
			chr = str.toCharArray();
			int i = 0;
			for (i = 0; i < 3; i++)
			{
				if (chr[i] == '0')
				{
					reading += Number0_9.getName(chr[i] - '0');
				}
				else
				{
					reading += Number0_9.getName(chr[i] - '0');
					reading += ChineseRead.getName(i);
				}
			}
		}
		else
		{
			reading += reading4_Other(str);
		}
		return reading;
	}
	// (****)且末位非0, 读入一个四位数，输出结果
	public String reading4_Other(String str)
	{
		int i;
		// 空串与null的区别
//		如果说str是null，那么内存根本没有创建字符串对象，并由str引用。
//
//		如果说str是空串，那么确定存在一个由str引用的字符串对象，只不过这个字符串的值是空
//
//		null用来表示没有实例存在，而“”本身就是一个实例，有自己的对象空间，和“123456”这样的字符串没有区别
		
		String reading = "";
//		System.out.println("Reading4_Other " + str);
		char[] chr = str.toCharArray();
		for (i = 0; i < 4; i++)
		{
			if (chr[i] == '0')
			{
				reading += Number0_9.getName(chr[i] - '0');
			}
			else
			{
				reading += Number0_9.getName(chr[i] - '0');
				reading += ChineseRead.getName(i);
			}
		}
		return reading;
	}
	
	// 总的转换过程
	public void getResult()
	{
		String str = this.input;
		String reading = "";
		String[] pieces = this.cuttingIntoPieces(str);
		int numberOfP = pieces.length;
		int n = pieces[0].length();
		int i = 0;
		
		// 如果输入的数不合法
		if (!this.checkInput(str))
		{
			System.out.println("Error: checkInput error!");
			System.exit(-1);
		}
		
		// 先处理pieces[0]
		switch (n)
		{
		case 1: reading += this.reading1(pieces[0]); break;
		case 2: reading += this.reading2(pieces[0]); break;
		case 3: reading += this.reading3(pieces[0]); break;
		case 4: reading += this.reading4(pieces[0]); break;
		default: reading = null;
				 System.out.println("Error: in first pieces");
				 break;
		}
		
		// 再根据切出来的String的个数来考虑加上"萬"...
		switch (numberOfP)
		{
		case 1: break;
		case 2: reading += "萬";
				for (i = 1; i < numberOfP; i++)
				{
					reading += this.reading4(pieces[i]);
				}
				break;
		case 3: reading += "億";
				for (i = 1; i < numberOfP; i++)
				{
					reading += this.reading4(pieces[i]);
					if (i == 1)
					{
						reading += "萬";
					}
				}
				break;
		case 4: reading += "萬";
				for (i = 1; i < numberOfP; i++)
				{
					reading += this.reading4(pieces[i]);
					if (i == 1)
					{
						reading += "億";
					}
					else if (i == 2)
					{
						reading += "萬";
					}
					else
					{
						;
					}
				}
				break;
		default: System.out.println("Error: the numberOfP is not 1, 2, 3, 4");
		}
		this.result = reading;
	}
	
	// 仅仅打印出结果
	public void outPut()
	{
		System.out.println(this.result);
	}
}
