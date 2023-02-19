/**
 * This class is a simple calculator to exhibit how to use stacks in applications.
 * The class checks for matching ( ) and also evaluates equations
 * that are valid. The equations are limited to integers with +, -, /, * operations.
 */
import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class Evaluator extends JFrame implements KeyListener {

    //=======================MAIN====================
    /**
     * Starts the evaluator.
     * @param args - not used
     */
    public static void main(String[] args) {
        Evaluator o = new Evaluator();
    }

    //======================FIELDS===================
    JTextArea textBox; // text box for the equation
    JTextField solutionText; // holds the solution

    //==================CONSTRUCTOR=================
    public Evaluator() {
        // create the GUI
        JPanel panel = new JPanel();
        textBox = new JTextArea(6, 30);
        JScrollPane scrollPane = new JScrollPane(textBox);
        JButton exitButton = new JButton("Exit");
        textBox.addKeyListener(this); // below we handle when a key is typed
        JButton evalButton = new JButton("Evaluate");
        solutionText = new JTextField(5);
        solutionText.setEditable(false);        
        
        // exit button closes app
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // evalButton calls evalExpression method
        evalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                findResult();    
            }
        });

        // add componenets and show the panel
        panel.add(scrollPane);
        panel.add(solutionText);
        panel.add(evalButton);
        panel.add(exitButton);
        this.add(panel);
        setVisible(true);
        this.pack();
    }

    //=======================METHODS==========================
    /**
     * Each time a key is pressed this method examines the contents of the
     * text cell and checks to see if the ( ) match correctly.
     * Pre : given the key event with knowledge of the current key typed
     * Post: text is colored green if ( ) match; otherwise colored red
     */
    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("char: " + e.getKeyChar() + " text: " + this.textBox.getText());
        if (this.paraMatch(this.textBox.getText()+e.getKeyChar()))
            this.textBox.setForeground(new Color(0, 200, 0));
        else
            this.textBox.setForeground(new Color(200, 0, 0));
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // not used
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // not used
    }

    /**
     * This method checks to see if the ( ) are valid
     * @param exp - given a string representing an expression
     * @return - true if ( ) are valiad; false otherwise
     */
    private boolean paraMatch(String exp) {
        StackReferenceBased<Character> parStack = new StackReferenceBased<Character>();
        for (int i = 0; i < exp.length(); i++) {
            // push onto stack each time we see (
            if (exp.charAt(i) == '(')
                parStack.push('(');
            // pop a ( from stack when ) is encountered
            else if (exp.charAt(i) == ')') {
                if (parStack.isEmpty()) // if no ( to pop then invalid
                    return false;
                else
                    parStack.pop();
            }
        }

        // true if ( matched a ) and false otherwise - leftover )
        return parStack.isEmpty();
    }

    private void findResult() {
        try {
            evalExpression();
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
            this.solutionText.setText("INVALID");
        }
    }
    /**
     * This method evaluates an expression, if valid.
     */
    private void evalExpression() {
        // get the expression from the box and turn into a character array
        String exp = this.textBox.getText();
        char[] tokens = exp.toCharArray();
 
        // Stack for numbers: 'values'
       StackReferenceBased<Integer> values = new StackReferenceBased<Integer>();
       // Stack for Operators: 'ops'
       StackReferenceBased<Character> ops = new StackReferenceBased<Character>();

       // traverse the expression
       int i  = 0;
       while (i < tokens.length) {
           // Current token is a number then push it to stack for numbers
           if (tokens[i] >= '0' && tokens[i] <= '9')  {
                       
                StringBuffer sbuf = new StringBuffer();
                // There may be more than one digit in number
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    sbuf.append(tokens[i++]);
                // after getting entire int integer  
                values.push(Integer.parseInt(sbuf.toString()));
                // when loop breaks we moved to next token to evaluate, so we back up
                i--;
           } else if (tokens[i] == '(') {
                // Current token is an opening brace,push it to 'ops'
                ops.push(tokens[i]);
           }
           // Closing ) encountered, solve entire ( )
           else if (tokens[i] == ')')  {
               while (ops.peek() != '(')
                 values.push(applyOp(ops.pop(), values.pop(), values.pop()));
               ops.pop();
           }
           // Current token is an operator.
           else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
               // While top of 'ops' has same or greater precedence to current
               // token, which is an operator. Apply operator on top of 'ops'
               // to top two elements in values stack
                while (!ops.isEmpty() && hasPrecedence(tokens[i], ops.peek())) 
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

               // Push current token to 'ops'.
               ops.push(tokens[i]);
           }

           i++; // go to next token
       } // end while

       // Entire expression has been parsed at this point, apply remaining
       // ops to remaining values
       while (!ops.isEmpty())
           values.push(applyOp(ops.pop(), values.pop(), values.pop()));

       // Top of 'values' contains result, return it
       int answer = values.pop();
       this.solutionText.setText(String.valueOf(answer));
   }

   // Returns true if op2 has higher or same precedence as op1,
   // otherwise returns false.
   public static boolean hasPrecedence(char op1, char op2)
   {
       if (op2 == '(' || op2 == ')')
           return false;

       if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
           return false;
       else
           return true;
   }

   // A utility method to apply an operator 'op' on operands 'a'
   // and 'b'. Return the result.
   public static int applyOp(char op, int b, int a)   {
       switch (op)  {
        case '+':
           return a + b;
        case '-':
           return a - b;
        case '*':
           return a * b;
        case '/':
           if (b == 0)
               throw new UnsupportedOperationException( "Cannot divide by zero");
           return a / b;
       }
       return 0;
   }
} // end class