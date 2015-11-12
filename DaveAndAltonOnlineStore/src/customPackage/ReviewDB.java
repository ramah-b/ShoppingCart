package customPackage;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.Product;
import model.Review;
import customTools.DBUtil;


public class ReviewDB {
	
	public static void insert(Review review) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.persist(review);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e + "this is the insert exception");
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void update(Review review) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.merge(review);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void delete(Review review) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.remove(em.merge(review));
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		} 
		}

		public static List<Review> getReviews(Product product){
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select r from Review r where r.product = :product";
			TypedQuery<Review> q = em.createQuery(qString, Review.class);
			q.setParameter("product", product);
			List<Review> review = null;
			try {
				review = q.getResultList();
			}catch (NoResultException e){
				System.out.println(e);
			}finally{
				em.close();
			}
			return review;
		}
}
