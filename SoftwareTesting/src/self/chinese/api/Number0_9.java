package self.chinese.api;

public enum Number0_9 {
	Zero("零", 0), One("壹", 1), Two("贰", 2), Three("叁", 3), Four("肆", 4), Five("伍", 5),
	Six("陸", 6), Seven("柒", 7), Eight("捌", 8), Nine("玖", 9);
	private String name;
	private int index;
	private Number0_9(String name, int index)
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
    	for(Number0_9 m : Number0_9.values())
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
