import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

//GUI CLASS
public class LSGUI extends JFrame implements ActionListener{
    private JLabel InfoLabel;
    private JLabel wordToTranslate;
    private JTextField userInput;
    private JButton OkButton;
    private final Timer t;
    private final Timer t2;
    private EnglishAndFrenchArrays arrays;
    private int language;
    private int word;
    private String answer;
    
    //CONSTRUCTOR FOR LSGUI CLASS
    public LSGUI()
    {
        super();
        GridBagConstraints layoutConst;

        //SET TITLE
        setTitle("LanguageGUI");
        
        //LAYOUT
        setLayout(new GridBagLayout());
        
        //INFO LABEL
        InfoLabel = new JLabel("Type the translation into the field below.");
        //GRIDBAG CONSTRAINTS
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy =0;
        layoutConst.insets = new Insets(10,10,10,10);
        //ADD INFO LABEL TO GUI
        add(InfoLabel, layoutConst);
  
        //WORDTOTRANSLATE LABEL
        arrays = new EnglishAndFrenchArrays();
        language = arrays.getLanguage();
        word = arrays.getWord();
        wordToTranslate = new JLabel(arrays.getWordToTranslate(language, word));
        answer = arrays.getAnswer(language, word);
 
        //GRIDBAG CONSTRAINTS
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 0;
        layoutConst.gridy =1;
        layoutConst.insets = new Insets(10,10,10,10);
        //ADD WORDTOTRANSLATE LABEL TO GUI
        add(wordToTranslate, layoutConst);
        
        //USERINPUT TEXTFIELD
        userInput = new JTextField();
        //SET USERINPUT TEXTFIELD SIZE
        userInput.setPreferredSize(new Dimension(150,20));
        userInput.setMinimumSize(userInput.getPreferredSize());
        //GRIDBAG CONSTRAINTS
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 1;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10,10,10,10);
        //ADD USERINPUT TEXTFIELD TO GUI
        add(userInput, layoutConst);
        //MAKE TEXT FIELD EDITABLE
        userInput.setEditable(true);
        
        //OK BUTTON
        OkButton = new JButton("Ok");
        //GRIDBAG CONSTRAINTS
        layoutConst = new GridBagConstraints();
        layoutConst.gridx = 2;
        layoutConst.gridy = 1;
        layoutConst.insets = new Insets(10,10,10,10);
        //ADD OK BUTTON TO GUI
        add(OkButton, layoutConst);
        //ADD ACTION LISTENER FOR OK BUTTON
        OkButton.addActionListener(new ButtonPressedListener());
        
        //TIMER FOR TYPING IN ANSWER
        t = new Timer(5*1000,this);
        t.start();
        //TIMER FOR DISPLAYING ANSWER
        t2 = new Timer(10*1000,this);
        t2.start();

    }//END LSGUI

    @Override//SET UP KEYBOARDACTION
    public void addNotify() {
        super.addNotify();
        SwingUtilities.getRootPane(OkButton).setDefaultButton(OkButton);
    }//ENTER NOW ACTIVATES OKBUTTON
    
    @Override//ACTION PERFORMED BY TIMER METHOD
    public void actionPerformed(ActionEvent e) {
        //ACTION PERFORMED WHEN THE OKAY BUTTON PRESSED OR ANSWER TIMER FIRES
        if(e.getSource() == t){//answer timer check
            t.stop();//stop answer timer
            userInput.setEditable(false);//stop user from changing input
            //CHECK ANSWER
            if(userInput.getText().equalsIgnoreCase(answer))
                {
                InfoLabel.setText("Correct!");
                }
            else
                {
                InfoLabel.setText("Incorrect! Answer: " + answer);
                userInput.setText("Incorrect");
                }
            }//end answer check
        //ACTION PERFORMED WHEN ANSWER DISPLAY TIMER FIRES
        else if(e.getSource() == t2){//answer display timer check
            userInput.setText("");//reset textbox
            userInput.setEditable(true);//allow textbox to be edited
            InfoLabel.setText("Type the translation into the field below.");
                                 //reset infolabel
            language = arrays.getLanguage();//chooses language of word 
            word = arrays.getWord(); //chooses the word number to be used
            wordToTranslate.setText(arrays.getWordToTranslate(language, word));
            //sets the wordToTranslate label to the word choosen 
            answer = arrays.getAnswer(language, word);
            //sets the answer to the numbered word from the other language
            t.start(); //starts the answer timer again
        }  
    }
    //ACTION PERFORMED BY OKBUTTON PRESSED INNER CLASS
    class ButtonPressedListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {// do stuff
    t.stop();//stop answer timer
        userInput.setEditable(false);//stop user from changing input
        //CHECK ANSWER
        if(userInput.getText().equalsIgnoreCase(answer))
            {
            InfoLabel.setText("Correct!");
            }
        else
            {
            InfoLabel.setText("Incorrect! Answer: " + answer);
            userInput.setText("Incorrect");
            }
        }//end answer check
    }//end ButtonPressedListener inner class
}//end LSGUI class
