package org.zerock.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;

import org.apache.catalina.filters.SetCharacterEncodingFilter;
import org.zerock.domain.Store;



public class StoreDAO {

	
	String driverName = "oracle.jdbc.driver.OracleDriver";
	String jdbcURL = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
	String userName = "dclub";
	String userPw = "dclub";
	// 원래대로라면 서비스를 먼저 만드는 것이 맞다.
	// DAO에서는 웹에서 사용하는 API사용 x
	
	public void insert(Store store)throws Exception {
		
		
		// 디버깅용
		System.out.println("debug: insert "+ store);
		
		Class.forName(driverName);
		
		// SQL문 필요
		String sql = "insert into tbl_store(sno,name,lat,lng,menu)"
				+ "values (seq_store.nextval , ?, ? ,? ,? )";
		
		// Connection , PreparedStatement ,Resultset은 select에서만 -> insert는 return 이 1 row affected 이런식으로 나오므로
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(jdbcURL,userName,userPw);
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, store.getName());
			pstmt.setDouble(2, store.getLat());
			pstmt.setDouble(3, store.getLng());
			pstmt.setString(4, store.getMenu());
			
			pstmt.executeUpdate();
			
		}catch ( Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pstmt != null) { try {pstmt.close(); }catch(Exception e) { } }
			if(con != null) { try {con.close(); }catch (Exception e) { } }
		}
		// close
		
	}
		
	// 목록
	public List<Store> selectAll()throws Exception {
		
		// 확인용 가짜
		List<Store> storeList = new ArrayList<>();
		// sql
		String query = "SELECT * FROM tbl_store ORDER BY sno desc";
		
		// Connection , PreparedStatement , ResultSet
		
		
		Class.forName(driverName);
		// 먹쉬돈나

//			select sno,name,lat,lng,menu,
//	        	   regdate,updatedate
//			from tbl_store order by sno desc;
		
		
		
		try(Connection con = DriverManager.getConnection(jdbcURL,userName,userPw);
			PreparedStatement pstmt = con.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			){
				
			// 데이터의 개수를 모르므로 while 루프
			// 일단 한 칸내려 -> (rs.next) 읽어보고 데이터가 없으면 false가 된다
			while(rs.next()) {
				// 각각의 레코드는 store객체를 의미
				Store store = new Store();
				// rs.아무타입 -> 1번부터
				store.setSno(rs.getLong(1));
				store.setName(rs.getString(2));
				store.setLat(rs.getDouble(3));
				store.setLng(rs.getDouble(4));
				store.setMenu(rs.getString(5));
				store.setRegdate(rs.getDate(6));
				store.setUpdateDate(rs.getDate(7));
				
				storeList.add(store);
			}
			
			
			}catch(Exception e) {
				e.printStackTrace();
				throw e;
			}
		
		// close
		
		return storeList;
		//return null;
	}
	
	public Store selectOne(Long sno)throws Exception {
		
		Store result = new Store();
		
		String SQL ="SELECT * FROM TBL_STORE WHERE sno = ?";
		
		Class.forName(driverName);
		
		// sno,name,lat,lng,menu,
		// regdate, updatedate 
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try{
			
			con = DriverManager.getConnection(jdbcURL,userName,userPw);
			pstmt = con.prepareStatement(SQL);
			// 값을 넣어준다
			// 값이 있으므로 autoclosable이 아니다.
			pstmt.setLong(1, sno);
			
			// 값을 보낸다
			rs = pstmt.executeQuery();
			
			while(rs.next()) {

				result.setSno(rs.getLong(1));
				result.setName(rs.getString(2));
				result.setLat(rs.getDouble(3));
				result.setLng(rs.getDouble(4));
				result.setMenu(rs.getString(5));
				result.setRegdate(rs.getDate(6));
				result.setUpdateDate(rs.getDate(7));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(rs != null) { try {rs.close(); }catch(Exception e) {} }
			if(pstmt != null) { try {pstmt.close(); }catch(Exception e) {} }
			if(con != null) { try {con.close(); }catch(Exception e) {} }
		}
		
		return result;
	}
	// 삭제하는 메서드
	public void delete(Long sno)throws Exception {
		// 디버그를 위한 로그
		System.out.println("debug: delete "+ sno);
		
		// SQL문 필요
		String sql = "delete from tbl_store where sno = ?";
		
		Class.forName(driverName);
		
		// Connection , PreparedStatement ,Resultset은 select에서만 -> insert는 return 이 1 row affected 이런식으로 나오므로
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(jdbcURL,userName,userPw);
			pstmt = con.prepareStatement(sql);
			
			pstmt.setLong(1, sno);
			
			pstmt.executeUpdate();
			
		}catch ( Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pstmt != null) { try {pstmt.close(); }catch(Exception e) { } }
			if(con != null) { try {con.close(); }catch (Exception e) { } }
		}
	}
	// 수정하는 메서드
	public void update(Store store)throws Exception {
		String sql ="update tbl_store set name = ? , lat= ?, lng =?, menu =?, updatedate = sysdate where sno =?";
		
		Class.forName(driverName);
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection(jdbcURL,userName,userPw);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, store.getName());
			pstmt.setDouble(2, store.getLat());
			pstmt.setDouble(3, store.getLng());
			pstmt.setString(4, store.getMenu());
			pstmt.setLong(5, store.getSno());
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(pstmt != null) { try {pstmt.close(); }catch(Exception e) {} }
			if(con != null) { try {con.close(); }catch(Exception e) {} }
		}
	}
	
}
