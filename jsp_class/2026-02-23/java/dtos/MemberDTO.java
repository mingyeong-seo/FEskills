package webprj.dtos;

import java.sql.Date;

import lombok.Data;

@Data
public class MemberDTO {
	private String id;
	private String pass;
	private String name;
	private Date reg_date;
}
