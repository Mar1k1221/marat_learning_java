package HomeWork4;

import java.util.ArrayList;

public class DayTwoPartFour {
    public static void main(String[] args) {
        ShortVideo shortVideo1 = new ShortVideo("Video-1",30,true,76767);
        ShortVideo shortVideo2 = new ShortVideo("Video-2",60,false,13909);
        ShortVideo shortVideo3 = new ShortVideo("Video-3",22,true,90987);

        ManagerChannel managerChannel = new ManagerChannel();
        managerChannel.uploadVideo(shortVideo1);
        managerChannel.uploadVideo(shortVideo2);
        managerChannel.uploadVideo(shortVideo3);

        managerChannel.printVideos();
        managerChannel.addViewsToVideo("Video-2",30000);


    }
}
class ShortVideo{
    private String title;
    private int durationSeconds;
    private boolean hasVoiceOver;
    private int views;

    public ShortVideo(String title, int durationSeconds, boolean hasVoiceOver, int views) {
        setTitle(title);
        setDurationSeconds(durationSeconds);
        setHasVoiceOver(hasVoiceOver);
        setViews(views);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
       if (title != null && !title.trim().isEmpty()){
           this.title = title;
       } else {
           System.out.println("Название не может быть пустым.");
       }
    }

    public int getDurationSeconds() {
        return durationSeconds;
    }

    public void setDurationSeconds(int durationSeconds) {
        if (durationSeconds > 0 && durationSeconds <= 60){
            this.durationSeconds = durationSeconds;
        } else {
            System.out.println("Указано некорректное время видео.");
        }
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        if (views >= 0){
            this.views = views;
        }
    }

    public boolean isHasVoiceOver() {
        return hasVoiceOver;
    }

    public void setHasVoiceOver(boolean hasVoiceOver) {
        this.hasVoiceOver = hasVoiceOver;
    }
}
class ManagerChannel{
    private ArrayList<ShortVideo> arrayList = new ArrayList<>();

    public void uploadVideo(ShortVideo shortVideo){
        arrayList.add(shortVideo);

    }
    public void printVideos(){
        for (ShortVideo s: arrayList){
            if (!s.isHasVoiceOver()){
                System.out.println("Видео без голоса найдено, его название: " + s.getTitle());
            }
        }


    }
    public void addViewsToVideo(String title, int views){
        for (ShortVideo s:arrayList){
            if (s.getTitle().equals(title)){
                s.setViews(s.getViews() + views);
                System.out.println("Совпадение найдено. Итого количество просмотров: " + s.getViews());
            }
        }
    }
}
