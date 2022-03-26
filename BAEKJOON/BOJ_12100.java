import java.io.*;
// 백준온라인저지 12100 2048(easy) 문제 풀이 Java
public class BOJ_12100 {
// 상하좌우 이동을 반복문으로 구현하기 위해 사용할 배열
static int[] moveR = {-1, 1, 0, 0};
static int[] moveC = {0, 0, -1, 1};
// 결과를 저장할 변수
static int result = 0;
public static void main(String[] args) throws IOException {
// 입력을 받을 객체
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 보드 크기
int n = Integer.parseInt(br.readLine());
// 보드
int[][] board = new int[n][n];
// 보드판 정보 받아서 초기화
for (int i = 0; i < n; i++) {
String[] info = br.readLine().split(" ");
for (int j = 0; j < n; j++) {
board[i][j] = Integer.parseInt(info[j]);
}
}
// 5번 이하로 움직이는 모든 경우를 판달할 재귀 메서드
recursion(0, 5, board);
// 결과 출력
System.out.println(result);
}
/**
* 이동하는 모든 경우의 수를 체크할 재귀메서드
* @param index : 재귀메서드 진행 횟수
* @param limit : 보드가 움직여야하는 횟수
* @param board : 보드판
*/
static void recursion(int index, int limit, int[][] board) {
// 보드가 5번 움직였을 겨우
if (index == limit) {
// 각각의 경우의 수마다 결과 값을 저장할 임시변수
int tempReulst = 0;
// 보드판의 모든 값을 순회해서 가장 높은 숫자를 결과 임시변수에 저장
for (int i = 0; i < board.length; i++) {
for (int j = 0; j < board.length; j++) {
tempReulst = Math.max(tempReulst, board[i][j]);
}
}
// 임시결과변수와 결과변수를 비교해서 큰 값을 결과변수에 저장 후 종료
result = Math.max(result, tempReulst);
return;
}
// 반복문으로 상하좌우 이동
for (int i = 0; i < 4; i++) {
// 보드 내에서 숫자가 합쳐졌는지 여부를 판단할 배열
boolean[][] sumChk = new boolean[board.length][board.length];
// 각각의 경우의 수마다 보드판을 조작해야 하므로 임시보드판 생성 후 초기화
int[][] tempBoard = new int[board.length][board.length];
for (int q = 0; q < board.length; q++) {
for (int j = 0; j < board.length; j++) {
tempBoard[q][j] = board[q][j];
}
}
// 보드판의 값들을 위로, 왼쪽으로 움직이는 경우
if (i == 0 || i==2) {
// 보드판의 좌측 상단부터 시작
for (int j = 0; j < tempBoard.length; j++) {
for (int k = 0; k < tempBoard[j].length; k++) {
// 정해진 방향으로 보드판의 값들을 움직이기
move(tempBoard, sumChk, i, j, k);
}
}
}
// 보드판의 값들을 아래로, 오른쪽으로 움직이는 경우
else if (i == 1 || i == 3) {
// 보드판의 우측 하단부터 시작
for (int j = tempBoard.length - 1; j >= 0; j--) {
for (int k = tempBoard[j].length; k >= 0; k--) {
// 정해진 방향으로 보드판의 값들을 움직이기
move(tempBoard, sumChk, i, j, k);
}
}
}
// 한번의 이동이 완료된 후 재귀 호출
recursion(index +1, limit, tempBoard);
}
}
/**
* 보드판의 값들을 움직이기 위해 사용하는 메서드
* @param board : 보드판을 표현할 배열
* @param sumChk : 보드판의 값들이 합쳐졌는지 여부를 체크하기 위한 배열
* @param i : 어느 방향으로 움직이는지를 구분하기 위한 변수 (0:상, 1:하, 2:좌, 3:우)
* @param j : 시작 행
* @param k : 시작 열
*/
private static void move(int[][] board, boolean[][] sumChk, int i, int j, int k) {
// 보드판의 값 체크를 시작할 행과 열 받기
int nowRow = j;
int nowCol = k;
// 이동할 위치의 행과 열 계산
int moveRow = nowRow + moveR[i];
int moveCol = nowCol + moveC[i];
// 계산된 위치가 보드판을 벗어나면 종료
if (moveRow >= board.length || moveRow < 0 || moveCol >= board.length || moveCol < 0) {
return;
}
// 이동의 종료 여부를 판단할 변수
boolean end = false;
// 이동 시작
while (!end) {
// 이동할 위치에 값이 0이면
if (board[moveRow][moveCol] == 0) {
// 현재 위치의 값을 이동할 위치의 값으로 저장
board[moveRow][moveCol] = board[nowRow][nowCol];
// 현재 위치의 값을 0으로 변경
board[nowRow][nowCol] = 0;
// 현재 위치의 행과열 값 갱신
nowRow = moveRow;
nowCol = moveCol;
// 다음에 이동할 위치 계산
moveRow = nowRow + moveR[i];
moveCol = nowCol + moveC[i];
// 계산된 위치가 보드판을 벗어나면 이동 종료
if (moveRow >= board.length || moveRow < 0 || moveCol >= board.length || moveCol < 0) {
end = true;
}
}
// 이동할 위치에 값이 현재의 값과 동일하면
else if (board[moveRow][moveCol] == board[nowRow][nowCol]) {
// 이동할 위치의 값이 합쳐진 이력이 없을 경우 블록을 합치고 종료
if (!sumChk[moveRow][moveCol]) {
// 이동할 위치의 값 갱신 (블록 2개가 합쳐지는 것)
board[moveRow][moveCol] = board[moveRow][moveCol] * 2;
// 현재 위치의 값 0으로 변경
board[nowRow][nowCol] = 0;
// 이동할 위치의 값이 합쳐진 적이 있다는 이력 남기기
sumChk[moveRow][moveCol] = true;
}
// 이동할 위치의 값이 합쳐진 이력이 존재하면 아무것도 하지않고 이동 종료
end = true;
}
// 이동할 위치의 값이 현재 위치의 값과 다르다면 이동 종료
else {
end = true;
}
}
}
}

