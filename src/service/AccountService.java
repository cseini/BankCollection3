package service;
import domain.*;
import java.util.List;
public interface AccountService {
	public AccountBean findById(AccountBean account);
	public void chagePassword(AccountBean account);
	public void deleteAccount(AccountBean account);
}
