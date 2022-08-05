package textproc;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.util.Map;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;


public class BookReaderController {
	public BookReaderController(GeneralWordCounter counter) {
		SwingUtilities.invokeLater(() -> createWindow(counter, "BookReader", 100, 300));
	}

	private void createWindow(GeneralWordCounter counter, String title, int width, int height) {
		JFrame frame = new JFrame(title);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container pane = frame.getContentPane();
		// pane är en behållarkomponent till vilken de övriga komponenterna (listvy, knappar etc.) ska läggas till.
		
		SortedListModel<Map.Entry<String, Integer>> model = new SortedListModel<>(counter.getWordList());
		
		JList<Map.Entry<String, Integer>> list = new JList<>(model);
		
		JScrollPane scrollPane = new JScrollPane(list);
				
		scrollPane.setPreferredSize(new Dimension(width, height));
		
		pane.add(scrollPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		
		JRadioButton alphabetic = new JRadioButton("Alphabetic");
		JRadioButton freq = new JRadioButton("Frequency");
		ButtonGroup group = new ButtonGroup();
		
		group.add(alphabetic);
		group.add(freq);
		
		JTextField textBox = new JTextField(30);
		JButton search = new JButton("Find");
		
		alphabetic.addActionListener(event -> {
			model.sort((n1, n2) -> n1.getKey().compareTo(n2.getKey()));
		});
		
		freq.addActionListener(event -> {
			model.sort((n1, n2) -> n2.getValue() - n1.getValue());
		});
		
		search.addActionListener(event -> {
		 	String text = textBox.getText();
		 	for(int i = 0; i < model.getSize(); i++) {
		 		if(model.getElementAt(i).getKey().equalsIgnoreCase(text)) {
		 			list.setSelectedIndex(i);
		 			list.ensureIndexIsVisible(i);
		 			break;
		 		}
		 		if(i == model.getSize() - 1) {
		 			JOptionPane.showMessageDialog(null, "Den finns inte");
		 		}
		 	}
		});
		
		textBox.addActionListener(event ->{
			String text = textBox.getText();
		 	for(int i = 0; i < model.getSize(); i++) {
		 		if(model.getElementAt(i).getKey().equalsIgnoreCase(text)) {
		 			list.setSelectedIndex(i);
		 			list.ensureIndexIsVisible(i);
		 			break;
		 		}
		 		if(i == model.getSize() - 1) {
		 			JOptionPane.showMessageDialog(null, "Den finns inte");
		 		}
		 	}
		});
		
		panel.add(alphabetic);
		panel.add(freq);
		panel.add(textBox);
		panel.add(search);

		pane.add(panel, BorderLayout.SOUTH);
		frame.pack();
		frame.setVisible(true);
	}
}

