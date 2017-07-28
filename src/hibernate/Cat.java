package hibernate;

public class Cat {
	private String name;
	private String color;
	private Person owner;

	// �޲����Ĺ�����
	public Cat() {
	}

	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Cat(String name, String color) {
		this.name = name;
		this.color = color;
	}

	// name��setter��getter����
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	// color��setter��getter����
	public void setColor(String color) {
		this.color = color;
	}

	public String getColor() {
		return this.color;
	}

	// owner��setter��getter����
	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public Person getOwner() {
		return this.owner;
	}
}