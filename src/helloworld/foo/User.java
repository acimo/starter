package helloworld.foo;

import java.io.Serializable;

public class User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName;

	{
		userName = "Bob";
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String newName) {
		this.userName = newName;
	}
	

}
