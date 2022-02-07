import java.io.IOException;

import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.List;

public class Lists {
	protected Shell shlAllPossibleGuesses;

	
	public Lists (String lists) throws IOException {
		try {
			Display display = Display.getDefault();
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
	 * Open the window.
	 */
	public void open() {
		
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents(String lists) {
		shlAllPossibleGuesses = new Shell();
		shlAllPossibleGuesses.setSize(320, 602);
		shlAllPossibleGuesses.setText("All Possible Guesses");
		
		Label lblList = new Label(shlAllPossibleGuesses, SWT.NONE);
		lblList.setBounds(10, 10, 188, 523);
		lblList.setText(lists);

	}
}
