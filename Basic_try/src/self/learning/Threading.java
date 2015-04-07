//// 此处程序在fun(z)处出现错误，原因是参数类型不匹配
//// Long 与 long 的区别：Long是long的包装类， 是一个对象(引用)而不是数字， 故匹配Long也要是一个Long类型的对象
//// 所以当调用fun的参数是int 数字的时候首先考虑 直接匹配， 不行则向上转型看看有没有long， 都没有则报错
//
//// 有关split 输入的参数是正则表达式，而不是单纯的ASCII码， 比如\s就是正则表达式里空格的表示方法
//// 由于在“”中，所以要对“\"作转义解释
//package self.learning;
//
//public class Threading {
//	public static void fun(short n)
//	{
//		System.out.println("short");
//	}
//	public static void fun(Short n)
//	{
//		System.out.println("SHORT");
//	}
//	public static void fun(Long n)
//	{
//		System.out.println("LONG");
//	}
//	
//	// 向上转型的正确写法
////	public static void fun(long n)
////	{
////		System.out.println("LONG");
////	}
//	public 	static void main(String[] args) throws Exception {
////		Thread.sleep(3000);
////		System.out.println("alive");
//		
////		String text = "Welcome to Java contest";
////		String[] words = text.split("\\s");
////		System.out.println(words.length);
//		
//		Short y = 0;
//		int z = y;
//		fun(y);
//		fun(z);
//	}
//}
