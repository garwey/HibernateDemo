package hibernate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import org.hibernate.annotations.Parent;

@Embeddable
public class Name {
	@Column(name = "News_firstname")
	private String first;
	@Column(name = "News_lastname")
	private String last;
	@Parent
	// ①
	private News owner;

	// 无参数的构造器
	public Name() {
	}

	// 初始化全部成员变量的构造器
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

	public void setOwner(News owner) {
		this.owner = owner;
	}

	public News getOwner() {
		return this.owner;
	}

}
