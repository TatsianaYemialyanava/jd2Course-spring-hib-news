package by.htp.les04.bean;

import java.io.Serializable;

public class RegistrationInfo implements Serializable { 
	private static final long serialVersionUID = -8742505101662471068L;
	
	private String name;
	private String surname;
	private String email;
	private String login;
	private String password;
	
	public RegistrationInfo() {
	}
	
	public RegistrationInfo(String name, String surname, String email, String login, String password) {
		super();
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.login = login;
		this.password = password;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSurmame(String surname) {
		this.surname = surname;
	}
	
	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RegistrationInfo other = (RegistrationInfo) obj;
		if (email == null) {
			if (other.email != null) {
				return false;
			}
		} else if (!email.equals(other.email)) {
			return false;
		}
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		return true;
	}
	
	@Override
	public String toString() {	
		return "Name: " + this.name + "\n" +
	            "Surname:" + this.surname + "\n" +
				"email: " + this.email + "\n" + 
				"login: " + this.login;
	}
	
}
