package webprj.daos;

import webprj.common.JDBCPooler;
import webprj.dtos.MemberDTO;

public class MemberDAO extends JDBCPooler {
	// 파라미터로 받은 ID, Pass 에 해당하는 row get 해서 DTO에 set한 후 return하도록 
	// 메서드 정의 
	public MemberDTO getMemberDTO(String id, String pass) {
		
		System.out.println(id + pass);
		String sql = "Select id,pass,name,reg_date "
				+ "from member where id = ? and pass = ?";
		MemberDTO dto = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			
			
			
			// 쿼리 실행
			rs = pstmt.executeQuery();
			System.out.println(rs);
			while(rs.next()) { // ID,PASS 가 맞다면..
				//DTO 객체 생성 및 데이터 셋업
				dto = new MemberDTO();
				dto.setId(id);
				dto.setPass(pass);
				dto.setName(rs.getString("name"));
				dto.setReg_date(rs.getDate("reg_date"));
			}
			
			System.out.println(dto);
		} catch (Exception e) {
			System.out.print(e.getMessage());
		}
		return dto;
	}
}
