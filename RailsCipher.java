class RailsCipher extends Ciphers {
	String inptext;
	int Rails;
	RailsCipher(int Rails1,String text){
		inptext=text;
		Rails=Rails1;
	}
	public String decryptRailsCipher() {
		char[] decrypted = new char[inptext.length()];
		int n = 0;
		for(int k = 0 ; k < Rails; k ++) {
			int index = k;
			boolean down = true;
			while(index < inptext.length() ) {
				decrypted[index] = inptext.charAt(n++);
				
				if(k == 0 || k == Rails - 1) {
					index = index + 2 * (Rails - 1);
				}
				else if(down) {
					index = index +  2 * (Rails - k - 1);
					down = !down;
				}
				else {
					index = index + 2 * k;
					down = !down;
				}
			}
		}
		return new String(decrypted);
	}
	public String railFenceCipher() {
		char[] encrypted = new char[inptext.length()];
		int n = 0;
		
		
		for(int k = 0 ; k < Rails; k ++) {
			int index = k;
			boolean down = true;
			while(index < inptext.length() ) {
				//System.out.println(k + " " + index+ " "+ n );
				encrypted[n++] = inptext.charAt(index);
				
				if(k == 0 || k == Rails - 1) {
					index = index + 2 * (Rails - 1);
				}
				else if(down) {
					index = index +  2 * (Rails - k - 1);
					down = !down;
				}
				else {
					index = index + 2 * k;
					down = !down;
				}
			}
		}
		return new String(encrypted);
	}
	}
