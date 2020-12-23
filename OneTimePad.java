import java.util.Random;
class OneTimePad extends Ciphers {
		private int generateRandomKey() {
			Random random=new Random();
			int key=random.nextInt(2);
			return key;
		}
		
		
	public String oneTimePad(String text) 
	{
		String binary_string=asciiToBinary(text);
		String[] parsed=binary_string.split(" ");
		for (int i = 0; i < parsed.length; i++) {
			System.out.print(parsed[i]);	
		}
		String encrypted_string_stream="";
		int[] key=new int[parsed.length];
		int[] encrypted_stream=new int[ parsed.length];
		System.out.println();
		for(int i=0;i<parsed.length;i++) {
			key[i]=generateRandomKey();
			System.out.print(key[i]);
			encrypted_stream[i]=Integer.parseInt(parsed[i])^key[i];
			encrypted_string_stream+=encrypted_stream[i];
		}
		System.out.println("\nOutput:");
		
	return encrypted_string_stream;
		
		
	}
	
	
	
	public String decryptOneTimePad(String text, String key) 
	{
		int[] decrypted_stream=new int[text.length()];
		String decrypted_string_stream="";
		String[] encrypted_text=new String[text.length()];
		String[] encryption_key=new String[key.length()];
		for (int i = 0; i < encryption_key.length; i++) {
			encrypted_text[i]="";
			encrypted_text[i]+=text.charAt(i);
			encryption_key[i]="";
			encryption_key[i]+=key.charAt(i);
			decrypted_stream[i]=Integer.parseInt(encrypted_text[i])^ (Integer.parseInt(encryption_key[i]));
			decrypted_string_stream+=decrypted_stream[i];
			
		}
		System.out.println("\nOutput:");
		
	return decrypted_string_stream;
		
		
	}

}