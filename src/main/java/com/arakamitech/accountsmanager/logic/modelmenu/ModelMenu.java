package com.arakamitech.accountsmanager.logic.modelmenu;

import com.arakamitech.accountsmanager.logic.enums.MenuType;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author cristhian
 */
public class ModelMenu {

    String icon;
    String name;
    MenuType type;

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuType getType() {
        return type;
    }

    public ModelMenu(String icon, String name, MenuType type) {
        this.icon = icon;
        this.name = name;
        this.type = type;
    }

    public Icon toIcon() {
        String workingDir = System.getProperty("user.dir");
        String filePath = workingDir + "/src/main/java/com/arakamitech/accountsmanager/view/icons/" + icon + ".jpg";

        File imgFile = new File(filePath);
        if (!imgFile.exists()) {
            filePath = workingDir + "/src/main/java/com/arakamitech/accountsmanager/view/icons/" + icon + ".PNG";
            imgFile = new File(filePath);
        }

        return new ImageIcon(filePath);
    }

}
