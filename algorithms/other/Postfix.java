package baitap;

import java.util.Stack;

/*
–       Nếu là toán hạng: cho ra output.

–       Nếu là dấu mở ngoặc “(“: cho vào stack

–       Nếu là dấu đóng ngoặc “)": lấy các toán tử trong stack ra và cho vào output cho đến khi gặp dấu mở ngoặc “(“. 
		(Dấu mở ngoặc cũng phải được đưa ra khỏi stack)

–       Nếu là toán tử:

		Chừng nào ở đỉnh stack là toán tử và toán tử đó có độ ưu tiên lớn hơn hoặc bằng toán tử hiện tại thì 
		lấy toán tử đó ra khỏi stack và cho ra output.
		lấy toán tử hiện tại vào stack
		Sau khi duyệt hết biểu thức infix, nếu trong stack còn phần tử thì lấy các token trong đó ra và cho lần lượt vào output.
 */

/*
 * Duyệt biểu thức dạng chuỗi từ trái sang phải:

	+ Nếu là toán hạng thì dùng Push() đưa vào ngăn xếp S.

	+ Nếu là toán tử thì Pop() 2 toán hạng trong ngăn xếp S ra, sau đó tính toán giá trị của chúng dựa vào toán tử này, 
		sau đó Push() lại vào S.

	+ Thực hiện cho đến khi gặp kí tự "\0" kết thúc chuỗi.

	+ Kết quả của biểu thức chính là phần tử còn lại cuối cùng trong ngăn xếp S.
 */
public class Postfix {

	public static String infixToPostfix(String infix) {
		// TODO Auto-generated method sstub
		String postfix = "";
		//
		Stack s = new Stack();
		char x, tolen;

		for (int i = 0; i < infix.length(); i++) {
			tolen = infix.charAt(i);
			// nếu là toán hạng
			if (tolen - '0' >= 0 && tolen - '0' <= 9) {
				postfix += tolen;
			} else {
				postfix += " ";
				// nếu là (
				if (tolen == '(') {
					s.push(tolen);
				}
				// nếu là )
				else if (!s.isEmpty() && tolen == ')') {
					x = (char) s.pop();
					while (x != '(') {
						postfix += x;
						x = (char) s.pop();
					}
				}
				// nếu là toán tử
				else {
					if (!s.isEmpty() && getPriority(tolen) <= getPriority((char) s.peek())) {
						x = (char) s.pop();
						postfix += x;
						s.push(tolen);
					} else {
						s.push(tolen);
					}
				}
			}
		}
		//
		postfix += " ";
		while (!s.isEmpty()) {
			x = (char) s.pop();
			postfix += x;
		}
		return postfix;
	}

	public static int getPriority(char x) {
		// TODO Auto-generated method stub
		if (x == '(')
			return 0;
		if (x == '+' || x == '-')
			return 1;
		if (x == '*' || x == '/' || x == '%')
			return 2;

		return 3;
	}

	public static String calculato(String postfix) throws Exception {
		// TODO Auto-generated method stub
		String sum = "";
		char tolen;
		Stack s = new Stack();
		//
		String temp = "";
		for (int i = 0; i < postfix.length(); i++) {
			tolen = postfix.charAt(i);
			// nếu là toán hạng
			if (tolen - '0' >= 0 && tolen - '0' <= 9) {
				temp += tolen;
			} else if (tolen == ' ') {
				System.out.println(temp);
				s.push(temp);
				temp = "";
			}
			// nếu là toán tử
			else {
				int op1 = Integer.parseInt(s.pop().toString());
				int op2 = Integer.parseInt(s.pop().toString());
				switch (tolen) {
				case '+':
					s.push(op2 + op1);
					break;
				case '-':
					s.push(op2 - op1);
					break;
				case '*':
					s.push(op2 * op1);
					break;
				case '/':
					s.push(op2 / op1);
					break;
				case '%':
					s.push(op2 % op1);
					break;

				default:
					throw new Exception();

				}
			}
		}
		//
		sum = s.pop().toString();
		return sum;
	}

	public static int handle(String output) {
		// TODO Auto-generated method stub
		int carry = 0;
		int sum = 0;
		for (int i = 0; i < output.length(); i++) {

			char c = output.charAt(i);
			if (c - '0' >= 0 && c - '0' <= 9) {
				carry = 1;
				sum = sum * 10 * carry + c - '0';
			} else {
				sum = 0;
				carry = 0;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		String infix = "2*30+41*15";
		String postfix = infixToPostfix(infix);
		String sum;
		try {
			System.out.println("infix = " + infix);
			System.out.println("postfix = " + postfix);
			sum = calculato(postfix);
			System.out.println("sum = " + sum);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Biểu thức lỗi");
		}
	}
}
