package com.arakamitech.accountsmanager.logic.model;

import com.arakamitech.accountsmanager.logic.enums.MenuType;
import lombok.Builder;
import lombok.Data;

import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author cristhian
 */
@Data
@Builder
public class ModelMenu {

    String icon;
    String name;
    MenuType type;

    public Icon toIcon() {
        String workingDir = System.getProperty("user.dir");
        String filePath = workingDir + "/src/main/java/com/arakamitech/accountsmanager/view/icons/" + icon + ".jpg";

        File imgFile = new File(filePath);
        if (!imgFile.exists()) {
            filePath = workingDir + "/src/main/java/com/arakamitech/accountsmanager/view/icons/" + icon + ".PNG";
        }

        return new ImageIcon(filePath);
    }

}
