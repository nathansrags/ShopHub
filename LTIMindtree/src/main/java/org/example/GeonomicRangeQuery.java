package org.example;

import java.util.*;

//Find the minimal nucleotide from a range of sequence DNA.
public class GeonomicRangeQuery {
    public static void main(String[] args) {
        GeonomicRangeQuery grq = new GeonomicRangeQuery();
        final String S = "CAGCCTA";
        grq.solution(S, new int[]{2, 5, 6}, new int[]{4, 5, 6});
    }

    private int[] solution(String s, int[] p, int[] q) {
        int[] result = new int[s.length()];
        List<Integer> resultList = new ArrayList<>();
        Map<Character, Integer> impactMap = new HashMap<>();
        impactMap.put('A', 1);
        impactMap.put('C', 2);
        impactMap.put('G', 3);
        impactMap.put('T', 4);
        System.out.println(impactMap);
        char cd = 'G';
        System.out.println(impactMap.get(cd));
        s = s.trim();
        if (!s.isEmpty()) {
            for (int i = 0; i < p.length; i++) {
                int start = p[i];
                int end = q[i] + 1;
                String conceited = s.substring(start, end);
                int[] groups = new int[s.length()];
                System.out.println(conceited);
                for (int j = 0; j < conceited.length(); j++) {
                    char c = conceited.toCharArray()[j];
                    groups[j] = impactMap.get(c);
                }
                OptionalInt minFactor = Arrays.stream(groups).sorted().filter(e -> e > 0).findFirst();
                minFactor.ifPresent(resultList::add);
            }
            System.out.println(resultList);
        }

        return result;
    }
}
