package company;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginCheckAdminOrEmp {
	String login_id;
	String login_pw;
	ResultSet rs = null;
	
	public LoginCheckAdminOrEmp(ResultSet rs){
		this.rs = rs;
	}
	
	boolean CheckLogin(){ //���̵�� �н����尡 ��ġ�ϴ� ������� ������ true ��ȯ
		try {
			if(rs.first())	return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	boolean IdentifyAdmin(){ //���̵�� �н����尡 ��ġ�� �� �߿� ������� admin�̾�� true ��ȯ��
		try {
			if(rs.getInt("ID") == 0)	return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
