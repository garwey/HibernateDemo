package hibernate;

public class Cat {
	private String name;
	private String color;
	private Person owner;

	// 无参数的构造器
	public Cat() {
	}

	// 初始化全部成员变量的构造器
	public Cat(String name, String color) {
		this.name = name;
		this.color = color;
	}

	// name的setter和getter方法
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	// color的setter和getter方法
	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	// owner的setter和getter方法
	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public Person getOwner() {
		return this.owner;
	}
}