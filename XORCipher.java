class XORCipher extends Ciphers {
    private static int[] matchKeyWithInput(int[] key, int len) {
	  int j = 0;
	   int n = 0;
	    
	  int[] keyArr = new int[len];
	    System.out.print("key: ");
	    while (n < len) {
	      if (j > key.length-1) {
	        j = 0;
	      }

	      keyArr[n] = key[j];
	      System.out.print(keyArr[n]);
	      j++;
	      n++;
	    }
	    return keyArr;
  }
    
    
    
  public String encryptXOR(String text, int[] key1) 
  {
    String binary_string = asciiToBinary(text);
    String[] parsed = binary_string.split(" ");
    int[] keyArr=matchKeyWithInput(key1, parsed.length);
    System.out.print("\nPlaintext binary:");
    for (int i = 0; i < parsed.length; i++) {
      System.out.print(Integer.parseInt(parsed[i]));
    }
    String encrypted_string_stream = "";
    int[] encrypted_stream = new int[parsed.length];
    System.out.println();
    for (int i = 0; i < parsed.length; i++) {
      encrypted_stream[i] = Integer.parseInt(parsed[i]) ^ keyArr[i];
      encrypted_string_stream += encrypted_stream[i];
    }
    System.out.println();
    System.out.println("\nResult:");

    return encrypted_string_stream;
  }
  
  
  
  public String decryptXOR(String text, int[] key) 
  {
		int[] decrypted_stream=new int[text.length()];
		String decrypted_string_stream="";
		String[] encrypted_text=new String[text.length()];
		int[] encryption_key=new int[text.length()];
		encryption_key=matchKeyWithInput(key, text.length());
		String[] encryption_key2=new String[text.length()];
		for (int i = 0; i < encryption_key.length; i++) {
			encrypted_text[i]="";
			encrypted_text[i]+=text.charAt(i);
			encryption_key2[i]+=encryption_key[i];
			decrypted_stream[i]=Integer.parseInt(encrypted_text[i])^(encryption_key[i]);
			decrypted_string_stream+=decrypted_stream[i];
			
		}
		System.out.println("\nOutput:");
		
	return decrypted_string_stream;
	}
}