package day0107db;

import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import day1226.student;

/*
 * create table foodrest 
(
	num smallint auto_increment primary key,
    foodname varchar(30),
    foodprice int,
    foodsize varchar(20) default '보통');

create table foodorder
(
	idx smallint auto_increment primary key,
    num smallint,
    ordername varchar(20),
    ordercnt smallint,
    bookingday varchar(30),
    constraint fk_foodorder_num foreign key(num) references foodrest(num));
 */
public class Ex1FoodMysqlDb extends JFrame {
	FoodModel foodModel = new FoodModel();
	DefaultTableModel foodRestTableModel;
	DefaultTableModel foodOrderTableModel;
	JTable foodResTable;
	JTable foodOrderTable;

	JButton btnFoodResAdd, btnFoodResDel;
	JButton btnFoodOrderAdd, btnFoodOrderDel;
	JTextField tfFoodNum, tfOrderName, tfOrderCnt, tfBookingDay;
	JTextField tfFoodName, tfFoodPrice, tfFoodSize;

	public Ex1FoodMysqlDb() {
		// TODO Auto-generated constructor stub
		super("메뉴 등록 및 예약");
		this.setBounds(200, 100, 1000, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.initDesign();
		this.setVisible(true);
	}

	public void initDesign() {
		JPanel p1 = new JPanel();
		btnFoodResAdd = new JButton("메뉴등록");
		btnFoodResDel = new JButton("메뉴삭제");
		btnFoodOrderAdd = new JButton("예약하기");
		btnFoodOrderDel = new JButton("예약취소");

		tfFoodName = new JTextField(7);
		tfFoodPrice = new JTextField(7);
		tfFoodSize = new JTextField(5);

		p1.add(new JLabel("메뉴명"));
		p1.add(tfFoodName);
		p1.add(new JLabel("가격등록"));
		p1.add(tfFoodPrice);
		p1.add(new JLabel("사이즈"));
		p1.add(tfFoodSize);

		p1.add(btnFoodResAdd);
		p1.add(btnFoodResDel);
		p1.add(btnFoodOrderAdd);
		p1.add(btnFoodOrderDel);
		this.add("North", p1);

		// 왼쪽에 등록된 메뉴 보이게 하기
		String[] menuTilte = { "번호", "메뉴명", "가격", "사이즈" };
		foodRestTableModel = new DefaultTableModel(menuTilte, 0);// 제목과 행갯수는 일단 0으로
		foodResTable = new JTable(foodRestTableModel);
		this.add("West", new JScrollPane(foodResTable));

		// 생성된 메뉴 테이블에 db 데이터 출력
		writeFoodMenu();

		// 가운데 예약테이블 보이게 하기
		String[] orderTable = { "번호", "예약자", "메뉴명", "가격", "사이즈", "인원수", "예약일" };
		foodOrderTableModel = new DefaultTableModel(orderTable, 0);
		foodOrderTable = new JTable(foodOrderTableModel);
		this.add("Center", new JScrollPane(foodOrderTable));

		// 생성된 예약자 테이블에 예약 내용 출력
		writeFoodOrderJoin();

		// 하단에 예약내용 입력부분 추가
		tfOrderName = new JTextField(5);
		tfOrderCnt = new JTextField(3);
		tfBookingDay = new JTextField(10);
		tfFoodNum = new JTextField(3);

		JPanel p2 = new JPanel();
		p2.add(new JLabel("메뉴번호"));
		p2.add(tfFoodNum);

		p2.add(new JLabel("예약자명"));
		p2.add(tfOrderName);

		p2.add(new JLabel("인원수"));
		p2.add(tfOrderCnt);

		p2.add(new JLabel("예약시간"));
		p2.add(tfBookingDay);

		this.add("South", p2);

		// 버튼 이벤트들

		// 메뉴 등록 버튼
		btnFoodResAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String foodName = tfFoodName.getText();
				int foodprice = Integer.parseInt(tfFoodPrice.getText());
				String foodSize = tfFoodSize.getText();

				// insert 메서드 호출
				foodModel.foodMenuInsert(foodName, foodprice, foodSize);
				// 테이블 다시 출력
				writeFoodMenu();
				// 입력 데이터초기화
				tfFoodName.setText("");
				tfFoodPrice.setText("");
				tfFoodSize.setText("");
			}
		});
		// 메뉴 삭제 버튼
		btnFoodResDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 선택한 행번호 얻기
				int row = foodResTable.getSelectedRow();
				// 선택 안했을 경우 -1
				if (row == -1) {
					JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "삭제하려는 메뉴를 선택해주세요");
					return;
				}

				// 선택한 행의 0번열의 num 값 얻기
				int num = Integer.parseInt(foodResTable.getValueAt(row, 0).toString());
				System.out.println(num);// 콘솔로 먼저 확인하기

				// 해당 메뉴를 예약한 예약갯수 구하기
				int cnt = foodModel.getOrderMenuCount(num);
				// cnt 가 0 이면 아무도 주문 안했으므로 삭제가능
				// 그렇지 않으면 메세지 알림
				if (cnt == 0) {
					foodModel.deleteFoodMenu(num);
					JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "삭제되었습니다");
					writeFoodMenu();// 전체 메뉴 다시 출력
				} else {
					JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "해당 메뉴는 예약자가 있어서 삭제가 안됩니다\n먼저 예약을 취소 후 삭제해주세요");
				}
			}
		});
		// 예약 버튼
		btnFoodOrderAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 입력값들 읽어오기
				int num = Integer.parseInt(tfFoodNum.getText());
				String orderName = tfOrderName.getText();
				int orderCnt = Integer.parseInt(tfOrderCnt.getText());
				String bookingDay = tfBookingDay.getText();

				// dto 에 넣어주기
				FoodOrderDto dto = new FoodOrderDto(num, orderName, orderCnt, bookingDay);

				// 예약 insert 메서드 호출하기
				foodModel.foodOrderInsert(dto);

				// 다시 출력하기
				writeFoodOrderJoin();

				// 입력값 초기화
				tfFoodNum.setText("");
				tfOrderName.setText("");
				tfOrderCnt.setText("");
				tfBookingDay.setText("");
			}
		});
		// 예약 취소 버튼
		btnFoodOrderDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// 0번열의 idx 값을 얻어서 삭제 후
				// "예약이 취소되었습니다" 알림
				// 선택안했을경우 "취소할 데이터를 선택해주세요"
				int row = foodOrderTable.getSelectedRow();
				// 선택 안했을 경우
				if (row == -1) {
					JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "취소할 예약번호를 선택해주세요");
					return;
				}
				// 선택한 행의 0번열의 idx 값 얻기
				int idx = Integer.parseInt(foodOrderTable.getValueAt(row, 0).toString());
				System.out.println(idx);
				// 삭제
				foodModel.deleteOrder(idx);
				// 메시지알림
				JOptionPane.showMessageDialog(Ex1FoodMysqlDb.this, "예약이 취소되었습니다");
				// 예약테이블 다시 출력
				writeFoodOrderJoin();

			}
		});
	}

	public void writeFoodMenu() {
		// db 에서 전체 등록된 메뉴를 얻는다
		List<Vector<String>> list = foodModel.getAllMenus();
		// 기존 메뉴들 삭제
		foodRestTableModel.setRowCount(0);
		// table 에 출력
		for (Vector<String> data : list) {
			foodRestTableModel.addRow(data);
		}
	}

	public void writeFoodOrderJoin() {
		// order 데이터 가져오기
		List<Vector<String>> list = foodModel.getAllOrders();
		// 기존 데이터 모두 삭제
		foodOrderTableModel.setRowCount(0);
		// table 에 출력
		for (Vector<String> data : list) {
			foodOrderTableModel.addRow(data);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ex1FoodMysqlDb ex1 = new Ex1FoodMysqlDb();

	}

}
