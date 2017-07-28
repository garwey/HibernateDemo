package hibernate;

public class Person {
	// 使用Name组件作为复合主键
	private Name name;
	// 普通属性
	private String email;
	// 组件属性，代表此人拥有的宠物
	private Cat pet;

	// name的setter和getter方法
	public void setName(Name name) {
		this.name = name;
	}

	public Name getName() {
		return this.name;
	}

	// email的setter和getter方法
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	// pet的setter和getter方法
	public void setPet(Cat pet) {
		this.pet = pet;
	}

	public Cat getPet() {
		return this.pet;
	}
}