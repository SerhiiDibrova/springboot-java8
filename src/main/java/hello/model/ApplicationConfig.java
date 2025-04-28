package hello.model;

public class ApplicationConfig {
    private String settingOne;
    private int settingTwo;
    private boolean settingThree;

    public ApplicationConfig(String settingOne, int settingTwo, boolean settingThree) {
        this.settingOne = settingOne;
        this.settingTwo = settingTwo;
        this.settingThree = settingThree;
        validate();
    }

    public String getSettingOne() {
        return settingOne;
    }

    public void setSettingOne(String settingOne) {
        this.settingOne = settingOne;
    }

    public int getSettingTwo() {
        return settingTwo;
    }

    public void setSettingTwo(int settingTwo) {
        this.settingTwo = settingTwo;
    }

    public boolean isSettingThree() {
        return settingThree;
    }

    public void setSettingThree(boolean settingThree) {
        this.settingThree = settingThree;
    }

    private void validate() {
        if (settingOne == null || settingOne.isEmpty()) {
            throw new IllegalArgumentException("settingOne must not be null or empty");
        }
        if (settingTwo < 0) {
            throw new IllegalArgumentException("settingTwo must be non-negative");
        }
        if (!settingThree) {
            throw new IllegalArgumentException("settingThree must be true");
        }
    }
}