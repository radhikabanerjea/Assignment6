/*Radhika Banerjea
 * February 7, 2021
 * The GUI shows the following menu:
Encode message given the key to be used.
Decipher message given the key to be used.
Given a message, the output will be the 26 possible decoded messages
Given a message, the output will be the best guessed decoded message

 */
//importing what is necessary
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.MessageBox;
import java.io.IOException;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Text;
import exceptionbasics.EmptyStringException;
import exceptionbasics.IntegerOutOfRangeException;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Assignment6 {
	//variables for the message box and key where they will type in what they want
	private Text message;
	private Text keybox;
	//variable for the shell.
	private Shell shlLoginApp = new Shell();
	 //array that will hold all the different decoded options
	static String [] options = new String[26];
	//variable used for the key
	static int key = 0;
	//used for the while loops in try catch statements
	static boolean c = false;
	//used to hold the char Array versions of the user's input
	static char[]sentence;
	//messagebox variable.
	MessageBox messageBox = new MessageBox(shlLoginApp, SWT.ICON_WARNING);


	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Assignment6 window = new Assignment6();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		//variables for the display, the Labels for the message, the labels for the key.
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(561, 364);
		shell.setText("SWT Application");
		
		Label lblMessage = new Label(shell, SWT.NONE);
		lblMessage.setBounds(35, 50, 70, 20);
		lblMessage.setText("Message:");
		
		Label keyLabel = new Label(shell, SWT.NONE);
		keyLabel.setBounds(35, 143, 70, 20);
		keyLabel.setText("Key:");
		
		//defining the dimeensions of the key and message boxes
		message = new Text(shell, SWT.BORDER);
		message.setBounds(35, 84, 439, 26);
		keybox = new Text(shell, SWT.BORDER);
		keybox.setBounds(35, 175, 70, 26);
		
		//button variable for encoding a message, and the action listener for it too.
		Button btnEncode = new Button(shell, SWT.NONE);
		btnEncode.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				c=false;
				try 
					{ 
					//asks for the key and ensures the input is within the acceptable range.

						key = Integer.parseInt(keybox.getText());
						if (key>25||key<0) {
							//throws exception if it is out of the range
							throw new IntegerOutOfRangeException();
						}
						
						if (message.getText().equals("")) {
							//throws exception if it is out of the range

							throw new EmptyStringException();

						
						}
						c=true;
					}
					 //throws exception if the key inputed isn't a valid integer.
					catch (NumberFormatException e1)  
					{ 
						messageBox.setMessage("not a valid integer"); 		
						messageBox.open();

					} 
				//catching if the key is bigger than 24, or smaller than 1
					catch (IntegerOutOfRangeException e1)  
					{ 
						
						messageBox.setMessage("Please enter a message between 0 and 25"); 
						messageBox.open();
					} 
				//catching if the message is empty
					catch (EmptyStringException e1)  
					{ 
						messageBox.setMessage("Your input must contain something. Try again."); 
						messageBox.open();

					} 
					
				
				
				
				//converts input to char array, goes to encode method for the correct encoded version. then displays it on a message box
				if (c) {
					sentence = message.getText().toCharArray();
					for (int i = 0;i<sentence.length; i++) {
						System.out.println(sentence[i]);
					}
					messageBox.setMessage("The encripted form is: " + encode(sentence,key));
					messageBox.open();

				}
			}
		});
		btnEncode.setBounds(35, 239, 90, 30);
		btnEncode.setText("Encode:");
		
	
		//button variable for the button that decodes the message with a given key
		Button btnDecipher = new Button(shell, SWT.NONE);
		btnDecipher.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				c=false;	
				//try and catch to see if the user enters and empty message, or a key that is out of range, or a key that is not an integer.
				try 
					{ 
						key = Integer.parseInt(keybox.getText());
						if (key>25||key<0) {
							//throws exception if it is out of the range
							throw new IntegerOutOfRangeException();
						}
						
						if (message.getText().equals("")) {
							//throws exception if it is out of the range

							throw new EmptyStringException();

						
						}
						c=true;
					}
					 
					catch (NumberFormatException e1)  
					{ 
						messageBox.setMessage("not a valid integer"); 		
						messageBox.open();

					} 
					catch (IntegerOutOfRangeException e1)  
					{ 
						
						messageBox.setMessage("Please enter a key between 0 and 25"); 
						messageBox.open();
					} 
					catch (EmptyStringException e1)  
					{ 
						messageBox.setMessage("Your input must contain something. Try again."); 
						messageBox.open();

					} 
					
				
				
				
				//converts input to char array, goes to decode for the correct decoded version, then displays it in the message box.
				if (c) {
					sentence = message.getText().toCharArray();
					for (int i = 0;i<sentence.length; i++) {
						System.out.println(sentence[i]);
					}
					messageBox.setMessage("The decryipted form is: " + decode(sentence,key));
					messageBox.open();

				}
			
			}
		});
		btnDecipher.setText("Decipher");
		btnDecipher.setBounds(142, 239, 90, 30);
		
	
		//button variable for option of printing out all the potential decoded versions.
		Button btnAllGueses = new Button(shell, SWT.NONE);
		btnAllGueses.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				
				c=false;
				//try and catch for seeing whether the message inputted is empty.
				try 
					{ 	
						if (message.getText().equals("")) {
							//throws exception if it is out of the range

							throw new EmptyStringException();
						
						}
						c=true;
					}

					catch (EmptyStringException e1)  
					{ 
						messageBox.setMessage("Your input must contain something. Try again."); 
						messageBox.open();

					} 
					
				
				//converts input to char array, makes the list of decoded options and sends the options to the list class so they can be displayed.
				if (c) {
				
					//converts input to char array, goes to breakCode method for all of the encription possibilities.
					sentence = message.getText().toCharArray();			
					options = breakCode(sentence);
					String list = "";
					//adds the returned array from break code to a string.
					for (int i = 0; i<options.length; i++) {
						list = list + options[i] + "\n";
					}
					
					try {
						new Lists (list);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
				
			}
		});
		
		
		btnAllGueses.setBounds(247, 239, 90, 30);
		btnAllGueses.setText("All Guesses");
		

		//button variable for trying to find the best guess
		Button btnBestGuess = new Button(shell, SWT.NONE);
		btnBestGuess.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				c=false;	
				//try and catch for seeing whether the message inputted is empty.

				try 
					{
						if (message.getText().equals("")) {
							//throws exception if it is out of the range

							throw new EmptyStringException();

						
						}
						c=true;
					}
					 
				catch (EmptyStringException e1)  
					{ 
						System.out.println("im an empty string");
						messageBox.setMessage("Your input must contain something. Try again."); 
						messageBox.open();

					} 
					
				
				
				//converts input to char array, goes to attempt method for the attempted decoded version. Displays the attempted decoded version.
				if (c) {
			
					String input = message.getText();
					messageBox.setMessage("The attempted decryipted form is: " + attempt(input));
					messageBox.open();

				}
			}
		});
		btnBestGuess.setBounds(353, 239, 90, 30);
		btnBestGuess.setText("Best Guess");
		
	

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * This method takes the sentence char Array made from the users input and goes through the ASCII codes for all the characters that are the alphabet uppercase and lower case. Then the key is added to those ASCII code number to shift the characters for the Caesar cypher. If the character goes past z when the key is added, then 26 is  subtracted from that number to loop it back to the beginning of the alphabet. The encrypted version is then returned
	 * @param sentence the message to be encoded
	 * @param key the key by which each letter will be moved through the alphabet.
	 * @return the encoded message
	 */
	public static String encode(char [] sentence, int key) {
		String output = "";
		for (int i=0;i<sentence.length;i++) {
			if (sentence[i]<=90 &&sentence[i]>=65) {
				sentence [i] = (char)(sentence [i] + key);
				if (sentence [i]>90) {
					sentence [i] = (char)(sentence [i] - 26);
				}
			}
			else if (sentence[i]<=122 &&sentence[i]>=97) {
				sentence [i] = (char)(sentence [i] + key);
				if (sentence [i]>122) {
					sentence [i] = (char)(sentence [i] - 26);
				}
			}
			
			output = output +sentence [i];
		
		}
		return output;
	}

	/**
	 * This method takes the sentence char Array made from the users input and goes through the ASCII codes for all the characters that are the alphabet uppercase and lower case. Then the key is subtracted to those ASCII code numbers to shift the characters for the Caesar cypher. If the character goes past z when the key is added, then 26 is  added to that number to loop it back to the end of the alphabet. The decoded version is then returned as a string so that it can be used in the next method.
	 * @param sentence  the sentence to decode
	 * @param key the key used to see how many spaces to go back when decoding
	 * @return
	 */
	public static String decode(char [] sentence, int key) {
		//char [] sent = new char[sentence.length];
		for (int i=0;i<sentence.length;i++) {
			if (sentence[i]<=90 &&sentence[i]>=65) {
				sentence [i] = (char)(sentence [i] - key);
				if (sentence [i]<65) {
				sentence [i] = (char)(sentence [i] + 26);
				}
			}
			else if (sentence[i]<=122 &&sentence[i]>=97) {
				sentence [i] = (char)(sentence [i] - key);
				if (sentence [i]<97) {
				sentence [i] = (char)(sentence [i] + 26);
				}
			}
			
		}
		//string that combines the values of the char array sentence into one string.
		String line = new String(sentence);
		return line;
		
	}

	/**
	 * This method takes the sentence char Array made from the users input. It runs 26 times. on the time that is zero, it just takes the value of i in the for loop for the key. But from 1-25, it just takes one as the key because sentence keeps replacing itself in the decode method. It saves all of the different ways that
	 * the sentence could be decoded and saves it in the array options. It then returns options.
	 * @param sentence array to find the possible decoded versions of
	 * @return array of decoded versions
	 */
	public static String[] breakCode(char [] sentence) {
		for (int i = 0;i<26;i++) {
			switch (i) {
				case 0:
					options[i] = decode(sentence,i);
				break;
				
				default:
					options [i] = decode(sentence,1);
			}
		}
		
		return options;
	}
	
	/**
	 * method that attempts to decode a given string. It checks for the ratio of consonants to vowels, and it searches for common words in different decoded versions of the 
	 * @param input the message to decode from the user
	 * @return returns the attempted deoded version
	 */
	public static String attempt(String input) {
		//converting input to char array and finding all the possible decoded options.
		sentence = input.toCharArray();  
		options = breakCode(sentence);
	
		//boolean used to exit the method when needed
		boolean a = true;
		//for loop that cycles from 0 to 26 so that it cycles through all the encription options
		for(int i = 0;i<26;i++) {
			//splits the options into individual words so that can be analyzed
			String[] tokens = options[i].split(" ");			
			//for loop cycles through the length of the tokens array 
			for (int j = 0;j<tokens.length;j++) {
				//checks for some of the most common english words being present in one of the options, then printing that out
				//It excludes 'a' so if a single letter word begins a sentence it won't automatically choose the option with A in the beginning
				if (tokens[j].equalsIgnoreCase("and")||tokens[j].equalsIgnoreCase("the")||tokens[j].equalsIgnoreCase("of")||tokens[j].equalsIgnoreCase("it")||tokens[j].equalsIgnoreCase("that")||tokens[j].equalsIgnoreCase("you")||tokens[j].equalsIgnoreCase("to")||tokens[j].equalsIgnoreCase("in")) {
					System.out.println(options[i]);
					return options[i];
				
				}
				//if there aren'ts any common english words then it checks whether fifty-eight percent of the letters are consonants
				//because that is the minimum ratio of consonants to vowels in a sentence usually.
				else if (i==25 && j==(tokens.length-1)) {
					for (int h = 0;h<26;h++) {
						char [] broken = options[h].toCharArray();
						//variables that keep track of the number of consonants and vowels.
						double v = 0;
						double c = 0;
		
						for (int r = 0; r<broken.length; r++) {
							switch(broken[r]) {
							//adds to v if its a vowel, adds to c if its a consonant.	
							case 'A','a','E','e','I','i','O','o','U','u':
									v++;
								break;
								case 'B','b','C','c','D','d','F','f','G','g','H','h','J','j','K','k','L','l','M','m','N','n','P','p','Q','q','R','r','S','s','T','t','V','v','W','w','X','x','Y','y','Z','z':
									c++;

								break;
							}
						}
						//does the math for if the ratio is 0.58, and prints out the option that is greater than 0.58.
						double x = c/(v+c);
						if (x>=0.58) {
							System.out.println(options[h]);
							return options [h];
						}
					}
					
				}
			}
		}
	
		return null;
	}
	

}
