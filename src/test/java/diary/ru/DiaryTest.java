package diary.ru;

public class DiaryTest {

    @org.junit.Test
    public void loginDiary() {
        Diary diary = new Diary();
        diary.login();


    }
    @org.junit.Test
    public void registation() throws InterruptedException {
        Diary diary = new Diary();
        diary.registration();
        //проверки нет, вместо psvm.

    }
}