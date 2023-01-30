import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/*
public class FriendsGUI {
  
  public static void main(String[] args) throws ListException, MalformedURLException {
    JFrame frame = new JFrame("Text File to Button List");
    frame.setSize(400, 500);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    FriendsList friendList = new FriendsList();
    friendList.add(0, new Friend("magicschoolbusdropout", false));
    friendList.add(1, new Friend("Lezduit", true));
    friendList.add(2, new Friend("hoosierdaddy", true));
    // String[] lines = readTextFile("textfile.txt");
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    for (int i = 0; i <= 2; i++) {
      String name = "<html>" + friendList.get(i).toString().replace("\n", "<br>") + "</html>";
      JButton button = new JButton(name);

      button.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          System.out.println("Button clicked: " + name);
        }
      });
      panel.add(button);
    }

    JScrollPane scrollPane = new JScrollPane(panel);
    frame.add(scrollPane, BorderLayout.CENTER);

    // frame.setSize(300, 150);
    frame.setVisible(true);
  }
}
*/
