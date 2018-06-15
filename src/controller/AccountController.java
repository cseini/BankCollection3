package controller;
import javax.swing.JOptionPane;

enum Butt{
	EXIT,
	ACCOUNT,
	LIST
;}
public class AccountController {
	public static void main(String[] args) {
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
				break;
			case LIST:
				break;
			}
		}
	}
}
