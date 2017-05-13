package hibernate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.annotations.CollectionType;
import javax.persistence.*;

enum Season {
	spring, summer, autumn, winter
}

@Entity
// ����������һ��Hibernate�ĳ־û���
@Table(name = "news_inf")
// ָ������ӳ��ı�
public class News {
	private String data;
	// ָ������ı�ʶ���ԡ�ͨ��ӳ�䵽���ݱ��������
	@Id
	@Column(name = "news_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Lob
	private byte[] pic;
	@Enumerated(EnumType.STRING)
	private Season season;
	@Transient
	private int trans;
	@Temporal(TemporalType.DATE)
	private Date date;
	@ElementCollection(targetClass = String.class)
	@CollectionTable(name = "score_inf", joinColumns = @JoinColumn(name = "news_id"))
	@Column(name = "mark")
	@MapKeyColumn(name = "subject_name")
	@MapKeyClass(Integer.class)
	private Map<Integer, String> scores = new HashMap<>();

	public Map<Integer, String> getScores() {
		return scores;
	}

	public void setScores(Map<Integer, String> scores) {
		this.scores = scores;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getTrans() {
		return trans;
	}

	public void setTrans(int trans) {
		this.trans = trans;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

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
