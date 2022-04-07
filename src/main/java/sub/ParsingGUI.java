package sub;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ParsingGUI extends JFrame{

    // read
    private JLabel inputRead;
    private JButton buttonRead;
    private JButton buttonFileRead;
    // print
    private JButton buttonPrint;
    // exit
    private JButton buttonExit;
    //
    private Container container;
    private JTree tree;
    //
    private ReactorList reactorList;

    public ParsingGUI(){
        super("parsing");
        this.setBounds(500,200,700,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // read
        buttonRead = new JButton("Импорт");
        buttonFileRead = new JButton("Выбрать файл");
        inputRead = new JLabel("Путь к файлу");
        // print
        buttonPrint = new JButton("Вывести информацию");
        // exit
        buttonExit = new JButton("Выход");

        container = this.getContentPane();
        container.setLayout(new GridLayout(2,3));
        // read
        buttonRead.addActionListener(new ButtonReadEventListener());
        container.add(buttonRead);
        buttonFileRead.addActionListener(new ButtonChooseReadFileEventListener());
        container.add(buttonFileRead);
        container.add(inputRead);
        // print
        buttonPrint.addActionListener(new ButtonPrintEventListener());
        container.add(buttonPrint);
        // exit
        buttonExit.addActionListener(new ButtonExitEventListener());
        container.add(buttonExit);

    }

    class ButtonReadEventListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                String linkToRead = inputRead.getText();
                if(linkToRead == "" || linkToRead == "Путь к файлу") throw new Exception("Выберите файл");
                reactorList = new ReactorList(linkToRead);
                String message = "Данные импортированы из "+linkToRead.substring(linkToRead.lastIndexOf('\\')+1);
                JOptionPane.showMessageDialog(null, message,"Вывод",JOptionPane.PLAIN_MESSAGE);
            } catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(),"Вывод",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    class ButtonPrintEventListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                if(reactorList == null) throw new Exception("Нет данных");
                DefaultMutableTreeNode reactorTree = new DefaultMutableTreeNode("Reactor", true);
                DefaultMutableTreeNode reactorBranch = null;
                for(Reactor reactor : reactorList.getReactors()){
                    reactorBranch = new DefaultMutableTreeNode(reactor.getType(), true);
                    reactorBranch.add(new DefaultMutableTreeNode(reactor.getBurnup(), false));
                    reactorBranch.add(new DefaultMutableTreeNode(reactor.getKpd(), false));
                    reactorBranch.add(new DefaultMutableTreeNode(reactor.getEnrichment(), false));
                    reactorBranch.add(new DefaultMutableTreeNode(reactor.getTermalCapacity(), false));
                    reactorBranch.add(new DefaultMutableTreeNode(reactor.getElectricalCapacity(), false));
                    reactorBranch.add(new DefaultMutableTreeNode(reactor.getLifeTime(), false));
                    reactorBranch.add(new DefaultMutableTreeNode(reactor.getFirstLoad(), false));
                    reactorTree.add(reactorBranch);
                }
                tree = new JTree(reactorTree);
                tree.setShowsRootHandles(true);
                //
                JFrame infoFrame = new JFrame("info");
                JPanel infoPanel = new JPanel();
                infoPanel.setLayout(new BorderLayout());
                infoFrame.setContentPane(infoPanel);
                infoFrame.setBounds(200,200,300,400);
                infoFrame.add(tree);
                infoFrame.add(new JScrollPane(tree));
                infoFrame.setVisible(true);
            } catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(),"Вывод",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    class ButtonChooseReadFileEventListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try{
                JFileChooser fileChooser = new JFileChooser("D:/_Mehi/6sem/INF/web3maven/src/main/java/files/");
                int ret = fileChooser.showDialog(null, "Выбрать файл");
                if(ret == JFileChooser.APPROVE_OPTION){
                    File file = fileChooser.getSelectedFile();
                    inputRead.setText(file.getAbsolutePath());
                }
            } catch(Exception exception){
                JOptionPane.showMessageDialog(null, exception.getMessage(),"Вывод",JOptionPane.PLAIN_MESSAGE);
            }
        }
    }

    class ButtonExitEventListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            dispose();
        }
    }

}
