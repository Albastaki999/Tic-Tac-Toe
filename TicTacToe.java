import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Game1 implements MouseListener {
    private JLabel[][] cells;
    private char currentPlayer;

    Game1() {
        JFrame f = new JFrame("TicTacToe");
        f.setLayout(new GridLayout(3, 3));

        cells = new JLabel[3][3];
        currentPlayer = 'X';

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                cells[row][col] = new JLabel();
                cells[row][col].setFont(new Font("Arial", Font.PLAIN, 72));
                cells[row][col].setHorizontalAlignment(JLabel.CENTER);
                cells[row][col].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cells[row][col].addMouseListener(this);
                f.add(cells[row][col]);
            }
        }
        
        f.setSize(500, 500);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        
        public void mouseClicked(MouseEvent e) {
        JLabel clickedCell = (JLabel) e.getSource();
        if (clickedCell.getText().equals("")) {
            clickedCell.setText(String.valueOf(currentPlayer));
            clickedCell.setForeground(currentPlayer == 'X' ? Color.BLUE : Color.RED);
            clickedCell.setOpaque(true);
            clickedCell.setBackground(Color.gray);
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
            // Implement Game1 logic here (check for a win or draw)
            if(checkWin()==1){
                JOptionPane.showMessageDialog(null,"Player : "+(currentPlayer=='X'?'2':'1')+" wins");
            }
            else if(checkWin()==0){
                JOptionPane.showMessageDialog(null,"It's a Draw");
            }
            if(checkWin()==1 || checkWin()==0){
                for (int i = 0 ; i<3 ;i++){
                    for(int j=0 ; j<3; j++){
                        cells[i][j].setText("");
                        cells[i][j].setBackground(null);
                        currentPlayer='X';
                    }
                }
            }
        }
    }

    public int checkWin(){
        if(!cells[0][0].getText().isEmpty() && !cells[0][1].getText().isEmpty() && !cells[0][2].getText().isEmpty() && cells[0][0].getText().equals(cells[0][1].getText()) && cells[0][1].getText().equals(cells[0][2].getText())){
            return 1;
        }
        if(!cells[1][0].getText().isEmpty() && !cells[1][1].getText().isEmpty() && !cells[1][2].getText().isEmpty() && cells[1][0].getText().equals(cells[1][1].getText()) && cells[1][1].getText().equals(cells[1][2].getText())){
            return 1;
        }
        if(!cells[2][0].getText().isEmpty() && !cells[2][1].getText().isEmpty() && !cells[2][2].getText().isEmpty() && cells[2][0].getText().equals(cells[2][1].getText()) && cells[2][1].getText().equals(cells[2][2].getText())){
            return 1;
        }
        if(!cells[0][0].getText().isEmpty() && !cells[1][0].getText().isEmpty() && !cells[2][0].getText().isEmpty() && cells[0][0].getText().equals(cells[1][0].getText()) && cells[1][0].getText().equals(cells[2][0].getText())){
            return 1;
        }
        if(!cells[0][1].getText().isEmpty() && !cells[1][1].getText().isEmpty() && !cells[2][1].getText().isEmpty() && cells[0][1].getText().equals(cells[1][1].getText()) && cells[1][1].getText().equals(cells[2][1].getText())){
            return 1;
        }
        if(!cells[0][2].getText().isEmpty() && !cells[1][2].getText().isEmpty() && !cells[2][2].getText().isEmpty() && cells[0][2].getText().equals(cells[1][2].getText()) && cells[1][2].getText().equals(cells[2][2].getText())){
            return 1;
        }
        if(!cells[0][0].getText().isEmpty() && !cells[1][1].getText().isEmpty() && !cells[2][2].getText().isEmpty() && cells[0][0].getText().equals(cells[1][1].getText()) && cells[1][1].getText().equals(cells[2][2].getText())){
            return 1;
        }
        if(!cells[0][2].getText().isEmpty() && !cells[1][1].getText().isEmpty() && !cells[2][0].getText().isEmpty() && cells[0][2].getText().equals(cells[1][1].getText()) && cells[1][1].getText().equals(cells[2][0].getText())){
            return 1;
        }
        int count =0;
    
        for (int i = 0; i<3; i++){
            for(int j=0 ; j<3; j++){
                if(cells[i][j].getText().equals("X") || cells[i][j].getText().equals("O")){
                    count++;
                }
            }
        }
        if(count==9){
            return 0;
        }
        return -1;
    }

    // Implement other MouseListener methods

    public void mouseEntered(MouseEvent e){
        
    }
    public void mouseExited(MouseEvent e){
        
        
    }
    public void mouseReleased(MouseEvent e){
        
        
    }
    public void mousePressed(MouseEvent e){
        
        
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Game1());
    }
}