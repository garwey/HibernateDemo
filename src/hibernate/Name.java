package hibernate;

//@Embeddable
public class Name implements java.io.Serializable {
	// @Column(name = "News_firstname")
	private String first;
	// @Column(name = "News_lastname")
	private String last;
	// @Parent
	private Person owner;

	// �޲����Ĺ�����
	public Name() {
	}

	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Name(String first, String last) {
		this.first = first;
		this.last = last;
	}

	public String getFirst() {
		return first;
	}

	public void setFirst(String first) {
		this.first = first;
	}

	public String getLast() {
		return last;
	}

	public void setLast(String last) {
		this.last = last;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

	public Person getOwner() {
		return this.owner;
	}
}
