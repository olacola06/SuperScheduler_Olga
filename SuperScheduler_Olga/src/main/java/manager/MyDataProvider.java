package manager;

import models.Direction;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyDataProvider {

    @DataProvider
    public Iterator<Object[]> directionsSetting() throws IOException {
        List <Object[]> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader ("src/test/resources/directionsSet.csv"));
        String line = reader.readLine();
        while(line!=null) {
            String[] object = line.split(";");
            list.add(new Object[]{Direction.builder().from(object[0]).to(object[1]).numberKm(object[2])
                    .cost(object[3]).currency(object[4]).build()});
            line = reader.readLine();
        }
        return list.iterator();
    }

}
