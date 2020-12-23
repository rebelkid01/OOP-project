
class Ciphers {
	public static int[] pointing_atchar;
	public static int difference_betweenchars;
	public static int alphabet_letters=26;
	public static int LETTER_Z_SMALL=122;
	public static int LETTER_A_SMALL=97;
	public static int LETTER_Z_CAPITAL=90;
	public static int LETTER_A_CAPITAL=65;
	public static String asciiToBinary(String asciiString) 
	  {

	    byte[] bytes = asciiString.getBytes();
	    StringBuilder binary = new StringBuilder();
	    for (byte b: bytes) {
	      int val = b;
	      for (int i = 0; i < 8; i++) {
	        binary.append((val & 128) == 0 ? 0 : 1);
	        val <<= 1;
	        binary.append(' ');

	      }

	    }
	    return binary.toString();
	  }

	
}
