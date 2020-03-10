import javax.swing.*;



public class Square   {

    private int x, y;
    private String image;
    public JButton button;


        int redfrogx = 3, redfrogy = 5;

    public Square(int y, int x, String image,Board board)
    {
        this.x = x;
        this.y = y;
        ImageIcon i = new ImageIcon(image + ".png");
        this.image = image;
        button = new JButton(i);
        button.setIcon(i);
        button.addActionListener(board);

    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public JButton getButton() {
        return button;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }





}