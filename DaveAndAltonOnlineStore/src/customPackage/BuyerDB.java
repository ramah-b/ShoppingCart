package customPackage;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Buyer;
import customTools.DBUtil;

public class BuyerDB {
	
	public static void insert(Buyer buyer) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.persist(buyer);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e + "this is the insert exception");
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void update(Buyer buyer) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.merge(buyer);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void delete(Buyer buyer) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.remove(em.merge(buyer));
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		} 
		}
		//new methods to select a user by username and check if a username already exists
		public static Buyer selectBuyer(String username, String password){
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			username = username.toLowerCase();
			String qString = "select b from Buyer b where b.username = :username and b.password = :password";
			TypedQuery<Buyer> q = em.createQuery(qString, Buyer.class);
			q.setParameter("username", username);
			q.setParameter("password", password);
			Buyer buyer = null;
			try {
				buyer = q.getSingleResult();
			}catch (NoResultException e){
				System.out.println(e);
			}finally{
				em.close();
			}
			return buyer;
		}
		
		public static Buyer selectBuyerUsername(String username){
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			username = username.toLowerCase();
			String qString = "select b from Buyer b where b.username = :username";
			TypedQuery<Buyer> q = em.createQuery(qString, Buyer.class);
			q.setParameter("username", username);
			Buyer buyer = null;
			try {
				buyer = q.getSingleResult();
			}catch (NoResultException e){
				System.out.println(e);
			}finally{
				em.close();
			}
			return buyer;
		}
		
		public static boolean usernameExists(String username){
			Buyer b = selectBuyerUsername(username);
			return b != null;
		}
		
		
		public static Buyer selectBuyerEmail(String email){
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			email = email.toLowerCase();
			String qString = "select b from Buyer b where b.email = :email";
			TypedQuery<Buyer> q = em.createQuery(qString, Buyer.class);
			q.setParameter("email", email);
			Buyer buyer = null;
			try {
				buyer = q.getSingleResult();
			}catch (NoResultException e){
				System.out.println(e);
			}finally{
				em.close();
			}
			return buyer;
		}
		
		public static boolean emailExists(String email){
			Buyer b = selectBuyerEmail(email);
			return b != null;
		}
		
}
