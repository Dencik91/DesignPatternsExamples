package student.examples;

import com.github.pjfanning.xlsx.StreamingReader;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Listeners (TestListener.class)
public class TestCalculateMedium {
    @BeforeClass
    public void setup() {}

    @DataProvider(name = "provideList")
    public Iterator<List<Integer>> provideListInt() {
        List<List<Integer>> results = new ArrayList<>();
        try (
                InputStream is = Files.newInputStream(new File(
                        "C:\\Users\\denisa\\IdeaProjects\\Domashka\\src\\test\\resources\\data.xlsx").toPath());
                Workbook workbook = StreamingReader.builder()
                        .rowCacheSize(100)
                        .bufferSize(4096)
                        .open(is)
        ){
            for (Sheet sheet : workbook){
                for (Row r : sheet) {
                    List<Integer> line = new ArrayList<>();
                    for (Cell c : r) {
                        line.add(Integer.valueOf((int) c.getNumericCellValue()));
                        System.out.println(r);
                    }
                    results.add(line);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return results.iterator();
    }


    @Test(dataProvider = "provideList")
    public void calculateMediumTest(List<Integer> list) {
        System.out.println("New Test");
        System.out.println(list);
        Calculator app = new Calculator();
        int result = list.get(0);
        list.remove(0);
        int mediumFunction = app.calculateMedium(list);
        Assert.assertEquals(mediumFunction, result);

    }

    @AfterClass
    public void createReports(ITestContext context) {
        context.getSuite().getResults().forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }
}
