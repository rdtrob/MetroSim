import java.util.ArrayList;
import java.util.List;

public class Station implements Node {
    private String name;
    private List<Edge> lines;

    public Station(String name) {
        this.name = name;
        this.lines = new ArrayList<Edge>();
    }

    public Station(Node copy) {
        this.name = copy.getName();
        for (Edge i : copy.getLines())
            this.addLine(new Line(i));
    }

    public void addLine(Edge line) {
        this.lines.add(line);
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Edge> getLines() {
        return lines;
    }

    public boolean equals(Object station) {
        if (this == station)
            return true;
        if (station == null)
            return false;
        if (getClass() != station.getClass())
            return false;
        Station other = (Station) station;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        return true;
    }
}