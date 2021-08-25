//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//public class BJ_5551_쇼핑몰 {
//	
//	static class Person {
//		int id;
//		int w;
//		
//		Person(int id, int w) {
//			this.id = id;
//			this.w = w;
//		}
//
//		@Override
//		public String toString() {
//			return "Person [id=" + id + ", w=" + w + "]";
//		}
//	}
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		int N = Integer.parseInt(st.nextToken());
//		int k = Integer.parseInt(st.nextToken());
//		
//		Queue<Person> PersonQueue = new LinkedList<>();
//		
//		for(int n =0; n < N; n++) {
//			st = new StringTokenizer(br.readLine());
//			Person p = new Person(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//			System.out.println(p);
//			PersonQueue.add(p); // 큐에 고객 담기. 
//		}
//		
//		Queue<>
//		
//		for(int i = 0; i < k; i++) {
//			Person p = PersonQueue.poll();
//		}
//		
//		
//	}
//}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    private static int N, K, outNo;
    private static long ans;
    private static Queue<Customer> customers;
    private static PriorityQueue<Customer> out;
    private static Stack<Integer> remainPosId;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        customers = new LinkedList<>();
        out = new PriorityQueue<>();
        remainPosId = new Stack<>();

        for (int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            customers.offer(new Customer(id, w));
        }

        run();
        System.out.println(ans);
    }

    public static void run() {
        int time = 0;
        if (N < K) {
            for(int i = 0; i < N; ++i){
                Customer customer = customers.poll();
                customer.posId = i;
                customer.time = customer.w;
                out.offer(customer);
            }
        } else {
            for(int i = 0; i < K; ++i){
                Customer customer = customers.poll();
                customer.posId = i;
                customer.time = customer.w;
                out.offer(customer);
            }
        }
        while(!out.isEmpty()) {
            time = out.peek().time;
            removeCustomer(time); // out
            addCustomer(time); // in
        }
    }

    public static void addCustomer(int time){
        while(!remainPosId.isEmpty()){
            if(customers.isEmpty()) return;
            Customer customer = customers.poll();
            customer.posId = remainPosId.pop();
            customer.time = time + customer.w;
            out.offer(customer);
        }
    }

    public static void removeCustomer(int time){
        while(!out.isEmpty()){
            if(time == out.peek().time){
                Customer customer = out.poll();
                remainPosId.add(customer.posId); // stack 에 남은 pos 추가
                calculate(customer.id);
            } else {
                break;
            }
        }
    }

    public static void calculate(int customerId){
        ans += 1l * customerId * ++outNo;
    }

    static class Customer implements Comparable<Customer> {

        int id;
        int w;
        int posId;
        int time;

        public Customer(int id, int w) {
            this.id = id;
            this.w = w;
        }

        @Override
        public int compareTo(Customer c) {
            if (this.time == c.time) {
                return Integer.compare(c.posId, this.posId);
            }
            return Integer.compare(this.time, c.time);
        }
    
