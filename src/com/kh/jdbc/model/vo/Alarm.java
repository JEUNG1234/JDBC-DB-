public class Alarm {
	private String id;        // 알람 고유 ID
	private String time;      // 알람 시간 (HH:MM 형식)
	private String message;   // 알람 메시지

	public Alarm(String id, String time, String message) {
		this.id = id;
		this.time = time;
		this.message = message;
	}

	public String getId() { return id; }
	public String getTime() { return time; }
	public String getMessage() { return message; }

	// 수정 기능을 위해 Setter 추가
	public void setTime(String time) { this.time = time; }
	public void void setMessage(String message) { this.message = message; }

	@Override
	public String toString() {
		return "ID: " + id + ", 시간: " + time + ", 메시지: " + message;
	}
}