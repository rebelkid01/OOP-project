class CaeserCipher extends Ciphers {
		
		private static String plainTextValidated(int pointing_at,int key, String cipher_text ) {
			int y;
			 y=alphabet_letters-key;
			if(pointing_at==' ')
			{
				cipher_text+=((char)(pointing_at));
			}
			else if(pointing_at<LETTER_A_CAPITAL && pointing_at>LETTER_Z_SMALL)
			{
				cipher_text+=((char)(pointing_at));
			}
			else if(pointing_at<LETTER_A_SMALL && pointing_at>LETTER_Z_CAPITAL)
			{
				cipher_text+=((char)(pointing_at));
			}
			
			else if(pointing_at>=LETTER_A_CAPITAL && pointing_at<=LETTER_Z_CAPITAL)
			{
				if(pointing_at+key>LETTER_Z_CAPITAL )
				{
					pointing_at=pointing_at-y;
					cipher_text+=((char)(pointing_at));
				}
				else if(pointing_at+key<=LETTER_Z_CAPITAL)
				{
					pointing_at=pointing_at+key;
					cipher_text+=((char)(pointing_at));
				}
			}
			else if(pointing_at>=LETTER_A_SMALL && pointing_at<=LETTER_Z_SMALL)
			{
				if(pointing_at+key>LETTER_Z_SMALL )
				{
					pointing_at=pointing_at-y;
					cipher_text+=((char)(pointing_at));
				}
				else if(pointing_at+key<=LETTER_Z_SMALL)
				{
					pointing_at=pointing_at+key;
					cipher_text+=((char)(pointing_at));
				}
			}
			else 
			{
				cipher_text+=((char)(pointing_at));
			}
			return cipher_text;
		}
		
		
		private static String cipherTextValidated(int pointing_at,int key, String cipher_text) {
			int y;
			 y=alphabet_letters-key;
			if(pointing_at==' ')
			{
				cipher_text+=((char)(pointing_at));
			}
			if(pointing_at<LETTER_A_CAPITAL && pointing_at>LETTER_Z_SMALL)
			{
				cipher_text+=((char)(pointing_at));
			}
			if(pointing_at<LETTER_A_SMALL && pointing_at>LETTER_Z_CAPITAL)
			{
				cipher_text+=((char)(pointing_at));
			}
			
			else if(pointing_at>=LETTER_A_CAPITAL && pointing_at<=LETTER_Z_CAPITAL)
			{
				if(pointing_at+y>LETTER_Z_CAPITAL )
				{
					pointing_at=pointing_at-key;
					cipher_text+=((char)(pointing_at));
				}
				else if(pointing_at+y<=LETTER_Z_CAPITAL)
				{
					pointing_at=pointing_at+y;
					cipher_text+=((char)(pointing_at));
				}
			}
			else if(pointing_at>=LETTER_A_SMALL && pointing_at<=LETTER_Z_SMALL)
			{
				if(pointing_at+y>LETTER_Z_SMALL )
				{
					pointing_at=pointing_at-key;
					cipher_text+=((char)(pointing_at));
				}
				else if(pointing_at+y<=LETTER_Z_SMALL)
				{
					pointing_at=pointing_at+y;
					cipher_text+=((char)(pointing_at));
				}
			}
			else {
				cipher_text+=((char)(pointing_at));
			}	
			return cipher_text;
		}
		
		public String caeserCipher(String text,int key) 
		{
			String cipher_text="";
			 for(int i=0; i<text.length(); i++) 
			 {
				 int pointing_at;
				 pointing_at=(int)text.charAt(i);	
				cipher_text=plainTextValidated(pointing_at,key, cipher_text) ;	
			 }
			 return cipher_text;
		}	
		
		
		
		
		public String decryptCaeserCipher(String text,int key)
			{
			
			 String cipher_text="";
			 for(int i=0; i<text.length(); i++) 
			 {
				 int pointing_at;
				 pointing_at=(int)text.charAt(i);
					{
						cipher_text=cipherTextValidated(pointing_at, key, cipher_text);
						
					}
					
			 }
			 return cipher_text;
					
		}		
	
}

