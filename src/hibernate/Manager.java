package hibernate;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Manager {
	public static void main(String[] args) throws Exception{
		// ʵ����Configuration
		Configuration conf = new Configuration().configure();
		// Configuration conf = new Configuration()
		// // ����addAnnotatedClass()������ӳ־û���
		// .addAnnotatedClass(hibernate.News.class);

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(conf.getProperties()).buildServiceRegistry();
		// ��Configurationʵ������SessionFactoryʵ��
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// ����Session
		Session sess = sf.openSession();
		// ��ʼ����
		Transaction tx = sess.beginTransaction();
		// ������Ϣ����
		News n = new News();
		// n.setId(001);
		n.setData("001data");
		File file = new File("test.jpg");
		byte[] content = new byte[(int) file.length()];
		new FileInputStream(file).read(content);
		n.setPic(content);
		// ������Ϣ
		//sess.save(n);
		n = (News) sess.get(News.class, 001);
		File file2 = new File("C:/Users/GARWEY/Desktop/new.jpg");
		content = n.getPic();
		new FileOutputStream(file2).write(content);
		
		//System.out.print(n.getPic());
		// �ύ����
		tx.commit();
		sess.close();
		sf.close();
	}
}
