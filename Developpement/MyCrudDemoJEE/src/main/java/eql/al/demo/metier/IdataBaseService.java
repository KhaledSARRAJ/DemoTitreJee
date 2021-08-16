package eql.al.demo.metier;
import java.util.List;

import javax.ejb.Local;
@Local
public interface IdataBaseService {
	public  List getAllSchoolDetails() ;
	public  String createNewSchool(String name, String phone, String adresse1, String phonee, String note);
	public  String deleteSchoolDetails(int schoolId);
	public  String updateSchoolDetails(int schoolId, String updatedSchoolName, String phone, String adresse1, String phonee, String note);
}
