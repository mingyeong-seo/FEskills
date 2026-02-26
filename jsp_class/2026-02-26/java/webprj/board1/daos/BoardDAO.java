package webprj.board1.daos;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.RowSetInternal;

import webprj.board1.dtos.BoardDTO;
import webprj.common.JDBCPooler;

public class BoardDAO extends JDBCPooler {
   
   public void updateVisitCount(int num) {
      String sql = "Update Board "
            + "set visitcount = visitcount + 1 where num = ?";
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, num);
         pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
   

   public BoardDTO getArticle(int num) {

      BoardDTO dto = new BoardDTO();
      
      String sql = "Select m.name, b.* from member m inner join board b "
            + "On m.id = b.id where num = ?";
      
      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, num);
         
         rs = pstmt.executeQuery();
         
         if (rs.next()) {
            dto.setNum(rs.getInt("num"));
            dto.setTitle(rs.getString("title"));
            dto.setContent(rs.getString("content"));
            dto.setPostdate(rs.getDate("postdate"));
            dto.setId(rs.getString("id"));
            dto.setVisitcount(rs.getString("visitcount"));
            dto.setName(rs.getString("name"));
         }
      } catch (Exception e) {
         e.printStackTrace();
      }
      return dto;
   }
   
   public int selectCount(Map<String, Object> map) {
      int totalCount = 0; 
      
      String sql = "SELECT COUNT(*) FROM Board";
      
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
   
   public List<BoardDTO> selectList(Map<String, Object> map) {
      List<BoardDTO> bbs = new ArrayList<BoardDTO>(); 
      
      String sql = "Select * from ( Select Tb.*, rownum rnum From ( Select * from board ";
      if(map.get("searchWord") != null) {    
         sql += " Where " + map.get("searchField") + " LIKE  '%" + 
      map.get("searchWord") + "%'";
      }
      
      sql += "   Order By num DESC ) Tb ) where rnum Between ? And ?";
      
      try {
         
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, map.get("start").toString());
         pstmt.setString(2, map.get("end").toString());
         
         rs = pstmt.executeQuery();
         
         while(rs.next()) {
            BoardDTO dto = new BoardDTO();
            dto.setNum(rs.getInt("num"));
            dto.setTitle(rs.getString("title"));
            dto.setContent(rs.getString("content"));
            dto.setPostdate(rs.getDate("postdate"));
            dto.setId(rs.getString("id"));
            dto.setVisitcount(rs.getString("visitcount"));
            
            bbs.add(dto);
         }
      } catch (Exception e) {
         System.out.println(e.getMessage());
         e.printStackTrace();
      }
      return bbs;
   }
   
   public int insertWrite(BoardDTO dto) {
      int res = 0;
      
      try {
         String sql = "Insert into board(num, title, id, content) "
               + " values(SEQ_BOARD_NUM.nextval,?,?,?)"; 
         
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, dto.getTitle());
         pstmt.setString(2, dto.getId());
         pstmt.setString(3, dto.getContent());
         
         res = pstmt.executeUpdate();
      } catch (Exception e) {
         e.printStackTrace();
      }
      return res;
   }
   
   public int updateArticle(BoardDTO dto) {
      int res = 0;
     
      String sql = "Update Board Set title = ?, content = ? Where num = ?";
      
      try {   
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, dto.getTitle());
            pstmt.setString(2, dto.getContent());
            pstmt.setInt(3, dto.getNum());
            
            res = pstmt.executeUpdate();
      } catch (Exception e) {
            e.printStackTrace();
      }
      return res;
   }
   
   public int deleteArticle(int num) {
      int res = 0;
      
      String sql = "Delete From Board Where num = ?";
      
      try {
         pstmt = conn.prepareStatement(sql);
          pstmt.setInt(1, num);

          res = pstmt.executeUpdate();
      } catch (Exception e) {
            e.printStackTrace();
      }
      
      return res;
   }
   
}