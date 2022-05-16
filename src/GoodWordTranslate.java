import java.util.Scanner;

public class GoodWordTranslate {
    private static final String ADMIN_ID = "admin"; //유튜브 계정 아이디
    private static final String ADMIN_PW = "0000"; //유튜브 계정 비밀번호
    private static final String[] badWords = {"킹", "시발", "꺼져", "미친"}; //금칙어 리스트
    private static final String[] goodWords = {"열", "사랑", "행운", "희망"}; //순화어 리스트, 금칙어와 1:1 매핑이 안되는 케이스 처리필요
    public static void main(String[] args) {
        String id, pw = "";
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("[시스템] 유튜브 계정의 아이디를 입력하세요 {Ex - admin} : ");
            id = sc.nextLine();
            System.out.print("[시스템] 유튜브 계정의 비밀번호를 입력하세요{Ex - 0000} : ");
            pw = sc.nextLine();

            if (ADMIN_ID.compareTo(id) != 0 || ADMIN_PW.compareTo(pw) != 0)
                System.out.println("[경고] 유튜브 계정의 아이디 및 비밀번호를 다시 확인해 주세요.");
            else
                break;
        }

        System.out.printf("[안내] 안녕하세요 %s 님.\n", id);
        System.out.println("[안내] 유튜브 영상의 자막을 생성해 주세요.");
        String inputString = sc.nextLine();
        System.out.println("========================================");
        System.out.println("[알림] 프로그램 금칙어 리스트입니다. 쓰면 나쁜 사람");
        System.out.println(String.join(", ", badWords)); //등록된 금칙어 리스트 출력
        System.out.println("========================================");

        System.out.println("[알림] 자막 순화 프로그램 결과입니다.");
        for (int i = 0; i<badWords.length; i++) {
            inputString = inputString.replaceAll(badWords[i],goodWords[i]); //금칙어를 순화어로 변경하기
        }
        System.out.printf(">>> %s\n", inputString);
        System.out.println("[안내] 프로그램을 종료합니다.");
    }
}