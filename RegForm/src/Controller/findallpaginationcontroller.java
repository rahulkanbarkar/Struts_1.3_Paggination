package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Beans.Student;
import dao.StudentDao;

public class findallpaginationcontroller extends Action{
	
@Override
public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
		HttpServletResponse response) throws Exception {
	// TODO Auto-generated method stub
	System.out.println("test 1");
	String spageid=request.getParameter("page"); 
	int pageid=Integer.parseInt(spageid);  
    int total=3;  
    if(pageid==1){}  
    else{  
        pageid=pageid-1;  
        pageid=pageid*total+1;  
    }  
    
    StudentDao dao = new StudentDao();
	ResultSet rsv = dao.findAll(pageid,total);
	
	List  list = new ArrayList();
	while (rsv.next()) {
		int id = rsv.getInt(1);
		String first_name = rsv.getString(2);
		String last_name = rsv.getString(3);
		String dob = rsv.getString(4);
		String city = rsv.getString(5);
		String password = rsv.getString(6);
		Student ef = new Student();
		ef.setId(id);
		ef.setFirst_name(first_name);
		ef.setLast_name(last_name);
		ef.setDob(dob);
		ef.setCity(city);
		ef.setPassword(password);
		list.add(ef);
	}
	System.out.println("controller " + Arrays.asList(list));
	request.setAttribute("reslist", list);
	return mapping.findForward("findAll");

}
}
