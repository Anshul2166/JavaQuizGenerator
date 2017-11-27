import javax.swing.*;
import java.awt.*;
import java.awt.Dimension.*;
import java.awt.event.*;

public class OOPS_Mini_Project extends JFrame
{
    JFrame accessFrame, optionsMenuFrame, insertQuestionFrame, deleteQuestionFrame, modifyQuestionFrame, generateTestFrameRegUser, generateTestFrameUnregUser;
    JButton loginSubmitButton, unregUserSubmitButton, insertQuestionButton;       //buttons for accessFrame
    JTextArea infoOnAccessFrame, userID, password, typePassID, infoOnOptionsMenuFrame;
    JTextField inputUserID;
    JPasswordField inputPassword;
    JButton insertQuestion, deleteQuestion, modifyQuestion, generateTest;
    JRadioButton physicsRadioButton, chemistryRadioButton, mathsRadioButton;
    JRadioButton trueFalse, fillUps, multipleChoice;
    Color myColor = new Color(230,230,230);
    JFrame trueFalseFrame, fillUpsFrame, multipleChoiceFrame;
    JTextArea trueFalseQuestion, fillUpsQuestion, multipleChoiceQuestion;
    JTextField   trueFalseAnswer, fillUpsAnswer;
    JTextField  multipleChoiceOption1, multipleChoiceOption2, multipleChoiceOption3, multipleChoiceOption4, multipleChoiceAnswer;
    JButton insertTrueFalseButton, insertFillUpsButton, insertMultipleChoiceButton;
    
    public static void main(String args[])
    {
        new OOPS_Mini_Project();
    }
    
    public OOPS_Mini_Project()
    {
        //this is the main frame
        accessFrame = new JFrame();
        accessFrame.setSize(400,400);
        accessFrame.setLocationRelativeTo(null);
        accessFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        accessFrame.setResizable(false);
        accessFrame.setTitle("OOPS MINI PROJECT");
        
        //this is the button for registered users (on entering username and password)
        loginSubmitButton = new JButton();
        loginSubmitButton.setText("SUBMIT");
        loginSubmitButton.setBounds(50, 275, 100, 30);
        loginSubmitButton.setToolTipText("Registered User (access to full functionality)");
        
        //this is the button for guest user
        unregUserSubmitButton = new JButton();
        unregUserSubmitButton.setText("GUEST");
        unregUserSubmitButton.setBounds(250, 275, 100, 30);
        unregUserSubmitButton.setToolTipText("Guest Access (can view Questions only)");
        
        //ActionListener for buttons
        ListenForAccessFrame loginListen = new ListenForAccessFrame();
        loginSubmitButton.addActionListener(loginListen);
        unregUserSubmitButton.addActionListener(loginListen);
        
        //basic info displayed on the accessFrame i.e. on the first frame
        infoOnAccessFrame = new JTextArea();
        infoOnAccessFrame.setText("Registered User can ADD, DELETE, MODIFY, VIEW and EXPORT Questions and Solutions\nUnregistered users can only VIEW Questions\n");
        infoOnAccessFrame.setLineWrap(true);
        infoOnAccessFrame.setWrapStyleWord(true);
        infoOnAccessFrame.setBounds(50,50,300,50);
        infoOnAccessFrame.setBackground(Color.yellow);
        infoOnAccessFrame.setEditable(false);
        
        //will show text to enter user id and password
        typePassID = new JTextArea();
        typePassID.setText("ENTER USER ID AND PASSWORD");
        typePassID.setBounds(50, 125, 300, 20);
        typePassID.setBackground(myColor);
        typePassID.setEditable(false);
        
        //shows text User ID 
        userID = new JTextArea();
        userID.setText("User ID: ");
        userID.setBounds(50,170,60,20);
        userID.setBackground(myColor);
        userID.setEditable(false);
        
        //shows text Password
        password = new JTextArea();
        password.setText("Password: ");
        password.setBounds(50,210,60,300);
        password.setBackground(myColor);
        password.setEditable(false);
        
        //text field to enter User ID
        inputUserID = new JTextField();
        inputUserID.setToolTipText("Type User ID here");
        inputUserID.setBounds(130, 170, 150, 20);
        
        //text field to enter Password
        inputPassword = new JPasswordField();
        inputPassword.setToolTipText("Type Password here");
        inputPassword.setBounds(130, 210, 150, 20);
        
        //new panel added to accessFrame
        JPanel panelForAccessFrame = new JPanel();                  
        panelForAccessFrame.setBackground(myColor);
        
        //adding all buttons, textfields, textareas, panels to the accessFrame
        accessFrame.add(loginSubmitButton);
        accessFrame.add(unregUserSubmitButton);
        accessFrame.add(infoOnAccessFrame);
        accessFrame.add(typePassID);
        accessFrame.add(userID);
        accessFrame.add(password);
        accessFrame.add(inputUserID);
        accessFrame.add(inputPassword);
        accessFrame.add(panelForAccessFrame);
        accessFrame.setVisible(true);
    }
    
    //class to implemement ActionListener on buttons of accessFrame
    private class ListenForAccessFrame implements ActionListener, WindowListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            if(e.getSource() == loginSubmitButton)
            {
                //if("ADMIN".equals(inputUserID.getText())&&("ADMIN".equals(inputPassword.getText())))
                //{
                    new OptionsMenuFrame();
                    accessFrame.setEnabled(false);
                //}
               // else
                //{
                  //  JOptionPane.showMessageDialog(accessFrame, "Wrong USER ID or PASSWORD\nPlease Try Again", "ERROR", JOptionPane.ERROR_MESSAGE);
                //}
            }
            else if(e.getSource() == unregUserSubmitButton)
            {
                new GenerateTestFrameUnregUser();
                accessFrame.setEnabled(false);
            }
        }

        @Override
        public void windowOpened(WindowEvent we) {
        }

        @Override
        public void windowClosing(WindowEvent e) 
        {
            if(e.getWindow()== optionsMenuFrame)
            {
                accessFrame.setEnabled(true);
            }
            else if(e.getWindow() == generateTestFrameUnregUser)
            {
                accessFrame.setEnabled(true);
            }
        }

        @Override
        public void windowClosed(WindowEvent e) 
        {
            
        }

        @Override
        public void windowIconified(WindowEvent we) {
        }

        @Override
        public void windowDeiconified(WindowEvent we) {
        }

        @Override
        public void windowActivated(WindowEvent we) {
        }

        @Override
        public void windowDeactivated(WindowEvent we) {
        }
    }
    
    private class OptionsMenuFrame extends JFrame
    {
        public OptionsMenuFrame()
        {
            //frame to show buttons for different functionalities
            optionsMenuFrame = new JFrame();
            optionsMenuFrame.setSize(400,400);
            optionsMenuFrame.setLocationRelativeTo(null);
            optionsMenuFrame.setTitle("Registered User");
            optionsMenuFrame.setResizable(false);
            optionsMenuFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            
            ListenForAccessFrame windowListen = new ListenForAccessFrame();
            optionsMenuFrame.addWindowListener(windowListen);
            
            //radio buttons for subject select
            physicsRadioButton = new JRadioButton("PHYSICS");
            physicsRadioButton.setBackground(myColor);
            chemistryRadioButton = new JRadioButton("CHEMISTRY");
            chemistryRadioButton.setBackground(myColor);
            mathsRadioButton = new JRadioButton("MATHEMATICS");
            mathsRadioButton.setBackground(myColor);
            
            JTextArea infoOnOptionsFrame = new JTextArea();
            infoOnOptionsFrame.setText("Please select a Subject and Click on the function you want to perform");
            infoOnOptionsFrame.setBackground(Color.yellow);
            infoOnOptionsFrame.setWrapStyleWord(true);
            infoOnOptionsFrame.setLineWrap(true);
            infoOnOptionsFrame.setBounds(50,50,300,35);
            
            ButtonGroup subject = new ButtonGroup();
            subject.add(physicsRadioButton);
            subject.add(chemistryRadioButton);
            subject.add(mathsRadioButton);
            
            JPanel panelForRadioButtons = new JPanel();
            panelForRadioButtons.add(physicsRadioButton);
            panelForRadioButtons.add(chemistryRadioButton);
            panelForRadioButtons.add(mathsRadioButton);
            panelForRadioButtons.setBounds(50,110,300,30);
            panelForRadioButtons.setBackground(myColor);
                    
            //button to insert a question
            insertQuestion = new JButton();
            insertQuestion.setText("INSERT");
            insertQuestion.setBounds(50,175,130,30);
            insertQuestion.setToolTipText("Insert a question to question bank");
            
            //button to delete a question
            deleteQuestion = new JButton();
            deleteQuestion.setText("DELETE");
            deleteQuestion.setBounds(220,175,130,30);
            deleteQuestion.setToolTipText("Delete a question from question bank");
            
            //button to modify a question
            modifyQuestion = new JButton();
            modifyQuestion.setText("MODIFY");
            modifyQuestion.setBounds(50,255,130,30);
            modifyQuestion.setToolTipText("Modify a question in question bank");
            
            //button to generate test
            generateTest = new JButton();
            generateTest.setText("GENERATE TEST");
            generateTest.setBounds(220,255,130,30);
            generateTest.setToolTipText("Generate random test from question bank");
            
            //ActionListener for buttons of this frame
            ListenForOptionsMenuFrame functionalityListen = new ListenForOptionsMenuFrame();
            insertQuestion.addActionListener(functionalityListen);
            deleteQuestion.addActionListener(functionalityListen);
            modifyQuestion.addActionListener(functionalityListen);
            generateTest.addActionListener(functionalityListen);
            
            //panel for this frame
            JPanel panelForOptionsMenuFrame = new JPanel();
            panelForOptionsMenuFrame.setBackground(myColor);
            
            optionsMenuFrame.add(infoOnOptionsFrame);
            optionsMenuFrame.add(panelForRadioButtons);
            optionsMenuFrame.add(insertQuestion);
            optionsMenuFrame.add(deleteQuestion);
            optionsMenuFrame.add(modifyQuestion);
            optionsMenuFrame.add(generateTest);
            optionsMenuFrame.add(panelForOptionsMenuFrame);
            optionsMenuFrame.setVisible(true);
        }
    }
    
    private class ListenForOptionsMenuFrame implements ActionListener,WindowListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == insertQuestion)
            {
                new InsertQuestionFrame();
                optionsMenuFrame.setEnabled(false);
            }
            
            else if(e.getSource() == deleteQuestion)
            {
                new DeleteQuestionFrame();
                optionsMenuFrame.setEnabled(false);
            }
            
            else if(e.getSource() == modifyQuestion)
            {
                new ModifyQuestionFrame();
                optionsMenuFrame.setEnabled(false);
            }
            
            else if(e.getSource() == generateTest)
            {
                new GenerateTestFrameRegUser();
                optionsMenuFrame.setEnabled(false);
            }
        }

        @Override
        public void windowOpened(WindowEvent we) {
        }

        @Override
        public void windowClosing(WindowEvent e) 
        {
            if(e.getWindow() == insertQuestionFrame ||e.getWindow() == deleteQuestionFrame ||e.getWindow() == modifyQuestionFrame ||e.getWindow() == generateTestFrameRegUser)
            {
                optionsMenuFrame.setEnabled(true);
            }
        }

        @Override
        public void windowClosed(WindowEvent we) {
        }

        @Override
        public void windowIconified(WindowEvent we) {
        }

        @Override
        public void windowDeiconified(WindowEvent we) {
        }

        @Override
        public void windowActivated(WindowEvent we) {
        }

        @Override
        public void windowDeactivated(WindowEvent we) {
        }
    }
    
    private class InsertQuestionFrame extends JFrame
    {
        public InsertQuestionFrame()
        {
            insertQuestionFrame = new JFrame();
            insertQuestionFrame.setSize(400,400);
            insertQuestionFrame.setLocationRelativeTo(null);
            insertQuestionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            insertQuestionFrame.setTitle("INSERT A QUESTION");
            insertQuestionFrame.setResizable(false);
            
            JTextArea textForInsertQuestionFrame = new JTextArea();
            textForInsertQuestionFrame.setText("Select a Subject and Click on Proceed");
            textForInsertQuestionFrame.setLineWrap(true);
            textForInsertQuestionFrame.setWrapStyleWord(true);
            textForInsertQuestionFrame.setBackground(Color.yellow);
            textForInsertQuestionFrame.setBounds(50,50,300,20);
                        
            trueFalse = new JRadioButton("True/False");
            trueFalse.setBackground(myColor);
            trueFalse.setBounds(50,120,200,30);
            fillUps = new JRadioButton("Fill in the Blanks");
            fillUps.setBackground(myColor);
            fillUps.setBounds(50,180,200,30);
            multipleChoice = new JRadioButton("Multiple Choice Questions");
            multipleChoice.setBackground(myColor);
            multipleChoice.setBounds(50,240,200,30);
            
            ButtonGroup questionType = new ButtonGroup();
            questionType.add(trueFalse);
            questionType.add(fillUps);
            questionType.add(multipleChoice);      
            
            ListenForOptionsMenuFrame windowListener = new ListenForOptionsMenuFrame();
            insertQuestionFrame.addWindowListener(windowListener);
            
            JPanel panelForInsertQuestionFrame = new JPanel();                  
            panelForInsertQuestionFrame.setBackground(myColor);
            
            insertQuestionButton = new JButton("PROCEED");
            insertQuestionButton.setBounds(150,300,100,30);
            
            ListenForInsertQuestionFrame listenForInsertQuestionFrame = new ListenForInsertQuestionFrame();
            insertQuestionButton.addActionListener(listenForInsertQuestionFrame);
            
            insertQuestionFrame.add(textForInsertQuestionFrame);
            insertQuestionFrame.add(insertQuestionButton);
            insertQuestionFrame.add(trueFalse);
            insertQuestionFrame.add(fillUps);
            insertQuestionFrame.add(multipleChoice);
            insertQuestionFrame.add(panelForInsertQuestionFrame);
            insertQuestionFrame.setVisible(true);
        }
    }
     
    private class DeleteQuestionFrame extends JFrame
    {
        public DeleteQuestionFrame()
        {
            deleteQuestionFrame = new JFrame();
            deleteQuestionFrame.setSize(400,400);
            deleteQuestionFrame.setLocationRelativeTo(null);
            deleteQuestionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            deleteQuestionFrame.setTitle("DELETE A QUESTION");
            deleteQuestionFrame.setResizable(false);
            
            ListenForOptionsMenuFrame windowListener = new ListenForOptionsMenuFrame();
            deleteQuestionFrame.addWindowListener(windowListener);
            
            JPanel panelForDeleteQuestionFrame = new JPanel();                  
            panelForDeleteQuestionFrame.setBackground(myColor);
            
            deleteQuestionFrame.add(panelForDeleteQuestionFrame);
            
            deleteQuestionFrame.setVisible(true);
        }
    }
    
    private class ModifyQuestionFrame extends JFrame
    {
        public ModifyQuestionFrame()
        {
            modifyQuestionFrame = new JFrame();
            modifyQuestionFrame.setSize(400,400);
            modifyQuestionFrame.setLocationRelativeTo(null);
            modifyQuestionFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            modifyQuestionFrame.setTitle("MODIFY A QUESTION");
            modifyQuestionFrame.setResizable(false);
            
            ListenForOptionsMenuFrame windowListener = new ListenForOptionsMenuFrame();
            modifyQuestionFrame.addWindowListener(windowListener);
            
            JPanel panelForModifyQuestionFrame = new JPanel();                  
            panelForModifyQuestionFrame.setBackground(myColor);
            
            modifyQuestionFrame.add(panelForModifyQuestionFrame);
            
            modifyQuestionFrame.setVisible(true);
        }
    }
    
    private class GenerateTestFrameRegUser extends JFrame
    {
        public GenerateTestFrameRegUser()
        {
            generateTestFrameRegUser = new JFrame();
            generateTestFrameRegUser.setSize(400,400);
            generateTestFrameRegUser.setLocationRelativeTo(null);
            generateTestFrameRegUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            generateTestFrameRegUser.setTitle("GENERATE TEST");
            generateTestFrameRegUser.setResizable(false);
            
            ListenForOptionsMenuFrame windowListener = new ListenForOptionsMenuFrame();
            generateTestFrameRegUser.addWindowListener(windowListener);
            
            JPanel panelForGenerateTestFrame = new JPanel();                  
            panelForGenerateTestFrame.setBackground(myColor);
            
            generateTestFrameRegUser.add(panelForGenerateTestFrame);
            
            generateTestFrameRegUser.setVisible(true);
        }
    }
    
    private class GenerateTestFrameUnregUser extends JFrame
    {
        public GenerateTestFrameUnregUser()
        {
            generateTestFrameUnregUser = new JFrame();
            generateTestFrameUnregUser.setSize(400,400);
            generateTestFrameUnregUser.setLocationRelativeTo(null);
            generateTestFrameUnregUser.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            generateTestFrameUnregUser.setTitle("GENERATE TEST");
            generateTestFrameUnregUser.setResizable(false);
            
            ListenForAccessFrame windowListenGuest = new ListenForAccessFrame();
            generateTestFrameUnregUser.addWindowListener(windowListenGuest);
            
            JPanel panelForGenerateTestFrame = new JPanel();                  
            panelForGenerateTestFrame.setBackground(myColor);
            
            generateTestFrameUnregUser.add(panelForGenerateTestFrame);
            
            generateTestFrameUnregUser.setVisible(true);
        }
    }
    
    private class TrueFalseFrame extends JFrame
    {
        public TrueFalseFrame()
        {
            trueFalseFrame = new JFrame();
            trueFalseFrame.setSize(400,400);
            trueFalseFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            trueFalseFrame.setLocationRelativeTo(null);
            trueFalseFrame.setTitle("Insert True/False");
            trueFalseFrame.setResizable(false);
            
            JPanel panelForTrueFalseFrame = new JPanel();                  
            panelForTrueFalseFrame.setBackground(myColor);
            
            JTextArea textArea1 = new JTextArea();
            textArea1.setText("Write the question in the box below");
            textArea1.setLineWrap(true);
            textArea1.setWrapStyleWord(true);
            textArea1.setBounds(50,50,300,20);
            textArea1.setBackground(Color.yellow);
            textArea1.setEditable(false);
            
            trueFalseQuestion = new JTextArea();
            trueFalseQuestion.setBounds(50,80,300,130);
            trueFalseQuestion.setBackground(Color.white);
            trueFalseQuestion.setLineWrap(true);
            trueFalseQuestion.setWrapStyleWord(true);
            
            JTextArea textArea2 = new JTextArea();
            textArea2.setText("Write the answer (TRUE/FALSE) in the box below");
            textArea2.setLineWrap(true);
            textArea2.setWrapStyleWord(true);
            textArea2.setBounds(50,230,300,20);
            textArea2.setBackground(Color.yellow);
            textArea2.setEditable(false);
            
            trueFalseAnswer = new JTextField("",10);
            trueFalseAnswer.setBounds(150,260,100,30);
            
            insertTrueFalseButton = new JButton("INSERT");
            insertTrueFalseButton.setBounds(150,310,100,30);
            
            trueFalseFrame.add(textArea1);
            trueFalseFrame.add(textArea2);
            trueFalseFrame.add(trueFalseQuestion);
            trueFalseFrame.add(trueFalseAnswer);
            trueFalseFrame.add(insertTrueFalseButton);
            trueFalseFrame.add(panelForTrueFalseFrame);
            trueFalseFrame.setVisible(true);
        }
    }
    
    private class ListenForInsertQuestionFrame implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            int value;
            if(e.getSource()== insertQuestionButton)
            {
                if(trueFalse.isSelected())
                {
                    value = 1;
                    new TrueFalseFrame();
                }
                else if(fillUps.isSelected())
                {
                    value = 2;
                    new FillUpsFrame();
                }
                else if(multipleChoice.isSelected())
                {
                    value = 3;
                }
            }
        }
        
    }
    
    private class FillUpsFrame extends JFrame
    {
        public FillUpsFrame()
        {
            fillUpsFrame = new JFrame();
            fillUpsFrame.setSize(400,400);
            fillUpsFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            fillUpsFrame.setLocationRelativeTo(null);
            fillUpsFrame.setTitle("Insert Fill Up");
            fillUpsFrame.setResizable(false);
            
            JPanel panelForFillUpsFrame = new JPanel();                  
            panelForFillUpsFrame.setBackground(myColor);
            
            JTextArea textArea1 = new JTextArea();
            textArea1.setText("Write the question in the box below");
            textArea1.setLineWrap(true);
            textArea1.setWrapStyleWord(true);
            textArea1.setBounds(50,50,300,20);
            textArea1.setBackground(Color.yellow);
            textArea1.setEditable(false);
            
            trueFalseQuestion = new JTextArea();
            trueFalseQuestion.setBounds(50,80,300,130);
            trueFalseQuestion.setBackground(Color.white);
            trueFalseQuestion.setLineWrap(true);
            trueFalseQuestion.setWrapStyleWord(true);
            
            JTextArea textArea2 = new JTextArea();
            textArea2.setText("Write the answer (TRUE/FALSE) in the box below");
            textArea2.setLineWrap(true);
            textArea2.setWrapStyleWord(true);
            textArea2.setBounds(50,230,300,20);
            textArea2.setBackground(Color.yellow);
            textArea2.setEditable(false);
            
            trueFalseAnswer = new JTextField("",10);
            trueFalseAnswer.setBounds(150,260,100,30);
            
            insertTrueFalseButton = new JButton("INSERT");
            insertTrueFalseButton.setBounds(150,310,100,30);
            
            trueFalseFrame.add(textArea1);
            trueFalseFrame.add(textArea2);
            trueFalseFrame.add(trueFalseQuestion);
            trueFalseFrame.add(trueFalseAnswer);
            trueFalseFrame.add(insertTrueFalseButton);
            trueFalseFrame.add(panelForFillUpsFrame);
            trueFalseFrame.setVisible(true);
        }
    }
    
}
