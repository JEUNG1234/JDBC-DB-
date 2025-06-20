import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AlarmDAO {
	private List<Alarm> alarmDB = new ArrayList<>(); // 알람 데이터 저장소

	// 저장 (추가)
	public boolean addAlarm(Alarm alarm) {
		if (getAlarmById(alarm.getId()) != null) { // ID 중복 체크
			return false;
		}
		return alarmDB.add(alarm);
	}

	// 삭제
	public boolean deleteAlarm(String id) {
		return alarmDB.removeIf(a -> a.getId().equals(id));
	}

	// 수정
	public boolean updateAlarm(Alarm updatedAlarm) {
		for (int i = 0; i < alarmDB.size(); i++) {
			if (alarmDB.get(i).getId().equals(updatedAlarm.getId())) {
				alarmDB.set(i, updatedAlarm);
				return true;
			}
		}
		return false;
	}

	// 검색 (ID)
	public Alarm getAlarmById(String id) {
		return alarmDB.stream()
				.filter(a -> a.getId().equals(id))
				.findFirst()
				.orElse(null);
	}

	// 검색 (시간)
	public List<Alarm> getAlarmsByTime(String time) {
		return alarmDB.stream()
				.filter(a -> a.getTime().equals(time))
				.collect(Collectors.toList());
	}

	// 전체 출력
	public List<Alarm> getAllAlarms() {
		return new ArrayList<>(alarmDB);
	}
}