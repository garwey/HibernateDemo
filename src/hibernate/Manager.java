package hibernate;

import java.io.File;
import java.io.FileInputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Manager {
	public static void main(String[] args) throws Exception {
		// ʵ����Configuration
		Configuration conf = new Configuration().configure();
		// Configuration conf = new Configuration()
		// // ����addAnnotatedClass()������ӳ־û���
		// .addAnnotatedClass(hibernate.News.class);
		// ��Configurationʵ������SessionFactoryʵ��
		SessionFactory sf = conf.buildSessionFactory();
		// ����Session
		Session sess = sf.openSession();
		// ��ʼ����
		Transaction tx = sess.beginTransaction();
		// ������Ϣ����
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
		// ������Ϣ
		sess.save(n);
		// �ύ����
		tx.commit();
		sess.close();
		sf.close();
	}
}
