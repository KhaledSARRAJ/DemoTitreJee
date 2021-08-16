package eql.al.demo.metier;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import eql.al.demo.dao.IdataBase;
import eql.al.demo.entites.SchoolEntityManager;

@Stateless
public class SchoolServiceImpl implements  IdataBaseService{
	//@EJB (pour injecter EJB seulement)
	@Inject // (pour injecter n'imporquel type d'élément géré par le conteneur)
	private IdataBase dataDao;

	
	@Override
	public List getAllSchoolDetails() {
		// TODO Auto-generated method stub
		return dataDao.getAllSchoolDetails();
	}

	@Override  
	public String createNewSchool(String name, String phone, String adresse1, String email, String note) {
		dataDao.createNewSchool(name,phone,  adresse1, email, note);
		return "Article bien ajouter";	
	}

	@Override
	public String deleteSchoolDetails(int schoolId) {
		dataDao.deleteSchoolDetails(schoolId);
		return "article bien supprimer";

	}

	@Override
	public String updateSchoolDetails(int schoolId, String updatedSchoolName, String phone, String adresse1, String email, String note) {
		dataDao.updateSchoolDetails(schoolId, updatedSchoolName,phone,adresse1, email,note);
		return "article a jour";
	}

}
