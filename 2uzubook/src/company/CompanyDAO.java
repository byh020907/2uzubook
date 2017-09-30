package company;

import dao.Database;
import user.UserDAO;

public class CompanyDAO extends Database{
	
	private static CompanyDAO instance;

	public static CompanyDAO getInstance(){
		if(instance==null)
			instance=new CompanyDAO();
		return instance;
	}
	
	public int join(Company company) {
		String SQL="insert into company (name,email,key,keyword) values (?,?,?,?)";

		try {
			return executeAndUpdate(SQL, company.getName(),company.getEmail(),company.getKey(),company.getKeyword());
		}catch (Exception e) {
			// TODO: handle exception
		}
		return -1;
	}

}
