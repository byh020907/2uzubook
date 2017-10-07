package company;

import org.json.simple.JSONArray;

import dao.Database;

public class CompanyDAO extends Database{
	
	private static CompanyDAO instance;
	
	private CompanyDAO(){}

	public static CompanyDAO getInstance(){
		if(instance==null)
			instance=new CompanyDAO();
		return instance;
	}
	
	public int login(String serialKey) {
		String SQL="select `key` from company where `key`=?";
		
		JSONArray ja=executeAndGet(SQL,serialKey);
		
		//디비오류
		if(ja==null)
			return -1;
		
		//로그인
		if(ja.size()==1)
			return 1;//성공
		else
			return 0;//실패
	}
	
	public int join(Company company) {
		String SQL="insert into company (name, email, `key`, keyword) values (?,?,?,?)";

		try {
			return executeAndUpdate(SQL, company.getName(),company.getEmail(),company.getKey(),company.getKeyword());
		}catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
