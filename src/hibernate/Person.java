package hibernate;

public class Person {
	// ʹ��Name�����Ϊ��������
	private Name name;
	// ��ͨ����
	private String email;
	// ������ԣ��������ӵ�еĳ���
	private Cat pet;

	// name��setter��getter����
	public void setName(Name name) {
		this.name = name;
	}

	public Name getName() {
		return this.name;
	}

	// email��setter��getter����
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	// pet��setter��getter����
	public void setPet(Cat pet) {
		this.pet = pet;
	}

	public Cat getPet() {
		return this.pet;
	}
}