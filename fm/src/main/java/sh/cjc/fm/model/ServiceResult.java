package sh.cjc.fm.model;

public class ServiceResult<T> {
    private Boolean success;
    private String error;
    private T customType;

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public T getCustomType() {
        return customType;
    }

    public void setCustomType(T customType) {
        this.customType = customType;
    }
}