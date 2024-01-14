package GoogleMap.Models;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Common extends HttpServlet {
	// 画面遷移
	public static void gotoPage(HttpServletRequest request, HttpServletResponse response, String page) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(page);
        rd.forward(request, response);
	}
	
	// 性別の表示
	public static String displaySex(int sex) {
		String sexStr = null;
		
		switch(sex) {
		case 1:
			sexStr = "男性";
			break;
		case 2:
			sexStr = "女性";
			break;
		case 3:
			sexStr = "その他";
			break;
		default:
			break;
		}
		return sexStr;
	}
	
	// 生年月日のフォーマット
	public static String formatBirthday(String year, String month, String date) {
		// 月を「0x」月形式に成形
		if(Integer.parseInt(month) >= 1 && Integer.parseInt(month) <= 9) {
			month = "0" + month;
		}
		// 日を「0x」日形式に成形
		if(Integer.parseInt(date) >= 1 && Integer.parseInt(date) <= 9) {
			date = "0" + date;
		}
		return year + month + date;
	}
	
	// 生年月日の表示
	public static String displayBirthday(String birthday) {
		StringBuilder addYear = new StringBuilder(birthday);
		addYear.insert(4, "年 ");
		StringBuilder addMonth = addYear.insert(8, "月 ");
		
		return addMonth + "日";
	}
	
	// 年齢の表示
	public static String displayAge(int age) {
		String ageStr = null;
		
		switch(age) {
		case 0:
			ageStr = "年齢が選択されていません";
			break;
		case 10:
			ageStr = "10代以下";
			break;
		case 20:
			ageStr = "20代";
			break;
		case 30:
			ageStr = "30代";
			break;
		case 40:
			ageStr = "40代";
			break;
		case 50:
			ageStr = "50代";
			break;
		case 60:
			ageStr = "60代";
			break;
		case 70:
			ageStr = "70代以上";
			break;
		default:
			break;
		}
		return ageStr;
	}
	
	// 年齢の計算
	public static String calculateAge(String birthday) {
		// フォーマッター(yyyyMMdd)
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		// long型を「日」へ変換
		TimeUnit DAY = TimeUnit.DAYS;
		// 一年の日数
		long daysOfYear = 365;
		// 返却する年齢
		int age = 0;
		
		try {
			// 現在の日付
			Date now = new Date();
			// フォーマットされた現在の日付(yyyyMMdd)
			Date nowFormatted = formatter.parse(formatter.format(now));
			// 誕生日の日付をDate型に変換
			Date birthdayFormatted = formatter.parse(birthday);
			
			// 現在の日付 - 誕生日(日数で計算)
			long diff = DAY.convert(nowFormatted.getTime() - birthdayFormatted.getTime(), TimeUnit.MILLISECONDS);
			
			// diff / 一年の日数
			age = (int) ((int)diff/daysOfYear);
			
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return Integer.toString(age);
		
	}
}