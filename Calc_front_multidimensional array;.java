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
			// 2次元配列宣言
			String[][] user_input = new String[2][4];

			for (int i = 0; i < user_input[0].length; i++) {
				user_input[0][i] = new java.util.Scanner(System.in).nextLine();
			}
			// 空白の場合、終了。結果を表示
			if (user_input[0][0].equals("")) { // 1文字目が空白の場合
				System.out.println("計算を終了します。");
				break;
				// 入力不足の場合
			} else if (user_input[0][1].equals("")) { 
				System.err.println("入力エラー");
				continue;
			}

			// 演算子
			String[] ops = { "+", "-", "×", "÷", "%", "^", "r" };

			// 要素が4以下の処理
			if (!(user_input[0][1].equals(ops[6])) && user_input[0][3].equals("")) {
				int integerCalc;
				int digit1 = Integer.parseInt(user_input[0][0]);
				int digit2 = Integer.parseInt(user_input[0][2]);
				int ans = integerCalc(digit1, digit2, user_input);
				System.out.println("-----結果表示--------");
				System.out.println(ans);
				System.out.println("計算を終了します");
				System.out.println("-------------------");
			}
			// 平方根が配列[0]にある場合
			else if (user_input[0][1].equals(ops[6]) && user_input[0][3].equals("")) {
				double squareCalc;
				double digit3 = Double.parseDouble(user_input[0][0]);
				double result = squareCalc(digit3, user_input);
				System.out.println("-----結果表示--------");
				System.out.println(result);
				System.out.println("計算を終了します");
				System.out.println("-------------------");

			}
			// 要素が4以上の処理
			// 配列[0][1]共に平方根がない場合の処理
			else if (!(user_input[0][3].equals("") && (user_input[0][1].equals(ops[6])))) {
				int integerCalc;
				int integerNewCalc;
				int digit1 = Integer.parseInt(user_input[0][0]);
				int digit2 = Integer.parseInt(user_input[0][2]);
				int ans = integerCalc(digit1, digit2, user_input);

				for (int i = 0; i < user_input[1].length; i++) {
					user_input[1][i] = new java.util.Scanner(System.in).nextLine();
					int digit4 = Integer.parseInt(user_input[1][0]);
					int newAns = integerNewCalc(ans, digit4, user_input);
					System.out.println("-----結果表示--------");
					System.out.println(newAns);
					System.out.println("計算を終了します");
					System.out.println("-------------------");
					break;
				}

			}
		}
	}

	// 要素が4以下の処理
	// 配列[0]に平方根を含んでいない場合
	public static int integerCalc(int digit1, int digit2, String[][] user_input) {
		if (user_input[0][1].equals("+")) {
			return digit1 + digit2;
		}
		if (user_input[0][1].equals("-")) {
			return digit1 - digit2;
		}
		if (user_input[0][1].equals("×")) {
			return digit1 * digit2;
		}
		if (user_input[0][1].equals("÷")) {
			return digit1 / digit2;
		}
		if (user_input[0][1].equals("%")) {
			return digit1 % digit2;
		}
		if (user_input[0][1].equals("^")) {
			return digit1 ^ digit2;
		}
		return 0;
	}

	// 配列[0]に平方根を含んでいる場合
	public static double squareCalc(double digit3, String[][] user_input) {
		if (user_input[0][1].equals("r")) {
			double A = Math.sqrt(digit3);
			return A;
		}
		return 0.0;
	}

	// 要素5以上の計算
	// 配列[0][1]共に平方根がない場合の処理
	public static int integerNewCalc(int ans, int digit4, String[][] user_input) {
		if (user_input[0][3].equals("+")) {
			return ans + digit4;
		}
		if (user_input[0][3].equals("-")) {
			return ans - digit4;
		}
		if (user_input[0][3].equals("×")) {
			return ans * digit4;
		}
		if (user_input[0][3].equals("÷")) {
			return ans / digit4;
		}
		// %(除算・余り),^(べき乗)の追加
		if (user_input[0][3].equals("%")) {
			return ans % digit4;
		}
		if (user_input[0][3].equals("^")) {
			return ans ^ digit4;
		}
		return 0;
	}
}
