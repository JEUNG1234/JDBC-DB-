import java.util.List;

public class AlarmService {
    private AlarmDAO alarmDAO;

    public AlarmService(AlarmDAO alarmDAO) {
        this.alarmDAO = alarmDAO;
    }

    // 알람 추가
    public boolean registerAlarm(Alarm alarm) {
        System.out.println("[Service] 알람 등록 시도: " + alarm.getTime());
        return alarmDAO.addAlarm(alarm);
    }

    // 알람 삭제
    public boolean removeAlarm(String id) {
        System.out.println("[Service] 알람 삭제 시도: ID " + id);
        return alarmDAO.deleteAlarm(id);
    }

    // 알람 수정
    public boolean modifyAlarm(Alarm alarm) {
        System.out.println("[Service] 알람 수정 시도: ID " + alarm.getId());
        return alarmDAO.updateAlarm(alarm);
    }

    // 알람 검색 (ID)
    public Alarm findAlarmById(String id) {
        System.out.println("[Service] ID로 알람 검색 시도: " + id);
        return alarmDAO.getAlarmById(id);
    }

    // 알람 검색 (시간)
    public List<Alarm> findAlarmsByTime(String time) {
        System.out.println("[Service] 시간으로 알람 검색 시도: " + time);
        return alarmDAO.getAlarmsByTime(time);
    }

    // 전체 알람 조회
    public List<Alarm> getAllAlarms() {
        System.out.println("[Service] 전체 알람 조회 시도.");
        return alarmDAO.getAllAlarms();
    }
}