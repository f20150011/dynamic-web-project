package com.sapient.order.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sapient.order.dto.Order;
import com.sapient.order.service.IOrderService;
import com.sapient.order.service.OrderServiceImpl;

@WebServlet("/hello")
public class OrderServlet extends HttpServlet {
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("hit by demo");
////		resp.setHeader("token", "f348hfa93497fawefuih");
//		String company = req.getHeader("company");
//		String headquater = req.getHeader("headquater");
//		System.out.println(headquater);
//		resp.setHeader("company", "publicis."+company);
////		resp.setHeader("location", "http://www.google.com");
////		resp.setStatus(301);
//		Enumeration<String> headers=req.getHeaderNames();
//        while(headers.hasMoreElements()) 
//        { 
//        	String header = headers.nextElement();
//            String pvalue=req.getHeader(header); 
//            System.out.println(header+" "+pvalue);
//        } 
//        
//        PrintWriter writer = resp.getWriter();
//        writer.println("<b>Hello Internet</b>");
//		
//	}
//	
//	@Override
//	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.println("Hola");
////        PrintWriter writer = resp.getWriter();
////        writer.println("<b>Hello Internet from POST</b>");
//	}
	
	IOrderService orderService = new OrderServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Order order = new Order();
		String company = req.getParameter("company");
		String location = req.getParameter("location");
		Float price = Float.valueOf(req.getParameter("price"));
		order.setCompany(company);
		order.setLocation(location);
		order.setPrice(price);
		orderService.processOrder(order);
//		String res[] = req.getParameterValues("subjects");
//		for (String string : res) {
//			System.out.println(string);
//		}
	}
	
}
