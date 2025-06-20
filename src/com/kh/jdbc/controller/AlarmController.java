import java.util.List;

public class AlarmController {
	private AlarmService alarmService;

	public AlarmController(AlarmService alarmService) {
		this.alarmService = alarmService;
	}

	// 알람 추가 요청
	public String addAlarm(String id, String time, String message) {
		Alarm newAlarm = new Alarm(id, time, message);
		if (alarmService.registerAlarm(newAlarm)) {
			return "SUCCESS";
		} else {
			return "FAIL: ID 중복 또는 등록 실패";
		}
	}

	// 알람 삭제 요청
	public String deleteAlarm(String id) {
		if (alarmService.removeAlarm(id)) {
			return "SUCCESS";
		} else {
			return "FAIL: 해당 ID의 알람 없음";
		}
	}

	// 알람 수정 요청
	public String updateAlarm(String id, String time, String message) {
		Alarm updatedAlarm = new Alarm(id, time, message);
		if (alarmService.modifyAlarm(updatedAlarm)) {
			return "SUCCESS";
		} else {
			return "FAIL: 해당 ID의 알람 없음";
		}
	}

	// 알람 검색 요청 (ID)
	public Alarm searchAlarmById(String id) {
		return alarmService.findAlarmById(id);
	}

	// 알람 검색 요청 (시간)
	public List<Alarm> searchAlarmsByTime(String time) {
		return alarmService.findAlarmsByTime(time);
	}

	// 전체 알람 목록 조회 요청
	public List<Alarm> getAllAlarms() {
		return alarmService.getAllAlarms();
	}
}