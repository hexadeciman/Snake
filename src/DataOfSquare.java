import java.util.ArrayList;
import java.awt.Color;

public class DataOfSquare {

	
	//ArrayList that'll contain the colors
	ArrayList<Color> ColorArray =new ArrayList<Color>();
	int color; //2: snake , 1: food, 0:empty 
	SquarePanel square;
	public DataOfSquare(int col){
		
		//Lets add the color to the arrayList
		ColorArray.add(Color.darkGray);//0 
		ColorArray.add(Color.BLUE);    //1 
		ColorArray.add(Color.white);   //2 
		color=col;
		square = new SquarePanel(ColorArray.get(color));
	}
	public void lightMeUp(int colorObject){
		square.ChangeColor(ColorArray.get(colorObject));
	}
}
