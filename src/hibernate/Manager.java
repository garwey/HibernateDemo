package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Manager {
	public static void main(String[] args) {
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
		// n.setData("001data");
		// ������Ϣ
		// sess.save(n);
		n = (News) sess.get(News.class, 001);
		System.out.print(n.getData());
		// �ύ����
		tx.commit();
		sess.close();
		sf.close();
	}

}
