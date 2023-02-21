package Controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import Beans.Student;
import dao.StudentDao;

public class SelectAction extends Action{

	@Override
	public ActionForward execute(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Student s=(Student) form;
		StudentDao dao = new StudentDao();
		String idselected=request.getParameter("idSelected");
		System.out.println("idSelected"+idselected);
		ResultSet rsv=dao.find(Integer.parseInt(idselected));
		List<Student> list=new ArrayList<Student>();
		while(rsv.next()) {
			System.out.println(rsv.getString(2));
			int id=rsv.getInt(1);
			String first_name=rsv.getString(2);
			String last_name=rsv.getString(3);
			String dob=rsv.getString(4);
			String city=rsv.getString(5);
			String password=rsv.getString(6);
			Student ef=new Student();
			ef.setId(id);
			ef.setFirst_name(first_name);
			ef.setLast_name(last_name);
			ef.setDob(dob);
			ef.setCity(city);
			ef.setPassword(password);
			list.add(ef);
		}
		request.setAttribute("updatelist",list);
		return mapping.findForward("updatedelete");
	}
	}