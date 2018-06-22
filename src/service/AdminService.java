package service;
import java.util.List;
import domain.*;

public interface AdminService {
	public void createStaff(StaffBean staff);
	public List<MemberBean> memberList();
	public List<MemberBean> findMemberByName(String param);
	public MemberBean findMemberById(MemberBean member);
	public void createAccount(AccountBean account);
	public void createMinusAccount(MinusAccountBean account);
	public List<AccountBean> accountList();
	public List<AccountBean> findAccountByName(String name);
	public AccountBean findAccountById(AccountBean account);
	public String createAccountNum();
	public String randomNum();
	public String createDate();
}
