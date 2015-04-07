//// 实现一个泛型栈
//// 泛型类型的3条限制
//// new E(); new E[]; static修饰; public class Myexception<T> extends Exception
//
//package self.exercise;
//
//public class GenericStack<E> {
//	private final static int INITSIZE = 2;
//	private E[] arraylist = (E[])new Object[INITSIZE];
//	
//	// 如果没有这个变量就无法合理的处理栈操作
//	private int size = 0;
//	
//	public GenericStack()
//	{
//		this(INITSIZE);
//	}
//	public GenericStack(int initSize)
//	{
//		for (int i = 0; i < initSize; i++)
//		{
//			arraylist[i] = null;
//		}
//	}
//	
//	public int getSize()
//	{
//		return arraylist.length;
//	}
//	
//	// 返回栈顶元素
//	public E peek()
//	{
//		return arraylist[size - 1];
//	}
//	
//	public void push(E o)
//	{
//		// 自增长
//		if (size >= arraylist.length)
//		{
//			E[] temp = (E[])new Object[arraylist.length * 2];
//			// 数组的拷贝操作， 从arraylist -> temp
//			System.arraycopy(arraylist, 0, temp, 0, arraylist.length);
//			arraylist = temp;
//		}
//		this.arraylist[size++] = o;
//	}
//	public E pop()
//	{
//		E o = arraylist[--size];
//		return o;
//	}
//	public boolean isEmpty()
//	{
//		return size == 0;
//	}
//	
//	public static void main(String[] args)
//	{
//		GenericStack<String> stack1 = new GenericStack<String>();
//		stack1.push("London");
//		stack1.push("Paris");
//		System.out.println(stack1.pop());
//		stack1.push("Berlin");
//		System.out.println(stack1.pop());
//		System.out.println(stack1.pop());	
//		GenericStack<Integer> stack2 = new GenericStack<Integer>();
//		stack2.push(1);
//		stack2.push(2);
//		stack2.push(3);
//		System.out.println(stack2.pop());
//		System.out.println(stack2.pop());
//		System.out.println(stack2.pop());
//	}
//}
//
//
//
//
//
//
//
//
//
//
//
