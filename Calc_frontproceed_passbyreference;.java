package Calclator_pattern3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("値を入力してください");
		System.out.println("演算子: +, -, *, /,%(除算・余り),^(べき乗),r(平方根)");

		while (true) {
			// 条件設定
			String[] user_input = new String[4];
			for (int i = 0; i < user_input.length; i++) {
				user_input[i] = new java.util.Scanner(System.in).nextLine();
			}
			//空白の場合、処理を終了し、結果を表示
			if (user_input[0].equals("")) {
				System.out.println("終了");
				break;
			} else if (user_input[1].equals("")) {
				System.err.println("エラー");
				continue;
			}
			// 演算子
			String[] ops = { "+", "-", "×", "÷", "%", "^", "r" };
			
			//計算処理
			if (!(user_input[1].equals(ops[6])) && user_input[3].equals("")) {
				int calc;
				int digit1 = Integer.parseInt(user_input[0]);
				int digit2 = Integer.parseInt(user_input[2]);
				int ans = calc(digit1, digit2, user_input);
				System.out.println(ans);
			} else if (user_input[1].equals(ops[6]) && user_input[3].equals("")) {
				double calc2;
				double digit3 = Double.parseDouble(user_input[0]);
				double result = calc2(digit3, user_input);
				System.out.println(result);
			}

			else if (!(user_input[3].equals(""))) {
				user_input = tempArray(user_input);
			}
			//i=0の場合、入力値が上書きされてしまうため、4からスタート
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

			//出力
			int calc;
			int digit1 = Integer.parseInt(user_input[0]);
			int digit2 = Integer.parseInt(user_input[2]);
			int digit4 = Integer.parseInt(user_input[4]);

			int interAns = calc(digit1, digit2, user_input);
			int newAns = calc4(digit4, interAns, user_input);
			System.out.println(newAns);
			continue;
		}
	}
	//要素4以下の場合の処理
	//整数計算処理
	public static int calc(int digit1, int digit2, String[] user_input) {
		if (user_input[1].equals("+")) {
			return digit1 + digit2;
		}
		if (user_input[1].equals("-")) {
			return digit1 - digit2;
		}
		if (user_input[1].equals("×")) {
			return digit1 * digit2;
		}
		if (user_input[1].equals("÷")) {
			return digit1 / digit2;
		}

		if (user_input[1].equals("%")) {
			return digit1 % digit2;
		}
		if (user_input[1].equals("^")) {
			return digit1 ^ digit2;
		}
		return 0;
	}

	//平方根処理
	public static double calc2(double digit3, String[] user_input) {
		if (user_input[1].equals("r")) {
			double A = Math.sqrt(digit3);
			return A;
		}
		return 0.0;
	}

	//参照渡し
	public static String[] tempArray(String[] user_input) {
		String[] temp_input = new String[user_input.length + 1];
		for (int i = 0; i < user_input.length; i++) {
			temp_input[i] = user_input[i];
		}
		user_input = temp_input;
		return user_input;
	}

	//要素5以上の場合の計算処理
	public static int calc4(int digit4, int interAns, String[] user_input) {
		if (user_input[3].equals("+")) {
			return interAns + digit4;
		}
		if (user_input[3].equals("-")) {
			return interAns - digit4;
		}
		if (user_input[3].equals("×")) {
			return interAns * digit4;
		}
		if (user_input[1].equals("÷")) {
			return interAns / digit4;
		}
		if (user_input[3].equals("%")) {
			return interAns % digit4;
		}
		if (user_input[3].equals("^")) {
			return interAns ^ digit4;
		}
		return 0;
	}
}
