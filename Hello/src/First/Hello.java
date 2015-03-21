// 自动初始化在构造器被调用之前进行
// 一个最简单的java程序，证明在构造器World()被执行之前无法妨碍自动初始化的进行
// 比如World类中word如果从来没有被初始化，应该是一个不确定的数字，这里却是0

package First;

public class Hello
{
	public static void main(String[] argv)
	{
		World w = new World();
		System.out.println("HelloWorld");
		System.out.println("word is " + w.word);
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
