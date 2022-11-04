package Calclator;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// 数字と演算子を入力
		Scanner scanner = new Scanner(System.in);
		System.out.println("値を入力してください");
		System.out.println("演算子: +, -, x, ÷,%(除算・余り),^(べき乗),r(平方根)");
		// 計算条件
		while (true) {
			String[] user_input = new String[3];
			for (int i = 0; i < user_input.length; i++) {
				user_input[i] = new java.util.Scanner(System.in).nextLine();
			}
			if (user_input[0].equals("")) { // 1文字目が空白の場合
				System.out.println("計算を終了します。");
				break;
			} else if (user_input[1].equals("")) { // 入力不足の場合
				System.err.println("入力エラー");
				continue;
			}
			// 加減乗除の1回分計算実行
			// べき乗,除算（余り)の計算追加
			String[] ops = { "+", "-", "×", "÷", "%", "^", "r" };
			if (!(user_input[1].equals(ops[6]))) {
				int calc;
				int digit1 = Integer.parseInt(user_input[0]);
				int digit2 = Integer.parseInt(user_input[2]);
				int ans = calc(digit1, digit2, user_input);
				System.out.println(ans);
			} else {
				// 平方根の計算追加
				double calc2;
				double digit3 = Double.parseDouble(user_input[0]);
				double result = calc2(digit3, user_input);
				System.out.println(result);
			}
		}
	}

	// 加減乗除の1回分計算実行
	// べき乗,除算（余り)の計算追加
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
		// %(除算・余り),^(べき乗)の追加
		if (user_input[1].equals("%")) {
			return digit1 % digit2;
		}
		if (user_input[1].equals("^")) {
			return digit1 ^ digit2;
		}
		return 0;
	}

	// 平方根r(平方根)の追加
	public static double calc2(double digit3, String[] user_input) {
		if (user_input[1].equals("r")) {
			double A = Math.sqrt(digit3);
			return A;
		}
		return 0.0;
	}
}