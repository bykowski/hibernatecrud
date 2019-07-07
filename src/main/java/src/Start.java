package src;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Start {

    public static void main(String[] args) {
        DrugDao drugDao = new DrugDao();
//
//        Drug drug = new Drug();
//        drug.setName("Kawa");
//        drug.setPrice(new BigDecimal(25));
//        drug.setProdYear(LocalDate.of(1986, 04, 30));
//        drug.setDrugType(DrugType.LEGAL);
//        drugDao.saveDrug(drug);
//
//        System.out.println(drugDao.readDrug(1L));
//        drugDao.deleteDrug(1L);
//
//        Drug newDrug = new Drug();
//        newDrug.setId(2L);
//        newDrug.setName("MDMA");
//        newDrug.setPrice(new BigDecimal(28));
//        newDrug.setProdYear(LocalDate.of(1986, 04, 30));
//        newDrug.setDrugType(DrugType.SOFT);
//        drugDao.updateDrug(newDrug);

        List<Drug> drugsByPower = drugDao.getDrugsByPower(DrugType.SOFT);
        drugsByPower.forEach(System.out::println);

    }
}
