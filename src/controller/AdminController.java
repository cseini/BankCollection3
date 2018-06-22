package controller;
import javax.swing.JOptionPane;
import service.*;
import serviceImpl.*;
import domain.*;

public class AdminController {
	private static AdminController instance=new AdminController();
	public static AdminController getInstance() {return instance;}
	public AdminController() {}
	public void add(StaffBean member) {
		AdminServiceImpl.getInstance().createStaff(member);
	}
	public void MemberList() {
		JOptionPane.showMessageDialog(null,AdminServiceImpl.getInstance().memberList());
	}
	public void findMemberById() {
		MemberBean member=new MemberBean();
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("비밀번호"));
		JOptionPane.showMessageDialog(null,AdminServiceImpl.getInstance().findMemberById(member));
	}
	public void findMemberByName() {
		JOptionPane.showMessageDialog(null,AdminServiceImpl.getInstance().findMemberByName(JOptionPane.showInputDialog("이름")));
	}
	public void createAccount(AccountBean account) {
		AdminServiceImpl.getInstance().createAccount(account);
	}
	public void createMinusAccount(AccountBean account) {
		AdminServiceImpl.getInstance().createMinusAccount((MinusAccountBean) account);
	}
	public void list() {
		JOptionPane.showMessageDialog(null, AdminServiceImpl.getInstance().accountList());
	}
	public void findAccountById() {
		AccountBean account = new AccountBean();
		account.setUid(JOptionPane.showInputDialog("아이디"));
		account.setPass(JOptionPane.showInputDialog("패스워드"));
		JOptionPane.showMessageDialog(null, AdminServiceImpl.getInstance().findAccountById(account));
	}
	
	public void findAccountByName() {
		JOptionPane.showInputDialog(AdminServiceImpl.getInstance().findAccountByName(JOptionPane.showInputDialog("이름")));
	}
}
