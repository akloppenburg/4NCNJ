import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.ListSelectionModel;

/**
* @author Nathan Fritz - 113294199
 * @author Alex Kloppenburg - 113388722
 * @author Joe Pauly - 112909034
 * @author Cavan Gary - 113388151
 */
public class SelectionView extends JFrame implements ActionListener {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private NewsDataBaseModel newsDataBaseModel = new NewsDataBaseModel();
	
	/**
	 * 
	 */
	private JMenuBar jmb = new JMenuBar();
	
	/**
	 * 
	 */
	private JMenu jmFile = new JMenu("File");
	
	/**
	 * 
	 */
	private JMenuItem jmiLoad = new JMenuItem("Load");
	
	/**
	 * 
	 */
	private JMenuItem jmiSave = new JMenuItem("Save");
	
	/**
	 * 
	 */
	private JMenuItem jmiImport = new JMenuItem("Import");
	
	/**
	 * 
	 */
	private JMenuItem jmiExport = new JMenuItem("Export");
	
	/**
	 * 
	 */
	private JMenu jmNewsMaker = new JMenu("Newsmakers");
	
	/**
	 * 
	 */
	private JMenuItem jmiAddNewsMaker = new JMenuItem("Add Newsmaker");
	
	/**
	 * 
	 */
	private JMenuItem jmiEditNewsMaker = new JMenuItem("Edit Newsmaker");
	
	/**
	 * 
	 */
	private JMenuItem jmiDeleteNewsMaker = new JMenuItem("Delete Newsmaker");
	
	/**
	 * 
	 */
	private JMenuItem jmiDeleteNewsMakerList = new JMenuItem("Delete Newsmaker List");
	
	/**
	 * 
	 */
	private JMenu jmNewsStory = new JMenu("News Stories");
	
	/**
	 * 
	 */
	private JMenuItem jmiAddNewsStory = new JMenuItem("Add News Story");
	
	/**
	 * 
	 */
	private JMenuItem jmiEditNewsStory = new JMenuItem("Edit News Story");
	
	/**
	 * 
	 */
	private JMenuItem jmiSortNewsStories = new JMenuItem("Sort News Stories");
	
	/**
	 * 
	 */
	private JMenuItem jmiDeleteNewsStory = new JMenuItem("Delete News Stories");
	
	/**
	 * 
	 */
	private JMenuItem jmiDeleteAllNewsStories = new JMenuItem("Delete All News Stories");
	
	/**
	 * 
	 */
	private JMenu jmDisplay = new JMenu("Display");
	
	/**
	 * 
	 */
	private JMenuItem jmiPieChart = new JMenuItem("Pie Chart");
	
	/**
	 * 
	 */
	private JMenuItem jmiText = new JMenuItem("Text");
	
	/**
	 * 
	 */
	private JList<NewsMakerModel> jlNewsMakerList = new JList<NewsMakerModel>();
	
	/**
	 * 
	 */
	private JScrollPane jspNewsMakerList = new JScrollPane(jlNewsMakerList);
	
	/**
	 * 
	 */
	private JPanel jpNewsMakerList = new JPanel();
	
	/**
	 * 
	 */
	private JList<NewsStory> jlNewsStoryList = new JList<NewsStory>();
	
	/**
	 * 
	 */
	private JScrollPane jspNewsStoryList = new JScrollPane(jlNewsStoryList);
	
	/**
	 * 
	 */
	private JPanel jpNewsStoryList = new JPanel();
	
	/**
	 * 
	 */
	private JSplitPane splitPane;
	
	/**
	 * 
	 */
	private JLabel newsmakers = new JLabel("NewsMakers");
	
	/**
	 * 
	 */
	private JLabel newsstories = new JLabel("News Stories");
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 * @author Joe Pauly
	 * @author Cavan Gary
	 */
	public SelectionView() {
		//sets name of frame
		setTitle("Nooz");
		//makes the file tab
		jmFile.add(jmiLoad);
		jmFile.add(jmiSave);
		jmFile.add(jmiImport);
		jmFile.add(jmiExport);
		//sets apppropriate commands
		jmiLoad.setActionCommand("Load");
		jmiSave.setActionCommand("Save");
		jmiImport.setActionCommand("Import");
		jmiExport.setActionCommand("Export");
		//Set appropriate buttons inactive initially
		if(newsDataBaseModel.getNewsStoryListModel().isEmpty()){
			jmiLoad.setEnabled(true);
			jmiSave.setEnabled(false);
			jmiImport.setEnabled(true);
			jmiExport.setEnabled(false);
			
		}
		else{
			jmiLoad.setEnabled(true);
			jmiSave.setEnabled(true);
			jmiImport.setEnabled(true);
			jmiExport.setEnabled(true);
		}
		
		
		//makes NewsMaker tab
		jmNewsMaker.add(jmiAddNewsMaker);
		jmNewsMaker.add(jmiEditNewsMaker);
		jmNewsMaker.add(jmiDeleteNewsMaker);
		jmNewsMaker.add(jmiDeleteNewsMakerList);
		//set appropriate commands
		jmiAddNewsMaker.setActionCommand("Add Newsmaker");
		jmiEditNewsMaker.setActionCommand("Edit Newsmaker");
		jmiDeleteNewsMaker.setActionCommand("Delete Newsmaker");
		jmiDeleteNewsMakerList.setActionCommand("Delete Newsmaker List");
		//Set appropriate buttons inactive initially
		if(newsDataBaseModel.getNewsStoryListModel().isEmpty()){
			jmiAddNewsMaker.setEnabled(true);
			jmiEditNewsMaker.setEnabled(false);
			jmiDeleteNewsMaker.setEnabled(false);
			jmiDeleteNewsMakerList.setEnabled(false);
		}
		else{
			jmiAddNewsMaker.setEnabled(true);
			jmiEditNewsMaker.setEnabled(true);
			jmiDeleteNewsMaker.setEnabled(true);
			jmiDeleteNewsMakerList.setEnabled(true);
		}
		
		//makes NewsStory Tab
		jmNewsStory.add(jmiAddNewsStory);
		jmNewsStory.add(jmiEditNewsStory);
		jmNewsStory.add(jmiSortNewsStories);
		jmNewsStory.add(jmiDeleteNewsStory);
		jmNewsStory.add(jmiDeleteAllNewsStories);
		//Set appropriate commands
		jmiAddNewsStory.setActionCommand("Add News Story");
		jmiEditNewsStory.setActionCommand("Edit News Story");
		jmiSortNewsStories.setActionCommand("Sort News Stories");
		jmiDeleteNewsStory.setActionCommand("Delete News Story");
		jmiDeleteAllNewsStories.setActionCommand("Delete All News Stories");
		//Set appropriate buttons inactive initially
		if(newsDataBaseModel.getNewsStoryListModel().isEmpty()){
			jmiAddNewsStory.setEnabled(true);
			jmiEditNewsStory.setEnabled(false);
			jmiSortNewsStories.setEnabled(false);
			jmiDeleteNewsStory.setEnabled(false);
			jmiDeleteAllNewsStories.setEnabled(false);
		}
		else{
			jmiAddNewsStory.setEnabled(true);
			jmiEditNewsStory.setEnabled(true);
			jmiSortNewsStories.setEnabled(true);
			jmiDeleteNewsStory.setEnabled(true);
			jmiDeleteAllNewsStories.setEnabled(true);
		}
		
		
		//makes display tab
		jmDisplay.add(jmiPieChart);
		jmDisplay.add(jmiText);
		//Set appropriate commands
		jmiPieChart.setActionCommand("Pie Chart");
		jmiText.setActionCommand("Text");
		//Set appropriate buttons inactive initially
		if(this.newsDataBaseModel.getNewsStoryListModel().isEmpty()){
			jmiPieChart.setEnabled(false);
			jmiText.setEnabled(false);
		}
		else{
			jmiPieChart.setEnabled(true);
			jmiText.setEnabled(true);
		}
		
		//puts all menus into bar
		jmb.add(jmFile);
		jmb.add(jmNewsMaker);
		jmb.add(jmNewsStory);
		jmb.add(jmDisplay);
		
		//makes the frame and such
		jpNewsMakerList.setLayout(new BorderLayout());
		jpNewsStoryList.setLayout(new BorderLayout());
		jpNewsMakerList.add(jspNewsMakerList);
		jpNewsMakerList.add(newsmakers, BorderLayout.NORTH);
		jpNewsStoryList.add(jspNewsStoryList);
		jpNewsStoryList.add(newsstories, BorderLayout.NORTH);
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, jpNewsMakerList, jpNewsStoryList);
		jlNewsMakerList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		jlNewsStoryList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		
		setJMenuBar(jmb);
		add(splitPane);
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 */
	public void registerFileMenuListener(ActionListener fileMenuListener) {
		jmiLoad.addActionListener(fileMenuListener);
		jmiImport.addActionListener(fileMenuListener);
		jmiSave.addActionListener(fileMenuListener);
		jmiExport.addActionListener(fileMenuListener);
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 */
	public void registerNewsMakerMenuListener(ActionListener newsMakerMenuListener) {
		jmiAddNewsMaker.addActionListener(newsMakerMenuListener);
		jmiEditNewsMaker.addActionListener(newsMakerMenuListener);
		jmiDeleteNewsMaker.addActionListener(newsMakerMenuListener);
		jmiDeleteNewsMakerList.addActionListener(newsMakerMenuListener);
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 */
	public void registerNewsStoryMenuListener(ActionListener newsStoryMenuListener) {
		jmiAddNewsStory.addActionListener(newsStoryMenuListener);
		jmiEditNewsStory.addActionListener(newsStoryMenuListener);
		jmiSortNewsStories.addActionListener(newsStoryMenuListener);
		jmiDeleteNewsStory.addActionListener(newsStoryMenuListener);
		jmiDeleteAllNewsStories.addActionListener(newsStoryMenuListener);
	}
	
	/**
	 * @author Nathan Fritz
	 * @author Alex Kloppenburg
	 */
	public void registerDisplayMenuListener(ActionListener displayMenuListener) {
		jmiPieChart.addActionListener(displayMenuListener);
		jmiText.addActionListener(displayMenuListener);
	}
	
	/**
	 * @author Nathan Fritz
	 * @param newsDataBaseModel
	 */
	public void setNewsDataBaseModel(NewsDataBaseModel newsDataBaseModel) {
		
		//Sets Model
		this.newsDataBaseModel = newsDataBaseModel;
		if(this.newsDataBaseModel != null) {
			newsDataBaseModel.addActionListener(this);
		}
		jlNewsMakerList.setModel(newsDataBaseModel.getNewsMakers());
		jlNewsStoryList.setModel(newsDataBaseModel.getNewsStories());
	}

	
	/**
	 * @author Nathan Fritz
	 */
	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		
		if (actionEvent.getActionCommand().equals("Update Menu Items")) {
			//Set filemenu buttons
			if(this.newsDataBaseModel.getNewsStoryListModel().isEmpty() && this.newsDataBaseModel.getNewsMakerListModel().isEmpty()){
				jmiLoad.setEnabled(true);
				jmiSave.setEnabled(false);
				jmiImport.setEnabled(true);
				jmiExport.setEnabled(false);
				
			}
			else{
				jmiLoad.setEnabled(true);
				jmiSave.setEnabled(true);
				jmiImport.setEnabled(true);
				jmiExport.setEnabled(true);
			}
			
			//Set set Newsmaker Menu buttons
			if(newsDataBaseModel.getNewsMakerListModel().isEmpty()){
				jmiAddNewsMaker.setEnabled(true);
				jmiEditNewsMaker.setEnabled(false);
				jmiDeleteNewsMaker.setEnabled(false);
				jmiDeleteNewsMakerList.setEnabled(false);
			}
			else{
				jmiAddNewsMaker.setEnabled(true);
				jmiEditNewsMaker.setEnabled(true);
				jmiDeleteNewsMaker.setEnabled(true);
				jmiDeleteNewsMakerList.setEnabled(true);
			}
			
			//Set News Story Menu buttons
			if(newsDataBaseModel.getNewsStoryListModel().isEmpty()){
				jmiAddNewsStory.setEnabled(true);
				jmiEditNewsStory.setEnabled(false);
				jmiSortNewsStories.setEnabled(false);
				jmiDeleteNewsStory.setEnabled(false);
				jmiDeleteAllNewsStories.setEnabled(false);
			}
			else{
				jmiAddNewsStory.setEnabled(true);
				jmiEditNewsStory.setEnabled(true);
				jmiSortNewsStories.setEnabled(true);
				jmiDeleteNewsStory.setEnabled(true);
				jmiDeleteAllNewsStories.setEnabled(true);
			}
			
			//Set appropriate buttons inactive initially
			if(this.newsDataBaseModel.getNewsStoryListModel().isEmpty()  || this.newsDataBaseModel.getNewsMakerListModel().isEmpty()){
				jmiPieChart.setEnabled(false);
				jmiText.setEnabled(false);
			}
			else{
				jmiPieChart.setEnabled(true);
				jmiText.setEnabled(true);
			}
			
		}
	}
	
	/**
	 * @author Nathan Fritz
	 */
	public int[] getSelectedNewsMakers() {
		return jlNewsMakerList.getSelectedIndices();
	}
	
	/**
	 * @author Nathan Fritz
	 * @return
	 */
	public int[] getSelectedNewsStories() {
		return jlNewsStoryList.getSelectedIndices();
	}
}

