package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import model.Student;
import util.HibernateUtil;

public class StudentDao implements IStudentDao {

	@Override
	public void saveStudent(Student student) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start the transaction
			transaction = session.beginTransaction();

			// save student object
			session.persist(student);

			// commit the transaction
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	@Override
	public void updateStudent(Student student) {

		Transaction transaction = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start the transaction
			transaction = session.beginTransaction();

			// save student object
			session.merge(student);

			// commit the transaction
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}
		}

	}

	@Override
	public Student getStudentById(long id) {

		Transaction transaction = null;
		Student student = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start the transaction
			transaction = session.beginTransaction();

			// get student object
			student = session.get(Student.class, id);

			// student = session.load(Student.class, id);
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}
		}
		return student;
	}

	@Override
	public List<Student> getAllStudents() {

		Transaction transaction = null;
		List<Student> students = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start the transaction
			transaction = session.beginTransaction();

			// get students
			students = session.createQuery("from Student").list();

			// student = session.load(Student.class, id);
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}
		}
		return students;
	}

	@Override
	public void deleteStudent(long id) {

		Transaction transaction = null;
		Student student = null;

		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			// start the transaction
			transaction = session.beginTransaction();

			student = session.get(Student.class, id);

			// get student object
			session.remove(student);

			// student = session.load(Student.class, id);
			// commit the transaction
			transaction.commit();

		} catch (Exception e) {

			if (transaction != null) {
				transaction.rollback();
			}

		}

	}

}
