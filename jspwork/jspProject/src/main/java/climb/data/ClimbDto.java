package climb.data;

import java.sql.Timestamp;

public class ClimbDto {
	private int num;
	private String cname;
	private int cprice;
	private String cphoto;
	private String cday;
	private String curl;
	public String getCurl() {
		return curl;
	}
	public void setCurl(String curl) {
		this.curl = curl;
	}
	private Timestamp writeday;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getCprice() {
		return cprice;
	}
	public void setCprice(int cprice) {
		this.cprice = cprice;
	}
	public String getCphoto() {
		return cphoto;
	}
	public void setCphoto(String cphoto) {
		this.cphoto = cphoto;
	}
	public String getCday() {
		return cday;
	}
	public void setCday(String cday) {
		this.cday = cday;
	}
	public Timestamp getWriteday() {
		return writeday;
	}
	public void setWriteday(Timestamp writeday) {
		this.writeday = writeday;
	}
	
}