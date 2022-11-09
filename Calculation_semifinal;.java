package Calculation;

import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("値を入力してください");
		System.out.println("演算子: +, -, x, ÷,%(除算・余り),^(べき乗),r(平方根)");
		System.out.println("記号: =");

		while (true) {
			// 条件設定
			String[] user_input = new String[4];
			for (int i = 0; i < user_input.length; i++) {
				user_input[i] = new java.util.Scanner(System.in).nextLine();
			}
			// 空白の場合、処理を終了し、結果を表示
			if (user_input[0].equals("")) {
				System.out.println("終了");
				break;
			} else if (user_input[1].equals("")) {
				System.err.println("エラー");
				continue;
			}
			//使用可能な演算子
			String[] ops = { "+", "-", "*", "/", "%", "^", "r" };

			// 演算子が1つの場合の計算処理
			if (!(user_input[1].equals(ops[6])) && user_input[3].equals("")) {
				int calc;
				int input1 = Integer.parseInt(user_input[0]);
				int input2 = Integer.parseInt(user_input[2]);
				int ans = calcInteger(input1, input2, user_input);
				System.out.println(ans);
			} //rの場合の処理
			else if (user_input[1].equals(ops[6]) && user_input[3].equals("")) {
				double calc2;
				double input3 = Double.parseDouble(user_input[0]);
				double result = calc2(input3, user_input);
				System.out.println(result);
			}
			//参照渡しにより、入力可能な値を増やす
			else if (!(user_input[3].equals(""))) {
				user_input = tempArray(user_input);
			}
			// i=0の場合、入力値が上書きされてしまうため、4からスタート
			for (int i = 4; i < user_input.length; i++) {
				user_input[i] = new java.util.Scanner(System.in).nextLine();
			}

			// 確認用
			System.out.println("--------ここまでの入力-----------");
			for (int i = 0; i < user_input.length; i++) {
				System.out.print(user_input[i]);
			}
			System.out.println("");
			System.out.println("-----------------------------");

			// 戻り値を使用した場合の計算処理
			int calcInteger;
			int input1 = Integer.parseInt(user_input[0]);
			int input2 = Integer.parseInt(user_input[2]);
			int input4 = Integer.parseInt(user_input[4]);

			int middleAns = calcInteger(input1, input2, user_input);
			int finalAns = calc4(input4, middleAns, user_input);

			//配列1が+,-ではない場合、前から処理を行う
			if (user_input[1].equals(ops[2]) || user_input[1].equals(ops[3]) || user_input[1].equals(ops[4])
					|| (user_input[1].equals(ops[5]) || (user_input[1].equals(ops[6])))) {
				//出力
				System.out.println(finalAns);
			}

			// 演算子に優先順位をつけ、計算処理を行う
			//×,÷,%,^,+は+,-より先に計算を行う
			int calc;
			int ans;
			int interAns;
			Deque<String> q = new ArrayDeque<String>();

			// String[] ops = { "+", "-", "*", "/", "%", "^", "r" };
			
			//初めの演算子が+
			//次の演算子が*の場合の処理
			if ((user_input[1].equals(ops[0]) && user_input[3].equals(ops[2]))) {

				q.addLast(user_input[0]);
				q.addLast(user_input[1]);
				q.addLast(user_input[2]);
				q.addLast(user_input[3]);
				q.addLast(user_input[4]);

				String origin_digit1 = q.removeLast();
				String origin_digit2 = q.removeLast();
				String origin_digit3 = q.removeLast();

				int digit1 = Integer.parseInt(origin_digit1);
				int digit2 = Integer.parseInt(origin_digit3);

				if (user_input[3].equals(ops[2])) {
					int interAns1 = digit2 * digit1;
					String origin_digit4 = q.removeLast();
					String origin_digit5 = q.removeLast();

					int digit4 = Integer.parseInt(origin_digit5);
					int newAns = interAns1 + digit4;
					System.out.println(newAns);

				}
			}
			// 初めの演算子が+, 次の演算子が/の場合の処理
			if (user_input[1].equals(ops[0]) && user_input[3].equals(ops[3])) {
				q.addLast(user_input[0]);
				q.addLast(user_input[1]);
				q.addLast(user_input[2]);
				q.addLast(user_input[3]);
				q.addLast(user_input[4]);

				String origin_digit1 = q.removeLast();
				String origin_digit2 = q.removeLast();
				String origin_digit3 = q.removeLast();

				int digit1 = Integer.parseInt(origin_digit1);
				int digit2 = Integer.parseInt(origin_digit3);

				if (user_input[3].equals(ops[3])) {
					interAns = digit2 / digit1;
					String origin_digit4 = q.removeLast();
					String origin_digit5 = q.removeLast();

					int digit4 = Integer.parseInt(origin_digit5);
					int newAns = interAns + digit4;
					System.out.println(newAns);

				}
			}
			// 初めの演算子が+, 次の演算子が%の場合の処理
			if (user_input[1].equals(ops[0]) && user_input[3].equals(ops[4])) {
				q.addLast(user_input[0]);
				q.addLast(user_input[1]);
				q.addLast(user_input[2]);
				q.addLast(user_input[3]);
				q.addLast(user_input[4]);

				String origin_digit1 = q.removeLast();
				String origin_digit2 = q.removeLast();
				String origin_digit3 = q.removeLast();

				int digit1 = Integer.parseInt(origin_digit1);
				int digit2 = Integer.parseInt(origin_digit3);

				if (user_input[3].equals(ops[4])) {
					interAns = digit2 % digit1;
					String origin_digit4 = q.removeLast();
					String origin_digit5 = q.removeLast();

					int digit4 = Integer.parseInt(origin_digit5);
					int newAns = interAns + digit4;
					System.out.println(newAns);
				}
			}

			// 初めの演算子が+, 次の演算子が^の場合の処理
			if (user_input[1].equals(ops[0]) && user_input[3].equals(ops[5])) {
				q.addLast(user_input[0]);
				q.addLast(user_input[1]);
				q.addLast(user_input[2]);
				q.addLast(user_input[3]);
				q.addLast(user_input[4]);

				String origin_digit1 = q.removeLast();
				String origin_digit2 = q.removeLast();
				String origin_digit3 = q.removeLast();

				int digit1 = Integer.parseInt(origin_digit1);
				int digit2 = Integer.parseInt(origin_digit3);

				if (user_input[3].equals(ops[5])) {
					interAns = digit2 ^ digit1;
					String origin_digit4 = q.removeLast();
					String origin_digit5 = q.removeLast();

					int digit4 = Integer.parseInt(origin_digit5);
					int newAns = interAns + digit4;

					System.out.println(newAns);
				}
			}
			// 初めの演算子が+, 次の演算子が+の場合の処理
			if (user_input[1].equals(ops[0]) && user_input[3].equals(ops[0])) {
				q.addLast(user_input[0]);
				q.addLast(user_input[1]);
				q.addLast(user_input[2]);
				q.addLast(user_input[3]);
				q.addLast(user_input[4]);

				String origin_digit1 = q.removeLast();
				String origin_digit2 = q.removeLast();
				String origin_digit3 = q.removeLast();

				int digit1 = Integer.parseInt(origin_digit1);
				int digit2 = Integer.parseInt(origin_digit3);

				if (user_input[3].equals(ops[0])) {
					interAns = digit1 + digit2;
					String origin_digit4 = q.removeLast();
					String origin_digit5 = q.removeLast();

					int digit4 = Integer.parseInt(origin_digit5);
					int newAns = interAns + digit4;
					System.out.println(newAns);
				}
			}
			// 初めの演算子が+, 次の演算子が-
			if (user_input[1].equals(ops[0]) && user_input[3].equals(ops[1])) {
				q.addLast(user_input[0]);
				q.addLast(user_input[1]);
				q.addLast(user_input[2]);
				q.addLast(user_input[3]);
				q.addLast(user_input[4]);

				String origin_digit1 = q.removeLast();
				String origin_digit2 = q.removeLast();
				String origin_digit3 = q.removeLast();

				int digit1 = Integer.parseInt(origin_digit1);
				int digit2 = Integer.parseInt(origin_digit3);

				if (user_input[3].equals(ops[1])) {
					interAns = digit1 - digit2;
					String origin_digit4 = q.removeLast();
					String origin_digit5 = q.removeLast();

					int digit4 = Integer.parseInt(origin_digit5);
					int newAns = interAns + digit4;
					System.out.println(newAns);
				}
			}

			// 初めの演算子が-の場合の処理
			// 初めの演算子が-, 次の演算子が*の場合の処理
			if (user_input[1].equals(ops[1]) && user_input[3].equals(ops[2])) {

				q.addLast(user_input[0]);
				q.addLast(user_input[1]);
				q.addLast(user_input[2]);
				q.addLast(user_input[3]);
				q.addLast(user_input[4]);

				String origin_digit1 = q.removeLast();
				String origin_digit2 = q.removeLast();
				String origin_digit3 = q.removeLast();
				System.out.println(q);

				int digit1 = Integer.parseInt(origin_digit1);
				int digit2 = Integer.parseInt(origin_digit3);
				if (user_input[3].equals(ops[2])) {
					interAns = digit1 * digit2;
					String origin_digit5 = q.removeFirst();
					int digit4 = Integer.parseInt(origin_digit5);
					int newAns = digit4 - interAns;
					System.out.println(newAns);
				}
			}
			// 初めの演算子が-, 次の演算子が/の場合の処理
			if (user_input[1].equals(ops[1]) && user_input[3].equals(ops[3])) {

				q.addLast(user_input[0]);
				q.addLast(user_input[1]);
				q.addLast(user_input[2]);
				q.addLast(user_input[3]);
				q.addLast(user_input[4]);

				String origin_digit1 = q.removeLast();
				String origin_digit2 = q.removeLast();
				String origin_digit3 = q.removeLast();

				int digit1 = Integer.parseInt(origin_digit1);
				int digit2 = Integer.parseInt(origin_digit3);
				if (user_input[3].equals(ops[3])) {
					interAns = digit1 / digit2;
					String origin_digit4 = q.removeLast();
					String origin_digit5 = q.removeLast();

					int digit4 = Integer.parseInt(origin_digit5);
					int newAns = digit4 - interAns;
					System.out.println(newAns);

				}
			}
			// 初めの演算子が-, 次の演算子が%の場合の処理
			if (user_input[1].equals(ops[1]) && user_input[3].equals(ops[4])) {

				q.addLast(user_input[0]);
				q.addLast(user_input[1]);
				q.addLast(user_input[2]);
				q.addLast(user_input[3]);
				q.addLast(user_input[4]);

				String origin_digit1 = q.removeLast();
				String origin_digit2 = q.removeLast();
				String origin_digit3 = q.removeLast();

				int digit1 = Integer.parseInt(origin_digit1);
				int digit2 = Integer.parseInt(origin_digit3);
				if (user_input[3].equals(ops[4])) {
					interAns = digit2 % digit1;
					String origin_digit4 = q.removeLast();
					String origin_digit5 = q.removeLast();

					int digit4 = Integer.parseInt(origin_digit5);
					int newAns = digit4 - interAns;
					System.out.println(newAns);
				}
			}
			// 初めの演算子が-, 次の演算子が^の場合の処理
			if (user_input[1].equals(ops[1]) && user_input[3].equals(ops[5])) {

				q.addLast(user_input[0]);
				q.addLast(user_input[1]);
				q.addLast(user_input[2]);
				q.addLast(user_input[3]);
				q.addLast(user_input[4]);

				String origin_digit1 = q.removeLast();
				String origin_digit2 = q.removeLast();
				String origin_digit3 = q.removeLast();

				int digit1 = Integer.parseInt(origin_digit1);
				int digit2 = Integer.parseInt(origin_digit3);
				if (user_input[3].equals(ops[5])) {
					interAns = digit2 ^ digit1;
					String origin_digit4 = q.removeLast();
					String origin_digit5 = q.removeLast();

					int digit4 = Integer.parseInt(origin_digit5);
					int newAns = digit4 - interAns;
					System.out.println(newAns);
				}
			}
			// 初めの演算子が-, 次の演算子が+の場合の処理
			if (user_input[1].equals(ops[1]) && user_input[3].equals(ops[0])) {

				q.addLast(user_input[0]);
				q.addLast(user_input[1]);
				q.addLast(user_input[2]);
				q.addLast(user_input[3]);
				q.addLast(user_input[4]);

				String origin_digit1 = q.removeLast();
				String origin_digit2 = q.removeLast();
				String origin_digit3 = q.removeLast();

				int digit1 = Integer.parseInt(origin_digit1);
				int digit2 = Integer.parseInt(origin_digit3);
				if (user_input[3].equals(ops[0])) {
					interAns = digit2 + digit1;
					String origin_digit4 = q.removeLast();
					String origin_digit5 = q.removeLast();

					int digit4 = Integer.parseInt(origin_digit5);
					int newAns = digit4 - interAns;
					System.out.println(newAns);

				}
			}
			// 初めの演算子が-, 次の演算子が-の場合の処理
			if (user_input[1].equals(ops[1]) && user_input[3].equals(ops[1])) {

				q.addLast(user_input[0]);
				q.addLast(user_input[1]);
				q.addLast(user_input[2]);
				q.addLast(user_input[3]);
				q.addLast(user_input[4]);

				String origin_digit1 = q.removeLast();
				String origin_digit2 = q.removeLast();
				String origin_digit3 = q.removeLast();

				int digit1 = Integer.parseInt(origin_digit1);
				int digit2 = Integer.parseInt(origin_digit3);
				if (user_input[3].equals(ops[1])) {
					interAns = digit1 - digit2;
					String origin_digit4 = q.removeLast();
					String origin_digit5 = q.removeLast();

					int digit4 = Integer.parseInt(origin_digit5);
					int newAns = digit4 - interAns;
					System.out.println(newAns);

				}
			}

			continue;
		}

	}

	// 要素3以下の場合の処理
	// 整数計算処理
	public static int calcInteger(int input1, int input2, String[] user_input) {
		if (user_input[1].equals("+")) {
			return input1 + input2;
		}
		if (user_input[1].equals("-")) {
			return input1 - input2;
		}
		if (user_input[1].equals("*")) {
			return input1 * input2;
		}
		if (user_input[1].equals("/")) {
			return input1 / input2;
		}

		if (user_input[1].equals("%")) {
			return input1 % input2;
		}
		if (user_input[1].equals("^")) {
			return input1 ^ input2;
		}
		return 0;
	}

	// 平方根処理
	public static double calc2(double input3, String[] user_input) {
		if (user_input[1].equals("r")) {
			double A = Math.sqrt(input3);
			return A;
		}
		return 0.0;
	}

	// 参照渡し
	public static String[] tempArray(String[] user_input) {
		String[] temp_input = new String[user_input.length + 1];
		for (int i = 0; i < user_input.length; i++) {
			temp_input[i] = user_input[i];
		}
		user_input = temp_input;
		return user_input;
	}

	// 要素4以上、、前から処理を行う場合の計算処理
	public static int calc4(int input4, int middleAns, String[] user_input) {
		if (user_input[3].equals("+")) {
			return middleAns + input4;
		}
		if (user_input[3].equals("-")) {
			return middleAns - input4;
		}
		if (user_input[3].equals("*")) {
			return middleAns * input4;
		}
		if (user_input[1].equals("/")) {
			return middleAns / input4;
		}
		if (user_input[3].equals("%")) {
			return middleAns % input4;
		}
		if (user_input[3].equals("^")) {
			return middleAns ^ input4;
		}
		return 0;
	}
}
