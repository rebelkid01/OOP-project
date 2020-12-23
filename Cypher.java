import java.util.Scanner;
/*
 * Authors:-
 * Asma Barzhawand
 * Bahra Abdulkhaliq
 * Sivan Xawar 
 */
public class Cypher 
{
	
	public static void main(String[] args) 
	{
		Scanner scnr=new Scanner(System.in);
		Scanner scnr2=new Scanner(System.in);
		boolean exit=false;
		boolean isdecrypt=false;
		String text,key;
		String msg="[1]- Encrypt\n[2]- Decrypt\n[3]- Back";
		while (exit==false) {
			System.out.println("Choose a cipher or exit:");
			System.out.println("[1]- Vigenere Cipher");
			System.out.println("[2]- Rot13 Cipher");
			System.out.println("[3]- Rail Fence Cipher");
			System.out.println("[4]- OTP Cipher");
			System.out.println("[5]- Affine Cipher");
			System.out.println("[6]- XOR Cipher");
			System.out.println("[7]- Caeser Cipher");
			System.out.println("[8]- Exit");
			int user_choice=scnr.nextInt();
			//int rot,rails;
			switch(user_choice) {
			case 1:
				System.out.println(msg);
				int user_choice2=scnr.nextInt();
				switch(user_choice2) {
				case 1:
					isdecrypt=false;
					System.out.print("Enter The text:\n");
					text=scnr2.nextLine();
					System.out.print("Enter The Encryption Key:");
					key=scnr.next();
					for (int i = 0; i < key.length(); i++) {
						while(!(Character.isAlphabetic(key.charAt(i)))) {
							System.out.print("[!] The key must be in alphabetical letters:\n");
							System.out.println("Enter The text:");
							
							key=scnr.next();
							
						}	
					}
					
					VigenereCiphere vigenere=new VigenereCiphere(text, key, isdecrypt);
					System.out.println(vigenere.getVigenereCipher());
					break;
				case 2:
					isdecrypt=true;
					System.out.println("Enter The text:");
					text=scnr2.nextLine();
					System.out.println("Enter The decryption Key:");
					key=scnr.next();
					for (int i = 0; i < key.length(); i++) {
						while(!(Character.isAlphabetic(key.charAt(i)))) {
							System.out.print("[!] The key must be in alphabetical letters:\n");
							System.out.println("Enter The text:");
							
							key=scnr2.next();
								
						}	
					}
					VigenereCiphere vigenere2=new VigenereCiphere(text, key, isdecrypt);
					System.out.println(vigenere2.getVigenereCipher());
					break;
				case 3:
						break;
				default:
					System.out.println("[!] Choose between [1-3]");
				}
				break;
			case 2:
				System.out.println("Enter The text:");
				text=scnr2.nextLine();
				Rot13 rot13=new Rot13();
				System.out.println(rot13.encryptROT13Text(text));
				break;
			case 3:
				System.out.println(msg);
				int user_choice3=scnr.nextInt();
				switch (user_choice3) {
				case 1: 
					System.out.println("Enter The text:");
					text=scnr2.nextLine();
					System.out.println("How many rails?");
					int rail=scnr.nextInt();
					RailsCipher rails=new RailsCipher(rail, text);
					System.out.println(rails.railFenceCipher());
					break;
				case 2: 
					System.out.println("Enter The text:");
					text=scnr2.nextLine();
					System.out.println("How many rails?");	
					int rail_d=scnr.nextInt();
					RailsCipher rails_d=new RailsCipher(rail_d, text);
					System.out.println(rails_d.decryptRailsCipher());
					break;
				default:
					System.out.println("[!] Choose between [1-3]");
				}
				break;
			case 4:
				System.out.println(msg);
				int user_choice4=scnr.nextInt();
				switch (user_choice4) {
				case 1: 
					System.out.println("Enter The text:");
					text=scnr2.nextLine();
					OneTimePad onetimepad=new OneTimePad();
					System.out.println(onetimepad.oneTimePad(text));
					break;
				case 2: 
					System.out.println("[!] Please enter binary stream in order to work properly.");
					System.out.println("Enter The ecrypted binary stream:");
					text=scnr2.nextLine();
					OneTimePad onetimepad_d=new OneTimePad();
					System.out.println("Enter The key string:");
					String key_otp=scnr2.nextLine();
					
					if(key_otp.length()==text.length()) {
						System.out.println(onetimepad_d.decryptOneTimePad(text, key_otp));
					}
					else {
						System.out.println("[!] The key stream must be the same length as the encrypted stream.");	
					}
					break;
				default:
					System.out.println("[!] Choose between [1-3]");
				}
				break;
			case 5:
				System.out.println(msg);
				int user_choice5=scnr.nextInt();
				switch(user_choice5) {
				case 1:
						System.out.println("Enter The text:");
						text=scnr2.nextLine();
						System.out.println("Enter The first key:");
						int key1=scnr.nextInt();
						System.out.println("Enter The second key:");
						int key2=scnr.nextInt();
						
						AffineCipher affine=new AffineCipher(text, key1, key2);
						System.out.println(affine.encryptAffine());
						break;
					case 2:
						System.out.println("Enter The text:");
						text=scnr2.nextLine();
						System.out.println("Enter The first key:");
						key1=scnr.nextInt();
						System.out.println("Enter The second key:");
						key2=scnr.nextInt();
						//doesnt work
						AffineCipher affined=new AffineCipher(text, key1, key2);
						System.out.println(affined.decryptAffine());
						break;
					case 3:
							break;
					default:
						System.out.println("[!] Choose between [1-3]");
					}
				
				break;
			case 6:
				System.out.println(msg);
				int user_choice6=scnr.nextInt();
				switch(user_choice6) {
				case 1:
						System.out.println("Enter The text:");
						text=scnr2.nextLine();
						//WHAT IF THE NUMBER OF BITS ARE LARGER THAN THE TEXT ITSELF?
						System.out.println("How many bits do you want to use?");
						int key2=scnr.nextInt();
						int[] key1=new int[key2];
						int i=0;
						
						while(i<key1.length) {
						System.out.println("Enter a bit at each time");
						key1[i]=scnr.nextInt();
						while (key1[i]!=0 &&
								key1[i]!=1 ) {
							System.out.println("[!]You must either use 0 or 1");
							key1[i]=scnr.nextInt();
						}
						i++;
						}
						XORCipher xor=new XORCipher();
						System.out.println(xor.encryptXOR(text, key1));
						break;
					case 2:
						System.out.println("[!] Please enter binary stream in order to work properly.");
						System.out.println("Enter The binary encrypted stream:");
						text=scnr2.nextLine();
						int j=0;
						//test this
						System.out.println("How many bits do you want to use?");
						int key3=scnr.nextInt();
						int[] key4=new int[key3];
						while(j<key3) {
						System.out.println("Enter a bit at each time");	
						key4[j]=scnr.nextInt();
						while (key4[j]!=0 && key4[j]!=1) {
							System.out.println("[!]You must either use 0 or 1");
							key4[j]=scnr.nextInt();
							
						}	
						j++;
						}
						XORCipher xor_d=new XORCipher();
						System.out.println(xor_d.decryptXOR(text, key4));
						break;
						case 3:
							break;
					default:
						System.out.println("[!] Choose between [1-3]");
					}
				
				break;
			case 7:
				System.out.println(msg);
				int user_choice7=scnr.nextInt();
				switch(user_choice7) {
				case 1:
						System.out.println("Enter The text:");
						text=scnr2.nextLine();
						System.out.println("Enter character shift:");
						int key1=scnr.nextInt();
						CaeserCipher caeser=new CaeserCipher();
						System.out.println(caeser.caeserCipher(text, key1));
						break;
					case 2:
						System.out.println("Enter The text:");
						text=scnr2.nextLine();
						System.out.println("Enter character shift");
						int key2=scnr.nextInt();
						CaeserCipher caeser_d=new CaeserCipher();
						System.out.println(caeser_d.decryptCaeserCipher(text, key2));
						break;
					case 3:
							break;
					default:
						System.out.println("[!] Choose between [1-3]");
					}
				
				break;
			
			case 8:
				System.out.println("[!]Program Ended");
				exit=true;
				break;
			default:
				System.out.println("[!]Choose between [1-8]");
				
			}
		}
		scnr.close();	
		scnr2.close();
	}	
}
