package com.arakamitech.accountsmanager.logic.model;

import com.arakamitech.accountsmanager.logic.enums.MenuType;
import com.arakamitech.accountsmanager.logic.event.EventMenuSelected;
import com.arakamitech.accountsmanager.view.swing.MenuItem;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.Serial;
import javax.swing.*;

public class ListMenu<E> extends JList<E> {

    @Serial
    private static final long serialVersionUID = 1L;
    private final DefaultListModel<ModelMenu> model;
    private int selectedIndex = -1;
    private int overIndex = -1;
    private transient EventMenuSelected event;

    public void addEventMenuSelected(EventMenuSelected event) {
        this.event = event;
    }

    public ListMenu() {
        model = new DefaultListModel<>();
        setModel((ListModel<E>) model);
        addMouseListener(new MenuMouseAdapter());
        addMouseMotionListener(new MenuMouseMotionAdapter());
    }

    private class MenuMouseAdapter extends MouseAdapter {

        @Override
        public void mousePressed(MouseEvent me) {
            if (SwingUtilities.isLeftMouseButton(me)) {
                handleMousePressed(me);
            }
        }

        @Override
        public void mouseExited(MouseEvent me) {
            overIndex = -1;
            repaint();
        }

        private void handleMousePressed(MouseEvent me) {
            var index = locationToIndex(me.getPoint());
            Object o = model.getElementAt(index);
            if (o instanceof ModelMenu menu) {
                if (menu.getType() == MenuType.MENU) {
                    selectedIndex = index;
                    if (event != null) {
                        event.selected(index);
                    }
                }
            } else {
                selectedIndex = index;
            }
            repaint();
        }
    }

    private class MenuMouseMotionAdapter extends MouseMotionAdapter {

        @Override
        public void mouseMoved(MouseEvent me) {
            var index = locationToIndex(me.getPoint());
            if (index != overIndex) {
                handleMouseMoved(index);
            }
        }

        private void handleMouseMoved(int index) {
            Object o = model.getElementAt(index);
            if (o instanceof ModelMenu menu) {
                overIndex = (menu.getType() == MenuType.MENU) ? index : -1;
                repaint();
            }
        }
    }

    @Override
    public ListCellRenderer<? super E> getCellRenderer() {
        return new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> jlist, Object o, int index, boolean selected, boolean focus) {
                ModelMenu data;
                if (o instanceof ModelMenu o1) {
                    data = o1;
                } else {
                    data = ModelMenu.builder().icon("").name(o + "").type(MenuType.EMPTY).build();
                }
                var item = new MenuItem(data);
                item.setSelected(selectedIndex == index);
                item.setOver(overIndex == index);
                return item;
            }

        };
    }

    public void addItem(ModelMenu data) {
        model.addElement(data);
    }
}