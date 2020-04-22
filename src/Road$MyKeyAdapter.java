//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package PACKAGE_NAME;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class Road$MyKeyAdapter extends KeyAdapter {
    private Road$MyKeyAdapter(Road var1) {
        this.this$0 = var1;
    }

    public void keyPressed(KeyEvent e) {
        this.this$0.p.keyPressed(e);
    }

    public void keyReleased(KeyEvent e) {
        this.this$0.p.keyReleased(e);
    }
}
