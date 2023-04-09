import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import javax.xml.transform.Source;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class billTest {

    @ParameterizedTest
    @CsvFileSource(resources = "/决策表分析.csv")
    public void calculatecostOver1800Minutes(String d1, String d2, float cost) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime t1 = LocalDateTime.parse(d1,df);
        LocalDateTime t2 = LocalDateTime.parse(d2,df);
        Bill bill = new Bill();
        assertEquals(bill.calculatecost(t1,t2), cost,0.01);
    }

}
