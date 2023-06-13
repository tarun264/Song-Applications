public class Songs {
    private String title;
    private double duration;

    public Songs() {
    }

    public Songs(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }
    // so when we call any method using object eg A a = new A a and print a it we will get the address of the object
    //but we want to display what that method is reffering to so will will use toString function

    @Override
    public String toString() {
        return "Songs{" +
                "title='" + title + '\'' +
                ", duration=" + duration +
                '}';
    }
}
