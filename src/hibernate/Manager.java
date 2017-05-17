package hibernate;

import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Manager {
	public static void main(String[] args) throws Exception {
		// 实例化Configuration
		Configuration conf = new Configuration().configure();
		// Configuration conf = new Configuration()
		// // 调用addAnnotatedClass()方法添加持久化类
		// .addAnnotatedClass(hibernate.News.class);
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory();
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		// 创建消息对象
		News n = new News();
		// n.setId(001);
		File file = new File("test.txt");
		byte[] content = new byte[(int) file.length()];
		new FileInputStream(file).read(content);
		n.setPic(content);
		n.setData("d");
		n.setSeason(Season.summer);
		n.setTrans(666);
		n.setDate(new java.util.Date());
		// 保存消息
		sess.save(n);
		// 提交事务
		tx.commit();
		sess.close();
		sf.close();
	}
}
