//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package PACKAGE_NAME;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

public class Player {
    public static final int MAX_V = 100;
    public static final int MAX_TOP = 30;
    public static final int MAX_BOTTOM = 470;
    ImageIcon icon = new ImageIcon("res/car.png");
    Image img_center;
    ImageIcon icon1;
    Image img_left;
    ImageIcon icon2;
    Image img_right;
    Image img;
    int v;
    int dv;
    int s;
    int layer1;
    int layer2;
    int x;
    int y;
    int dy;

    public Player() {
        this.img_center = this.icon.getImage();
        this.icon1 = new ImageIcon("res/carleft.png");
        this.img_left = this.icon1.getImage();
        this.icon2 = new ImageIcon("res/carright.png");
        this.img_right = this.icon2.getImage();
        this.img = this.img_center;
        this.v = 20;
        this.dv = 0;
        this.s = 0;
        this.layer1 = 0;
        this.layer2 = 1200;
        this.x = 30;
        this.y = 100;
        this.dy = 0;
    }

    public Rectangle getRect() {
        return new Rectangle(this.x, this.y, 140, 43);
    }

    public void move() {
        this.s += this.v;
        this.v += this.dv;
        if (this.v <= 0) {
            this.v = 0;
        }

        if (this.v >= 100) {
            this.v = 100;
        }

        this.y -= this.dy;
        if (this.y <= 30) {
            this.y = 30;
        }

        if (this.y >= 470) {
            this.y = 470;
        }

        if (this.layer2 - this.v <= 0) {
            this.layer1 = 0;
            this.layer2 = 1200;
        } else {
            this.layer1 -= this.v;
            this.layer2 -= this.v;
        }

    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 39) {
            this.dv = 5;
        }

        if (key == 37) {
            this.dv = -5;
        }

        if (key == 38) {
            this.dy = 5;
            this.img = this.img_left;
        }

        if (key == 40) {
            this.dy = -5;
            this.img = this.img_right;
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == 39 || key == 37) {
            this.dv = 0;
        }

        if (key == 38 || key == 40) {
            this.dy = 0;
        }

        this.img = this.img_center;
    }
}
