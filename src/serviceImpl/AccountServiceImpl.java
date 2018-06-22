package serviceImpl;
import java.util.*;
import java.text.SimpleDateFormat;
import domain.*;
import service.AccountService;
public class AccountServiceImpl implements AccountService {
	private static AccountService instance = new AccountServiceImpl();
	public static AccountService getInstance() {return instance;}
	private AccountServiceImpl() {}

	@Override
	public AccountBean findById(AccountBean account) {
		AccountBean res = new AccountBean();
		/*for(int i=0;i<list.size();i++) {
			if(account.getUid().equals(list.get(i).getUid())
					&&
					account.getPass().equals(list.get(i).getPass())) {
				res=list.get(i);
				break;
			}
		}*/
		return res;
	}

	@Override
	public void chagePassword(AccountBean account) {
		String pass = account.getPass().split("/")[0];
		String newPass = account.getPass().split("/")[1];
		account.setPass(pass);
		if(account.getUid().equals(findById(account).getUid())
				&&
			account.getPass().equals(findById(account).getPass())) {
			/*list.get(list.indexOf(findById(account))).setPass(newPass);*/
		}
	}

	@Override
	public void deleteAccount(AccountBean account) {
		String pass = account.getPass().split("/")[0];
		String rePass = account.getPass().split("/")[1];
		account.setPass(pass);
		if(account.getUid().equals(findById(account).getUid())
				&&
			account.getPass().equals(findById(account).getPass())
			&&
			rePass.equals(findById(account).getPass())) {
			/*list.remove(list.indexOf(findById(account)));*/
		}
	}
}