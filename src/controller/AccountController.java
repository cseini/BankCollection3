package controller;
import javax.swing.JOptionPane;
import service.*;
import serviceImpl.*;
import domain.*;
enum Butt{
	EXIT,
	ACCOUNT,
	MINUS_ACCOUNT,
	LIST,
	FIND_BY_ID,
	FIND_BY_NAME,
	MINUS_LIST,
	DEPOSIT,
	WITHDRAW,
	CHANGE_PASS,
	DELETE_ACCOUNT
;}
public class AccountController {
	public static void main(String[] args) {
		AccountService service= new AccountServiceImpl();
		AccountBean account=null;
		while(true) {
			switch((Butt) JOptionPane.showInputDialog(null,
					"MAIN PAGE",
					"SELECT MENU",
					JOptionPane.QUESTION_MESSAGE,
					null,
					new Butt[] {
						Butt.EXIT,
						Butt.ACCOUNT,
						Butt.MINUS_ACCOUNT,
						Butt.LIST,
						Butt.FIND_BY_ID,
						Butt.FIND_BY_NAME,
						Butt.MINUS_LIST,
						Butt.DEPOSIT,
						Butt.WITHDRAW,
						Butt.CHANGE_PASS,
						Butt.DELETE_ACCOUNT},
						null)) {
			case EXIT:
				return;
			case ACCOUNT:
				account = new AccountBean(); 
				account.setName(JOptionPane.showInputDialog("이름"));
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPass(JOptionPane.showInputDialog("비밀번호"));
				service.createAccount(account);
				break;
			case MINUS_ACCOUNT:
				account = new MinusAccountBean(); 
				account.setName(JOptionPane.showInputDialog("이름"));
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPass(JOptionPane.showInputDialog("비밀번호"));
				((MinusAccountBean) account).setLimit(Integer.parseInt(JOptionPane.showInputDialog("대출한도")));
				service.createAccount(account);
				break;
			case LIST:
				JOptionPane.showMessageDialog(null,service.list());
				break;
			case DEPOSIT:
				break;
			case WITHDRAW:
				break;
			case FIND_BY_ID:
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPass(JOptionPane.showInputDialog("비밀번호"));
				JOptionPane.showMessageDialog(null, service.findById(account));
				break;
			case FIND_BY_NAME:
				JOptionPane.showMessageDialog(null, service.findByName(JOptionPane.showInputDialog("이름")));
				break;
			case MINUS_LIST:
				JOptionPane.showMessageDialog(null, service.findByMinusAccount(MinusAccountBean.ACCOUNT_TYPE)); 
				break;
			case CHANGE_PASS:
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPass(JOptionPane.showInputDialog("비밀번호")
						+"/"+JOptionPane.showInputDialog("새로운 비밀번호"));
				JOptionPane.showMessageDialog(null, service.changePass(account));
				//아이디, 비밀번호, new비밀번호 입력 - 아이디로 찾아서
				//바꿀 비밀번호 입력, 한번더 입력.s
				break;
			case DELETE_ACCOUNT:
				account = new AccountBean();
				account.setUid(JOptionPane.showInputDialog("아이디"));
				account.setPass(JOptionPane.showInputDialog("비밀번호")
						+"/"+JOptionPane.showInputDialog("정말 삭제하시겠습니까? 삭제하시려면 비밀번호"));
				JOptionPane.showMessageDialog(null,service.deleteAccount(account));
				
				// 계좌삭제 후 총 계좌수가 1 감소해야함.
				break;
				
			default:
				break;
			}
		}
	}
}
