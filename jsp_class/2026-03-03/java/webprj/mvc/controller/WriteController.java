package webprj.mvc.controller;

import java.io.File;
import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import webprj.board1.daos.mvc.MVCDAO;
import webprj.board1.dtos.mvc.MVCDTO;
import webprj.util.FileUtil;

public class WriteController extends HttpServlet {
	@Override
	 protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		req.getRequestDispatcher("/mvcboard/write.jsp").forward(req, resp);
	}
	
	// 신규글 작성 메서드 정의,, 파일 업로드 처리도 해야함
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String sDirectory = getServletContext().getRealPath("NAS");
		File folder = new File(sDirectory);
		if (!folder.exists()) folder.mkdirs();
		
		String orgFileName = "";
		
		orgFileName = FileUtil.uploadFile(req, sDirectory);
		
		// 여기까지 파일 어로드 끝
		
		//전달되는 폼 데이터 처리
		MVCDTO dto = new MVCDTO();
		dto.setName(req.getParameter("name"));
		dto.setTitle(req.getParameter("title"));
		dto.setContent(req.getParameter("content"));
		dto.setPass(req.getParameter("pass"));
		
		if(orgFileName != "") {
			String sfileName = FileUtil.renameFile(sDirectory, orgFileName);
			
			dto.setOfile(orgFileName);
			dto.setSfile(sfileName);
		}
		
		MVCDAO dao = new MVCDAO();
		int res = dao.insertWrite(dto);
		dao.close();
		
		if(res ==1) {
			resp.sendRedirect("list.do");
		}
	}
}
