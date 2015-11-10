package customPackage;

import java.util.List;
import model.Product;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;



import customTools.DBUtil;

public class ProductDB {
	public static void insert(Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.persist(product);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e + "this is the insert exception");
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void update(Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.merge(product);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void delete(Product product) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.remove(em.merge(product));
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		} 
		}
		
		public static Product selectProduct(String name){
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select p from Product p where p.name = :name";
			TypedQuery<Product> q = em.createQuery(qString, Product.class);
			q.setParameter("name", name);
			Product product = null;
			try {
				product = q.getSingleResult();
			}catch (NoResultException e){
				System.out.println(e);
			}finally{
				em.close();
			}
			return product;
		}
		
		public static List<Product> getProducts(){
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select p from Product p";
			TypedQuery<Product> q = em.createQuery(qString, Product.class);
			List<Product> product = null;
			try {
				product = q.getResultList();
			}catch (NoResultException e){
				System.out.println(e);
			}finally{
				em.close();
			}
			return product;
		}
		
		public static Product getProduct(long product_id){
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select p from Product p where p.productId = :product_id";
			TypedQuery<Product> q = em.createQuery(qString, Product.class);
			q.setParameter("product_id", product_id);
			Product product = null;
			try {
				product = q.getSingleResult();
			}catch (NoResultException e){
				System.out.println(e);
			}finally{
				em.close();
			}
			return product;
		}
		
		
		public static boolean usernameExists(String name){
			Product p = selectProduct(name);
			return p != null;
		}


}
