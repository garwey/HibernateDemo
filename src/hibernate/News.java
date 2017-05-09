package hibernate;

import javax.persistence.*;

@Entity  // 声明该类是一个Hibernate的持久化类
@Table(name = "news_inf")  // 指定该类映射的表
public class News {
	@Id  // 指定该类的标识属性。通常映射到数据表的主键列
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String data;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
}
