package serviceImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

import domain.*;
import service.AccountService;

public class AccountServiceImpl implements AccountService{
	private AccountBean[] list;
	private int count;
	
	public AccountServiceImpl() {
		list = new AccountBean[10];
		count=0;
	}
	@Override
	public void createAccount(AccountBean account) {
		account.setAccountNum(createAccountNum(createRandom(1,999)));
		account.setAccountType();
		account.setCreateDate(createDate());
		//account.setMoney(money);
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
		String accountNum="";
		for(int i=0;i<3;i++) {
			accountNum+=(i!=2)?createRandom(1,999)+"-":createRandom(1,999);
		}
		return accountNum;
	}

	@Override
	public String createRandom(int start, int end) {
		String random="";
		random=String.format("%03d",(((int)(Math.random()*(end-start))+start)));
		return random;
	}

	@Override
	public String createDate() {
		return new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}
	@Override
	public AccountBean findById(AccountBean account) {
		AccountBean searchedAccount = new AccountBean();
		// 배열 list를 looping 돌려서
		// id가 일치하고 비번이 일치한 값을 찾아서
		// 그 객체를 리턴한다.
		// 일단 일치하는 값이 없는 상황은 나중에 처리
		for(int i=0;i<count;i++) {
			if(account.getUid().equals(list[i].getUid())
			 &&account.getPass().equals(list[i].getPass())) {
				searchedAccount=list[i];
				break;
			}
		}
		return searchedAccount;
	}
	@Override
	public AccountBean[] findByName(String name) {
		int overlap =0;
		AccountBean[] arr = new AccountBean[countSameWord(name)];
		for(int i=0;i<count;i++) {
			if(name.equals(list[i].getName())) {
				arr[overlap++]=list[i];
			}
		}
		return arr;
	}
	@Override
	public int countSameWord(String word) {
		int wordCount=0;
		for(int i=0;i<count;i++) {
			if(word.equals(list[i].getName())){
				wordCount++;
			}
		}
		return wordCount;
	}
	@Override
	public AccountBean[] findByMinusAccount(String type) {
		int temp=0;
		AccountBean[] arr = new MinusAccountBean[countSameType(type)];
		for(int i=0;i<count;i++) {
			if(type.equals(list[i].getAccountType())) {
				arr[temp++]=list[i];
			}
		}
		return arr;
	}
	@Override
	public int countSameType(String type) {
		int typeCount=0;
		for(int i=0;i<count;i++) {
			if(type.equals(list[i].getAccountType())){
				typeCount++;
			}
		}
		return typeCount;
	}
}