package hibernate;

import javax.persistence.*;

@Entity  // ����������һ��Hibernate�ĳ־û���
@Table(name = "news_inf")  // ָ������ӳ��ı�
public class News {
	@Id  // ָ������ı�ʶ���ԡ�ͨ��ӳ�䵽���ݱ��������
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
