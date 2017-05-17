package hibernate;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.MapKeyClass;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

enum Season {
	spring, summer, autumn, winter
}

@Entity
// 声明该类是一个Hibernate的持久化类
@Table(name = "news_inf")
// 指定该类映射的表
public class News {
	private String data;
	// 指定该类的标识属性。通常映射到数据表的主键列
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
	private Name name;

	public Name getName() {
		return name;
	}

	public void setName(Name name) {
		this.name = name;
	}

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
