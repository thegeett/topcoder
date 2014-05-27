package practiceroom.tournament.sub1_25.sub3.pro500;

import java.util.ArrayList;
import java.util.List;

public class ArgParser {

	public static void main(String[] args) {
		String param0 = "{\\\\, \\,\\, }";
		String[] result = parse(param0);
		System.out.println(result.length);
		for (String r : result) {
			System.out.println(r);
		}
	}

	public static String[] parse(String param0) {
		// boolean validareString = validareString(param0);
		char[] p = param0.toCharArray();
		int count = 1;
		List<String> list = new ArrayList<String>();
		String pre = "";
		boolean escapFlg = false, mainloopFlg = true;
		String temp = "";
		if (p[0] != '{' || p[p.length - 1] != '}') {
			list.add("INVALID");
		} else {
			while (count <= param0.length() - 2 && mainloopFlg) {
				pre = "";
				boolean flg = true;
				while (flg && count <= param0.length() - 2) {
					if (pre.equals("")) {
						pre = p[count] + "";
						temp += pre;
						escapFlg = false;
					} else if (pre.equals("") && p[count] == '}') {
						pre = "";
						temp += pre;
						flg = false;
						escapFlg = false;
					} else if (pre.equals("\\") && (p[count] == ',' || p[count] == '{' || p[count] == '}')) {
						if (temp != "") {
							temp = temp.substring(0, temp.length() - 1);
						}
						pre = p[count] + "";
						temp += pre;
						escapFlg = true;
					} else if (pre.equals(",") && p[count] == ' ') {
						if (temp == "") {
							temp = " ";
						} else if (escapFlg) {
							pre = " ";
						} else {
							temp = temp.substring(0, temp.length() - 1);
							pre = "";
							flg = false;
						}
						temp += pre;
						escapFlg = false;
					} else if (pre.equals(",") && p[count] != ' ' && !escapFlg) {
						mainloopFlg = false;
						temp = "INVALID";
						break;
					} else if ((pre.equals("{") || pre.equals("}")) && !escapFlg) {
						mainloopFlg = false;
						temp = "INVALID";
						break;
					} else {
						pre = p[count] + "";
						temp += pre;
						escapFlg = false;
					}

					count++;
				}
				if(temp.equals("INVALID")){
					list.clear();
					list.add(temp);
				}else{
					list.add(temp);
				}
				temp = "";

				// count++;
			}
			if (p[count] == '}' && pre == "") {
				list.add("");
			}
		}

		System.out.println(list);
		String[] array = new String[list.size()];
		list.toArray(array); // fill the array
		return array;
	}

	private static boolean validareString(String param0) {

		if (param0.charAt(0) != '{' || param0.charAt(param0.length() - 1) != '}') {
			return false;
		} else if (param0.indexOf('{') == 1) {

		}

		return false;
	}

}
