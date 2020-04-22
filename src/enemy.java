//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package PACKAGE_NAME;

import java.awt.Image;
import java.awt.Rectangle;
import javax.swing.ImageIcon;

public class Enemy {
    int x;
    int y;
    int v;
    ImageIcon icon = new ImageIcon("res/as.png");
    Image img;
    Road road;

    public Rectangle getRect() {
        return new Rectangle(this.x, this.y, 140, 53);
    }

    public Enemy(int x, int y, int v, Road road) {
        this.img = this.icon.getImage();
        this.x = x;
        this.y = y;
        this.v = v;
        this.road = road;
    }

    public void move() {
        this.x = this.x - this.road.p.v + this.v;
    }
}
