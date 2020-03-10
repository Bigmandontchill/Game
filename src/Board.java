import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Board implements  ActionListener {

    private Square squares[] = new Square[25];
   private  boolean redselected = false;
    private  boolean greenselected = false;
    JButton greenbutton=new JButton();
    Square redsquare ;
  private   int green1=6;
    int green2=8;
    int green3=12;
    int green4=20;
    int green5=24;
    Square Lilypads[]=new Square[13];
    Square Frogs[]=new Square[6];
    private int Lilylength=7;
   // private boolean jumpover=false;
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

        Frogs[0]=squares[green1];
        Frogs[1]=squares[green2];
        Frogs[2]=squares[green3];
        Frogs[3]=squares[green4];
        Frogs[4]=squares[green5];
        Frogs[5]=squares[22];
//0,1,4,10,14,16,18
        Lilypads[0]=squares[0];
        Lilypads[1]=squares[2];
        Lilypads[2]=squares[4];
        Lilypads[3]=squares[10];
        Lilypads[4]=squares[14];
        Lilypads[5]=squares[16];
        Lilypads[6]=squares[18];
        redsquare=squares[22];

        frame.setContentPane(panel);// add panel to the frame
        frame.setTitle("Time");
        frame.setSize(800, 800);
        frame.setResizable(false);
        frame.setVisible(true);//we can see it
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    //will do it when you click  any  button
    public void actionPerformed(ActionEvent e) {
        //ImageIcon i = null;

        int red = 22;
        int x = 0;
        int z=0;

       boolean pad=false;
       boolean Green=false;





         for (int i = 0; i <Lilylength; i++)
         {
             if (e.getSource() == Lilypads[i].button)
             {
             //    System.out.println("$");
               pad = true;
             }
          }

          for(int g=0;g<Frogs.length-1;g++)
          {

              if(e.getSource()==Frogs[g].button)
              {
                 Green=true;
              }

          }



     //System.out.println(Green );

        //    when the redfrog is selected
        if (e.getSource() == Frogs[5].button && redselected == false) {

            if(greenselected==true)
            {

                //i = new ImageIcon("GreenFrog.png");
                //greenbutton.setIcon(i);
                setButtonIcon("GreenFrog",greenbutton);
                greenselected=false;
            }

            //i = new ImageIcon("RedFrog2.png");
            //redsquare.button.setIcon(i);
            setButtonIcon("RedFrog2",Frogs[5].button);
            redselected = true;


        }
     else    if(Green&&greenselected==false)
        {
            if(redselected==true)
            {
                //i = new ImageIcon("RedFrog.png");
                //redsquare.button.setIcon(i);
                setButtonIcon("RedFrog",Frogs[5].button);
                redselected=false;
            }
             greenbutton=(JButton)e.getSource();
             //i = new ImageIcon("GreenFrog2.png");
            //greenbutton.setIcon(i);
            setButtonIcon("GreenFrog2",greenbutton);
            greenselected=true;

        }

            if(greenselected&&e.getSource()!=greenbutton&&Green)//(e.getSource()==squares[green1].button|| e.getSource()==squares[green2].button||e.getSource()==squares[green3].button||e.getSource()==squares[green4].button||e.getSource()==squares[green5].button))
            {
             //   i = new ImageIcon("GreenFrog.png");
              //greenbutton.setIcon(i);
                setButtonIcon("GreenFrog",greenbutton);
              greenselected=false;

              greenbutton=(JButton)e.getSource();
             // i = new ImageIcon("GreenFrog2.png");
                setButtonIcon("GreenFrog2",greenbutton);
              //greenbutton.setIcon(i);
              greenselected=true;
            }


        else if ( redselected&&pad)//(e.getSource()==squares[0].button||e.getSource()==squares[2].button||e.getSource()==squares[4].button||e.getSource()==squares[10].button||e.getSource()==squares[14].button||e.getSource()==squares[16].button||e.getSource()==squares[18].button))
        {
            //check the button that you pressed ,store in the button
            JButton button = (JButton) e.getSource();
            while (Lilypads[x].button != button)
            {
                x++;
            }





                for(int a=0;a<Frogs.length-1;a++)
                {

                    int removex=(Lilypads[x].getX()+Frogs[5].getX())/2;
                    int removey=(Lilypads[x].getY()+Frogs[5].getY())/2 ;

                    if(Frogs[a].getX()==removex&&Frogs[a].getY()==removey )
                    {
                        // System.out.println("GG");
                        moveTo2(5, x);
                        setButtonIcon("LilyPad",Frogs[a].button);
                        Frogs[a].setImage("Lilypad");
                        Lilypads[Lilylength]=Frogs[a];
                        Lilylength++;

                        redselected = false;
                        a=Frogs.length;

                    }


                }

                System.out.println(Frogs[5].getY()+"\t"+Frogs[5].getX());



        }

      else  if(greenselected&&pad)//(e.getSource()==squares[0].button||e.getSource()==squares[2].button||e.getSource()==squares[4].button||e.getSource()==squares[10].button||e.getSource()==squares[14].button||e.getSource()==squares[16].button||e.getSource()==squares[18].button))
        {

            JButton button=(JButton)e.getSource();
            while (Lilypads[x].button!= button) {
                x++;//the buttopn that yoy click
            }

            while(Frogs[z].button!=greenbutton)
            {

                z++;//greenbutton
            }



            moveTo2(z,x);

            /*ImageIcon i=new ImageIcon("LilyPad.png");
            squares[green1].setImage("LilyPad");
            squares[green1].button.setIcon(i);*/

            greenselected=false;
        }
    }

    private  void moveTo2(int index, int otherindex)
    {

        ImageIcon i = new ImageIcon(Frogs[index].getImage() + ".png");
        Lilypads[otherindex].button.setIcon(i);
        i = new ImageIcon(Lilypads[otherindex].getImage() + ".png");
        Frogs[index].button.setIcon(i);

        Square temp = Frogs[index];
        Frogs[index] = Lilypads[otherindex];
        Lilypads[otherindex] = temp;

        String tempt = Frogs[index].getImage();
        Frogs[index].setImage(Lilypads[otherindex].getImage());
        Lilypads[otherindex].setImage(tempt);

    }

    private void setButtonIcon(String image,JButton button )
    {
       ImageIcon i=new ImageIcon(image+".png");
       button.setIcon(i);
    }


}