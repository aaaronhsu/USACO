/*
ID: pufflew1
LANG: JAVA
TASK: friday
*/

import java.util.*;
import java.io.*;

public class friday {
	static StreamTokenizer in;
	
	static int nextInt() throws Exception{
		in.nextToken();
		return (int) in.nval;
	}

	public static void main(String[] args) throws Exception {
		in = new StreamTokenizer(new BufferedReader(new FileReader("friday.in")));
		PrintWriter out = new PrintWriter(new File("friday.out"));

		int[] days = new int[7];

		int n = nextInt();

		int type = 0;

		int year = 1900;

		for (int yr = 0; yr < n; yr++) {
			if (year % 4 == 0 && year % 100 != 0) {
				for (int mo = 0; mo < 12; mo++) {
					if (mo == 1) {
						for (int day = 0; day < 29; day++) {
							if (day == 12) days[type]++;
							type = changeDate(type);
						}
					}
					else if (mo % 2 == 0) {
						if (mo < 7) {
							for (int day = 0; day < 31; day++) {
								if (day == 12) {
									days[type]++;
									System.out.println(type);
								}
								type = changeDate(type);
							}
						}
						else {
							for (int day = 0; day < 30; day++) {
								if (day == 12) {
									days[type]++;
									System.out.println(type);
								}
								type = changeDate(type);
							}
						}
						
					}
					else {
						if (mo < 7) {
							for (int day = 0; day < 30; day++) {
								if (day == 12) {
									days[type]++;
									System.out.println(type);
								}
								type = changeDate(type);
							}
						}
						else {
							for (int day = 0; day < 31; day++) {
								if (day == 12) {
									days[type]++;
									System.out.println(type);
								}
								type = changeDate(type);
							}
						}
					}
				}
			}
			else if (year % 400 == 0) {
				for (int mo = 0; mo < 12; mo++) {
					if (mo == 1) {
						for (int day = 0; day < 29; day++) {
							if (day == 12) days[type]++;
							type = changeDate(type);
						}
					}
					else if (mo % 2 == 0) {
						if (mo < 7) {
							for (int day = 0; day < 31; day++) {
								if (day == 12) {
									days[type]++;
									System.out.println(type);
								}
								type = changeDate(type);
							}
						}
						else {
							for (int day = 0; day < 30; day++) {
								if (day == 12) {
									days[type]++;
									System.out.println(type);
								}
								type = changeDate(type);
							}
						}
						
					}
					else {
						if (mo < 7) {
							for (int day = 0; day < 30; day++) {
								if (day == 12) {
									days[type]++;
									System.out.println(type);
								}
								type = changeDate(type);
							}
						}
						else {
							for (int day = 0; day < 31; day++) {
								if (day == 12) {
									days[type]++;
									System.out.println(type);
								}
								type = changeDate(type);
							}
						}
					}
				}
			}
			else {
				// not leap year
				for (int mo = 0; mo < 12; mo++) {
					if (mo == 1) {
						for (int day = 0; day < 28; day++) {
							if (day == 12) {
								days[type]++;
								System.out.println(type);
							}
							type = changeDate(type);
						}
					}
					
					else if (mo % 2 == 0) {
						if (mo < 7) {
							for (int day = 0; day < 31; day++) {
								if (day == 12) {
									days[type]++;
									System.out.println(type);
								}
								type = changeDate(type);
							}
						}
						else {
							for (int day = 0; day < 30; day++) {
								if (day == 12) {
									days[type]++;
									System.out.println(type);
								}
								type = changeDate(type);
							}
						}
						
					}
					else {
						if (mo < 7) {
							for (int day = 0; day < 30; day++) {
								if (day == 12) {
									days[type]++;
									System.out.println(type);
								}
								type = changeDate(type);
							}
						}
						else {
							for (int day = 0; day < 31; day++) {
								if (day == 12) {
									days[type]++;
									System.out.println(type);
								}
								type = changeDate(type);
							}
						}
					}
				}
			}

			year++;
		}

		out.print(days[5] + " ");
		out.print(days[6] + " ");
		for (int i = 0; i < 4; i++) {
			out.print(days[i] + " ");
		}
		out.println(days[4]);
		out.close();
	}

	static int changeDate(int n) {
		return (n + 1) % 7;
	}
}