// 编写一个泛型方法，返回二维数组中的最大元素
package self.exercise;

public class MaxInMatrix{
	// 这样会提示class E找不到
//	public static void max0(E[][] list)
//	{
////		return list[0][0];
//	}
	
	// 前面这部分<E extends Comparable<E>>解释了E是一个什么样的泛型, E必须是一个继承了Comparable的子类
	public static <E extends Comparable<E>> E max(E[][] list)
	{
		E o = list[0][0];
		for (int i = 0; i < list.length; i++)
		{
			for (int j = 0; j < list[i].length; j++)
			{
				if (o.compareTo(list[i][j]) < 0)
				{
					o = list[i][j];
				}
			}
		}
		return o;
	}
	public static void main(String[] args)
	{
		// 如果是int[][]就会报错， 因为泛型类型必须是引用类型
		Integer[][] a = {{13, 12, 11}, {23, 22, 21}, {2, 3, 1}};
		int result = MaxInMatrix.max(a);
		System.out.println("The max number in the Matrix is: " + result);
	}
}
