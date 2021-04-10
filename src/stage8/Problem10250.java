package stage8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Problem10250 {

	public static int hotelCombine(int H, int W, int N) {
		int floor;
		int roomNum;

		if ((N % H) == 0) {
			if ((N / H) == W) {
				floor = H;
				roomNum = W;
			} else {
				floor = H;
				roomNum = (N / H);
			}
		} else {
			floor = N % H;
			roomNum = (N / H) + 1;
		}
		int room = floor * 100 + roomNum;

		return room;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {
			int room = 0;
			st = new StringTokenizer(br.readLine(), " ");
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			room = Problem10250.hotelCombine(H, W, N);

			bw.write(room + "\n");
		}
		br.close();
		bw.flush();
		bw.close();
	}

}
