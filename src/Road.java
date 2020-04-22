//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package PACKAGE_NAME;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageObserver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Road extends JPanel implements ActionListener, Runnable {
    Timer Maintimer = new Timer(20, this);
    ImageIcon icon = new ImageIcon("res/road.png");
    Image img;
    Player p;
    Thread enemiesFactory;
    List<Enemy> enimies;

    public Road() {
        this.img = this.icon.getImage();
        this.p = new Player();
        this.enemiesFactory = new Thread(this);
        this.enimies = new ArrayList();
        this.Maintimer.start();
        this.enemiesFactory.start();
        this.addKeyListener(new PACKAGE_NAME.Road.MyKeyAdapter(this, (PACKAGE_NAME.Road.MyKeyAdapter)null));
        this.setFocusable(true);
    }

    public void paint(Graphics g) {
        Graphics g = (Graphics2D)g;
        g.drawImage(this.img, this.p.layer1, 0, (ImageObserver)null);
        g.drawImage(this.img, this.p.layer2, 0, (ImageObserver)null);
        g.drawImage(this.p.img, this.p.x, this.p.y, (ImageObserver)null);
        double v = (double)(3 * this.p.v);
        g.setColor(Color.WHITE);
        Font font = new Font("Arial", 2, 25);
        g.setFont(font);
        g.drawString("Скорость:" + v + "км/ч", 100, 30);
        Iterator i = this.enimies.iterator();

        while(true) {
            while(i.hasNext()) {
                Enemy e = (Enemy)i.next();
                if (e.x < 2400 && e.x > -2400) {
                    g.drawImage(e.img, e.x, e.y, (ImageObserver)null);
                    e.move();
                } else {
                    i.remove();
                }
            }

            return;
        }
    }

    public void actionPerformed(ActionEvent e) {
        this.p.move();
        this.repaint();
        this.TestCallisionWithEnemies();
        this.TestWin();
    }

    private void TestWin() {
        if (this.p.s >= 20000) {
            JOptionPane.showMessageDialog((Component)null, "Ура, вы выиграли!");
            System.exit(0);
        }

    }

    private void TestCallisionWithEnemies() {
        Iterator i = this.enimies.iterator();

        while(i.hasNext()) {
            Enemy e = (Enemy)i.next();
            if (this.p.getRect().intersects(e.getRect())) {
                JOptionPane.showMessageDialog((Component)null, "Вы проиграли!");
                System.exit(1);
            }
        }

    }

    public void run() {
        while(true) {
            Random rand = new Random();

            try {
                Thread.sleep((long)rand.nextInt(2000));
                this.enimies.add(new Enemy(1200, rand.nextInt(600), rand.nextInt(60), this));
            } catch (InterruptedException var3) {
                var3.printStackTrace();
            }
        }
    }

    private void printstackTrace() {
    }
}
