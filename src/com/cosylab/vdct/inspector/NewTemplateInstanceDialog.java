/**
 * Copyright (c) 2008, Cosylab, Ltd., Control System Laboratory, www.cosylab.com
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer. 
 * Redistributions in binary form must reproduce the above copyright notice,
 * this list of conditions and the following disclaimer in the documentation 
 * and/or other materials provided with the distribution. 
 * Neither the name of the Cosylab, Ltd., Control System Laboratory nor the names
 * of its contributors may be used to endorse or promote products derived 
 * from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE 
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE 
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, 
 * STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.cosylab.vdct.inspector;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import com.cosylab.vdct.graphics.DsManager;
import com.cosylab.vdct.vdb.VDBData;
import com.cosylab.vdct.vdb.VDBTemplate;

/**
 * @author ssah
 *
 */
public class NewTemplateInstanceDialog extends JDialog implements ActionListener {
	
	private JComboBox templateComboBox = null;
	JButton okButton = null; 

	private static final String titleString = "New template instance";
	private static final String templateTypeString = "Type:";

	private static final String okString = "OK";
	private static final String cancelString = "Cancel";
	
	public NewTemplateInstanceDialog(Dialog dialog) {
        super(dialog, true);
		setTitle(titleString);
        setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        createGUI();
    }
	
	
	public void setVisible(boolean b) {
		if (b) {
			refreshTemplateComboBox();
		}
		super.setVisible(b);
	}

	/** This method is called from within the constructor to initialize the form.
     */
    private void createGUI() {

		JPanel contentPanel = new JPanel(new GridBagLayout());
		contentPanel.setPreferredSize(new Dimension(192, 80));

    	JPanel templateTypePanel = createTemplateTypePanel();
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.insets = new Insets(4, 4, 4, 4);
		contentPanel.add(templateTypePanel, constraints);

	    JPanel buttonPanel = createButtonPanel();
		constraints = new GridBagConstraints();
		constraints.gridy = 1;
		constraints.weightx = 1.0;
		constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(4, 4, 4, 4);
        contentPanel.add(buttonPanel, constraints);
        
		getContentPane().add(contentPanel);
		pack();
    }

    private JPanel createTemplateTypePanel() {
    	
    	JPanel templateTypePanel = new JPanel(new GridBagLayout());
    	
    	JLabel templateTypeLabel = new JLabel(templateTypeString);
    	GridBagConstraints constraints = new GridBagConstraints();
		constraints.insets = new Insets(4, 4, 4, 4);
		templateTypePanel.add(templateTypeLabel, constraints);
		
    	templateComboBox = new JComboBox();
    	templateComboBox.setEditable(false);
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.insets = new Insets(4, 4, 4, 4);
		templateTypePanel.add(templateComboBox, constraints);

		return templateTypePanel;
    }

    private JPanel createButtonPanel() {
    	JPanel buttonPanel = new JPanel(new GridBagLayout());
		
    	okButton = new JButton(okString); 
    	okButton.setMnemonic('O');
    	okButton.addActionListener(this);
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.weightx = .5;
		constraints.anchor = GridBagConstraints.EAST;
        constraints.insets = new Insets(4, 4, 4, 4);
        buttonPanel.add(okButton, constraints);

    	JButton cancelButton = new JButton(cancelString); 
    	cancelButton.setMnemonic('C');
    	cancelButton.addActionListener(this);
    	
		constraints = new GridBagConstraints();
		constraints.gridx = 1;
		constraints.weightx = .5;
		constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(4, 4, 4, 4);
        buttonPanel.add(cancelButton, constraints);
        
        return buttonPanel;
    }
    
    private void refreshTemplateComboBox() {
    	templateComboBox.removeAllItems();
    	
    	Stack templateStack = DsManager.getDrawingSurface().getTemplateStack();
    	Enumeration templates = VDBData.getTemplates().keys();
    	while (templates.hasMoreElements()) {
    		String key = templates.nextElement().toString();
    		VDBTemplate t = (VDBTemplate)VDBData.getTemplates().get(key);
    		if (templateStack.isEmpty() || !templateStack.contains(t)) {
        		templateComboBox.addItem(key);
    		}
    	}
    	
    	boolean itemsExist = templateComboBox.getItemCount() > 0;
		templateComboBox.setEnabled(itemsExist);
		okButton.setEnabled(itemsExist);
    }

	public void actionPerformed(ActionEvent event) {
		String action = event.getActionCommand();

		if (action.equals(okString)) {
			String type = templateComboBox.getSelectedItem().toString();
	        DsManager.getDrawingSurface().createTemplateInstance(null, type, true);
        	setVisible(false);
		} else if (action.equals(cancelString)) {
        	setVisible(false);
		}
	}
}
