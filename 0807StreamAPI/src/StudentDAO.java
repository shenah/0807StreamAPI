import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

	//DB의 모든 데이터를 가져오고 저장하는 메소드
	public List<StudentDTO> fetch(){
		List <StudentDTO> list = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			pstmt = con.prepareStatement("select num, name, major, score, age, gender from student");
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				StudentDTO student = new StudentDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5), rs.getString(6));
				list.add(student);
			}
			
		} catch (Exception e) {
			//예외내용
			System.out.println(e.getMessage());
			//예외위치
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (Exception e) {}
		}
		return list;
	}
}
