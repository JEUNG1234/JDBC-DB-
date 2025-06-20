import java.util.List;
import java.util.Scanner;

public class AlarmMenu {
	private Scanner sc = new Scanner(System.in);
	private AlarmController alarmController;

	public AlarmMenu(AlarmController alarmController) {
		this.alarmController = alarmController;
	}

	public void mainMenu() {
		while (true) {
			System.out.println("\n--- 간단 알람 관리 프로그램 ---");
			System.out.println("1. 알람 추가");
			System.out.println("2. 알람 수정");
			System.out.println("3. 알람 삭제");
			System.out.println("4. 알람 검색 (ID)");
			System.out.println("5. 알람 검색 (시간)");
			System.out.println("6. 전체 알람 목록");
			System.out.println("0. 프로그램 종료");
			System.out.print("선택: ");
			int choice = sc.nextInt();
			sc.nextLine(); // 버퍼 비우기

			switch (choice) {
				case 1: addAlarmMenu(); break;
				case 2: updateAlarmMenu(); break;
				case 3: deleteAlarmMenu(); break;
				case 4: searchAlarmByIdMenu(); break;
				case 5: searchAlarmsByTimeMenu(); break;
				case 6: displayAllAlarms(); break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					return;
				default: System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
			}
		}
	}

	// 알람 추가 메뉴
	private void addAlarmMenu() {
		System.out.print("알람 ID (예: A001): ");
		String id = sc.nextLine();
		System.out.print("알람 시간 (HH:MM): ");
		String time = sc.nextLine();
		System.out.print("알람 메시지: ");
		String message = sc.nextLine();

		String result = alarmController.addAlarm(id, time, message);
		System.out.println(result.equals("SUCCESS") ? "알람 추가 성공!" : "알람 추가 실패: " + result);
	}

	// 알람 수정 메뉴
	private void updateAlarmMenu() {
		System.out.print("수정할 알람 ID: ");
		String id = sc.nextLine();
		Alarm existingAlarm = alarmController.searchAlarmById(id);
		if (existingAlarm == null) {
			System.out.println("해당 ID의 알람을 찾을 수 없습니다.");
			return;
		}

		System.out.println("현재 알람: " + existingAlarm);
		System.out.print("새 알람 시간 (HH:MM, Enter 시 기존 유지): ");
		String newTime = sc.nextLine();
		if (newTime.isEmpty()) newTime = existingAlarm.getTime();

		System.out.print("새 알람 메시지 (Enter 시 기존 유지): ");
		String newMessage = sc.nextLine();
		if (newMessage.isEmpty()) newMessage = existingAlarm.getMessage();

		String result = alarmController.updateAlarm(id, newTime, newMessage);
		System.out.println(result.equals("SUCCESS") ? "알람 수정 성공!" : "알람 수정 실패: " + result);
	}

	// 알람 삭제 메뉴
	private void deleteAlarmMenu() {
		System.out.print("삭제할 알람 ID: ");
		String id = sc.nextLine();
		String result = alarmController.deleteAlarm(id);
		System.out.println(result.equals("SUCCESS") ? "알람 삭제 성공!" : "알람 삭제 실패: " + result);
	}

	// ID로 알람 검색 메뉴
	private void searchAlarmByIdMenu() {
		System.out.print("검색할 알람 ID: ");
		String id = sc.nextLine();
		Alarm alarm = alarmController.searchAlarmById(id);
		if (alarm != null) {
			System.out.println("검색 결과: " + alarm);
		} else {
			System.out.println("해당 ID의 알람을 찾을 수 없습니다.");
		}
	}

	// 시간으로 알람 검색 메뉴
	private void searchAlarmsByTimeMenu() {
		System.out.print("검색할 알람 시간 (HH:MM): ");
		String time = sc.nextLine();
		List<Alarm> alarms = alarmController.searchAlarmsByTime(time);
		if (!alarms.isEmpty()) {
			System.out.println("검색 결과:");
			alarms.forEach(System.out::println);
		} else {
			System.out.println("해당 시간에 설정된 알람이 없습니다.");
		}
	}

	// 전체 알람 목록 출력
	private void displayAllAlarms() {
		System.out.println("\n--- 전체 알람 목록 ---");
		List<Alarm> allAlarms = alarmController.getAllAlarms();
		if (!allAlarms.isEmpty()) {
			allAlarms.forEach(System.out::println);
		} else {
			System.out.println("등록된 알람이 없습니다.");
		}
	}
}