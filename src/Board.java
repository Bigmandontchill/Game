import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Board implements  ActionListener {

    private Square squares[] = new Square[25];
   private  boolean redselected = false;
    private  boolean greenselected = false;
    JButton greenbutton=new JButton();
  private   int green1=6;
    int green2=8;
    int green3=12;
    int green4=20;
    int green5=24;
    Square Lilypads[]=new Square[13];
    private int Lilylength=7;
    ArrayList<Square>frogs=new ArrayList<Square>();

    public Board() {

        JFrame frame = new JFrame();//CREATE A Jframe
        JPanel panel = new JPanel();//create a panel
        GridLayout layout = new GridLayout(5, 5);
        panel.setLayout(layout);
        Square square0 = new Square(1, 1, "LilyPad", this);
        Square square1 = new Square(1, 2, "Water", this);
        Square square2 = new Square(1, 3, "LilyPad", this);
        Square square3 = new Square(1, 4, "Water", this);
        Square square4 = new Square(1, 5, "LilyPad", this);
        Square square5 = new Square(2, 1, "Water", this);
        Square square6 = new Square(2, 2, "GreenFrog", this);
        Square square7 = new Square(2, 3, "Water", this);
        Square square8 = new Square(2, 4, "GreenFrog", this);
        Square square9 = new Square(2, 5, "Water", this);
        Square square10 = new Square(3, 1, "LilyPad", this);
        Square square11 = new Square(3, 2, "Water", this);
        Square square12 = new Square(3, 3, "GreenFrog", this);
        Square square13 = new Square(3, 4, "Water", this);
        Square square14 = new Square(3, 5, "LilyPad", this);
        Square square15 = new Square(4, 1, "Water", this);
        Square square16 = new Square(4, 2, "LilyPad", this);
        Square square17 = new Square(4, 3, "Water", this);
        Square square18 = new Square(4, 4, "LilyPad", this);
        Square square19 = new Square(4, 5, "Water", this);
        Square square20 = new Square(5, 1, "GreenFrog", this);
        Square square21 = new Square(5, 2, "Water", this);
        Square square22 = new Square(5, 3, "RedFrog", this);
        Square square23 = new Square(5, 4, "Water", this);
        Square square24 = new Square(5, 5, "GreenFrog", this);
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
       for (int x=0;x<25;x++)
       {
         panel.add(squares[x].getButton());
       }
        frogs.add(squares[22]);
        frogs.add(squares[green1]);
        frogs.add(squares[green2]);
        frogs.add(squares[green3]);
        frogs.add(squares[green4]);
        frogs.add(squares[green5]);
        //0,1,4,10,14,16,18
        Lilypads[0]=squares[0];
        Lilypads[1]=squares[2];
        Lilypads[2]=squares[4];
        Lilypads[3]=squares[10];
        Lilypads[4]=squares[14];
        Lilypads[5]=squares[16];
        Lilypads[6]=squares[18];
        frame.setContentPane(panel);// add panel to the frame
        frame.setTitle("Time");
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setVisible(true);//we can see it
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //will do it when you click  any  button
    public void actionPerformed(ActionEvent e) {
        int x = 0;
        int z = 0;
        boolean pad = false;
        boolean Green = false;

        for (int i = 0; i < Lilylength; i++) {
            if (e.getSource() == Lilypads[i].button) {
                //    System.out.println("$");
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
                setButtonIcon("RedFrog", frogs.get(0).button);
                redselected = false;
            }
            greenbutton = (JButton) e.getSource();
            setButtonIcon("GreenFrog2", greenbutton);
            greenselected = true;
        }

        if (greenselected && e.getSource() != greenbutton && Green)//(e.getSource()==squares[green1].button|| e.getSource()==squares[green2].button||e.getSource()==squares[green3].button||e.getSource()==squares[green4].button||e.getSource()==squares[green5].button))
        {
            setButtonIcon("GreenFrog", greenbutton);
            greenselected = false;
            greenbutton = (JButton) e.getSource();
            setButtonIcon("GreenFrog2", greenbutton);
            greenselected = true;
        } else if (redselected && pad)//(e.getSource()==squares[0].button||e.getSource()==squares[2].button||e.getSource()==squares[4].button||e.getSource()==squares[10].button||e.getSource()==squares[14].button||e.getSource()==squares[16].button||e.getSource()==squares[18].button))
        {
            //check the button that you pressed ,store in the button
            JButton button = (JButton) e.getSource();
            while (Lilypads[x].button != button) {
                x++;
            }

            double removex =(double) (Lilypads[x].getX() + frogs.get(0).getX()) / 2;
            double removey = (double) (Lilypads[x].getY() + frogs.get(0).getY()) / 2;


            for (int n = 1; n < frogs.size(); n++) {
                if (frogs.get(n).getX() == removex && frogs.get(n).getY() == removey) {

                    frogs.get(n).setImage("LilyPad");
                    setButtonIcon("LilyPad", frogs.get(n).button);
                    Lilypads[Lilylength] = frogs.get(n);
                    frogs.remove(n);
                    Lilylength++;
                    moveTo2(0, x);
                    redselected = false;
                    n = frogs.size();
                }

            }
        } else if (greenselected && pad)//(e.getSource()==squares[0].button||e.getSource()==squares[2].button||e.getSource()==squares[4].button||e.getSource()==squares[10].button||e.getSource()==squares[14].button||e.getSource()==squares[16].button||e.getSource()==squares[18].button))
        {
            int u = 1;
            x=0;
            JButton button = (JButton) e.getSource();
            while (Lilypads[x].button != button)
            {
                x++;//the buttopn that yoy click
            }

            while (frogs.get(u).button != greenbutton)
            {

                u++;
            }



           double removex = (double) (Lilypads[x].getX() + frogs.get(u).getX())/2;
            double  removey = (double)(Lilypads[x].getY() + frogs.get(u).getY())/2;
            //System.out.println(removey+"\t"+removex);

            for(int t=1;t<frogs.size();t++)
            {

                if(frogs.get(t).getX()==removex&&frogs.get(t).getY()==removey)
                {

                    moveTo2(u, x);
                    frogs.get(t).setImage("LilyPad");
                    setButtonIcon("LilyPad", frogs.get(t).button);
                    Lilypads[Lilylength]=frogs.get(t);
                    frogs.remove(t);
                    Lilylength++;
                    greenselected=false;
                    t=frogs.size();
                }
            }
          //  moveTo2(u, x);
            //greenselected=false;

        }
    }

    private  void moveTo2(int index, int otherindex)
    {
        ImageIcon i = new ImageIcon(frogs.get(index).getImage() + ".png");
        Lilypads[otherindex].button.setIcon(i);
        i = new ImageIcon(Lilypads[otherindex].getImage() + ".png");
        frogs.get(index).button.setIcon(i);
        Square temp = frogs.get(index);
        frogs.set(index,Lilypads[otherindex]);
        Lilypads[otherindex] = temp;
        String tempt = frogs.get(index).getImage();
        frogs.get(index).setImage(Lilypads[otherindex].getImage());
        Lilypads[otherindex].setImage(tempt);
    }

    private void setButtonIcon(String image,JButton button )
    {
       ImageIcon i=new ImageIcon(image+".png");
       button.setIcon(i);
    }

}