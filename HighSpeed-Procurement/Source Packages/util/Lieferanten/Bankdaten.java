package Lieferanten;

public class Bankdaten {
	private String bank;
	private String iBAN;		//bestimmtes Format
	private String bicSwift;	//bestimmtes Format
	private int steuernummer;	//bestimmtes Format
	
	
	
	public Bankdaten(String bank, String iBAN, String bicSwift, int steuernummer) {
		super();
		this.bank = bank;
		this.iBAN = iBAN;
		this.bicSwift = bicSwift;
		this.steuernummer = steuernummer;
	}
	
	public Bankdaten update (String bank, String iBAN, String bicSwift, int steuernummer) {
		this.bank = bank;
		this.iBAN = iBAN;
		this.bicSwift = bicSwift;
		this.steuernummer = steuernummer;
		return this;
	}



	public String getBank() {
		return bank;
	}



	public void setBank(String bank) {
		this.bank = bank;
	}



	public String getiBAN() {
		return iBAN;
	}



	public void setiBAN(String iBAN) {
		this.iBAN = iBAN;
	}



	public String getBicSwift() {
		return bicSwift;
	}



	public void setBicSwift(String bicSwift) {
		this.bicSwift = bicSwift;
	}



	public int getSteuernummer() {
		return steuernummer;
	}



	public void setSteuernummer(int steuernummer) {
		this.steuernummer = steuernummer;
	}



	@Override
	public String toString() {
		return "Bankdaten [bank=" + bank + ", iBAN=" + iBAN + ", bicSwift=" + bicSwift + ", steuernummer="
				+ steuernummer + "]";
	}
	
	
}