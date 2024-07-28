package sd.sd.session;

import java.util.HashMap;
import java.util.Map;

public class Session {

    Long timeStart;
    Long timeEnd;
    Map<String, Object> data = new HashMap<>();

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    boolean active = true;

    public Session(Long timeStart) {
        this.timeStart = timeStart;
    }

    public Session(Long timeStart, Map<String, Object> data) {
        this.timeStart = timeStart;
        this.data = data;
    }

    public Long getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(Long timeStart) {
        this.timeStart = timeStart;
    }

    public Long getTimeEnd() {
        return timeEnd;
    }

    public void setTimeEnd(Long timeEnd) {
        this.timeEnd = timeEnd;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}
