/**
 * Created by robert on 11/28/14.
 */
public class Parser
{
    public OutputDevice printer;
    public Parser()
    {
        printer=new OutputDevice();
    }
    public void simulate(Route connection)
    {
        printer.printString("\nStarting simulation \n\n");
        Edge j=new Line();
        j=connection.getLines().getFirst();
        for (Edge i:connection.getLines())
        {
            if(i.getType().equals(j.getType()))
            {
                printer.printString("Departure from station "+i.getSource().getName()+" via "+i.getType()+"\n");
                printer.printString("Travels "+i.getWeight(1)/i.getWeight(0)+" seconds with an average speed of "+i.getWeight(0)+" km/h \n");
                if(i.equals(connection.getLines().getLast()))
                {
                    printer.printString("Arrival at station "+i.getDestination().getName()+"\n");
                }
            }
            else
            {
                printer.printString("Changed "+j.getType()+" with "+i.getType() + "\n");
                printer.printString("Departure from station "+i.getSource().getName()+" via "+i.getType()+"\n");
                printer.printString("Travels "+i.getWeight(1)/i.getWeight(0)+" seconds with an average speed of "+i.getWeight(0)+" km/h \n\n");
                if(i.equals(connection.getLines().getLast()))
                {
                    printer.printString("Arrival at station "+i.getDestination().getName()+"\n");
                }
            }
            j=i;
        }
    }
}
