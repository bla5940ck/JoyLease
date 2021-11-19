package util;

public class Util {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	// MySQL 8.0.13���蕭��嚙踝蕭�豲蕭謒rverTimezone���蕭謍堆嚙踐
	public static final String URL = 
			"jdbc:mysql://localhost:3306/Joylease?"
//			+ "useSSL=false&"                   
//			+ "rewriteBatchedStatements=true&"  
			+ "serverTimezone=Asia/Taipei&"  
//			+ "allowPublicKeyRetrieval=true&" 
			+ "useUnicode=true&"                
			+ "characterEncoding=utf-8";        
	
	public static final String USER = "root";
	
	public static final String PASSWORD = "password";
}
