import java.util.List;

/**
 * Created by robert on 11/24/14.
 */

public interface Node {
    public String getName();

    public void setName(String name);

    public List<Edge> getLines();

    public void addLine(Edge line);
}
