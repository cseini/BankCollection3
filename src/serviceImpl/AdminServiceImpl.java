package serviceImpl;
import service.AdminService;

import java.text.SimpleDateFormat;
import java.util.*;
import domain.*;
public class AdminServiceImpl implements AdminService{
	private static AdminService instance = new AdminServiceImpl();
	public static AdminService getInstance() {return instance;}
	private AdminServiceImpl() {}

	List<MemberBean> memberList;
	List<AccountBean> accountList;

	@Override
	public void createStaff(StaffBean staff) {
		staff.setAccessNum("123");
		System.out.println("========== 멤버 서비스==========");
		System.out.println("컨트롤러에서 넘어온 객체:"+staff);
	}

	@Override
	public List<MemberBean> memberList() {
		return memberList;
	}

	@Override
	public List<MemberBean> findMemberByName(String name) {
		List<MemberBean> temp = new ArrayList<>();
		for(MemberBean e : memberList) {
			if(name.equals(e.getName())) {
				temp.add(e);
			}
		}
		return temp;
	}

	@Override
	public MemberBean findMemberById(MemberBean member) {
		MemberBean dap = new MemberBean();
		for(MemberBean e : memberList) {
			if(member.getUid().equals(e.getUid())) {
				dap=e;
				break;
			}
		}
		return dap;
	}

	@Override
	public void createAccount(AccountBean account) {
		account.setAccountType();
		account.setAccountNum(createAccountNum());
		account.setCreateDate(createDate());
		System.out.println("----서비스임플 일반통장----");
		System.out.println(account);
	}

	@Override
	public void createMinusAccount(MinusAccountBean account) {
		account.setAccountType();
		account.setAccountNum(createAccountNum());
		account.setCreateDate(createDate());
		System.out.println("----서비스임플 마이너스통장----");
		System.out.println(account);
	}
	
	@Override
	public List<AccountBean> accountList() {
		return accountList;
	}

	@Override
	public List<AccountBean> findAccountByName(String name) {
		List<AccountBean> res = new ArrayList<>();
		for(int i=0;i<accountList.size();i++) {
			if(name.equals(accountList.get(i).getName())) {
				res.add(accountList.get(i));
			}
		}
		return res;
	}

	@Override
	public String createAccountNum() {
		String accountNum= "";
		for(int i=0;i<3;i++) {
			accountNum+=(i!=2)?randomNum()+("-"):randomNum();
		}
		return accountNum;
	}

	@Override
	public String randomNum() {
		return String.valueOf(((int)(Math.random()*999)+1));
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}
	@Override
	public AccountBean findAccountById(AccountBean account) {
		
		return null;
	}

}

