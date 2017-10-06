package controller;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class SMTPAuthenticator extends Authenticator {
	public SMTPAuthenticator() {
		super();
	}

	public PasswordAuthentication getPasswordAuthentication() {
		String username = "dragonlake.bae@gmail.com";
		String password = "kimtodsqimrfwqtv";
		return new PasswordAuthentication(username, password);
	}
}