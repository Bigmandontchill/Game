import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board implements  ActionListener {
    private boolean redselected = false;
    private boolean greenselected = false;
    private JButton greenbutton = new JButton();
    private Square Lilypads[] = new Square[13];
    private int Lilylength = 1;
    private ArrayList<Square> frogs = new ArrayList<Square>();
    private boolean menu = true;
    private JButton button1 = new JButton("1");
    private JButton button2 = new JButton("2");
    private JButton button3 = new JButton("3");
    private JPanel panel;
    private JFrame frame;

    public Board() {

         frame = new JFrame();//CREATE A Jframe
        panel = new JPanel();//create a panel
        frame.setContentPane(panel);// add panel to the frame
        frame.setTitle("Time");
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setVisible(true);//we can see it
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        button1.setPreferredSize(new Dimension(250,230));
        button2.setPreferredSize(new Dimension(250, 230));
        button3.setPreferredSize(new Dimension(250, 230));
        panel.add(button1);
        panel.add(button2);
        panel.add(button3);
        button1.addActionListener(this);
        button2.addActionListener(this);
        button3.addActionListener(this);
    }

    //will do it when you click  any  button
    public void actionPerformed(ActionEvent e) {
        int x = 0;
        int z = 0;
        boolean pad = false;
        boolean Green = false;

        if (menu == true) {

            if (e.getSource() == button1)
            {
                menu = false;
                loadlevel(1);

            }

          else if (e.getSource() == button2)
            {
                menu = false;
                loadlevel(2);

            }

            else if (e.getSource() == button3)
            {
                menu = false;
                loadlevel(3);

            }

        }

        //System.out.println(menu);

        if (menu == false) {
            for (int i = 0; i < Lilylength; i++) {
                if (e.getSource() == Lilypads[i].button) {
                    pad = true;
                }
            }
            for (int g = 1; g < frogs.size(); g++) {
                if (e.getSource() == frogs.get(g).button) {
                    Green = true;

                }
            }
            if (e.getSource() == frogs.get(0).button && redselected == false) {

                if (greenselected == true) {
                    setButtonIcon("GreenFrog", greenbutton);
                    greenselected = false;
                }
                setButtonIcon("RedFrog2", frogs.get(0).button);
                redselected = true;
            } else if (Green && greenselected == false) {
                if (redselected == true) {
                    setButtonIcon("RedFrog", frogs.get(0).getButton());
                    redselected = false;
                }
                greenbutton = (JButton) e.getSource();
                setButtonIcon("GreenFrog2", greenbutton);
                greenselected = true;
            }

            if (greenselected && e.getSource() != greenbutton &&Green)
            {
                setButtonIcon("GreenFrog", greenbutton);
                greenselected = false;
                greenbutton = (JButton) e.getSource();
                setButtonIcon("GreenFrog2", greenbutton);
                greenselected = true;
            }
            else if (redselected && pad)
            {
                //check the button that you pressed ,store in the button
                JButton button = (JButton) e.getSource();
                while (Lilypads[x].button != button) {
                    x++;
                }
                double removex = (double) (Lilypads[x].getX() + frogs.get(0).getX()) / 2;
                double removey = (double) (Lilypads[x].getY() + frogs.get(0).getY()) / 2;
                deleteFrog(removex, removey, 0, x);
            }
            else if (greenselected && pad) {
                int u = 1;
                x = 0;
                JButton button = (JButton) e.getSource();
                while (Lilypads[x].button != button) {
                    x++;//the buttopn that yoy click
                }

                while (frogs.get(u).button != greenbutton) {

                    u++;
                }

                double removex = (double) (Lilypads[x].getX() + frogs.get(u).getX()) / 2;
                double removey = (double) (Lilypads[x].getY() + frogs.get(u).getY()) / 2;
                deleteFrog2(removex, removey, u, x);
            }

            if (frogs.size() == 1) {


                setButtonIcon("win", frogs.get(0).button);
                for (int a = 0; a < Lilylength; a++) {
                    setButtonIcon("win", Lilypads[a].button);

                }


            }
        }
    }

    private void moveTo(int index, int otherindex) {
        ImageIcon i = new ImageIcon(frogs.get(index).getImage() + ".png");
        Lilypads[otherindex].button.setIcon(i);
        i = new ImageIcon(Lilypads[otherindex].getImage() + ".png");
        frogs.get(index).button.setIcon(i);

        Square temp = frogs.get(index);
        frogs.set(index, Lilypads[otherindex]);
        Lilypads[otherindex] = temp;

        String tempt = frogs.get(index).getImage();
        frogs.get(index).setImage(Lilypads[otherindex].getImage());
        Lilypads[otherindex].setImage(tempt);

    }

    private void setButtonIcon(String image, JButton button) {
        ImageIcon i = new ImageIcon(image + ".png");
        button.setIcon(i);
    }

    private void deleteFrog(double removex, double removey, int index, int otherindex)
    {
        for (int n = 1; n < frogs.size(); n++) {
            if (frogs.get(n).getX() == removex && frogs.get(n).getY() == removey) {
                moveTo(index, otherindex);
                frogs.get(n).setImage("LilyPad");
                setButtonIcon("LilyPad", frogs.get(n).button);
                Lilypads[Lilylength] = frogs.get(n);
                frogs.remove(n);
                Lilylength++;
                redselected = false;
                n = frogs.size();
            }

        }
    }

    private void deleteFrog2(double removex, double removey, int index, int otherindex) {
        for (int t = 1; t < frogs.size(); t++) {
            if (frogs.get(t).getX() == removex && frogs.get(t).getY() == removey) {
                moveTo(index, otherindex);
                frogs.get(t).setImage("LilyPad");
                setButtonIcon("LilyPad", frogs.get(t).button);
                Lilypads[Lilylength] = frogs.get(t);
                frogs.remove(t);
                Lilylength++;
                greenselected = false;
                t = frogs.size();
            }
        }
    }


    private void loadlevel(int level )
    {
        panel.remove(button1);
        panel.remove(button2);
        panel.remove(button3);
        int findredfrog=0;
        int findgreenfrogs;
        Square squares[] = new Square[25];
        if(level==1)
        {
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
        }


        else if(level==2)
        {
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
        }

        else {
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

        GridLayout layout = new GridLayout(5, 5);
        panel.setLayout(layout);


        for (int x = 0; x < 25; x++) {
            panel.add(squares[x].getButton());
        }

        frame.setContentPane(panel);

        while (squares[findredfrog].getImage() != "RedFrog") {
            findredfrog++;
        }

        squares[findredfrog].getButton().addActionListener(this);
        frogs.add(squares[findredfrog]);

        // System.out.println(findredfrog);

        for (findgreenfrogs = 0; findgreenfrogs < 25; findgreenfrogs++) {
            if (squares[findgreenfrogs].getImage() == "GreenFrog")
            {   squares[findgreenfrogs].getButton().addActionListener(this);
                frogs.add(squares[findgreenfrogs]);
            }
        }


        for (int find = 0; find < 25; find++)
        {
            if (squares[find].getImage() == "LilyPad") {
                squares[find].getButton().addActionListener(this);
                Lilypads[Lilylength - 1] = squares[find];
                Lilylength++;
            }

        }
        Lilylength--;

    }

}