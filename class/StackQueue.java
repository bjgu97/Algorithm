import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueue {
	static int num = 1;
	public static void main(String[] args) {
		//stackTest();
		//queueTest();
		//method3();
		method4();
	}
	
	static void stackTest() {
		int a = 10;
		Stack<Integer> stack = new Stack<>();
		
		//데이터 추가
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		
		//데이터 간보기
		int top = stack.peek();
		System.out.println(top);
		top = stack.pop();
		System.out.println(top);
		System.out.println("현재 스택의 상태: " + stack + ", 크기: " + stack.size() + ", 비어있니? " + stack.isEmpty());
		
		//스택 전체적으로 소모할때
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}
	
	static void queueTest() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		
		//데이터 확인
		int front = queue.peek();
		System.out.println("맨 앞에는: " + front); //간보기
		front = queue.poll(); //데이터 가져오기
		
		//상태확인
		System.out.println("현재 큐의 상태: " + queue + ", 크기: " + queue.size() + ", 비어있니? " + queue.isEmpty());
		
		while(!queue.isEmpty()) {
			System.out.println(queue.poll());
		}
	}
	
	//디버깅 연습
	static void method3() {
		for(int i = 0; i < 100; i++) {
			System.out.println(i);
		}
	}
	
	static void method4() {
		int a = 10;
		int b = 20;
		if(a == 10 && b == 20 && 1 == 2) {
			System.out.println("통과!");
		}
	}

}
