package service;
import domain.AccountBean;
public interface AccountService {
	public void createAccount(AccountBean account);
	public void addList(AccountBean account);
	public AccountBean[] list();
	public int deposit(String money);
	public int withDraw(String money);
	public String createAccountNum(String random);
	public String createRandom(int start, int end);
	public String createDate();
	public AccountBean findById(AccountBean account);
	public AccountBean[] findByName(String name);
	public int countSameWord(String word);
	public AccountBean[] findByMinusAccount(String type);
	public int countSameType(String type);
}
