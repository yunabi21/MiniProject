package member;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberRepository {

	// 회원가입
	public int insert(MemberDTO memberDTO) {

		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/jdbcTest";
			conn = DriverManager.getConnection(url, "root", "1234");

			sql = "INSERT INTO member VALUES (?, ?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDTO.getId());
			pstmt.setString(2, memberDTO.getPw());
			pstmt.setString(3, memberDTO.getName());
			pstmt.setString(4, memberDTO.getGender());
			pstmt.setString(5, memberDTO.getBirth());
			pstmt.setString(6, memberDTO.getEmail());
			pstmt.setString(7, memberDTO.getTel());

			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 정보수정
	public int update(MemberDTO memberDTO) {

		int result = 0;

		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/jdbcTest";
			conn = DriverManager.getConnection(url, "root", "1234");

			sql = "UPDATE member SET pw = ?, email = ?, tel = ? WHERE id = ?";

			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, memberDTO.getPw());
			pstmt.setString(2, memberDTO.getEmail());
			pstmt.setString(3, memberDTO.getTel());
			pstmt.setString(4, memberDTO.getId());

			result = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러 : " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	// 회원탈퇴
	public int delete(String id, String pw) {
		
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		String sql;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/jdbcTest";
			conn = DriverManager.getConnection(url, "root", "1234");
			
			sql = "DELETE FROM member WHERE id = ? AND pw = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			result = pstmt.executeUpdate();
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		catch (SQLException e) {
			System.out.println("에러 : " + e);
		}
		finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	// 회원리스트
	public List<MemberDTO> getList() {
		
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/jdbcTest";
			conn = DriverManager.getConnection(url, "root", "1234");
			
			sql = "SELECT id, pw, name, gender, birth, email, tel FROM member ORDER BY name ASC";
			
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				MemberDTO memberDTO = new MemberDTO();
				
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPw(rs.getString("pw"));
				memberDTO.setName(rs.getString("name"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setBirth(rs.getString("birth"));
				memberDTO.setEmail(rs.getString("email"));
				memberDTO.setTel(rs.getString("tel"));
				
				memberList.add(memberDTO);
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		catch (SQLException e) {
			System.out.println("에러 : " + e);
		}
		finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberList;
	}
	
	// 아이디검색
	public List<MemberDTO> getList(String id) {
		
		List<MemberDTO> memberList = new ArrayList<MemberDTO>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost/jdbcTest";
			conn = DriverManager.getConnection(url, "root", "1234");
			
			sql = "SELECT id, pw, name, gender, birth, email, tel FROM member WHERE id = ? ";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				MemberDTO memberDTO = new MemberDTO();
				
				memberDTO.setId(rs.getString("id"));
				memberDTO.setPw(rs.getString("pw"));
				memberDTO.setName(rs.getString("name"));
				memberDTO.setGender(rs.getString("gender"));
				memberDTO.setBirth(rs.getString("birth"));
				memberDTO.setEmail(rs.getString("email"));
				memberDTO.setTel(rs.getString("tel"));
				
				memberList.add(memberDTO);
			}
		}
		catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		catch (SQLException e) {
			System.out.println("에러 : " + e);
		}
		finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (pstmt != null && !pstmt.isClosed()) {
					pstmt.close();
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return memberList;
	}
}
