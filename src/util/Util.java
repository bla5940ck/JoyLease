package util;

// �Q�����O�ŧi�`�ơA�Y�i�ΩI�s���覡�ϥΡA�����@�]��²��
public class Util {
	
	public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	
	// MySQL 8.0.13�H��u�ݫO�dserverTimezone�]�w�Y�i
	public static final String URL = 
			"jdbc:mysql://localhost:3306/JoyLease?"
//			+ "useSSL=false&"                   // ���ϥΥ[�K�s�u (�ݦ����Ҥ~��)
			+ "rewriteBatchedStatements=true&"  // �妸��s�ݭn����T
			+ "serverTimezone=Asia/Taipei";     // �]�w�ɰϸ�T
//			+ "allowPublicKeyRetrieval=true&"   // �t�XMySQL 8�H�᪩����K�X�x�s����]�w
//			+ "useUnicode=true&"                // �ϥ�Unicode�s�X (����~���|�ýX)
//			+ "characterEncoding=utf-8";        // �r���ĥ�UTF-8�]�w
	
	public static final String USER = "root";
	
	public static final String PASSWORD = "password";
}
