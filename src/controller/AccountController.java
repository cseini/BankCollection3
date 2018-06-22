package controller;
import javax.swing.JOptionPane;
import service.*;
import serviceImpl.*;
import domain.*;
public class AccountController {
	private static AccountController instance = new AccountController();
	public static AccountController getInstance() {return instance;}
	private AccountController() {}	
	
	public void updatePass() {
		AccountBean account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("아이디"));
		account.setPass(JOptionPane.showInputDialog("패스워드")
				+"/"+JOptionPane.showInputDialog("new패스워드"));
		AccountServiceImpl.getInstance().chagePassword(account);
	}
	public void deleteAccount() {
		AccountBean account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("아이디"));
		account.setPass(JOptionPane.showInputDialog("패스워드")
				+"/"+JOptionPane.showInputDialog("패스워드 확인"));
		AccountServiceImpl.getInstance().deleteAccount(account);
	}
	public static void main(String[] args) {
		
	}
}
