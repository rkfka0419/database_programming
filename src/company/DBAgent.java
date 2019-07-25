package company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class DBAgent {
	static Connection con = null;
	static Statement stmt = null;
	static ResultSet rs   = null ;
	static PreparedStatement  prStmt = null;
	
	// DBAgent ��ü�� �����ϰ� Local�� MySql ������ �����Ű�� �޼ҵ�
	// ���� �� ������ Connection ��ü�� con ��������� ����Ǹ�
	// ������ DBAgent ��ü�� ��ȯ��
	public static void getConnection(){
		//DBAgent agent = new DBAgent();
		String server = "localhost:3306"; 

		String database = "company"; 
		String username = "root";
		String password = "1234";
		
		try {
			Class c = Class.forName("org.gjt.mm.mysql.Driver");
			System.out.println("   <for debug>DB접속 성공 " + c);
		} catch (ClassNotFoundException e) {
			System.err.println("\n  ?? ����̹� �ε� ����: " + e.getMessage() );
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://" + server  + "/" + database,
					username, password );
			System.out.println("con 연결 성공");
			stmt = con.createStatement();
		} catch (SQLException e) {
			System.err.println("\n  ?? DBMS���� ���� ����:" + e.getMessage() );
			e.printStackTrace();
		}
		//return agent;
	}
	
	
	public ResultSet CheckLogin(int login_id, String login_pw){
		//String sql = "Select * from employee where id ="+ login_id+" and epw=PASSWORD('"+login_pw+"');";
		String sql = "Select * from employee where id = ? and epw=PASSWORD(?);";
		//String sql = "Select * from employee where id = ? and epw=?;";
		try {
			prStmt = con.prepareStatement(sql);
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		try {
			prStmt.setInt(1, login_id);
			prStmt.setString(2, login_pw);
			rs = prStmt.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return rs;
	}
	public int login(ResultSet rs){
		LoginCheckAdminOrEmp login = new LoginCheckAdminOrEmp(rs);
		if(login.CheckLogin() && login.IdentifyAdmin()) return 1;//에드민페이지로 가는 소스 추가
		else if(login.CheckLogin() && login.IdentifyAdmin() == false) return 2;  //직원메뉴로 가는 소스 추가
		return 3; //실패
	}
	
	//�����ڰ� ����� ������̺� ����Ѵ�.
	public int executeInsertWorker(){
		int cnt = 0;
		//��� ������ȣ�� ����Ʈ �Ͻ� "0000" �� ����.
		String sql = "insert into employee values(?,?,?,?,?,?,PASSWORD(?),?)";
		System.out.println("** ����� ����� ������ �Է��� �ּ���! **");
		System.out.print("�����ȣ : "); int ID = SkScanner.getInt();
		System.out.print("����̸� : "); String ename = SkScanner.getString();
		System.out.print("���� : "); String grade = SkScanner.getString();
		System.out.print("���� : "); String sex = SkScanner.getString();
		System.out.print("���� : "); int age = SkScanner.getInt();
		System.out.print("���� : "); String state = SkScanner.getString();
		System.out.print("��й�ȣ : "); String pw = SkScanner.getString();
		System.out.print("�μ� : "); String part = SkScanner.getString();
		try {
			prStmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			
			prStmt.setInt(1, ID);
			prStmt.setString(2, ename);
			prStmt.setString(3, grade);
			prStmt.setString(4, sex);
			prStmt.setInt(5, age);
			prStmt.setString(6, state);
			prStmt.setString(7, pw);
			prStmt.setString(8, part);
			cnt = prStmt.executeUpdate();
			//rs = prStmt.executeQuery();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return cnt;
	}
	
	//�μ���� �޼ҵ�
	public int executeInsertDepartment(){

		int cnt = 0;
		//�μ� ���
		String sql = "insert into department values(?,?,?,?)";
		System.out.println("** ����� �μ��� ������ �Է��� �ּ���! **");
		System.out.print("�μ���ȣ : "); int did = SkScanner.getInt();
		System.out.print("�μ��̸� : "); String dname = SkScanner.getString();
		System.out.print("��ġ : "); String location = SkScanner.getString();
		System.out.print("�μ��� : "); String head = SkScanner.getString();
		
		
		try {
			prStmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			prStmt.setInt(1, did);
			prStmt.setString(2, dname);
			prStmt.setString(3, location);
			prStmt.setString(4, head);
			
			cnt = prStmt.executeUpdate();
			//rs = prStmt.executeQuery();
			System.out.println("�μ��� ��� �Ǿ����ϴ� !!!");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		return cnt;
	}
	
	//�μ� ���� �޼ҵ�
	public int executeModifyDepartment(int number){
		int cnt= 0;
		department dep = new department();
		String sql = "update department set dname = ?, location =?,head = ? where did =  "+number+";";
		System.out.println("�μ���ȣ : "+number +"\t�� ���� ������ �Է��� �ּ���!");
		//System.out.print("�μ���ȣ : "); int did = SkScanner.getInt();
		System.out.print("�μ��̸� : "); String dname = SkScanner.getString();
		System.out.print("��ġ : "); String location = SkScanner.getString();
		System.out.print("�μ��� : "); String head = SkScanner.getString();
		//dep.setDid(did);
		dep.setDname(dname);
		dep.setLocation(location);
		dep.setHead(head);
		try {
			prStmt = con.prepareStatement(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			//prStmt.setInt(1, dep.getDid());
			prStmt.setString(1, dep.getDname());
			prStmt.setString(2,dep.getLocation());
			prStmt.setString(3,dep.getHead());
			cnt = prStmt.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cnt;
	}
	
	//��� ���� �޼ҵ�
		public int executeModifyWorker(int number){
			int cnt= 0;
			employee worker = new employee();
			String sql = "update employee set ename = ?, grade =?,sex = ?,age=?,part=? where ID ="+number+";";
			System.out.println("��� : "+number +"\t�� ���� ������ �Է��� �ּ���!");
			//System.out.print("�μ���ȣ : "); int did = SkScanner.getInt();
			System.out.print("�̸� : "); String ename = SkScanner.getString();
			System.out.print("���� : "); String grade = SkScanner.getString();
			System.out.print("���� : "); String sex = SkScanner.getString();
			System.out.print("���� : "); int age = SkScanner.getInt();
			System.out.print("�μ� : "); String part = SkScanner.getString();
			
			worker.setEname(ename);
			worker.setGrade(grade);
			worker.setSex(sex);
			worker.setAge(age);
			worker.setPart(part);
			
			try {
				prStmt = con.prepareStatement(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				//prStmt.setInt(1, dep.getDid());
				prStmt.setString(1,worker.getEname() );
				prStmt.setString(2,worker.getGrade());
				prStmt.setString(3,worker.getSex());
				prStmt.setInt(4,worker.getAge());
				prStmt.setString(5,worker.getPart());
				cnt = prStmt.executeUpdate();
				
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			return cnt;
		}
	//�μ� ���� 
	public int executeDeleteDepartment(int num){
		int cnt = 0;
		department dep = new department();
		String sql =  "delete from department where did = "+num+";";
		try {
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnt;
	}
	//��� ���� 
		public int executeDeleteWorker(int num){
			int cnt = 0;
			department dep = new department();
			String sql =  "delete from employee where ID = "+num+";";
			try {
				cnt = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cnt;
		}
	// �־��� SQL ���� �����Ͽ�  ResultSet ��ü ��ȯ
	public ResultSet executeSelect(String sql) {
		ResultSet rs = null;;			
		try {
			rs = stmt.executeQuery(sql);
		}
		catch( SQLException ex ) {               
			System.err.println("SQL�� ������ ����:" + ex.getMessage() );        
		}
			
			return rs;
		}
	
	
	//��� �μ��� �����Ͽ� ResultSet ��ü ��ȯ
	//��� �μ��� �����ش�.
	public ResultSet executeSelectAllDepartment() {
		return executeSelect("select * from department;");
		}
	
	//�ش� �̸��� ��� ã��
	//�ش� �̸��� ���� ��� ������� �����ش�(�������� �� ������ �ֱ� ������ )
	public ResultSet executeSerachWorker(String ename){
		String sql = "select * from employee where ename ='"+ename+"';";
		return executeSelect(sql);
	}
	//�ش� ID�� ��� ���� ��� �޼ҵ� (�̸޼ҵ忡�� id�� ���� ����� �̸��� �����´�.)
	public ResultSet executeSerachWorkerNameByID(int id){
		String sql = "select * from employee where ID = "+id+";";
		return executeSelect(sql);
	}
	//�޼��� ������
	public int sendMessage(String title,String body,String sender,String receiver, String sendtime ){
		int cnt = 0;
		String sql ="insert into message (title,body,sender,receiver,sendtime) values"
				+ "('"+title+"','"+body+"','"+sender+"','"+receiver+"','"
				+sendtime+"');";
		try {
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	//----------------�޼��� ���� ���� DB�޼ҵ�--------------------
	//id��� ���� �� �޼��� ����� �����ش�
	public ResultSet executeReceiveMessageList(int id){
		return executeSelect("select * from message,employee where message.receiver=employee.ename and"
				+ " employee.ID ="+id+";");
	}
	//�ش� �޼�����ȣ �� �޼����� ��� ������ �����ش�.
	public ResultSet executeReceiveMessageBody(int mnumber){
		String sql = "select * from message where mnumber = "+mnumber+";";
		return executeSelect(sql);
	}
	//----------------------------------------------------
	
	//-----------------�޼��� ���� ���� DB�޼ҵ�---------------------
	public int updatePasswordById(int id,String password){
		int cnt = 0;
		String sql = "update employee set epw =PASSWORD ('"+password+"')where id ="+id+";";
		try {
			cnt = stmt.executeUpdate(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	//��������
	public void close() {
		try {
			// ������ �ݴ´�.
			if( stmt != null ) this.stmt.close();
			if( con != null ) this.con.close();

		} catch (SQLException ex ) {};    

		System.out.print("Good bye!!!");

	} 
}

