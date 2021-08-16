package eql.al.demo.web;


import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import eql.al.demo.metier.IdataBaseService;
import eql.al.demo.metier.SchoolServiceImpl;




@ManagedBean
@SessionScoped
public class SchoolBean{
	@EJB
	private IdataBaseService data;
	
	private int id;
	private String name;		 
	private String phone;
	private String email;
	private String address1;
	private String note;
	private String editSchoolId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public IdataBaseService getData() {
		return data;
	}

	public void setData(IdataBaseService data) {
		this.data = data;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEditSchoolId() {
		return editSchoolId;
	}

	public void setEditSchoolId(String editSchoolId) {
		this.editSchoolId = editSchoolId;
	}

	// Method To Fetch The Existing School List From The Database
	public List schoolListFromDb() {
		return data.getAllSchoolDetails();		
	}

	// Method To Add New School To The Database
	public String addNewSchool(SchoolBean schoolBean) {
		 data.createNewSchool(schoolBean.getName(),schoolBean.getEmail(),schoolBean.getPhone(),schoolBean.getNote(),schoolBean.getAddress1());
		 return "schoolsList.xhtml";
	}

	// Method To Delete The School Details From The Database
	public String deleteSchoolById(int schoolId) {		
		 data.deleteSchoolDetails(schoolId);		
		 return	"schoolsList.xhtml?faces-redirect=true";
	}

	  // Method To Navigate User To The Edit Details Page And Passing Selecting School Id Variable As A Hidden Value
    public String editSchoolDetailsById() {
        editSchoolId = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("selectedSchoolId");     
        return "schoolEdit.xhtml";
    }
 
    // Method To Update The School Details In The Database
    public String updateSchoolDetails(SchoolBean schoolBean) {
        return data.updateSchoolDetails(Integer.parseInt(schoolBean.getEditSchoolId()), schoolBean.getName(), schoolBean.getPhone(), schoolBean.getAddress1(), schoolBean.getEmail(), schoolBean.getNote() );        
    }
}