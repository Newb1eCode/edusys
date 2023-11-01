/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Com.edusys.utility;

import java.awt.Image;
import java.net.*;
import javax.swing.*;

/**
 *
 * @author ADMIN
 */
public class Xlimage {
    public static Image getAppIcon() {
        URL url = Xlimage.class.getResource("/Com/edusys/icon/fpt.png");
        return new ImageIcon(url).getImage();
    }
}
