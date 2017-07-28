package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Manager {
	public static void main(String[] args) throws Exception {
		// 创建Session
		Session sess = HibernateUtil.currentSession();
		// 开始事务
		Transaction tx = sess.beginTransaction();
		// 创建消息对象
		User parent = new User();
		parent.setName("father");
		User u = new User();
		u.setName("son");
		u.setParent(parent);
		// 保存消息
		sess.save(u);
		// 执行原生sql
		sess.createSQLQuery(
				"INSERT INTO USER VALUES(" + ((long) 30) + ",'" + u.getName() + "'," + u.getParent().getId() + ")")
				.executeUpdate();
		// 修改信息
		u.setName("James");
		sess.update(u);
		// 提交事务
		tx.commit();
		HibernateUtil.closeSession();

		Manager m = new Manager();
		m.createAndStore();
		HibernateUtil.sessionFactory.close();
	}

	private void createAndStore() {
		Person person = new Person();
		person.setName(new Name("Jack", "Holms"));
		person.setEmail("someemail@163.com");
		person.setPet(new Cat("Miao", "Black"));

		Session session = HibernateUtil.currentSession();
		Transaction tx = session.beginTransaction();
		session.save(person);
		tx.commit();
		HibernateUtil.closeSession();
	}
}
