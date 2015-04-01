/*
 * 
 */
package Telas;

import Classes.*;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.HashMap;
import java.util.Map;
import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author Davi
 */
public class SelectTags extends JPanel {
    
    private final Map<Integer, JCheckBox> labelFieldMap = new HashMap<>();
    
    public SelectTags() {
        setLayout(new GridBagLayout());
        
        DatabaseHandle dbh = new DatabaseHandle();
        Map<String, Integer> allTags = dbh.getMapTags();
        
        JCheckBox tagCheck;
        
        int i = 0;
        for(String key:allTags.keySet()) {
            
            tagCheck = new JCheckBox(key);
            labelFieldMap.put(allTags.get(key), tagCheck);
            add(tagCheck, createGbc(1, i));
            i++;
        }
        
        setBorder(BorderFactory.createTitledBorder("Selecione as tags que deseja buscar"));
    }
    
    public ArrayList<Integer> getSelectedIDs () {
        ArrayList<Integer> selectedIDs = new ArrayList<>();
        JCheckBox box;
        for(Integer key: labelFieldMap.keySet()) {
            box = labelFieldMap.get(key);
            if(box.isSelected()) {
                selectedIDs.add(key);
            }
        }
        return selectedIDs;
    }
    
    public static GridBagConstraints createGbc(int x, int y) {
      GridBagConstraints gbc = new GridBagConstraints();
      gbc.gridx = x;
      gbc.gridy = y;
      gbc.weightx = 1.0;
      gbc.weighty = gbc.weightx;
      if (x == 0) {
         gbc.anchor = GridBagConstraints.LINE_START;
         gbc.fill = GridBagConstraints.BOTH;
         gbc.insets = new Insets(3, 3, 3, 8);
      } else {
         gbc.anchor = GridBagConstraints.LINE_END;
         gbc.fill = GridBagConstraints.HORIZONTAL;
         gbc.insets = new Insets(3, 3, 3, 3);
      }
      return gbc;
   }
   
    public static ArrayList<Integer> showTagsForSelection() {
        SelectTags mainPanel = new SelectTags();
        int optionType = JOptionPane.DEFAULT_OPTION;
        int messageType = JOptionPane.PLAIN_MESSAGE;
        Icon icon = null;
        String[] options = {"Submit", "Cancel"};
        Object initialValue = options[0];
        int reply = JOptionPane.showOptionDialog(null, mainPanel,
                "Selecionar Tags", optionType, messageType, icon, options,
                initialValue);
        if (reply == 0) {
            return mainPanel.getSelectedIDs();
        }
        return null;
    }

}
