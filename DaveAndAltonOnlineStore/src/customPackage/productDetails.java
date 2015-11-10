package customPackage;

import java.io.IOException;
import java.math.BigDecimal;
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
					//productBean.setQuantity(p.getQuantity().intValue());
	
			}
			
		
			
			request.setAttribute("productBean", productBean);
		
			getServletContext()
			.getRequestDispatcher("/productDetails.jsp")
			.forward(request, response);
		
	}


}
