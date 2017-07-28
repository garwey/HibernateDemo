package hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class Manager {
	public static void main(String[] args) throws Exception {
		// ����Session
		Session sess = HibernateUtil.currentSession();
		// ��ʼ����
		Transaction tx = sess.beginTransaction();
		// ������Ϣ����
		User parent = new User();
		parent.setName("father");
		User u = new User();
		u.setName("son");
		u.setParent(parent);
		// ������Ϣ
		sess.save(u);
		// ִ��ԭ��sql
		sess.createSQLQuery(
				"INSERT INTO USER VALUES(" + ((long) 30) + ",'" + u.getName() + "'," + u.getParent().getId() + ")")
				.executeUpdate();
		// �޸���Ϣ
		u.setName("James");
		sess.update(u);
		// �ύ����
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
