package stageA11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Bulk {
	int height, weight;
	int rank;

	Bulk() {
	}

	Bulk(int height, int weight, int rank) {
		this.height = height;
		this.weight = weight;
		this.rank = rank;
	}
}

public class Problem7568 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		Bulk[] people = new Bulk[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			people[i] = new Bulk(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), 1);
		}
		br.close();
		for (int i = 0; i < N - 1; i++) {
			for (int j = i + 1; j < N; j++) {
				if (people[i].height < people[j].height && people[i].weight < people[j].weight) {
					if (people[i].rank != N)
						people[i].rank++;
				} else if (people[i].height > people[j].height && people[i].weight > people[j].weight) {
					if (people[j].rank != N)
						people[j].rank++;
				}
			}
		}

		for (int i = 0; i < N; i++)
			bw.write(people[i].rank + " ");
		bw.flush();
		bw.close();

	}

}
