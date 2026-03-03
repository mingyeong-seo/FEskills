package webprj.board1.daos.mvc;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import webprj.board1.dtos.BoardDTO;
import webprj.board1.dtos.mvc.MVCDTO;
import webprj.common.JDBCPooler;

public class MVCDAO extends JDBCPooler{
	public int insertWrite(MVCDTO dto) {
	      int res = 0;
	      
	      try {
	         String sql = "Insert into mvcboard(idx, name, title, content, ofile, sfile, pass) "
	               + " values(MVC_SEQ.nextval,?,?,?,?,?,?)"; 
	         
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, dto.getName());
	         pstmt.setString(2, dto.getTitle());
	         pstmt.setString(3, dto.getContent());
	         pstmt.setString(4, dto.getOfile());
	         pstmt.setString(5, dto.getSfile());
	         pstmt.setString(6, dto.getPass());
	         
	         res = pstmt.executeUpdate();
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      return res;
	   }	
	
	
	  public int selectCount(Map<String, Object> map) {
	      int totalCount = 0; 
	      
	      String sql = "SELECT COUNT(*) FROM mvcboard";
	      
	      if(map.get("searchWord") != null) { 
	         sql += " Where " + map.get("searchField") + " LIKE  '%" + 
	      map.get("searchWord") + "%'";
	      }
	      
	      try {
	         stmt = conn.createStatement(); 
	         rs = stmt.executeQuery(sql);  
	         rs.next();
	         
	         totalCount = rs.getInt(1);   
	      } catch (SQLException e) {
	         System.out.println(e.getMessage());
	         e.printStackTrace();
	      }
	      
	      return totalCount;
	   }
	  
	  public List<MVCDTO> selectList(Map<String, Object> map) {
	      List<MVCDTO> bbs = new ArrayList<>(); 
	      
	      String sql = "Select * from ( Select Tb.*, rownum rnum From ( Select * from mvcboard ";
	      if(map.get("searchWord") != null) {    
	         sql += " Where " + map.get("searchField") + " LIKE  '%" + 
	      map.get("searchWord") + "%'";
	      }
	      
	      sql += "   Order By idx DESC ) Tb ) where rnum Between ? And ?";
	      
	      try {
	         
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, map.get("start").toString());
	         pstmt.setString(2, map.get("end").toString());
	         
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            MVCDTO dto = new MVCDTO();
	            dto.setIdx(rs.getString("idx"));
	            dto.setName(rs.getString("name"));
	            dto.setTitle(rs.getString("title"));
	            dto.setContent(rs.getString("content"));
	            dto.setPostdate(rs.getDate("postdate"));
	            dto.setOfile(rs.getString("ofile"));
	            dto.setSfile(rs.getString("sfile"));
	            dto.setDowncount(rs.getInt("downcount"));
	            dto.setPass(rs.getString("pass"));
	            dto.setVisitcount(rs.getInt("visitcount"));
	            
	            bbs.add(dto);
	         }
	      } catch (Exception e) {
	         System.out.println(e.getMessage());
	         e.printStackTrace();
	      }
	      return bbs;
	   }
	   
}
