package controller;
import javax.swing.JOptionPane;
import service.*;
import serviceImpl.*;
enum Butt{
	EXIT,
	ACCOUNT,
	LIST
;}
public class AccountController {
	public static void main(String[] args) {
		
		AccountService service= new AccountServiceImpl();
		while(true) {
			switch((Butt) JOptionPane.showInputDialog(null,
					"MAIN PAGE",
					"SELECT MENU",
					JOptionPane.QUESTION_MESSAGE,
					null,
					new Butt[] {
						Butt.EXIT,
						Butt.ACCOUNT,
						Butt.LIST},
						null)) {
			case EXIT:
				return;
			case ACCOUNT:
				service.addList(service.createAccount(
						JOptionPane.showInputDialog("이름"),
						JOptionPane.showInputDialog("아이디"),
						JOptionPane.showInputDialog("비밀번호")));
				break;
			case LIST:
				JOptionPane.showMessageDialog(null,service.showResult());
				break;
			}
		}
	}
}
