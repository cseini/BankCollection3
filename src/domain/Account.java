package domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Account {
	public final static String BANK_NAME = "비트뱅크";
	public final static String ACCOUNT_TYPE = "기본통장";
	public final static String WITHDRAW_SUCCESS = "출금성공";
	public final static String WITHDRAW_FAIL = "잔액부족";
	public final static String DEPOSIT_SUCCESS = "입금성공";
	public final static String DEPOSIT_FAIL = "적합한 입력값이 아님";
	protected int money;
	protected String name, uid, pass, accountType, accountNum, createDate;

	public void setName(String name) {
		this.name = name;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public void setCreateDate(String createDate) {
		this.createDate = new SimpleDateFormat("yyyy년 MM월 dd일").format(new Date());
	}

	public String getName() {
		return name;
	}

	public String getUid() {
		return uid;
	}

	public String getPass() {
		return pass;
	}

	public int getMoney() {
		return money;
	}

	public String getAccountType() {
		return accountType;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public String getCreateDate() {
		return createDate;
	}
	public String toString() {
		return String.format("%s \n%s \n계좌번호 %s \n이름 : %s \n생성일 : %s \n잔액 : %d원\n" ,BANK_NAME,ACCOUNT_TYPE,accountNum,name,createDate,money);
	}
}
