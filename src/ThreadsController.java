
import java.util.ArrayList;
import java.util.Scanner;
import java.io.InputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;



public class ThreadsController extends Thread {
	int points = 0;
    ArrayList<ArrayList<DataOfSquare>> Squares = new ArrayList<ArrayList<DataOfSquare>>();
    Tuple headSnakePos;
    int sizeSnake = 3;
    long speed = 50;
    public static int directionSnake;

    ArrayList<Tuple> positions = new ArrayList<Tuple>();
    Tuple foodPosition;
    private boolean isPaused = false; // Add this line

    // Constructor of ControlleurThread
    ThreadsController(Tuple positionDepart) {
        // Get all the threads
        Squares = Window.Grid;

        headSnakePos = new Tuple(positionDepart.x, positionDepart.y);
        directionSnake = 1;

        // !!! Pointer !!!!
        Tuple headPos = new Tuple(headSnakePos.getX(), headSnakePos.getY());
        positions.add(headPos);

        foodPosition = new Tuple(Window.height - 1, Window.width - 1);
        spawnFood(foodPosition);
    }

    // Important part:
    public void run() {
        while (true) {
            if (!isPaused) { // Check if the game is not paused
                moveInterne(directionSnake);
                checkCollision();
                moveExterne();
                deleteTail();
            }
            pauser();
        }
    }

	 
	 //delay between each move of the snake
	 private void pauser(){
		 try {
				sleep(speed);
		 } catch (InterruptedException event) {
			event.printStackTrace();
		 }
	 }
	 //


	 //Checking if the snake bites itself or is eating

private void checkCollision() {
    Scanner sc = new Scanner(System.in);
    Tuple posCritique = positions.get(positions.size() - 1);
    for (int i = 0; i <= positions.size() - 2; i++) {
        boolean biteItself = posCritique.getX() == positions.get(i).getX() && posCritique.getY() == positions.get(i).getY();
        if (biteItself) {
            System.out.println("Restart? (y/n)");
            String yesOrNo = sc.nextLine(); // Use nextLine() instead of hasNextLine
			if ("y".equals(yesOrNo)) {
				// Close the scanner before restarting

				// Create a new instance of ThreadsController and start it
				ThreadsController newController = new ThreadsController(new Tuple(10, 10));
				// Update headSnakePos and foodPosition for the new instance
				newController.headSnakePos = new Tuple(10, 10);
				newController.foodPosition = new Tuple(Window.height - 1, Window.width - 1);
				// Clear the positions array
				newController.positions.clear();
				Tuple headPos = new Tuple(newController.headSnakePos.getX(), newController.headSnakePos.getY());
				newController.positions.add(headPos);
				newController.isPaused = false;
				newController.start();

            } else if ("n".equals(yesOrNo)) {

                stopTheGame();
            }
        }
    }

		 boolean eatingFood = posCritique.getX()==foodPosition.y && posCritique.getY()==foodPosition.x;
		 if(eatingFood){
			points+=1; //points added
			System.out.println("Yummy!");
			System.out.println("Points:" + points);
			sizeSnake=sizeSnake+1; 
			foodPosition = getValAleaNotInSnake();
			spawnFood(foodPosition);	
		//adds crunch sound
			try {
				//obtains inputStream of NewcrunchSound
				InputStream inputStream = this.getClass().getResourceAsStream("NewcrunchSound.wav");

				// Check if the input stream is null before proceeding
				if (inputStream != null) {
					//creates an AudioInputStream from the loaded sound file.
					AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(inputStream);

					//  specifies the audio format (16-bit PCM, 44100 Hz, 1 channel)
					AudioFormat format = new AudioFormat(44100, 16, 1, true, false);
					//converts the original AudioInputStream to match the specified audio format.
					AudioInputStream compatibleInputStream = AudioSystem.getAudioInputStream(format, audioInputStream);
					//crates Clip object and opens it with AudioInputStream
					Clip clip = AudioSystem.getClip();
					clip.open(compatibleInputStream);

					clip.start();
					
					// checks if clip is running
					while (clip.isRunning()) {
						Thread.sleep(10);
					}
				} else {
					System.err.println("Error. Input is null.");
				}
			} catch (Exception e) {
				e.printStackTrace();
				System.err.println("Error playing sound: " + e.getMessage());
			}


			
		}
	 }



	 //Stops The Game
	 private void stopTheGame(){
		 System.out.println("COLISION! \n");
		 while(true){
			 pauser();
		 }
	 }
	 
	 //Put food in a position and displays it
	 private void spawnFood(Tuple foodPositionIn){
		 	Squares.get(foodPositionIn.x).get(foodPositionIn.y).lightMeUp(1);
	 }
	 
	 //return a position not occupied by the snake
	 private Tuple getValAleaNotInSnake(){
		 Tuple p ;
		 int ranX= 0 + (int)(Math.random()*19); 
		 int ranY= 0 + (int)(Math.random()*19); 
		 p=new Tuple(ranX,ranY);
		 for(int i = 0;i<=positions.size()-1;i++){
			 if(p.getY()==positions.get(i).getX() && p.getX()==positions.get(i).getY()){
				 ranX= 0 + (int)(Math.random()*19); 
				 ranY= 0 + (int)(Math.random()*19); 
				 p=new Tuple(ranX,ranY);
				 i=0;
			 }
		 }
		 return p;
	 }
	 
	 //Moves the head of the snake and refreshes the positions in the arraylist
	 //1:right 2:left 3:top 4:bottom 0:nothing
	 private void moveInterne(int dir){
		 switch(dir){
		 	case 4:
				 headSnakePos.ChangeData(headSnakePos.x,(headSnakePos.y+1)%20);
				 positions.add(new Tuple(headSnakePos.x,headSnakePos.y));
		 		break;
		 	case 3:
		 		if(headSnakePos.y-1<0){
		 			 headSnakePos.ChangeData(headSnakePos.x,19);
		 		 }
		 		else{
				 headSnakePos.ChangeData(headSnakePos.x,Math.abs(headSnakePos.y-1)%20);
		 		}
				 positions.add(new Tuple(headSnakePos.x,headSnakePos.y));
		 		break;
		 	case 2:
		 		 if(headSnakePos.x-1<0){
		 			 headSnakePos.ChangeData(19,headSnakePos.y);
		 		 }
		 		 else{
		 			 headSnakePos.ChangeData(Math.abs(headSnakePos.x-1)%20,headSnakePos.y);
		 		 } 
		 		positions.add(new Tuple(headSnakePos.x,headSnakePos.y));

		 		break;
		 	case 1:
				 headSnakePos.ChangeData(Math.abs(headSnakePos.x+1)%20,headSnakePos.y);
				 positions.add(new Tuple(headSnakePos.x,headSnakePos.y));
		 		 break;
		 }
	 }
	 
	 //Refresh the squares that needs to be 
	 private void moveExterne(){
		 for(Tuple t : positions){
			 int y = t.getX();
			 int x = t.getY();
			 Squares.get(x).get(y).lightMeUp(0);
			 
		 }
	 }
	 
	 //Refreshes the tail of the snake, by removing the superfluous data in positions arraylist
	 //and refreshing the display of the things that is removed
	 private void deleteTail(){
		 int cmpt = sizeSnake;
		 for(int i = positions.size()-1;i>=0;i--){
			 if(cmpt==0){
				 Tuple t = positions.get(i);
				 Squares.get(t.y).get(t.x).lightMeUp(2);
			 }
			 else{
				 cmpt--;
			 }
		 }
		 cmpt = sizeSnake;
		 for(int i = positions.size()-1;i>=0;i--){
			 if(cmpt==0){
				 positions.remove(i);
			 }
			 else{
				 cmpt--;
			 }
		 }
	 }
}
