public class AlarmRun {
	public static void main(String[] args) {
		// 객체 생성 및 연결
		AlarmDAO alarmDAO = new AlarmDAO();
		AlarmService alarmService = new AlarmService(alarmDAO);
		AlarmController alarmController = new AlarmController(alarmService);
		AlarmMenu alarmMenu = new AlarmMenu(alarmController);

		// 프로그램 실행
		alarmMenu.mainMenu();
	}
}