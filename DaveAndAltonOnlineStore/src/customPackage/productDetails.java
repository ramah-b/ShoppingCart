package customPackage;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.math.BigDecimal;

import model.LineItm;
import model.Product;
import model.Review;

/**
 * Servlet implementation class productDetails
 */
@WebServlet("/productDetails")
public class productDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public productDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		if(action.equals("details"))
			processDetails(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	
	private void processDetails(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
			
		String product_id = request.getParameter("product_id");
		long p_id = Long.parseLong(product_id);
		System.out.println(product_id);
	
		
		Products productBean = new Products();
			Product p = ProductDB.getProduct(p_id);
			
			if(p == null)
				productBean = null;
			else 
			{
				
					
					
					productBean.setProduct_id((int)p.getProductId());
					productBean.setName(p.getName());
					productBean.setDescription(p.getDescription());
					productBean.setPrice(p.getPrice().doubleValue());
					productBean.setCategory(p.getCategory());
					productBean.setQuantity(p.getQuantity().intValueExact());
	
			}
			
			List<Review> r = ReviewDB.getReviews(p);
			ArrayList<Review> reviewList = new ArrayList<Review>();
			if(r == null || r.isEmpty())
				reviewList = null;
			else 
			{
				for (int i =0; i< r.size(); i++){
					
					
					Review temp_r = new Review();
					
						temp_r.setReviewId((int) r.get(i).getReviewId());
						temp_r.setText(r.get(i).getText());
						temp_r.setStars(r.get(i).getStars());
						temp_r.setReviewDate(r.get(i).getReviewDate());
						temp_r.setBuyer(r.get(i).getBuyer());
						temp_r.setProduct(r.get(i).getProduct());
					
						reviewList.add(i, temp_r);
						
					}
					
					
				}
			
		
			
			request.setAttribute("productBean", productBean);
			request.setAttribute("reviewList", reviewList);
			getServletContext()
			.getRequestDispatcher("/productDetails.jsp")
			.forward(request, response);
		
	}


}
