package a01_diexp.z06_vo;

import org.springframework.stereotype.Component;

// a01_diexp.z06_vo.Dao
@Component
public class Dao {
	private String jdbcDriver;
	private String user;
	private String pass;
	public Dao() {
	}
	public Dao(String jdbcDriver, String user, String pass) {
		super();
		this.jdbcDriver = jdbcDriver;
		this.user = user;
		this.pass = pass;
	}
	public String getJdbcDriver() {
		return jdbcDriver;
	}
	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
