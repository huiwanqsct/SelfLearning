package self.learning;

// 枚举类型的创建
public enum Money {
	YI("壹圆", 1), ER("贰圆", 2), WU("伍圆", 5), SY("拾圆", 10), ES("贰拾圆", 20), WS("伍拾圆", 50);
	private String name;
	private int index;
	private Money(String name, int index)
	{
		this.name = name;
		this.index = index;
	}
	// get set
	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    
    // 普通类方法
    public static String getName(int index)
    {
    	for(Money m : Money.values())
    	{
    		if (m.getIndex() == index)
    		{
    			return m.name;
    		}
    	}
    	return null;
    }
    // values()方法： 静态方法，返回一个包含全部枚举值的数组
    
    // 覆盖toString()方法， 如果不覆盖，则打印出某个enum例子的名字， 在这里是YI, ...
    @Override
    public String toString()
    {
    	return this.index + "_" + this.name;
    }
}
