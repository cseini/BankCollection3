package serviceImpl;

import domain.Account;
import service.AccountService;

public class AccountServiceImpl implements AccountService{
	private Account[] list;
	private int count;
	
	public AccountServiceImpl() {
		list = new Account[10];
		count=0;
	}
	@Override
	public Account createAccount(String name, String uid, String pass) {
		Account account = new Account();
		account.setName(name);
		account.setUid(uid);
		account.setPass(pass);
		account.setAccountNum(createAccountNum(createRandom(1,999)));
		account.setAccountType(Account.ACCOUNT_TYPE);
		account.setCreateDate(createDate());
		//account.setMoney(money);
		return account;
	}

	@Override
	public void addList(Account account) {
		list[count++] = account;
	}

	@Override
	public Account[] list() {
		return list;
	}

	@Override
	public int deposit(String money) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int withDraw(String money) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String createAccountNum(String random) {
		String accountNum="";
		for(int i=0;i<3;i++) {
			accountNum+=(i!=2)?random+"-":random;
		}
		return accountNum;
	}

	@Override
	public String createRandom(int start, int end) {
		String random="";
		random=String.format("%03d",(((int)(Math.random()*end))+start));
		return random;
	}

	@Override
	public String createDate() {
		String date="";
		return date;
	}

	@Override
	public String showResult() {
		String result="";
		for(int i=0;i<count;i++) {
			result+=list[i].toString();
		}
		return result;
	}
}