package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class Manager {
	public static void main(String[] args) {
		// 实例化Configuration
		 Configuration conf = new Configuration().configure();
		// Configuration conf = new Configuration()
		// // 调用addAnnotatedClass()方法添加持久化类
		// .addAnnotatedClass(hibernate.News.class);

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(conf.getProperties()).buildServiceRegistry();
		// 以Configuration实例创建SessionFactory实例
		SessionFactory sf = conf.buildSessionFactory(serviceRegistry);
		// 创建Session
		Session sess = sf.openSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		// 创建消息对象
		News n = new News();
		// n.setId(001);
		// n.setData("001data");
		// 保存消息
		// sess.save(n);
		n = (News) sess.get(News.class, 001);
		System.out.print(n.getData());
		// 提交事务
		tx.commit();
		sess.close();
		sf.close();
	}

}
