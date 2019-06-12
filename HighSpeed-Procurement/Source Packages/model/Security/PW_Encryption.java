package model.Security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PW_Encryption {

	private String data;
	private String pw;
	private String finish;

	public PW_Encryption(String data) throws NoSuchAlgorithmException {
		super();
		this.data = data;
		Initialize(data);
	}

	public static void main(String[] args) {

	}

	private void Initialize(String data) throws NoSuchAlgorithmException {
		String pw = data;
		String algorithm = "SHA-256";

		// generateHash(data, algorithm);

		System.out.println(generateHash(pw, algorithm));
		finish = generateHash(pw, algorithm);
	}

	private static String generateHash(String data, String algorithm) throws NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance(algorithm);
		digest.reset();
		byte[] hash = digest.digest(data.getBytes());
		return bytesToStringHex(hash);
	}

	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();

	private static String bytesToStringHex(byte[] bytes) {
		char[] hexChars = new char[bytes.length * 2];
		for (int i = 0; i < bytes.length; i++) {
			int v = bytes[i] & 0xFF;
			hexChars[i * 2] = hexArray[v >>> 4];
			hexChars[i * 2 + 1] = hexArray[v & 0x0F];

		}
		return new String(hexChars);

	}

	public String getData() throws NoSuchAlgorithmException {
		return finish;
	}

}
