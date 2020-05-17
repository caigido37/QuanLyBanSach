/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import QLBS.Danhmuc;
import View.BanSachJPanel;
import View.ThongKeJPanel;
import View.TrangChuJPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
//import java.awt.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Khanh Vo
 */
public class ChuyenmanhinhController {
    private JPanel root;
    private String kindSeleted = "";
    
    private List<Danhmuc> listItem = null;

    public ChuyenmanhinhController(JPanel jpnRoot) {
        this.root = jpnRoot;
    }
    public void setView(JPanel jpnItem, JLabel jlbItem){
        kindSeleted = "TrangChu";
        jpnItem.setBackground(Color.yellow);
        jpnItem.setBackground(Color.blue);
        root.removeAll();
        root.setLayout(new BorderLayout());
        root.add(new TrangChuJPanel());
        root.validate();
        root.repaint();
    }

    /**
     *
     * @param listItem
     */
    public void setEvent(List<Danhmuc> listItem){
        this.listItem = listItem;
        for(Danhmuc item : listItem){
        item.getJlb().addMouseListener(new LabelEvent(item.getKind(), item.getJpn(), item.getJlb()));
        }
    }
    class LabelEvent implements  MouseListener{
        private JPanel node;
        private String kind;
        private JPanel jpnItem;
        private JLabel  jlbItem;

        public LabelEvent(String kind, JPanel jpnItem, JLabel jlbItem) {
            this.kind = kind;
            this.jpnItem = jpnItem;
            this.jlbItem = jlbItem;
        }
        
        

        @Override
        public void mouseClicked(MouseEvent me) {
            switch (kind){
                case "TrangChu":
                    node = new TrangChuJPanel();
                    break;
                case "BanSach":
                    node = new BanSachJPanel();
                    break;
                case "ThongKe":
                    node = new ThongKeJPanel();
                default:
                    node = new BanSachJPanel();
                    break;
            }
            root.removeAll();
            root.setLayout(new BorderLayout());
            root.add(node);
            root.validate();
            root.repaint();
            setChangeBackgroud(kind);
        }

        @Override
        public void mousePressed(MouseEvent me) {
            kindSeleted = kind;
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
             
        }

        @Override
        public void mouseReleased(MouseEvent me) {
            
        }

        @Override
        public void mouseEntered(MouseEvent me) {
            jpnItem.setBackground(new Color(96,100,191));
            jlbItem.setBackground(new Color(96,100,191));
        }

        @Override
        public void mouseExited(MouseEvent me) {
          if(!kindSeleted.equalsIgnoreCase(kind)){
          jpnItem.setBackground(new Color(76,175,80));
          jlbItem.setBackground(new Color(76,175,80));
          }
        }
    }
    private void setChangeBackgroud(String kind){
        for(Danhmuc item : listItem){
            if(item.getKind().equalsIgnoreCase(kind)){
                item.getJpn().setBackground(new Color(96,100,191));
                item.getJlb().setBackground(new Color(96,100,191));
            }else {
                item.getJpn().setBackground(new Color(76,175,80));
                item.getJlb().setBackground(new Color(76,175,80));
            }
        }
    }
}
