package eql.al.demo.dao;
import java.util.List;

import javax.ejb.Local;

public interface IdataBase {
	public  List getAllSchoolDetails() ;
	public  String createNewSchool(String name, String phone, String adresse1, String email, String note);
	public  String deleteSchoolDetails(int schoolId);
	public  String updateSchoolDetails(int schoolId, String updatedSchoolName, String phone, String adresse1, String email, String note);
}
