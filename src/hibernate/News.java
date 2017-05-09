package hibernate;

import javax.persistence.*;

@Entity
// ����������һ��Hibernate�ĳ־û���
@Table(name = "news_inf")
// ָ������ӳ��ı�
public class News {
	private String data;
	@Id
	// ָ������ı�ʶ���ԡ�ͨ��ӳ�䵽���ݱ��������
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Lob
	private byte[] pic;

	public String getData() {
		return data;
	}

	public int getId() {
		return id;
	}

	public byte[] getPic() {
		return pic;
	}

	public void setData(String data) {
		this.data = data;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPic(byte[] pic) {
		this.pic = pic;
	}
}
