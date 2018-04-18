package kk.bingo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class Bingo5x5App {

	/** 何枚ビンゴを作成するか？ How many Bingo ? */
	private static int BINGO_NUM = 36;

	/** ＤＢ情報 */
	private static String DB_INFO = "jdbc:oracle:thin:@IP:PORT:ORCL";
	private static String DB_USER = "user";
	private static String DB_PASS = "pass";

	/** ビンゴの中に埋める文字を格納しているテーブル。IDには1～シーケンスに登録しておく。 */
	private static String BINGO_TARGET_SQL = "SELECT id, target_name FROM BINGO_TARGET_TBL";

	/** ビンゴ出力先 */
	private static String BINGO_OUTPUT_PATH = "C:\\temp\\bingo.csv";

	public static void main(String[] args) throws Exception {
		var bingoList = new ArrayList<ArrayList<BingoTarget>>();
		for (int i = 0; i < BINGO_NUM; i++) {
			/** ランダム数（今回は真ん中だけ空欄にする為、24回ランダムでデータを取得する）*/
			int randamNum = 24;
			bingoList.add(pick(randamNum));
		}

		printBingo(bingoList);
		outputBingo(bingoList);
	}

	private static ArrayList<BingoTarget> pick(int choice) {
		var allBingoTargets = getAllBingoTargets();
		var choiceBingoTargets = new ArrayList<BingoTarget>(choice);
		var combination = new ArrayList<>(choice);
		Random rnd = new Random();
		for (int i = 0; i < choice; ++i) {
			int randamId = 0;
			do {
				randamId = rnd.nextInt(allBingoTargets.size()) + 1;
			} while (combination.contains(randamId));

			for (BingoTarget bingoTarget : allBingoTargets) {
				if (bingoTarget.id == randamId) {
					choiceBingoTargets.add(bingoTarget);
					break;
				}
			}
		}

		return choiceBingoTargets;
	}

	private static ArrayList<BingoTarget> getAllBingoTargets() {
		var allBingoTargets = new ArrayList<BingoTarget>();
		try {
			try (
					var con = DriverManager.getConnection(DB_INFO, DB_USER, DB_PASS);
					var ps = con.prepareStatement(BINGO_TARGET_SQL);
					var result = ps.executeQuery();) {
				while (result.next()) {
					allBingoTargets.add(new BingoTarget(result.getInt("id"), result.getString("target_name")));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return allBingoTargets;
	}

	private static void printBingo(ArrayList<ArrayList<BingoTarget>> bingoTargetsList) {
		for (var bingoTargets : bingoTargetsList) {
			for (int i = 0; i < 5; i++) {
				System.out.print(bingoTargets.get(i).targetName + "\t");
			}
			System.out.println();
			for (int i = 5; i < 10; i++) {
				System.out.print(bingoTargets.get(i).targetName + "\t");
			}
			System.out.println();
			for (int i = 10; i < 12; i++) {
				System.out.print(bingoTargets.get(i).targetName + "\t");
			}
			System.out.print("　\t");
			for (int i = 12; i < 14; i++) {
				System.out.print(bingoTargets.get(i).targetName + "\t");
			}
			System.out.println();
			for (int i = 14; i < 19; i++) {
				System.out.print(bingoTargets.get(i).targetName + "\t");
			}
			System.out.println();
			for (int i = 19; i < 24; i++) {
				System.out.print(bingoTargets.get(i).targetName + "\t");
			}
			System.out.println();
			System.out.println();
		}
	}

	private static void outputBingo(ArrayList<ArrayList<BingoTarget>> bingoTargetsList) {
		File file = new File(BINGO_OUTPUT_PATH);
		try (
				PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), "windows-31j")))) {
			for (var bingoTargets : bingoTargetsList) {
				for (int i = 0; i < 5; i++) {
					writer.print(bingoTargets.get(i).targetName + "\t");
				}
				writer.println();
				for (int i = 5; i < 10; i++) {
					writer.print(bingoTargets.get(i).targetName + "\t");
				}
				writer.println();
				for (int i = 10; i < 12; i++) {
					writer.print(bingoTargets.get(i).targetName + "\t");
				}
				writer.print("　\t");
				for (int i = 12; i < 14; i++) {
					writer.print(bingoTargets.get(i).targetName + "\t");
				}
				writer.println();
				for (int i = 14; i < 19; i++) {
					writer.print(bingoTargets.get(i).targetName + "\t");
				}
				writer.println();
				for (int i = 19; i < 24; i++) {
					writer.print(bingoTargets.get(i).targetName + "\t");
				}
				writer.println();
				writer.println();
			}
		} catch (IOException e2) {
			e2.printStackTrace();
		}
	}
}
