package controller;
import javax.swing.JOptionPane;
import service.*;
import serviceImpl.*;
import domain.*;
public class MemberController {
	private static MemberController instance = new MemberController();
	public static MemberController getInstance() {return instance;}
	private MemberController() {}
	public void join(UserBean member) {
		System.out.println("========== 멤버 컨트롤러==========");
		System.out.println("화면에서 넘어온 객체:"+member);
		MemberServiceImpl.getInstance().createUser(member);
	}
	public void updatePass() {
		MemberBean member=new MemberBean();
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("비밀번호"));
		MemberServiceImpl.getInstance().updatePassword(member);
	}
	public void withdrawal() {
		MemberBean member=new MemberBean();
		member.setUid(JOptionPane.showInputDialog("아이디"));
		member.setPass(JOptionPane.showInputDialog("비밀번호"));
		MemberServiceImpl.getInstance().deleteMember(member);
	}
	public static void main(String[] args) {

	}
}
