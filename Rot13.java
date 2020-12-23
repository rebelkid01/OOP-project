class Rot13 extends Ciphers {	
	public String encryptROT13Text(String text_toencrypt) {
		int ROT=13;
		String cipher_text="";
		pointing_atchar=new int[text_toencrypt.length()];
		for(int i=0; i<text_toencrypt.length(); i++)
			
		{
			//abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890`./'\/*-<>>?+_
			pointing_atchar[i]=(int) text_toencrypt.charAt(i);
			if(pointing_atchar[i]+ROT > LETTER_Z_SMALL && pointing_atchar[i] <=LETTER_Z_SMALL)
			{
				difference_betweenchars=(pointing_atchar[i]+ROT)-123;
				pointing_atchar[i]=97+difference_betweenchars;
				
				cipher_text+=((char)(pointing_atchar[i]));
			}
			else if(pointing_atchar[i]+ROT > LETTER_Z_CAPITAL && pointing_atchar[i] <=LETTER_Z_CAPITAL)
			{
				difference_betweenchars=(pointing_atchar[i]+ROT)-91;
				pointing_atchar[i]=LETTER_A_CAPITAL+difference_betweenchars;
				cipher_text+=((char)(pointing_atchar[i]));
			}
			else if((pointing_atchar[i]+ROT > (96+ROT) && pointing_atchar[i]+ROT <= LETTER_Z_SMALL) || (pointing_atchar[i]+ROT >= (LETTER_A_CAPITAL+ROT) && pointing_atchar[i]+ROT <= LETTER_Z_CAPITAL ))  {
				cipher_text+=((char)(((int) text_toencrypt.charAt(i)) +ROT));
			}
			
			else {
				cipher_text+=((char)pointing_atchar[i]);
			}
			
		}
		return cipher_text;
	}
}
