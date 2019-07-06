import java.awt.Color;
import javax.swing.JPanel;

public class SquarePanel extends JPanel{
	
	private static final long serialVersionUID = 1L;

	protected SquarePanel(Color d){
		this.setBackground(d);
	}
	
	protected void ChangeColor(Color d){
		this.setBackground(d);
		this.repaint();
	}
	
}

