package org.oweis.Lear_ClientAPI.Converter;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Home implements ActionListener {
	public String namePassByUser;
	public String path; 
	JButton importButton,saveButton;
	JFrame frame;
	JPanel headerPanel,controlPanel,checkBoxPanel,buttonsPanel;
	JTextArea infoText,pathText,familyText;
	JLabel pathLabel,familyLabel;
	JCheckBox checkBox;
	public Home() {
		headerPanel = new JPanel();
		controlPanel = new JPanel();
		checkBoxPanel = new JPanel();
		buttonsPanel = new JPanel();
		
		headerPanel.setLayout(new GridLayout(1,1));
		headerPanel.setSize(50,200);
		controlPanel.setLayout(new GridLayout(2,2));
		checkBoxPanel.setLayout(new GridLayout(1,1));
		checkBoxPanel.setSize(50,200);
		buttonsPanel.setLayout(new GridLayout(1,2));
		
		frame = new JFrame();
		frame.setLayout(new GridLayout(4,1));
		frame.setSize(600, 200);
		
		 infoText = new JTextArea("Choisir un fichier à importer");
		
		 pathLabel = new JLabel("Path File : ");
		
		 pathText = new JTextArea(" . . . ");
		
		 familyLabel = new JLabel("Family Name : ");
		
		 familyText = new JTextArea("Your Family Name Here");
		
		 checkBox = new JCheckBox("Keep Xml File");
		
		importButton = new JButton("Import File");
		importButton.addActionListener(this);
		
		saveButton = new JButton("Save Xi7aja");
		saveButton.addActionListener(this);
		
		headerPanel.add(infoText);
		
		controlPanel.add(pathLabel);
		controlPanel.add(pathText);
		controlPanel.add(familyLabel);
		controlPanel.add(familyText);
		
		checkBoxPanel.add(checkBox);
		
		buttonsPanel.add(importButton);
		buttonsPanel.add(saveButton);
		
		frame.add(headerPanel);
		frame.add(controlPanel);
		frame.add(checkBoxPanel);
		frame.add(buttonsPanel);
		frame.setVisible(true);


	}
	public static void main(String args[]){
		Home home = new Home ();
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource() == importButton ) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(frame);
			if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			System.out.println("Selected file: " + selectedFile.getAbsolutePath());
				}
			}
		if(event.getSource() == saveButton ) ;
	}
}
