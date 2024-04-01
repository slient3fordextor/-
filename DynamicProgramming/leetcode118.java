package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class leetcode118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == i || j == 0) rows.add(1);
                else rows.add(list.get(i-1).get(j) + list.get(i-1).get(j-1));
            }
            list.add(rows);
        }
        return list;
    }
}
