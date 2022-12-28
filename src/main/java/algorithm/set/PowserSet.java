package algorithm.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 집합 > 멱집합 멱집합 : 어떤 집합의 모든 부분집합을 원소로 하는 집합
 * 
 * @author devhee
 *
 */
public class PowserSet {
	static String[] setArr = { "a", "b", "c","d" };
	static final int MAX_SIZE = setArr.length;
	static boolean[] isInclude = new boolean[MAX_SIZE];
	static List<Set<String>> setList = new ArrayList<Set<String>>();

	public static void main(String[] args) {

		// step1 재귀로 멱집합 구하기
		powerSetRecursive(setArr, isInclude, 0);
		printSetList();

		// step2 조합으로 멱집합 구하기

	}
	
	/**
	 * 표준 출력
	 */
	private static void printSetList() {
		for (Iterator<Set<String>> iterator = setList.iterator(); iterator.hasNext();) {
			Set<String> set = (Set<String>) iterator.next();
			// 출력 pretty
			System.out.println(set.toString().replaceAll("\\[", "\\{")
					.replaceAll("\\]", "\\}"));
		}
		System.out.printf("부분집합의 개수:%d개", setList.size());
	}
	
	/**
	 * 재귀 방식의 멱함수 구하기
	 * 
	 * @param setArr
	 * @param isInclude
	 * @param idx
	 */
	private static void powerSetRecursive(String[] setArr, boolean[] isInclude, int idx) {

		// 재귀 종료 조건
		if (idx == setArr.length) {
			Set<String> tempSet = new HashSet<String>();
			// 부분집합 추가
			for (int i = 0; i < isInclude.length; i++) {
				if (isInclude[i]) {
					tempSet.add(setArr[i]);
				}
			}
			setList.add(tempSet);
			return;
		}
		
		// 포함하지 않는 경우
		isInclude[idx] = false;
		powerSetRecursive(setArr, isInclude, idx + 1);
		
		// 포함 하는 경우
		isInclude[idx] = true;
		powerSetRecursive(setArr, isInclude, idx + 1);

	}

}
