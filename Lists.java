/*Radhika Banerjea
 * February 7, 2021
 * pop up window for all the encoding options
 */
//importing what's necessary
import java.io.IOException;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;

public class Lists {
	protected Shell shlAllPossibleGuesses;

	/**
	 * 
	 * @param lists the list of all the possible decoding options
	 * @throws IOException
	 */
	public Lists (String lists) throws IOException {
		try {
			//creating the display.
			Display display = Display.getDefault();
			//going to the method that makes the shell and has the label with the options.
			createContents(lists);
			shlAllPossibleGuesses.open();
			shlAllPossibleGuesses.layout();
			while (!shlAllPossibleGuesses.isDisposed()) {
				if (!display.readAndDispatch()) {
					display.sleep();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}




	/**
	 * Create contents of the window.
	 */
	protected void createContents(String lists) {
		//creating the shell, and the dimensions of the shell for lists
		shlAllPossibleGuesses = new Shell();
		shlAllPossibleGuesses.setSize(320, 602);
		shlAllPossibleGuesses.setText("All Possible Guesses");
		
		//dimensions of the label that contains all the info of the guesses.
		Label lblList = new Label(shlAllPossibleGuesses, SWT.NONE);
		lblList.setBounds(10, 10, 188, 523);
		lblList.setText(lists);

	}
}
