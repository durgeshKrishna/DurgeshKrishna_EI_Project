import java.util.ArrayList;
import java.util.List;
interface Observer {
    void update(String news);
}
class Subscriber implements Observer {
    private String name;

    public Subscriber(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}
interface Subject {
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObservers();
}
class NewsAgency implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private String latestNews;

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(latestNews);
        }
    }

    public void setLatestNews(String news) {
        this.latestNews = news;
        notifyObservers();
    }
}
public class ObserverPattern {
    public static void main(String[] args) {
        NewsAgency agency = new NewsAgency();

        Observer sub1 = new Subscriber("Alice");
        Observer sub2 = new Subscriber("Bob");
        Observer sub3 = new Subscriber("Charlie");

        agency.addObserver(sub1);
        agency.addObserver(sub2);
        agency.addObserver(sub3);

        agency.setLatestNews("Breaking News: Observer Pattern implemented!");
        agency.setLatestNews("Weather Update: Sunny day ahead!");
    }
}
