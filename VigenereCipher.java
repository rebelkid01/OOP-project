class VigenereCiphere extends Ciphers{
	private String text;
	private String key;
	private boolean isdecrypt;
	VigenereCiphere(String c_text, String c_key, boolean c_isdecrypt){
		text=c_text;
		key=c_key;
		isdecrypt=c_isdecrypt;
	}
	public String getVigenereCipher() {
		int i,j;
		i=0;
		j=0;
		int keysign=1;
		String cipher_text="";
		int pointing_atchar[]=new int[text.length()];
		if(isdecrypt) {
			difference_betweenchars=LETTER_A_CAPITAL;
			keysign=-1;
			alphabet_letters=26;
		}
		else {
		difference_betweenchars=-LETTER_A_CAPITAL;
		alphabet_letters=0;
		}
		text=text.toUpperCase();
		key=key.toUpperCase();
		System.out.println("result:");
		while(key.length()<text.length()) {
			key+=key;
		}
		while( i<text.length()) {
			pointing_atchar[i]=((text.charAt(i) + (keysign*key.charAt(i))+alphabet_letters) %26)+LETTER_A_CAPITAL;
			if((int)text.charAt(i)<LETTER_A_CAPITAL || (int) text.charAt(i)>LETTER_Z_CAPITAL) {
				pointing_atchar[i]=(int)text.charAt(i);
				cipher_text+=(char)pointing_atchar[i];
				j--;
			}
			else if(pointing_atchar[i]>LETTER_Z_CAPITAL || pointing_atchar[i]<LETTER_A_CAPITAL && pointing_atchar[i]+26>LETTER_A_CAPITAL) {
				pointing_atchar[i]=(pointing_atchar[i]+alphabet_letters);
				cipher_text+=(char)pointing_atchar[i];
				}
			else {
				cipher_text+=(char)pointing_atchar[i];
				}			
				 i++;
				 j++;
				 if(j>key.length()-1) {
						j=0;
					}
		}
		return cipher_text;
	}
}
