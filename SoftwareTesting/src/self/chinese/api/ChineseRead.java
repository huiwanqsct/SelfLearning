package self.chinese.api;

public enum ChineseRead {
	// 数组下标
	One("", 3), Ten("拾", 2), Hun("佰", 1), Tho("仟", 0);
	private String name;
	private int index;
	private ChineseRead(String name, int index)
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
    	for(ChineseRead m : ChineseRead.values())
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
    	return this.name;
    }
}
