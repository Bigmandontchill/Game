import javax.swing.*;


/**
 * This class is used to create square
 * @author  Tianran Wang
 */
public class Square   {

    private int x, y;
    private String image;
    private JButton button;

    /**
     * this constructor create a square
     * @param y  y position of the square
     * @param x  x position of the square
     * @param image  image for the square
     */
    public Square(int y, int x, String image)
    {
        this.x = x;
        this.y = y;
        ImageIcon i = new ImageIcon(image + ".png");
        this.image = image;
        button = new JButton(i);
        button.setIcon(i);
    }

    /**
     *  @return x position of the square
     */
    public int getX() {
        return x;
    }

    /**
     *@return  y position of the square
     */
    public int getY() {
        return y;
    }

    /**
     * @return image of the square
     */
    public String getImage() {
        return image;
    }

    /**
     * change the image of the square
     * @param image  new image for the square
     */
    public void setImage(String image) {
        this.image = image;
    }

    /**
     * @return the button of the square
     *
     */
    public JButton getButton() {
        return button;
    }

    /**
     *change x position of the square
     * @param x  new x for the square
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * change y position of the square
     * @param  y  new y for the square
     */
    public void setY(int y) {
        this.y = y;
    }





}