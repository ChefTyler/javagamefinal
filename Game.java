//ChefTyler
//Final Project 2371
//Built from http://ryisnow.net/2017/04/30/a-beginners-text-adventure-game-creation-in-java/
//A lot is editied, changed, altered, modified.

//imports everything the game needs to run
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Game {
	//rules and declrations for the game
	JFrame window;
	Container con;
	JPanel titleNamePanel, startButtonPanel, mainTextPanel, choiceButtonPanel, playerPanel;
	JLabel titleNameLabel, hpLabel, hpLabelNumber, weaponLabel, weaponLabelName;
	Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
	Font normalFont = new Font("Times New Roman", Font.PLAIN, 28);
	JButton startButton, choice1, choice2, choice3, choice4;
	JTextArea mainTextArea;
	int playerHP, goblinHP, greenBlood;
	String weapon, position;
	
	TitleScreenHandler tsHandler = new TitleScreenHandler();
	ChoiceHandler choiceHandler = new ChoiceHandler();
	String[] Animation = {"|", "/", "-", "\\"};
	//THREADING STUFF
	boolean contine_gamer_thread = true;
	Thread t1 = new Thread(new Runnable(){
		public void run()
		{
			int animstate = 0;
			while(contine_gamer_thread){
				mainTextArea.setText("The Game is Over.\nUpon killing the goblin the town welcomes you,\n or you have either attacked the guard\nor died at the hands of the goblin \nI hope you had fun\n" + Animation[animstate] + Animation[animstate] + Animation[animstate] + Animation[animstate] + Animation[animstate] + Animation[animstate] + Animation[animstate] + Animation[animstate] + Animation[animstate]);

				//TODO: sleep

				try{
					Thread.sleep(50);
				}
				catch(InterruptedException e){
					
				}
			animstate++;
			animstate = animstate % 4;
			}
			
		}
	}, "Gamer_Thread");

	public static void main(String[] args) {

//Prints out the line in the terminal used to run the game

		new Game();
		System.out.println("\nHope you enjoyed the game!");
	}
	
	public Game(){
		//creats the frame for the game and colors the background
		window = new JFrame();
		window.setSize(800, 600);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setBackground(Color.DARK_GRAY);
		window.setLayout(null);
		window.setVisible(true);
		con = window.getContentPane();
		//creates the area with the title
		titleNamePanel = new JPanel();
		titleNamePanel.setBounds(100, 100, 600, 150);
		titleNamePanel.setBackground(Color.DARK_GRAY);
		titleNameLabel = new JLabel("Final Project");
		titleNameLabel.setForeground(Color.white);
		titleNameLabel.setFont(titleFont);	
		
		startButtonPanel = new JPanel();
		startButtonPanel.setBounds(300, 400, 200, 100);
		startButtonPanel.setBackground(Color.DARK_GRAY);
		//creats the button and activates it to begin the game
		startButton = new JButton("Begin");
		startButton.setBackground(Color.black);
		startButton.setForeground(Color.white);
		startButton.setFont(normalFont);
		startButton.addActionListener(tsHandler);
		startButton.setFocusPainted(false);
		
		titleNamePanel.add(titleNameLabel);
		startButtonPanel.add(startButton);
		
		con.add(titleNamePanel);
		con.add(startButtonPanel);
	}
	//initializes the game
	public void createGameScreen(){
		
		titleNamePanel.setVisible(false);
		startButtonPanel.setVisible(false);
		
		mainTextPanel = new JPanel();
		mainTextPanel.setBounds(100, 100, 600, 250);
		mainTextPanel.setBackground(Color.black);
		con.add(mainTextPanel);
		//creates the area where text is shown to player
		mainTextArea = new JTextArea("Final Project");
		mainTextArea.setBounds(100, 100, 600, 250);
		mainTextArea.setBackground(Color.black);
		mainTextArea.setForeground(Color.white);
		mainTextArea.setFont(normalFont);
		mainTextArea.setLineWrap(true);
		mainTextPanel.add(mainTextArea);
		//creates where the buttons go
		choiceButtonPanel = new JPanel();
		choiceButtonPanel.setBounds(250, 350, 300, 150);
		choiceButtonPanel.setBackground(Color.DARK_GRAY);
		choiceButtonPanel.setLayout(new GridLayout(4,1));
		con.add(choiceButtonPanel);
		//creats the buttons for choices in the game
		choice1 = new JButton("Choice 1");
		choice1.setBackground(Color.black);
		choice1.setForeground(Color.white);
		choice1.setFont(normalFont);
		choice1.setFocusPainted(false);
		choice1.addActionListener(choiceHandler);
		choice1.setActionCommand("c1");
		choiceButtonPanel.add(choice1);
		choice2 = new JButton("Choice 2");
		choice2.setBackground(Color.black);
		choice2.setForeground(Color.white);
		choice2.setFont(normalFont);
		choice2.setFocusPainted(false);
		choice2.addActionListener(choiceHandler);
		choice2.setActionCommand("c2");
		choiceButtonPanel.add(choice2);
		choice3 = new JButton("Choice 3");
		choice3.setBackground(Color.black);
		choice3.setForeground(Color.white);
		choice3.setFont(normalFont);
		choice3.setFocusPainted(false);
		choice3.addActionListener(choiceHandler);
		choice3.setActionCommand("c3");
		choiceButtonPanel.add(choice3);
		choice4 = new JButton("Choice 4");
		choice4.setBackground(Color.black);
		choice4.setForeground(Color.white);
		choice4.setFont(normalFont);
		choice4.setFocusPainted(false);
		choice4.addActionListener(choiceHandler);
		choice4.setActionCommand("c4");
		choiceButtonPanel.add(choice4);
		//creats stats for the player and adjusts colors and etc.
		playerPanel = new JPanel();
		playerPanel.setBounds(100, 15, 600, 50);
		playerPanel.setBackground(Color.black);
		playerPanel.setLayout(new GridLayout(1,4));
		con.add(playerPanel);
		hpLabel = new JLabel("HP:");
		hpLabel.setFont(normalFont);
		hpLabel.setForeground(Color.orange);
		playerPanel.add(hpLabel);
		hpLabelNumber = new JLabel();
		hpLabelNumber.setFont(normalFont);
		hpLabelNumber.setForeground(Color.orange);
		playerPanel.add(hpLabelNumber);
		weaponLabel = new JLabel("Weapon:");
		weaponLabel.setFont(normalFont);
		weaponLabel.setForeground(Color.orange);
		playerPanel.add(weaponLabel);
		weaponLabelName = new JLabel();
		weaponLabelName.setFont(normalFont);
		weaponLabelName.setForeground(Color.orange);
		playerPanel.add(weaponLabelName);

		playerSetup();


	}//creates the player and the goblin giving them health
	public void playerSetup(){
		playerHP = 10;
		goblinHP = 150;
		weapon = "Fist";
		weaponLabelName.setText(weapon);
		hpLabelNumber.setText("" + playerHP);
		townGate();
	}//opening screen
	public void townGate(){
		position = "townGate";
		mainTextArea.setText("You are at the gate of the town. \nA guard is standing in front of you. \n\nWhat do you do?");		
		choice1.setText("Talk to the guard");
		choice2.setText("Attack the guard");
		choice3.setText("Leave");
		choice4.setText("");
	}
	//starting area and south advancement
	public void talkGuard(){
		position = "talkGuard";
		mainTextArea.setText("Guard: Hello traveler, \nI've never seen you before \nI'm sorry but we cannot let a stranger enter our town.\nHowever there is a Goblin nearby, kill it \nand you are welcome here.");
		choice1.setText("Leave");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	//why would you fight the guard, but if you chose to do so, this is that part of the game
	public void attackGuard(){
		position = "attackGuard";
		mainTextArea.setText("Guard: Hey don't be stupid!\n\nThe guard wacks you with his sword\n");
		playerHP = 0;
		//This annoying loop has taken me two days to get it to work so I'm so done with this. there was a 'while' that existed
		//but with the while it would infinite loop, there is another full loop
		//as per guidelines
		
		if (playerHP <= 0) {lose();}
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("Game Over!");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
	}
	//hub area to travel from
	public void crossRoad(){
		position = "crossRoad";
		mainTextArea.setText("You are at a crossroad.\nIf you go south, you will go back to the town.");
		choice1.setText("Go north");
		choice2.setText("Go east");
		choice3.setText("Go south");
		choice4.setText("Go west");
	}
	//sets north to give you health
	public void north(){
		position = "north";
		mainTextArea.setText("There is a river. \nYou drink the water and rest at the riverside. \n\n(Your HP is recovered by 100)");
		playerHP = playerHP + 100;
		hpLabelNumber.setText(""+playerHP);
		choice1.setText("Go south");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	//sets east to get the long sword
	public void east(){
		position = "east";
		mainTextArea.setText("You walked into a forest and found a Long Sword!\n\n(You obtained a Long Sword)");
		weapon = "Long Sword";
		weaponLabelName.setText(weapon);
		choice1.setText("Go west");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	//prompt and etc. for encountering the goblin
	public void west(){
		position = "west";
		mainTextArea.setText("You encounter a goblin!");
		choice1.setText("Fight");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	//programs the actual fight with the goblin in
	public void fight(){
		position = "fight";
		mainTextArea.setText("Goblin HP: " + goblinHP + "\n\nWhat do you do?");
		choice1.setText("Attack");
		choice2.setText("Run");
		choice3.setText("");
		choice4.setText("");
	}
	//sets player damage for un-armed and armed
	public void playerAttack(){
		position = "playerAttack";
		
		int playerDamage = 1;
		
		if(weapon.equals("Fist")){
			playerDamage = new java.util.Random().nextInt(3);
		}
		else if(weapon.equals("Long Sword")){
			playerDamage = new java.util.Random().nextInt(15); 
		}
		//part of the goblin fight
		mainTextArea.setText("You attacked the goblin and gave " + playerDamage + " damage!");
		
		goblinHP = goblinHP - playerDamage;
		
		choice1.setText("Continue");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");		
	}
	//sets variables and prompts for the goblin fight
	public void goblinAttack(){
		position = "goblinAttack";
		
		int goblinDamage = 25;
		
		goblinDamage = new java.util.Random().nextInt(6); 
		
		mainTextArea.setText("The goblin attacked you and gave " + goblinDamage + " damage!");
		
		playerHP = playerHP - goblinDamage;
		hpLabelNumber.setText(""+playerHP);
		
		choice1.setText("Continue");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");	
	}
	//if you win the fight against the goblin
	public void win(){
		position = "win";
		
		mainTextArea.setText("You defeated the Goblin!\nThe Goblin oozed a thick slime!\n\n(You have collected Green Blood)");
		
		greenBlood = 1;
		
		choice1.setText("Go to crossroads");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		
	}
	//if you die
	public void lose(){
		position = "lose";
		
		mainTextArea.setText("You have been killed!\n\n");
		
		choice1.setText("");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("End");

	}
	
	//the end screen for the game
	public void ending(){
		position = "ending";

		
		mainTextArea.setText("That is the end of the game\nI hope you enjoyed your journey\nGoodbye.\n\n");
		choice1.setText("Thank you!");
		choice2.setText("");
		choice3.setText("");
		choice4.setText("");
		choice1.setVisible(true);
		choice2.setVisible(false);
		choice3.setVisible(false);
		choice4.setVisible(false);

		//Start thread T1
		t1.start();
		//it does its thing
	}



	
	
	
		
	
	
	//creates actionListener for you to start the game
	public class TitleScreenHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			createGameScreen();
		}
	}

	// switch/break for options in the game
	public class ChoiceHandler implements ActionListener{
		
		public void actionPerformed(ActionEvent event){
			
			String yourChoice = event.getActionCommand();
			
			switch(position){
			case "townGate":
				switch(yourChoice){
				case "c1": 
					if(greenBlood==1){
						ending();
					}
					else{
						talkGuard();
					}
				break;
				case "c2": attackGuard();break;
				case "c3": crossRoad();break;
				}
			break;
			case "talkGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
				}
			break;
			case "attackGuard":
				switch(yourChoice){
				case "c1": townGate(); break;
				}
			break;
			case "crossRoad":
				switch(yourChoice){
				case "c1": north(); break;
				case "c2": east();break;
				case "c3": townGate(); break;
				case "c4": west();break;
				}
			break;
			case "north":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
			break;
			case "east":
				switch(yourChoice){
				case "c1": crossRoad(); break;
				}
			break;
			case "west":
				switch(yourChoice){
				case "c1": fight(); break;
				case "c2": crossRoad(); break;
				}
			break;
			case "fight":
				switch(yourChoice){
				case "c1": playerAttack();break;
				case "c2": crossRoad(); break;
				}
			break;
			case "playerAttack":
				switch(yourChoice){
				case "c1": 
					if(goblinHP<1){
						win();
					}
					else{
						goblinAttack();
					}
				break;
				}
			break;
			case "goblinAttack":
				switch(yourChoice){
				case "c1": 
					if(playerHP<1){
						lose();
					}
					else{
						fight();
					}
				}
			break;
			case "win":
				switch(yourChoice){
					case "c1": crossRoad();
				}
			break;
			case "lose":
				switch(yourChoice){
					case "c4": ending(); break;
					case "c3": ending(); break;
					case "c2": ending(); break;
					case "c1": ending(); break;
				}
			break;
			case "ending":
				switch(yourChoice){
					case "c1": contine_gamer_thread = false; 
					try{t1.join();}catch(InterruptedException e){}
					System.exit(0);
					break;
					
				}
			break;
			}
			
			
		}
	}



}
