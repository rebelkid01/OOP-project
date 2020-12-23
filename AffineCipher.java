class AffineCipher extends Ciphers {
	char[] pointing_atchar;
	String text;
	int key1,key2;
	AffineCipher(String c_text, int c_key1, int c_key2){
		text=c_text;
		key1=c_key1;
		key2=c_key2;
	}
	public String encryptAffine(){
		pointing_atchar = new char[text.length()];
		for (int i=0;i<text.length();i++) {
			if (Character.isUpperCase(text.charAt(i))) {
			pointing_atchar[i] = (char)((((((int)text.charAt(i)-65)*key1)+key2 ) %26 )+65);
		}
		else if (Character.isLowerCase(text.charAt(i))){
			pointing_atchar[i]=(char)((((((int)text.charAt(i)-97)*key1)+key2 ) %26 )+97);
				
			}
		else {
			pointing_atchar[i]=text.charAt(i);
		}
			
			}
		return new String(pointing_atchar);	
	}
	public String decryptAffine()  
    { 
        int key1_inv = 0; 
        int flag = 0; 
        for (int i = 0; i < 26; i++)  
        {
        	pointing_atchar = new char[text.length()];
        	
            flag = (key1 * i) % 26; 
            if (flag == 1)  
            { 
                key1_inv = i; 
            } 
        }
        for (int i=0;i<text.length();i++) {
			if (Character.isUpperCase(text.charAt(i))) {
				pointing_atchar[i]=(char) (((key1_inv *  
	                    ((text.charAt(i) - 65 - key2)) % 26)) + 65);
		}
		else if (Character.isLowerCase(text.charAt(i))){
			pointing_atchar[i]=(char) (((key1_inv *  
                    ((text.charAt(i) - 97 - key2)) % 26)) + 97);
			}
		else {
			pointing_atchar[i]=text.charAt(i);
		}
			
			}
		return new String(pointing_atchar);	
	}}
