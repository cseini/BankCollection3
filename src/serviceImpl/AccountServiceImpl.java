package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;
import domain.*;
import service.AccountService;

public class AccountServiceImpl implements AccountService {
	private AccountBean[] list;
	private int count;

	public AccountServiceImpl() {
		list = new AccountBean[10];
		count = 0;
	}

	@Override
	public void createAccount(AccountBean account) {
		account.setAccountNum(createAccountNum(createRandom(1, 999)));
		account.setAccountType();
		account.setCreateDate(createDate());
		// account.setMoney(money);
		addList(account);
	}

	@Override
	public void addList(AccountBean account) {
		list[count++] = account;
	}

	@Override
	public AccountBean[] list() {
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
		String accountNum = "";
		for (int i = 0; i < 3; i++) {
			accountNum += (i != 2) ? createRandom(1, 999) + "-" : createRandom(1, 999);
		}
		return accountNum;
	}

	@Override
	public String createRandom(int start, int end) {
		String random = "";
		random = String.format("%03d", (((int) (Math.random() * (end - start)) + start)));
		return random;
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분 ss초").format(new Date());
	}

	@Override
	public AccountBean findById(AccountBean account) {
		AccountBean searchedAccount = new AccountBean();
		// 배열 list를 looping 돌려서
		// id가 일치하고 비번이 일치한 값을 찾아서
		// 그 객체를 리턴한다.
		// 일단 일치하는 값이 없는 상황은 나중에 처리
		for (int i = 0; i < count; i++) {
			if (account.getUid().equals(list[i].getUid()) && account.getPass().equals(list[i].getPass())) {
				searchedAccount = list[i];
				break;
			} 
		}
		return searchedAccount;
	}

	@Override
	public AccountBean[] findByName(String name) {
		int overlap = 0;
		AccountBean[] arr = new AccountBean[countSameWord(name)];
		for (int i = 0; i < count; i++) {
			if (name.equals(list[i].getName())) {
				arr[overlap++] = list[i];
			}
		}
		return arr;
	}

	@Override
	public int countSameWord(String word) {
		int wordCount = 0;
		for (int i = 0; i < count; i++) {
			if (word.equals(list[i].getName())) {
				wordCount++;
			}
		}
		return wordCount;
	}

	@Override
	public AccountBean[] findByMinusAccount(String type) {
		int temp = 0;
		AccountBean[] arr = new MinusAccountBean[countSameType(type)];
		for (int i = 0; i < count; i++) {
			if (type.equals(list[i].getAccountType())) {
				arr[temp++] = list[i];
			}
		}
		return arr;
	}

	@Override
	public int countSameType(String type) {
		int typeCount = 0;
		for (int i = 0; i < count; i++) {
			if (type.equals(list[i].getAccountType())) {
				typeCount++;
			}
		}
		return typeCount;
	}

	@Override

	public String changePass(AccountBean account) {
		String msg = "";
		String pass = account.getPass().split("/")[0];
		String newPass = account.getPass().split("/")[1];
		account.setPass(pass);
		account=findById(account);
		if(account.getUid()==null) {
			msg = "ID없음 혹은 비번 틀림";
		}else {
			if(pass.equals(newPass)) {
				msg="기존비밀번호와 동일합니다.";
			}else {
				account.setPass(newPass);
				msg="비번 변경";	
			}
		}
		// 성공:변경완료
		// 실패:변경실패, 기존과 동일한 비밀번호 입력하면,
		return msg;
	}

	@Override
	public String deleteAccount(AccountBean account) {
		String msg="ID 존재무, 혹은 비번 틀림";
		String pass=account.getPass().split("/")[0];
		String confirmPass=account.getPass().split("/")[1];
		for(int i=0;i<count;i++) {
			if(account.getUid().equals(list[i].getUid())
					&&
					pass.equals(list[i].getPass())
					&&
					confirmPass.equals(list[i].getPass())) {
				list[i]=list[--count];
				list[count]=null;
				msg="삭제성공";
				break;
			} else {
				msg="삭제실패";
			}
		}
		return msg;
	}
}