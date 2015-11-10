package customPackage;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.LineItm;
import model.Product;
import customTools.DBUtil;

public class LineItemDB {
	public static void insert(LineItm lineItem) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		System.out.println("before insert lineitem try");
		try {
		em.persist(lineItem);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e + "this is the insert exception");
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void update(LineItm lineItem) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.merge(lineItem);
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		}
		}

		public static void delete(LineItm lineItem) {
		EntityManager em = DBUtil.getEmFactory().createEntityManager();
		EntityTransaction trans = em.getTransaction();
		trans.begin(); 
		try {
		em.remove(em.merge(lineItem));
		trans.commit();
		} catch (Exception e) {
		System.out.println(e);
		trans.rollback();
		} finally {
		em.close();
		} 
		}
		
		public static List<LineItm> getLineItems(){
			EntityManager em = DBUtil.getEmFactory().createEntityManager();
			String qString = "select l from LineItm l";
			TypedQuery<LineItm> q = em.createQuery(qString, LineItm.class);
			List<LineItm> lineItem = null;
			try {
				lineItem = q.getResultList();
			}catch (NoResultException e){
				System.out.println(e);
			}finally{
				em.close();
			}
			return lineItem;
		}

}
