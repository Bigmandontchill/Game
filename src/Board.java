import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * This class create the  game board and perform logic of the game.
 * @author  Tianran Wang
 */
public class Board implements ActionListener {
    /**use to check when redfrog is selected*/
    private boolean redselected = false;
    /**use to check when greenfrog is selected*/
    private boolean greenselected = false;
    /**use to store  selected button for greenfrog*/
    private JButton greenbutton = new JButton();
    /**use to store Lilypads*/
    private Square Lilypads[] = new Square[13];
    /**length of Lilypads array*/
    private int Lilylength = 0;
    /**use to store frogs*/
    private ArrayList<Square> frogs = new ArrayList<Square>();
    /**use to switch to game mode */
    private boolean menu = true;
    /**use to  select difficulties level */
    private JButton button1 = new JButton("MEDIUM");
    /**use to  select difficulties level */
    private JButton button2 = new JButton("EASY");
    /**use to  select difficulties level */
    private JButton button3 = new JButton("HARD");
    private JPanel panel;
    private JFrame frame;

    /**
     * It create  a window for the game
     */
    public Board() {
        frame = new JFrame();//CREATE A Jframe
        panel = new JPanel();//create a panel
        frame.setContentPane(panel);// add panel to the frame
        frame.setTitle("Time");
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setVisible(true);//we can see it
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.setPreferredSize(new Dimension(250, 230));
        button2.setPreferredSize(new Dimension(250, 230));
        button3.setPreferredSize(new Dimension(250, 230));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
    }

    /**
     * it execute if any button is clciked
     * @param e store the button that I pressed
     */
    public void actionPerformed(ActionEvent e) {
        if (menu == true) {

            if (e.getSource() == button1) {
                menu = false;
                loadlevel(1);

            } else if (e.getSource() == button2) {
                menu = false;
                loadlevel(2);

            } else if (e.getSource() == button3) {
                menu = false;
                loadlevel(3);

            }

        }
        //start of gamemode
        if (menu == false) {

          Gamelogic(e);
          displaywin();
        }
    }

    /**
     * This move a frog on to  the lilypad
     * @param index     is position of the frog in the list frogs
     * @param Lilyindex is  position of the lilypad in the array Lilypads
     */

    private void moveTo(int index, int Lilyindex) {
        //switch the look
        ImageIcon i = new ImageIcon(frogs.get(index).getImage() + ".png");
        Lilypads[Lilyindex].getButton().setIcon(i);
        i = new ImageIcon(Lilypads[Lilyindex].getImage() + ".png");
        frogs.get(index).getButton().setIcon(i);
        //switch the square between list frogs and Square LilyPads
        Square temp = frogs.get(index);
        frogs.set(index, Lilypads[Lilyindex]);
        Lilypads[Lilyindex] = temp;
        //switch the image
        String tempt = frogs.get(index).getImage();
        frogs.get(index).setImage(Lilypads[Lilyindex].getImage());
        Lilypads[Lilyindex].setImage(tempt);

    }
    /**
     * set the icon of the button
     * @param image  new icon for the button
     * @param button
     */
    private void setButtonIcon(String image, JButton button) {
        ImageIcon i = new ImageIcon(image + ".png");
        button.setIcon(i);
    }

    /**
     * remove  frogs  that have been jumped over if user perform a legal move
     * @param removex   use to check legal move
     * @param removey   use to check legal move
     * @param index     is position of the frog in the list frogs
     * @param Lilyindex is  position of the lilypad in the array Lilypads
     */
    private void deleteFrog(double removex, double removey, int index, int Lilyindex) {
        for (int n = 1; n < frogs.size(); n++) {
            if (frogs.get(n).getX() == removex && frogs.get(n).getY() == removey) {
                moveTo(index, Lilyindex);
                //remove greenfrog from the list ,add the greenfrog to array LilyPads
                frogs.get(n).setImage("LilyPad");
                setButtonIcon("LilyPad", frogs.get(n).getButton());
                Lilypads[Lilylength] = frogs.get(n);
                frogs.remove(n);
                Lilylength++;
                //deselect the redfrog and greenfrog
                redselected = false;
                greenselected = false;
                n = frogs.size();
            }

        }
    }


    /**
     * It load level
     * @param level the level that you want to load (the game has 3 level )
     */
    private void loadlevel(int level) {
        panel.remove(button1);
        panel.remove(button2);
        panel.remove(button3);
        int findredfrog = 0;
        int findgreenfrogs;
        Square squares[] = new Square[25];
        if (level == 1) {
            //set up all the squares for easy level
            Square square0 = new Square(1, 1, "LilyPad");
            Square square1 = new Square(1, 2, "Water");
            Square square2 = new Square(1, 3, "LilyPad");
            Square square3 = new Square(1, 4, "Water");
            Square square4 = new Square(1, 5, "LilyPad");
            Square square5 = new Square(2, 1, "Water");
            Square square6 = new Square(2, 2, "GreenFrog");
            Square square7 = new Square(2, 3, "Water");
            Square square8 = new Square(2, 4, "GreenFrog");
            Square square9 = new Square(2, 5, "Water");
            Square square10 = new Square(3, 1, "LilyPad");
            Square square11 = new Square(3, 2, "Water");
            Square square12 = new Square(3, 3, "GreenFrog");
            Square square13 = new Square(3, 4, "Water");
            Square square14 = new Square(3, 5, "LilyPad");
            Square square15 = new Square(4, 1, "Water");
            Square square16 = new Square(4, 2, "LilyPad");
            Square square17 = new Square(4, 3, "Water");
            Square square18 = new Square(4, 4, "LilyPad");
            Square square19 = new Square(4, 5, "Water");
            Square square20 = new Square(5, 1, "GreenFrog");
            Square square21 = new Square(5, 2, "Water");
            Square square22 = new Square(5, 3, "RedFrog");
            Square square23 = new Square(5, 4, "Water");
            Square square24 = new Square(5, 5, "GreenFrog");
            squares[0] = square0;
            squares[1] = square1;
            squares[2] = square2;
            squares[3] = square3;
            squares[4] = square4;
            squares[5] = square5;
            squares[6] = square6;
            squares[7] = square7;
            squares[8] = square8;
            squares[9] = square9;
            squares[10] = square10;
            squares[11] = square11;
            squares[12] = square12;
            squares[13] = square13;
            squares[14] = square14;
            squares[15] = square15;
            squares[16] = square16;
            squares[17] = square17;
            squares[18] = square18;
            squares[19] = square19;
            squares[20] = square20;
            squares[21] = square21;
            squares[22] = square22;
            squares[23] = square23;
            squares[24] = square24;
        } else if (level == 2) {
            //set up all the squares for medium level
            Square square0 = new Square(1, 1, "RedFrog");
            Square square1 = new Square(1, 2, "Water");
            Square square2 = new Square(1, 3, "LilyPad");
            Square square3 = new Square(1, 4, "Water");
            Square square4 = new Square(1, 5, "LilyPad");
            Square square5 = new Square(2, 1, "Water");
            Square square6 = new Square(2, 2, "GreenFrog");
            Square square7 = new Square(2, 3, "Water");
            Square square8 = new Square(2, 4, "LilyPad");
            Square square9 = new Square(2, 5, "Water");
            Square square10 = new Square(3, 1, "LilyPad");
            Square square11 = new Square(3, 2, "Water");
            Square square12 = new Square(3, 3, "LilyPad");
            Square square13 = new Square(3, 4, "Water");
            Square square14 = new Square(3, 5, "LilyPad");
            Square square15 = new Square(4, 1, "Water");
            Square square16 = new Square(4, 2, "LilyPad");
            Square square17 = new Square(4, 3, "Water");
            Square square18 = new Square(4, 4, "GreenFrog");
            Square square19 = new Square(4, 5, "Water");
            Square square20 = new Square(5, 1, "LilyPad");
            Square square21 = new Square(5, 2, "Water");
            Square square22 = new Square(5, 3, "LilyPad");
            Square square23 = new Square(5, 4, "Water");
            Square square24 = new Square(5, 5, "LilyPad");
            squares[0] = square0;
            squares[1] = square1;
            squares[2] = square2;
            squares[3] = square3;
            squares[4] = square4;
            squares[5] = square5;
            squares[6] = square6;
            squares[7] = square7;
            squares[8] = square8;
            squares[9] = square9;
            squares[10] = square10;
            squares[11] = square11;
            squares[12] = square12;
            squares[13] = square13;
            squares[14] = square14;
            squares[15] = square15;
            squares[16] = square16;
            squares[17] = square17;
            squares[18] = square18;
            squares[19] = square19;
            squares[20] = square20;
            squares[21] = square21;
            squares[22] = square22;
            squares[23] = square23;
            squares[24] = square24;
        } else {
            //set up all the squares for hard level
            Square square0 = new Square(1, 1, "LilyPad");
            Square square1 = new Square(1, 2, "Water");
            Square square2 = new Square(1, 3, "LilyPad");
            Square square3 = new Square(1, 4, "Water");
            Square square4 = new Square(1, 5, "GreenFrog");
            Square square5 = new Square(2, 1, "Water");
            Square square6 = new Square(2, 2, "GreenFrog");
            Square square7 = new Square(2, 3, "Water");
            Square square8 = new Square(2, 4, "LilyPad");
            Square square9 = new Square(2, 5, "Water");
            Square square10 = new Square(3, 1, "GreenFrog");
            Square square11 = new Square(3, 2, "Water");
            Square square12 = new Square(3, 3, "GreenFrog");
            Square square13 = new Square(3, 4, "Water");
            Square square14 = new Square(3, 5, "LilyPad");
            Square square15 = new Square(4, 1, "Water");
            Square square16 = new Square(4, 2, "LilyPad");
            Square square17 = new Square(4, 3, "Water");
            Square square18 = new Square(4, 4, "GreenFrog");
            Square square19 = new Square(4, 5, "Water");
            Square square20 = new Square(5, 1, "RedFrog");
            Square square21 = new Square(5, 2, "Water");
            Square square22 = new Square(5, 3, "GreenFrog");
            Square square23 = new Square(5, 4, "Water");
            Square square24 = new Square(5, 5, "LilyPad");
            squares[0] = square0;
            squares[1] = square1;
            squares[2] = square2;
            squares[3] = square3;
            squares[4] = square4;
            squares[5] = square5;
            squares[6] = square6;
            squares[7] = square7;
            squares[8] = square8;
            squares[9] = square9;
            squares[10] = square10;
            squares[11] = square11;
            squares[12] = square12;
            squares[13] = square13;
            squares[14] = square14;
            squares[15] = square15;
            squares[16] = square16;
            squares[17] = square17;
            squares[18] = square18;
            squares[19] = square19;
            squares[20] = square20;
            squares[21] = square21;
            squares[22] = square22;
            squares[23] = square23;
            squares[24] = square24;
        }
        //Gridlayout for the panel
        GridLayout layout = new GridLayout(5, 5);
        panel.setLayout(layout);

        //add button to the panel
        for (int x = 0; x < 25; x++) {
            panel.add(squares[x].getButton());
        }

        //add panel to the JFrame
        frame.setContentPane(panel);


        while (squares[findredfrog].getImage() != "RedFrog") {
            findredfrog++;
        }

        squares[findredfrog].getButton().addActionListener(this);
        frogs.add(squares[findredfrog]);//add redfrog to the frog list

        //add greenfrogs to the frog list
        for (findgreenfrogs = 0; findgreenfrogs < 25; findgreenfrogs++) {
            if (squares[findgreenfrogs].getImage() == "GreenFrog") {
                squares[findgreenfrogs].getButton().addActionListener(this);
                frogs.add(squares[findgreenfrogs]);
            }
        }

        //add lilypads to the  array LilyPad
        for (int find = 0; find < 25; find++) {
            if (squares[find].getImage() == "LilyPad") {
                squares[find].getButton().addActionListener(this);
                Lilypads[Lilylength] = squares[find];
                Lilylength++;
            }
        }
    }

    /**
     * It return true if any green frog is selected
     */
    private boolean Greenfrogisclciked(ActionEvent e) {
        boolean Green = false;
        for (int g = 1; g < frogs.size(); g++) {
            if (e.getSource() == frogs.get(g).getButton()) {
                Green = true;//Green is true if any greenfrog button is clicked

            }
        }
        return Green;
    }


    /**
     * It  return true if  any lilypad is clciked
     */
    private boolean LilyPadisclciked(ActionEvent e) {
        boolean pad = false;
        for (int i = 0; i < Lilylength; i++) {
            if (e.getSource() == Lilypads[i].getButton()) {
                pad = true;//pad is true if any lilypad  button is clicked
            }
        }
        return pad;
    }

    /**
     * Dispaly a win message
     */
    private void displaywin() {

        if (frogs.size() == 1) {
            setButtonIcon("win", frogs.get(0).getButton());

            for (int x = 0; x < Lilylength; x++) {

                setButtonIcon("win", Lilypads[x].getButton());
            }
        }

    }


    /**
     * This method perform the logic of the game
     */
    private void Gamelogic(ActionEvent e) {
        int x = 0;
        if (e.getSource() == frogs.get(0).getButton() && redselected == false) {
            //deselect the greenfrog button
            if (greenselected == true) {
                setButtonIcon("GreenFrog", greenbutton);
                greenselected = false;
            }
            //change the icon if redfrog is clciked
            setButtonIcon("RedFrog2", frogs.get(0).getButton());
            redselected = true;
        } else if (Greenfrogisclciked(e) && greenselected == false) {
            //deselect the redfrog button
            if (redselected == true) {
                setButtonIcon("RedFrog", frogs.get(0).getButton());
                redselected = false;
            }
            //change the icon if greenfrog is clciked
            greenbutton = (JButton) e.getSource();
            setButtonIcon("GreenFrog2", greenbutton);
            greenselected = true;
        }
        //to switch higlighted greenfrog
        if (greenselected && e.getSource() != greenbutton && Greenfrogisclciked(e)) {
            setButtonIcon("GreenFrog", greenbutton);
            greenbutton = (JButton) e.getSource();
            setButtonIcon("GreenFrog2", greenbutton);
        } else if (redselected && LilyPadisclciked(e)) {
            //check the button that you pressed ,store in the button
            JButton button = (JButton) e.getSource();
            while (Lilypads[x].getButton() != button) {
                x++;  // loop stop when if any button in array  Lilypads match button
            }
            double removex = (double) (Lilypads[x].getX() + frogs.get(0).getX()) / 2;//calculate move for x
            double removey = (double) (Lilypads[x].getY() + frogs.get(0).getY()) / 2;//calculate for y
            deleteFrog(removex, removey, 0, x);
        } else if (greenselected && LilyPadisclciked(e)) {
            int u = 1;
            x = 0;
            JButton button = (JButton) e.getSource();
            while (Lilypads[x].getButton() != button) {
                x++;//the buttopn that yoy click
            }

            while (frogs.get(u).getButton() != greenbutton) {

                u++;
            }

            double removex = (double) (Lilypads[x].getX() + frogs.get(u).getX()) / 2;
            double removey = (double) (Lilypads[x].getY() + frogs.get(u).getY()) / 2;
            deleteFrog(removex, removey, u, x);

        }

    }

}