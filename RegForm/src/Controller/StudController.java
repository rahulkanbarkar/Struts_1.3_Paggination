package Controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.RequestContext;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import Beans.Student;
import dao.StudentDao;



public class StudController extends DispatchAction {
	public RequestContext req;
	public ActionForward save(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		System.out.println("Save");
		ResultSet rsv =null;
		Student s = (Student) af;
		String dob = req.getParameter("dob");
		System.out.println(dob);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd"); // your template here
		java.util.Date date = formatter.parse(dob);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime()); 
		 long millis=System.currentTimeMillis();  
		  java.sql.Date currdate = new java.sql.Date(millis);   
		  System.out.println("Currdate: "+ currdate);
		if(currdate.after(sqlStartDate)){
			System.out.println(currdate + "is before >" +sqlStartDate);
			StudentDao dao = new StudentDao();
			int i = dao.save(s);
			if (i != 0)
				return am.findForward("success");
			else
				return am.findForward("failreg");
			
	}
		else 
			return am.findForward("failreg");
	}
	
	
	  public ActionForward findall(ActionMapping am, ActionForm af,
	  HttpServletRequest req, HttpServletResponse res) throws Exception 
	  {
	  StudentDao dao = new StudentDao(); 
	  ResultSet rsv = dao.findAll();
	  
	  List list = new ArrayList();
	  while (rsv.next()) {
	  int id = rsv.getInt(1);
	  String first_name = rsv.getString(2); 
	  String last_name = rsv.getString(3);
	  String dob = rsv.getString(4);
	  String city = rsv.getString(5);
	  String
	  password = rsv.getString(6);
	  Student ef = new Student(); 
	  ef.setId(id);
	  ef.setFirst_name(first_name); 
	  ef.setLast_name(last_name);
	  ef.setDob(dob);
	  ef.setCity(city); 
	  ef.setPassword(password);
	  list.add(ef);
	  
	  
	  } 
	  req.setAttribute("reslist", list);
	  return am.findForward("findAll");
	  }
	 
	
	
	
	
	  public ActionForward delete(ActionMapping am, ActionForm af,
	  HttpServletRequest req, HttpServletResponse res) throws Exception 
	  {
	  Student s= (Student) af; 
	  StudentDao dao = new StudentDao(); 
	  boolean b = dao.delete(s);
	  ResultSet rsv = dao.findAll();
	  List list = new ArrayList();
	  while(rsv.next()) 
	  { 
	  int id = rsv.getInt(1);
	  String first_name = rsv.getString(2);
	  String last_name = rsv.getString(3); 
	  String dob = rsv.getString(4); String
	  city = rsv.getString(5); 
	  String password = rsv.getString(6); 
	  s = new Student(); 
	  s.setId(id);
	  s.setFirst_name(first_name);
	  s.setLast_name(last_name);
	  s.setDob(dob); 
	  s.setCity(city);
	  s.setPassword(password); 
	  list.add(s);
	  s = null; 
	  } 
	  req.setAttribute("reslist", list);
	  if (b == true) 
	  return am.findForward("findAll");
	  else return am.findForward("fail");
	  }
	 
	
	  public ActionForward update(ActionMapping am, ActionForm af,
	  HttpServletRequest req, HttpServletResponse res) throws Exception
	  { 
	  Student s = (Student) af; 
	  StudentDao dao = new StudentDao(); 
	  boolean b = dao.update(s);
	  
	  ResultSet rsv = dao.findAll(); 
	  List list = new ArrayList(); 
	  while (rsv.next()) { 
	  int id = rsv.getInt(1);
	  String first_name = rsv.getString(2);
	  String last_name = rsv.getString(3); 
	  String dob = rsv.getString(4);
	  String city = rsv.getString(5); 
	  String password = rsv.getString(6); 
	  s = new Student();
	  s.setId(id); 
	  s.setFirst_name(first_name);
	  s.setLast_name(last_name); 
	  s.setDob(dob); 
	  s.setCity(city);
	  s.setPassword(password); 
	  list.add(s); 
	  s = null;
	  } 
	  req.setAttribute("reslist", list);
	  if (b == true)
	  return am.findForward("findAll");
	  else return am.findForward("fail");
	  
	  }
	 
	
	public ActionForward search(ActionMapping am, ActionForm af, HttpServletRequest req, HttpServletResponse res)
			throws Exception {
		Student s = (Student) af;
		System.out.println("Search");
		StudentDao dao = new StudentDao();
		ResultSet rsv = dao.findempcrud(s);
		List list = new ArrayList();
		while (rsv.next()) {
			System.out.println(rsv.getString(2));
			int id = rsv.getInt(1);
			String first_name = rsv.getString(2);
			String last_name = rsv.getString(3);
			String dob = rsv.getString(4);
			String city = rsv.getString(5);
			String password = rsv.getString(6);
			Student ef = new Student();
			ef.setId(id);
			ef.setFirst_name(first_name);
			s.setLast_name(last_name);
			s.setDob(dob);
			s.setCity(city);
			s.setPassword(password);
			list.add(s);
			
		}
		req.setAttribute("reslist", list);
		return am.findForward("search");

	}


}
