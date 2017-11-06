package resume;

public interface SQL_Command {
	
	//resume
	public static String INSERT_CERT_SQL="insert into cert (user,name,ins,date,keyword) values (?,?,?,?,?)";
	public static String INSERT_AWARD_SQL="insert into award (user,name,ins,grade,date,keyword) values (?,?,?,?,?,?)";
	public static String INSERT_CLUB_SQL="insert into club (user,name,`desc`,startdate,enddate,keyword) values (?,?,?,?,?,?)";
	public static String INSERT_PROJECT_SQL="insert into project (user,name,`desc`,startdate,enddate,keyword) values (?,?,?,?,?,?)";
	public static String INSERT_TEST_SQL="insert into test (user,name,score,date,keyword) values (?,?,?,?,?)";
	public static String INSERT_CONFERENCE_SQL="insert into conference (user,name,date,keyword) values (?,?,?,?)";
	
	//etc
	public static String INSERT_VOLUNTEER_SQL="insert into volunteer (user,name,ins,starttime,endtime,keyword) values (?,?,?,?,?,?)";
	public static String INSERT_READINF_SQL="insert into reading (user,name,date,keyword) values (?,?,?,?)";


}
