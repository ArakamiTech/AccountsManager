package com.arakamitech.accountsmanager.view.swing;

import com.arakamitech.accountsmanager.logic.enums.MenuType;
import com.arakamitech.accountsmanager.logic.modelmenu.ModelMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.SwingUtilities;

/**
 *
 * @author cristhian
 */
public class ListMenu<E extends Object> extends JList<E> {

    private final DefaultListModel model;
    private int selectedIndex = -1;

    public ListMenu() {
        model = new DefaultListModel();
        setModel(model);
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
                if (SwingUtilities.isLeftMouseButton(me)) {
                    int index = locationToIndex(me.getPoint());
                    Object o = model.getElementAt(index);
                    if (o instanceof ModelMenu) {
                        ModelMenu menu = (ModelMenu) o;
                        if (menu.getType() == MenuType.MENU) {
                            selectedIndex = index;
                        }
                    } else {
                        selectedIndex = index;
                    }
                    repaint();
                }
            }
        });

    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                ModelMenu data;
                if (o instanceof ModelMenu) {
                    data = (ModelMenu) o;
                } else {
                    data = new ModelMenu("", o + "", MenuType.EMPTY);
                }
                MenuItem item = new MenuItem(data);
                item.setSelected(selectedIndex == index);
                return item;
            }

        };
    }

    public void addItem(ModelMenu data) {
        model.addElement(data);
    }
}
