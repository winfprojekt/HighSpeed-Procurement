package util;

class Bankdaten {
	private String bank;
	private String iBAN;		
	private String bicSwift;	
	private String steuernummer;
	
	
	//Konstruktor
	public Bankdaten(String bank, String iBAN, String bicSwift, int steuernummer) {
		super();
		this.bank = bank;
		this.iBAN = iBAN;
		this.bicSwift = bicSwift;
		this.steuernummer = steuernummer;
	}
	
	//Getter + Setter
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


	//toString
	@Override
	public String toString() {
		return "Bankdaten [bank=" + bank + ", iBAN=" + iBAN + ", bicSwift=" + bicSwift + ", steuernummer="
				+ steuernummer + "]";
	}
	
	
}