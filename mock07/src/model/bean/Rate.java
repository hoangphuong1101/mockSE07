package model.bean;

public class Rate {
	int rateId;
	int threadId;
	int accountId;
	String content;
	int score;

	public Rate() {
		super();
	}

	public Rate(int rateId, int threadId, int accountId, String content, int score) {
		super();
		this.rateId = rateId;
		this.threadId = threadId;
		this.accountId = accountId;
		this.content = content;
		this.score = score;
	}

	public int getRateId() {
		return rateId;
	}

	public void setRateId(int rateId) {
		this.rateId = rateId;
	}

	public int getThreadId() {
		return threadId;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
