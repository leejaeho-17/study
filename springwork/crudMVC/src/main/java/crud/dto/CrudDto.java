package crud.dto;

import java.sql.Timestamp;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias("CrudDto")
public class CrudDto {
	
	private int num;
	private String name;
	private String email;
	private int age;
	private Timestamp regdate;
}
