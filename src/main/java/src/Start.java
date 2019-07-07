package src;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Start {

    public static void main(String[] args) {
        DrugDao drugDao = new DrugDao();

        Drug drug = new Drug();
        drug.setName("MDMA");
        drug.setPrice(new BigDecimal(25));
        drug.setProdYear(LocalDate.of(1986, 04, 30));
        drug.setDrugType(DrugType.SOFT);
        drugDao.saveDrug(drug);

        System.out.println(drugDao.readDrug(1L));

    }
}
