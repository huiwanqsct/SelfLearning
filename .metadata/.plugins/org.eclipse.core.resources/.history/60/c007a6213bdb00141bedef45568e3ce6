//// 阿里的上机笔试题
//// 从1-1000选出900个不同的随机数，并打印出来
//// 设置一个全零的一维数组，产生一个全新的随机数则把相应位从0置成相应数字加一，同时加入ArrayList里面
//// 如果发现对应的数组相应位不是0， 则计数器不变
//// 重复以上过程直到计数器的值为200
//
//package self.learning;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Random;
//
//public class Radom0 {
//	public static void main(String[] args) 
//	{
//
//		List<Integer> printList = new ArrayList<Integer>();
//		int[] temp = new int[1000];
//		int i = 0;
//		int count = 0;
//		int num = 0;
//		for (i = 0; i < 1000; i++)
//		{
//			temp[i] = 0;
//		}
//		  
//		i = 0;
//		Random rd = new Random();
//		while (count <= 900)
//		{
//			num = rd.nextInt(1000);		
//			if (temp[num] == 0)
//			{
//				temp[num] = num + 1;
//				printList.add(temp[num]);
//				i++;
//				count++;
//			}			
//		}
//		
//		// 每隔10个数字换行
//		count = 1;
//		for (i = 0; i < 900; i++)
//		{
//			System.out.print(printList.get(i) + " ");
//			if (count % 10 == 0)
//			{
//				System.out.println("");
//			}
//			count++;
//		}
////		  for (i = 0; i < 9; i++)
////		  {
////			  System.out.print(temp.remove(rd.nextInt(10 - i)) + " ");
////			  if (i == 10)
////			  {
////				  System.out.println("");
////			  }
////			  System.out.print(temp.get(0));
////		  }
//	}	
//}
