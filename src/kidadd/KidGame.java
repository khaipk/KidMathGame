package kidadd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Random;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class KidGame extends JFrame {

	private JPanel contentPane;
	JLabel cauHoi = new JLabel("");
	JLabel lblNewLabel_2 = new JLabel("");
	private JProgressBar progressBar = new JProgressBar();
	public Timer time;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					KidGame frame = new KidGame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		boolean flag;
		int score = 0;
		public int thoigian;
	
	/**
	 * Create the frame.
	 */
	private boolean choi() {
		int a, b, c;
		Random rd = new Random();
		a = rd.nextInt(10)+1 ;
		b = rd.nextInt(10)+1 ;
		c = rd.nextInt(20)+1 ;
		cauHoi.setText(a+" + "+b+" > "+c);
		if((a+b)<=c) return false;
		else return true;
	}
	
	
	
	public KidGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 477);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Bé Tập Làm Toán");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(10, 11, 414, 24);
		contentPane.add(lblNewLabel);
		
		
		
		cauHoi.setHorizontalAlignment(SwingConstants.CENTER);
		cauHoi.setBounds(10, 85, 414, 146);
		contentPane.add(cauHoi);
		
		
		
		JButton btnNewButton_1 = new JButton("CHƠI");
		btnNewButton_1.setBounds(160, 326, 120, 102);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 flag = choi();
				 thoigian = 100;
				 time = new Timer(100, new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						if(thoigian > 0) {
							thoigian--;
							progressBar.setValue(thoigian);
						} else { 
							cauHoi.setText("Thua");
						}
					}
				}) ;
				 time.start();
				 			}

			
		});
		JButton btnNewButton = new JButton("ĐÚNG");
		btnNewButton.setBounds(10, 273, 89, 52);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cauHoi.getText()=="") {
					JOptionPane.showMessageDialog(null, "Ấn CHƠI để bắt đầu.");
				} else {
				if(flag==true ) {
					score ++;
				} else score -- ;
			} lblNewLabel_2.setText(""+score); cauHoi.setText("");
			}
		});
		
		JButton btnSai = new JButton("SAI");
		btnSai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(cauHoi.getText()=="") {
					JOptionPane.showMessageDialog(null, "Ấn CHƠI để bắt đầu.");
				} else {
				if(flag==true ) {
					score --;
				} else score ++ ;
			} lblNewLabel_2.setText(""+score); cauHoi.setText("");
			}
		});
		btnSai.setBounds(335, 273, 89, 52);
		contentPane.add(btnSai);
		
		
		
		progressBar.setBounds(140, 273, 152, 34);
		contentPane.add(progressBar);
		
		JLabel lblNewLabel_1 = new JLabel("Điểm");
		lblNewLabel_1.setBounds(67, 46, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		
		lblNewLabel_2.setBounds(242, 46, 46, 14);
		contentPane.add(lblNewLabel_2);
	}
}
