package customPackage;

import java.io.IOException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Buyer;
import model.LineItm;
import model.Product;


/**
 * Servlet implementation class onlineServlet
 * This Servlet handles the Index.html, ProductList.JSP, ShoppingCart.JSP, ConfirmItem.JSP
 */
@WebServlet("/onlineServlet")
public class onlineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public onlineServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		
		if (action.equals("index"))
			processIndex(request,response);
		else if (action.equals("cart"))
			processCart(request,response);
		else if (action.equals("purchase"))
			processPurchase(request,response);
		else if(action.equals("continue"))
			processContinue(request, response);
		else if (action.equals("confirm"))
			processConfirm(request, response);
		else if (action.equals("login"))
			processLogin(request, response);
		else if (action.equals("register"))
			processRegister(request, response);
		else if (action.equals("NewUser"))
			processNewUser(request, response);
		else if (action.equals("homepage"))
			processHomepage(request, response);
		else if (action.equals("history"))
			processPurchaseHistory(request, response);
		else if (action.equals("logout"))
			processLogout(request, response);
		
		
	
	}

	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//System.out.println("in dopost");
		doGet(request, response);
		
	}

	
	private void processHomepage(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		getServletContext()
     	.getRequestDispatcher("/index.html")
     		.forward(request, response);
		
	}
	
	//to register and add new user to Buyer table
	private void processNewUser(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		Buyer newBuyer = new Buyer();
		
		HttpSession session = request.getSession();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");	
		String name = request.getParameter("name");		
		String email = request.getParameter("email");	
			
		if (!BuyerDB.usernameExists(username)){
			if (!BuyerDB.emailExists(email)){
				
		
			newBuyer.setName(name);
			newBuyer.setUsername(username);
			newBuyer.setPassword(password);
			newBuyer.setEmail(email);
			
			BuyerDB.insert(newBuyer);
			
			newBuyer = BuyerDB.selectBuyerUsername(username);
			
			ArrayList<LineItems> l_bean = new ArrayList<LineItems>();
			l_bean = (ArrayList<LineItems>) session.getAttribute("l_bean");
			
			if (l_bean != null || !(l_bean.isEmpty())){
				for (int i=0; i<l_bean.size(); i++){
					l_bean.get(i).setBuyer_id((int)newBuyer.getBuyerId());
				}
			}
			
		
			List<Product> p = ProductDB.getProducts();
			ArrayList<Products> productList = new ArrayList<Products>();
			if(p == null || p.isEmpty())
				productList = null;
			else 
			{
				for (int i =0; i< p.size(); i++){
					
					Products temp_p = new Products();
					temp_p.setProduct_id((int)p.get(i).getProductId());
					temp_p.setName(p.get(i).getName());
					temp_p.setDescription(p.get(i).getDescription());
					temp_p.setPrice(p.get(i).getPrice().doubleValue());
					temp_p.setCategory(p.get(i).getCategory());
					
					productList.add(i, temp_p);
					
					
				}
			}
			
		
			session.setAttribute("buyerUser", newBuyer);
			
				
			session.setAttribute("l_bean", l_bean);
			request.setAttribute("productList", productList);
			
		     getServletContext()
		     	.getRequestDispatcher("/productList.jsp")
		     		.forward(request, response);
			
		
		}else{
			String emailError = "Email Already Registered!";
			request.setAttribute("emailError", emailError);
			 getServletContext()
		     	.getRequestDispatcher("/NewUser.jsp")
		     		.forward(request, response);
			
		}
		}
			else{
		
			
			String message = "Username Exists.";
			
			request.setAttribute("message", message);
			
			
		     getServletContext()
		     	.getRequestDispatcher("/NewUser.jsp")
		     		.forward(request, response);
		}
			
	
		
	}

	//to direct user to register form page
	private void processRegister(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
		getServletContext()
     	.getRequestDispatcher("/NewUser.jsp")
     		.forward(request, response);
		
	}
	
	
	//First time the user start shopping and requests to view the product list
	private void processIndex(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
			
			List<Product> p = ProductDB.getProducts();
			ArrayList<Products> productList = new ArrayList<Products>();
			if(p == null || p.isEmpty())
				productList = null;
			else 
			{
				for (int i =0; i< p.size(); i++){
					
					Products temp_p = new Products();
					temp_p.setProduct_id((int)p.get(i).getProductId());
					temp_p.setName(p.get(i).getName());
					temp_p.setDescription(p.get(i).getDescription());
					temp_p.setPrice(p.get(i).getPrice().doubleValue());
					temp_p.setCategory(p.get(i).getCategory());
					
					productList.add(i, temp_p);
					
					
				}
			}
			
			Random rand = new Random();
			int user_id = rand.nextInt(500) + 1;
			//start a user session
			HttpSession session = request.getSession();
			session.setAttribute("user_id", user_id);
			ArrayList<LineItems> l_bean = new ArrayList<LineItems>();
			session.setAttribute("l_bean", l_bean);
			request.setAttribute("productList", productList);
			Buyer buyerUser = null;
			session.setAttribute("buyerUser", buyerUser);
			getServletContext()
			.getRequestDispatcher("/productList.jsp")
			.forward(request, response);
		
	}
	@SuppressWarnings({ "unchecked", "null" })
	
	
	
	
	private void processLogin(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
			
			HttpSession session = request.getSession();
			List<Product> p = ProductDB.getProducts();
			ArrayList<Products> productList = new ArrayList<Products>();
			if(p == null || p.isEmpty())
				productList = null;
			else 
			{
				for (int i =0; i< p.size(); i++){
					
					Products temp_p = new Products();
					temp_p.setProduct_id((int)p.get(i).getProductId());
					temp_p.setName(p.get(i).getName());
					temp_p.setDescription(p.get(i).getDescription());
					temp_p.setPrice(p.get(i).getPrice().doubleValue());
					temp_p.setCategory(p.get(i).getCategory());
					
					productList.add(i, temp_p);
					
					
				}
			}
			
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			Buyer buyerUser = BuyerDB.selectBuyer(username, password);
			
			if(buyerUser == null){
				String message = "Invalid Username and/or Password.";
				
				session.setAttribute("message", message);
				
				
			     getServletContext()
			     	.getRequestDispatcher("/index.jsp")
			     		.forward(request, response);
			}
				
			else 
			{
				
				//start a user session
				
				ArrayList<LineItems> l_bean = new ArrayList<LineItems>();
				l_bean = (ArrayList<LineItems>) session.getAttribute("l_bean");
				
				if (l_bean != null || !(l_bean.isEmpty())){
					for (int i=0; i<l_bean.size(); i++){
						l_bean.get(i).setBuyer_id((int)buyerUser.getBuyerId());
					}
				session.setAttribute("buyerUser", buyerUser);
				
				session.setAttribute("l_bean", l_bean);
				request.setAttribute("productList", productList);	
				}
			
			
			
		
			getServletContext()
			.getRequestDispatcher("/productList.jsp")
			.forward(request, response);
			}
		
	}
	
	
	//if there is an active session
	private void processContinue(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
			
			List<Product> p = ProductDB.getProducts();
			ArrayList<Products> productList = new ArrayList<Products>();
			if(p == null || p.isEmpty())
				productList = null;
			else 
			{
				for (int i =0; i< p.size(); i++){
					
					Products temp_p = new Products();
					temp_p.setProduct_id((int)p.get(i).getProductId());
					temp_p.setName(p.get(i).getName());
					temp_p.setDescription(p.get(i).getDescription());
					temp_p.setPrice(p.get(i).getPrice().doubleValue());
					temp_p.setCategory(p.get(i).getCategory());
					
					productList.add(i, temp_p);
					
					
				}
			}
			
			
			request.setAttribute("productList", productList);
		
			getServletContext()
			.getRequestDispatcher("/productList.jsp")
			.forward(request, response);
		
	}
	
	
	//View the shopping cart
	private void processCart(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
			
		ArrayList<LineItems> l_bean = new ArrayList<LineItems>();
		HttpSession session = request.getSession();
		double total = 0;
		
		String totalStr="";
		l_bean = (ArrayList<LineItems>) session.getAttribute("l_bean");
		Buyer b =(Buyer) session.getAttribute("buyerUser");
			
			if(l_bean == null || l_bean.isEmpty())
				l_bean = null;
			else{
			
			
			for (int i =0; i< l_bean.size(); i++){
				total += l_bean.get(i).getTotal_price();
			}
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			totalStr = df.format(total);
			}
			request.setAttribute("lineItemsList", l_bean);
			request.setAttribute("total", totalStr);
			request.setAttribute("buyerUser", b);
			getServletContext()
			.getRequestDispatcher("/shoppingCart.jsp")
			.forward(request, response);
		
	}
	
	//add an item to shopping cart
	private void processPurchase(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
			
		long product_id = Long.parseLong(request.getParameter("product_id"));
		System.out.println("inside process purchase" + product_id);
		int quantity =Integer.parseInt(request.getParameter("quantity"));
		Products productBean = new Products();
		LineItems lineItemBean = new LineItems();
		
		ArrayList<LineItems> l_bean = new ArrayList<LineItems>();
		HttpSession session = request.getSession();
		l_bean = (ArrayList<LineItems>) session.getAttribute("l_bean");
		Buyer buyerUser = (Buyer) session.getAttribute("buyerUser");
		
			Product p = ProductDB.getProduct(product_id);
			
			if(p == null)
				productBean = null;
			else 
			{
				
				//int new_quant = p.getQuantity().intValue() -1;
				//BigDecimal bd = new BigDecimal(new_quant);
				//p.setQuantity(bd);
			
				productBean.setPrice(p.getPrice().doubleValue());
				productBean.setName(p.getName());
				productBean.setProduct_id((int)p.getProductId());
			
				lineItemBean.setPrice(productBean.getPrice());
				lineItemBean.setProduct(productBean);
				lineItemBean.setQuantity(quantity);
				lineItemBean.setTotal_price(quantity*productBean.getPrice());
				if (buyerUser != null)
				lineItemBean.setBuyer_id((int)buyerUser.getBuyerId());
				
				l_bean.add(lineItemBean);
	
			}
			double total = 0;
			for (int i =0; i< l_bean.size(); i++){
				total += l_bean.get(i).getTotal_price();
			}
			DecimalFormat df = new DecimalFormat();
			df.setMaximumFractionDigits(2);
			String totalStr = df.format(total);
		
			
			session.setAttribute("l_bean", l_bean);
			request.setAttribute("lineItemBean", lineItemBean);
			request.setAttribute("total", totalStr);
			
		
			
		
			getServletContext()
			.getRequestDispatcher("/confirmItem.jsp")
			.forward(request, response);
		
	}

	//confirm purchase and add items to DB
	@SuppressWarnings("unchecked")
	private void processConfirm(HttpServletRequest request,
			HttpServletResponse response)throws ServletException, IOException {
			
		
		System.out.println("inside process confirm purchase");
		

		ArrayList<LineItems> l_bean = new ArrayList<LineItems>();
		HttpSession session = request.getSession();
		l_bean = (ArrayList<LineItems>) session.getAttribute("l_bean");
		Buyer buyerUser = (Buyer) session.getAttribute("buyerUser");
		ArrayList<LineItm> lineItemList = new ArrayList<LineItm>();
			
			if(l_bean == null || l_bean.isEmpty())
				l_bean = null;
			else 
			{
				for (int i=0; i<l_bean.size(); i++){
					LineItm l = new LineItm();
					
					
					BigDecimal bd = new BigDecimal(l_bean.get(i).getPrice());
					l.setPrice(bd);
					BigDecimal bd2 = new BigDecimal(l_bean.get(i).getTotal_price());
					l.setTotalprice(bd2);
					BigDecimal bd3 = new BigDecimal(l_bean.get(i).getQuantity());
					l.setQuantity(bd3);
					l.setBuyer(buyerUser);
					
					int product_id = l_bean.get(i).getProduct().getProduct_id();
					Product p = ProductDB.getProduct(product_id);
					
					System.out.println(p.getProductId());
				
					BigDecimal pQuant = p.getQuantity();
					if (pQuant.compareTo(bd3) != -1){
						pQuant = pQuant.subtract(bd3);
						p.setQuantity(pQuant);
					}else {
						l.setQuantity(bd3);
					}
					
					
					ProductDB.update(p);
					
					l.setProduct(p);
					
					LineItemDB.insert(l);
					lineItemList.add(i, l);
					
					
					
				}
			
			}

			session.setAttribute("l_bean", l_bean);
			request.setAttribute("lineItemsList", lineItemList);
			
		
			
		
			getServletContext()
			.getRequestDispatcher("/confirmPurchase.jsp")
			.forward(request, response);
		
	}
	
	//add new items to session's line item array list
	private void processPurchaseHistory(HttpServletRequest request,
		HttpServletResponse response)throws ServletException, IOException {
			
		ArrayList<LineItm> l_bean = new ArrayList<LineItm>();
		double total = 0;
		String totalStr="";
		HttpSession session = request.getSession();
		
		Buyer b =(Buyer) session.getAttribute("buyerUser");
			List<LineItm> l= (List<LineItm>) LineItemDB.getLineItems();
			if(l == null || l.isEmpty())
				l_bean = null;
			
			else{
				System.out.println(l.size());
			for (int i=0; i<l.size(); i++){
				if((int)l.get(i).getBuyer().getBuyerId() == (int)b.getBuyerId()){
				l_bean.add(l.get(i));
				total += l.get(i).getTotalprice().doubleValue();
				}
				DecimalFormat df = new DecimalFormat();
				df.setMaximumFractionDigits(2);
				totalStr = df.format(total);
			}
			
			
			}
			request.setAttribute("lineItemsList", l_bean);
			request.setAttribute("total", totalStr);
			request.setAttribute("buyerUser", b);
			getServletContext()
			.getRequestDispatcher("/shoppingHistory.jsp")
			.forward(request, response);
		
	}

	private void processLogout(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession session = request.getSession();
		//session.setAttribute("loginFlag", false);
		Buyer buyer = (Buyer)session.getAttribute("buyerUser");
		String username = buyer.getName();
		session.removeAttribute("buyerUser");
		request.removeAttribute("l_bean");
		try {
			request.setAttribute("username", username);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
