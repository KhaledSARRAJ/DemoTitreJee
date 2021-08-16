package eql.al.demo.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import eql.al.demo.entites.SchoolEntityManager;
@Stateless
public class DatabaseOperations implements IdataBase {

	@PersistenceContext(unitName = "MyCrud")
	private EntityManager entityManager;
	
	@Override
	public List<SchoolEntityManager> getAllSchoolDetails() {
		
		TypedQuery<SchoolEntityManager> sorgu = entityManager.createNamedQuery("school.findAll", SchoolEntityManager.class);
        return sorgu.getResultList();
	}
    public SchoolEntityManager getXContact(String name){
        return entityManager.find(SchoolEntityManager.class, name);
    }

	@Override
	public String createNewSchool(String name, String phone, String adresse1, String email, String note) {
		SchoolEntityManager newSchoolObj = new SchoolEntityManager();

		if (newSchoolObj.getId() == 0) {
			newSchoolObj.setName(name);
			newSchoolObj.setPhone(phone);
			newSchoolObj.setAddress1(adresse1);
			newSchoolObj.setEmail(email);
			newSchoolObj.setNote(note);
			
		}
		entityManager.persist(newSchoolObj); // INSERT INTO , auto_incr du numero
		entityManager.flush(); // UPDATE
		return "";
	}

	@Override
	public String deleteSchoolDetails(int schoolId) {
		SchoolEntityManager cpt = entityManager.find(SchoolEntityManager.class, schoolId);
		entityManager.remove(cpt);
		return "";

	}

//	SchoolEntityManager newSchoolObj = new SchoolEntityManager();
//	newSchoolObj.setId(schoolId);
//	newSchoolObj.setName(updatedSchoolName);
//	 entityManager.merge(newSchoolObj);
//	 FacesContext.getCurrentInstance().addMessage("editSchoolForm:schoolId", new FacesMessage("Votre article numéro" + schoolId + " a été bien modifier dans la base de données merci !"));
	 // Method To Update The School Details For A Particular School Id In The Database
    public  String updateSchoolDetails(int schoolId, String updatedSchoolName ,String phone, String adresse1, String email, String note) {

        if(isSchoolIdPresent(schoolId)) {
            Query queryObj = entityManager.createQuery("UPDATE SchoolEntityManager s SET s.name=:name WHERE s.id= :id");         
            queryObj.setParameter("id", schoolId);
            queryObj.setParameter("name", updatedSchoolName);
            int updateCount = queryObj.executeUpdate();
            if(updateCount > 0) {
                System.out.println("Record For Id: " + schoolId + " Is Updated");
            }
        }
        entityManager.flush();
        return "schoolEdit.xhtml";
    }
 
	private boolean isSchoolIdPresent(int schoolId) {
		boolean idResult = false;
		Query queryObj = entityManager.createQuery("SELECT s FROM SchoolEntityManager s WHERE s.id = :id");
		queryObj.setParameter("id", schoolId);
		SchoolEntityManager selectedSchoolId = (SchoolEntityManager) queryObj.getSingleResult();
		if (selectedSchoolId != null) {
			idResult = true;
		}
		return idResult;
	}
}
