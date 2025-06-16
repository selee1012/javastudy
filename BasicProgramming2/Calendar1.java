import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Calendar;
import java.util.*;

public class Calendar1 extends JFrame {
	
	// 날짜 가져오기
	Calendar calendar = Calendar.getInstance();
	
	// 연도, 월 저장
	int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH) + 1;
    
    // memo : 지난 과제 v체크 표시용, memo2 : 최근 과제 저장용
    HashMap<String, String> memo = new HashMap<String, String>();
	HashMap<String, String[]> memo2 = new HashMap<String, String[]>();
    
	public Calendar1() {
		// 날짜 설정
		calendar.set(year, month - 1, 1);
		
		//기본설정 타이틀, EXIT 기능, Size
		setTitle("MyCalendar");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700); 
        
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        
        //topPanel 구현 제일 위에 '<', '>' 버튼과 현재 달을 중앙에 표시 
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton t1 = new JButton("<");
        JLabel monthLabel = new JLabel(year + "년 " + month + "월");
        JButton t2 = new JButton(">");

        topPanel.add(t1);
        topPanel.add(monthLabel);
        topPanel.add(t2);
        c.add(topPanel, BorderLayout.NORTH);
        
        // g1패널 구현, 맨 위에 요일 작성 
        JPanel g1 = new JPanel(new GridLayout(0, 7, 2, 2));
        String[] days = {"일", "월", "화", "수", "목", "금", "토"};
        for (String day : days) {
            g1.add(new JLabel(day, JLabel.CENTER));
        }
        
        // 시작 요일과(1일인 요일), 그 달의 마지막 날짜 저장(11월은 30일이 마지막)
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
       
        //시작 요일이 전까지 공백으로 채우기
        for (int i = 1; i < startDay; i++) {
            g1.add(new JLabel(""));
        }
        
        // 시작 요일부터 시작, 1부터 채움, 메모가 저장되어 있으면 체크박스에 따라 색깔 변경, 기능은 action1를 통해 구현
        for (int day = 1; day <= daysInMonth; day++) {
        	String k = year + "-" + month + "-" + day;
        	String buttonText;
        	buttonText = String.valueOf(day);
        	JButton button = new JButton(buttonText);
        	if (memo2.containsKey(k)) {
        		if (memo2.get(k)[1].equals("진행 전")) button.setForeground(Color.RED);
                if (memo2.get(k)[1].equals("진행 중")) button.setForeground(Color.ORANGE);
                if (memo2.get(k)[1].equals("완료")) button.setForeground(Color.GREEN);
        	}
            button.setBackground(Color.WHITE);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	action1(String.valueOf(month), buttonText, g1, c);
                }
            });
            g1.add(button);
        }
        
        // g2패널 생성
        JPanel g2 = new JPanel(new GridLayout(3, 1, 5, 5));
        
        // 콤보박스 생성
        JPanel f1 = new JPanel(new FlowLayout());
        
        // 1~12월을 선택하는 콤보박스 추가
        JComboBox<String> monthComboBox = new JComboBox<> (
        	new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
        
        // 1~31일을 선택하는 콤보박스 추가
        JComboBox<String> dayComboBox = new JComboBox<>();
        for(int i=1; i<=31; i++) {
        	dayComboBox.addItem(String.valueOf(i));
        }
        
        f1.add(monthComboBox);
        f1.add(new JLabel("월"));
        f1.add(dayComboBox);
        f1.add(new JLabel("일"));
        
        //메모 + 텍스트 필드 작성
        JPanel f2 = new JPanel(new FlowLayout());
        f2.add(new JLabel("메모: "));
        JTextField textField = new JTextField();
        // 크기 조정
        textField.setPreferredSize(new Dimension(330,25)); 
        f2.add(textField);
        
        // 등록 버튼 생성
        JButton f3 = new JButton("등록");
        f3.setBackground(Color.WHITE);
        
        // 등록 버튼을 누르면 memo에 저장
        f3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String month1 = (String) monthComboBox.getSelectedItem();
            	String day1 = (String) dayComboBox.getSelectedItem();
            	
            	String keys = year + "-" + month1 + "-" + day1;
                memo.put(keys, textField.getText());
                JOptionPane.showMessageDialog(c, "메모 저장:\n" + 
                		 year + "년 " + month1 + "월 " + day1 + "일\n메모: " 
                		+ textField.getText(), "Message", JOptionPane.INFORMATION_MESSAGE);
                textField.setText("");
                update(g1, c);
            }
        });
        
        // f1~3을 g2에 합침
        g2.add(f1);
        g2.add(f2);
        g2.add(f3);
        
        // g1, g2를 c에 합침
        c.add(g1, BorderLayout.CENTER);
        c.add(g2, BorderLayout.SOUTH);
        
        //버튼에 기능 추가
        t1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (month == 1) {
                    year -= 1;
                    month = 12;
                } else {
                    month -= 1;
                }
                calendar.set(year, month - 1, 1);
                monthLabel.setText(year + "년 " + month + "월");
                update(g1, c);
            }
        });
        t2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (month == 12) {
                    year += 1;
                    month = 1;
                } else {
                    month += 1;
                }
                calendar.set(year, month - 1, 1);
                monthLabel.setText(year + "년 " + month + "월");
                update(g1, c);
            }
        });
        
        setVisible(true);
	}
    
	
	private void update(JPanel g1, Container c) {
        g1.removeAll(); // 기존 컴포넌트 제거
        
        //위에 날짜 추가하는 형식과 동일
        String[] days = {"일", "월", "화", "수", "목", "금", "토"};
        for (String day : days) {
            g1.add(new JLabel(day, JLabel.CENTER));
        }
        
        int startDay = calendar.get(Calendar.DAY_OF_WEEK);
        int daysInMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
       
        for (int i = 1; i < startDay; i++) {
            g1.add(new JLabel(""));
        }
        
        for (int day = 1; day <= daysInMonth; day++) {
        	String k = year + "-" + month + "-" + day;
        	String buttonText;
        	buttonText = String.valueOf(day);
        	JButton button = new JButton(buttonText);
        	if (memo2.containsKey(k)) {
        		if (memo2.get(k)[1].equals("진행 전")) button.setForeground(Color.RED);
                if (memo2.get(k)[1].equals("진행 중")) button.setForeground(Color.ORANGE);
                if (memo2.get(k)[1].equals("완료")) button.setForeground(Color.GREEN);
        	}
            button.setBackground(Color.WHITE);
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                	action1(String.valueOf(month), buttonText, g1, c);
                }
            });
            g1.add(button);
        }
        
        g1.revalidate(); // 레이아웃 갱신
        g1.repaint();    // 화면 갱신
    }
	
	public void action1(String month1, String day1, JPanel g1, Container c) {
        // 메인 프레임 생성
        JFrame frame = new JFrame();

        // 다이얼로그 생성, 사이즈및 레이아웃 설정
        JDialog c1 = new JDialog(frame, "Event", true);
        c1.setSize(300, 200);
        c1.setLayout(new BorderLayout());

        // 맨 위에 날짜 표시
        JLabel dateLabel = new JLabel(month1 + "월 " + day1 + "일", SwingConstants.CENTER);
        c1.add(dateLabel, BorderLayout.NORTH);

        // 텍스트 필드 패널 생성 및 추가
        JPanel textFieldPanel = new JPanel(new FlowLayout());
        String k = year + "-" + month + "-" + day1;
    	JTextField textField;
    	// 이미 값이 저장되어있는 경우 저장된 값이 textfield에 작성되어 있는 상태로 시작
        if (memo2.containsKey(k)) {
        	textField = new JTextField(memo2.get(k)[0], 15);
    	} else {
    		textField = new JTextField(15);
    	}
        
        textField.setBackground(Color.WHITE); // 텍스트 필드 배경색 설정
        textFieldPanel.add(textField);
        c1.add(textFieldPanel, BorderLayout.CENTER);

        // 라디오 버튼 패널 생성 및 추가
        JPanel radioPanel = new JPanel(new FlowLayout());
        ButtonGroup g = new ButtonGroup();
        JRadioButton before = new JRadioButton("진행 전");
        JRadioButton now = new JRadioButton("진행 중");
        JRadioButton after = new JRadioButton("완료");
        
        g.add(before);
        g.add(now);
        g.add(after);
        
        // 이미 값이 저장되어있는 경우 저장한 값의 체크박스에 표시된 상태로 시작
        if (memo2.containsKey(k)) {
        	if (memo2.get(k)[1].equals("진행 전")) before.setSelected(true);
            if (memo2.get(k)[1].equals("진행 중")) now.setSelected(true);
            if (memo2.get(k)[1].equals("완료")) after.setSelected(true);
        }
        
        radioPanel.add(before);
        radioPanel.add(now);
        radioPanel.add(after);

        // 라디오 버튼 패널을 텍스트 필드 아래로 배치
        textFieldPanel.add(radioPanel);

        // 저장 버튼 추가
        JButton saveButton = new JButton("저장");
        saveButton.addActionListener(e -> {
        	String inputText = textField.getText().trim(); // 입력 값 확인 (공백 제거)
        	String keys = year + "-" + month1 + "-" + day1;
        	
        	// selectedStatus를 null로 시작한 후 체크가 되어있으면 저장
        	String selectedStatus = null;
        	
        	if (before.isSelected()) {
                selectedStatus = "진행 전";
            } else if (now.isSelected()) {
                selectedStatus = "진행 중";
            } else if (after.isSelected()) {
                selectedStatus = "완료";
            }
        	
            if (inputText.isEmpty()) { // 텍스트 필드가 비어 있는 경우
                JOptionPane.showMessageDialog(c1, "텍스트 필드에 값을 입력하세요.", "오류", JOptionPane.WARNING_MESSAGE);
            } else if (selectedStatus == null) { // 체크박스가 안 체크 되어있는 경우
                JOptionPane.showMessageDialog(c1, "라디오 버튼을 선택하세요.", "오류", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(c1, "저장됨: " + inputText);
                // 해시맵 안에 배열을 사용하여 텍스트와, 체크박스 정보 모두 저장
                String[] values = {textField.getText(), selectedStatus};
                memo2.put(keys, values);
                textField.setText("");
                c1.dispose(); // 다이얼로그 닫기
                update(g1, c);
            }
  
        });
        c1.add(saveButton, BorderLayout.SOUTH);

        // 다이얼로그 위치 설정 및 표시
        c1.setLocationRelativeTo(frame);
        c1.setVisible(true);
    }
	
	public static void main(String[] args) {
		new Calendar1();
		
		
	}
}
