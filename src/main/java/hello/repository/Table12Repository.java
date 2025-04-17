

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hello.entity.Table12Entity;
import java.util.List;
import java.util.Optional;

@Repository
public interface Table12Repository extends JpaRepository<Table12Entity, Integer> {

    @Query("SELECT t FROM Table12Entity t WHERE t.id = :id")
    Optional<Table12Entity> findById(@Param("id") Integer id);

    @Query("SELECT t FROM Table12Entity t WHERE t.name = :name")
    List<Table12Entity> findByName(@Param("name") String name);

    @Query("SELECT t FROM Table12Entity t WHERE t.description = :description")
    List<Table12Entity> findByDescription(@Param("description") String description);

    @Query("SELECT t FROM Table12Entity t WHERE t.column1 = :column1")
    List<Table12Entity> findByColumn1(@Param("column1") String column1);

    @Query("SELECT t FROM Table12Entity t WHERE t.column2 = :column2")
    List<Table12Entity> findByColumn2(@Param("column2") String column2);

    @Query("SELECT t FROM Table12Entity t WHERE t.column3 = :column3")
    List<Table12Entity> findByColumn3(@Param("column3") String column3);

    @Query("SELECT t FROM Table12Entity t WHERE t.column4 = :column4")
    List<Table12Entity> findByColumn4(@Param("column4") String column4);

    @Query("SELECT t FROM Table12Entity t WHERE t.column5 = :column5")
    List<Table12Entity> findByColumn5(@Param("column5") String column5);

    @Query("SELECT t FROM Table12Entity t WHERE t.column6 = :column6")
    List<Table12Entity> findByColumn6(@Param("column6") String column6);

    @Query("SELECT t FROM Table12Entity t WHERE t.column7 = :column7")
    List<Table12Entity> findByColumn7(@Param("column7") String column7);

    @Query("SELECT t FROM Table12Entity t WHERE t.column8 = :column8")
    List<Table12Entity> findByColumn8(@Param("column8") String column8);

    @Query("SELECT t FROM Table12Entity t WHERE t.column9 = :column9")
    List<Table12Entity findByColumn9(@Param("column9") String column9);

    @Query("SELECT t FROM Table12Entity t WHERE t.column10 = :column10")
    List<Table12Entity> findByColumn10(@Param("column10") String column10);

    @Query("SELECT t FROM Table12Entity t WHERE t.column11 = :column11")
    List<Table12Entity> findByColumn11(@Param("column11") String column11);

    @Query("SELECT t FROM Table12Entity t WHERE t.column12 = :column12")
    List<Table12Entity> findByColumn12(@Param("column12") String column12);

    @Query("SELECT t FROM Table12Entity t WHERE t.column13 = :column13")
    List<Table12Entity> findByColumn13(@Param("column13") String column13);

    @Query("SELECT t FROM Table12Entity t WHERE t.column14 = :column14")
    List<Table12Entity> findByColumn14(@Param("column14") String column14);

    @Query("SELECT t FROM Table12Entity t WHERE t.column15 = :column15")
    List<Table12Entity> findByColumn15(@Param("column15") String column15);

    @Query("SELECT t FROM Table12Entity t WHERE t.column16 = :column16")
    List<Table12Entity> findByColumn16(@Param("column16") String column16);

    @Query("SELECT t FROM Table12Entity t WHERE t.column17 = :column17")
    List<Table12Entity> findByColumn17(@Param("column17") String column17);

    @Query("SELECT t FROM Table12Entity t WHERE t.column18 = :column18")
    List<Table12Entity> findByColumn18(@Param("column18") String column18);

    @Query("SELECT t FROM Table12Entity t WHERE t.column19 = :column19")
    List<Table12Entity> findByColumn19(@Param("column19") String column19);

    @Query("SELECT t FROM Table12Entity t WHERE t.column20 = :column20")
    List<Table12Entity> findByColumn20(@Param("column20") String column20);

    @Query("SELECT t FROM Table12Entity t WHERE t.column21 = :column21")
    List<Table12Entity> findByColumn21(@Param("column21") String column21);

    @Query("SELECT t FROM Table12Entity t WHERE t.column22 = :column22")
    List<Table12Entity> findByColumn22(@Param("column22") String column22);

    @Query("SELECT t FROM Table12Entity t WHERE t.column23 = :column23")
    List<Table12Entity> findByColumn23(@Param("column23") String column23);

    @Query("SELECT t FROM Table12Entity t WHERE t.column24 = :column24")
    List<Table12Entity> findByColumn24(@Param("column24") String column24);

    @Query("SELECT t FROM Table12Entity t WHERE t.column25 = :column25")
    List<Table12Entity> findByColumn25(@Param("column25") String column25);

    @Query("SELECT t FROM Table12Entity t WHERE t.column26 = :column26")
    List<Table12Entity> findByColumn26(@Param("column26") String column26);

    @Query("SELECT t FROM Table12Entity t WHERE t.column27 = :column27")
    List<Table12Entity> findByColumn27(@Param("column27") String column27);

    @Query("SELECT t FROM Table12Entity t WHERE t.column28 = :column28")
    List<Table12Entity> findByColumn28(@Param("column28") String column28);

    @Query("SELECT t FROM Table12Entity t WHERE t.column29 = :column29")
    List<Table12Entity> findByColumn29(@Param("column29") String column29);

    @Query("SELECT t FROM Table12Entity t WHERE t.column30 = :column30")
    List<Table12Entity> findByColumn30(@Param("column30") String column30);

    @Query("SELECT t FROM Table12Entity t WHERE t.column31 = :column31")
    List<Table12Entity> findByColumn31(@Param("column31") String column31);

    @Query("SELECT t FROM Table12Entity t WHERE t.column32 = :column32")
    List<Table12Entity> findByColumn32(@Param("column32") String column32);

    @Query("SELECT t FROM Table12Entity t WHERE t.column33 = :column33")
    List<Table12Entity> findByColumn33(@Param("column33") String column33);

    @Query("SELECT t FROM Table12Entity t WHERE t.column34 = :column34")
    List<Table12Entity> findByColumn34(@Param("column34") String column34);

    @Query("SELECT t FROM Table12Entity t WHERE t.column35 = :column35")
    List<Table12Entity> findByColumn35(@Param("column35") String column35);

    @Query("SELECT t FROM Table12Entity t WHERE t.column36 = :column36")
    List<Table12Entity> findByColumn36(@Param("column36") String column36);

    @Query("SELECT t FROM Table12Entity t WHERE t.column37 = :column37")
    List<Table12Entity> findByColumn37(@Param("column37") String column37);

    @Query("SELECT t FROM Table12Entity t WHERE t.column38 = :column38")
    List<Table12Entity> findByColumn38(@Param("column38") String column38);

    @Query("SELECT t FROM Table12Entity t WHERE t.column39 = :column39")
    List<Table12Entity> findByColumn39(@Param("column39") String column39);

    @Query("SELECT t FROM Table12Entity t WHERE t.column40 = :column40")
    List<Table12Entity> findByColumn40(@Param("column40") String column40);

    @Query("SELECT t FROM Table12Entity t WHERE t.column41 = :column41")
    List<Table12Entity> findByColumn41(@Param("column41") String column41);

    @Query("SELECT t FROM Table12Entity t WHERE t.column42 = :column42")
    List<Table12Entity> findByColumn42(@Param("column42") String column42);

    @Query("SELECT t FROM Table12Entity t WHERE t.column43 = :column43")
    List<Table12Entity> findByColumn43(@Param("column43") String column43);

    @Query("SELECT t FROM Table12Entity t WHERE t.column44 = :column44")
    List<Table12Entity> findByColumn44(@Param("column44") String column44);

    @Query("SELECT t FROM Table12Entity t WHERE t.column45 = :column45")
    List<Table12Entity> findByColumn45(@Param("column45") String column45);

    @Query("SELECT t FROM Table12Entity t WHERE t.column46 = :column46")
    List<Table12Entity> findByColumn46(@Param("column46") String column46);

    @Query("SELECT t FROM Table12Entity t WHERE t.column47 = :column47")
    List<Table12Entity> findByColumn47(@Param("column47") String column47);

    @Query("SELECT t FROM Table12Entity t WHERE t.column48 = :column48")
    List<Table12Entity> findByColumn48(@Param("column48") String column48);

    @Query("SELECT t FROM Table12Entity t WHERE t.column49 = :column49")
    List<Table12Entity> findByColumn49(@Param("column49") String column49);

    @Query("SELECT t FROM Table12Entity t WHERE t.column50 = :column50")
    List<Table12Entity> findByColumn50(@Param("column50") String column50);

    @Query("SELECT t FROM Table12Entity t WHERE t.column51 = :column51")
    List<Table12Entity> findByColumn51(@Param("column51") String column51);

    @Query("SELECT t FROM Table12Entity t WHERE t.column52 = :column52")
    List<Table12Entity> findByColumn52(@Param("column52") String column52);

    @Query("SELECT t FROM Table12Entity t WHERE t.column53 = :column53")
    List<Table12Entity> findByColumn53(@Param("column53") String column53);

    @Query("SELECT t FROM Table12Entity t WHERE t.column54 = :column54")
    List<Table12Entity> findByColumn54(@Param("column54") String column54);

    @Query("SELECT t FROM Table12Entity t WHERE t.column55 = :column55")
    List<Table12Entity> findByColumn55(@Param("column55") String column55);

    @Query("SELECT t FROM Table12Entity t WHERE t.column56 = :column56")
    List<Table12Entity> findByColumn56(@Param("column56") String column56);

    @Query("SELECT t FROM Table12Entity t WHERE t.column57 = :column57")
    List<Table12Entity> findByColumn57(@Param("column57") String column57);

    @Query("SELECT t FROM Table12Entity t WHERE t.column58 = :column58")
    List<Table12Entity> findByColumn58(@Param("column58") String column58);

    @Query("SELECT t FROM Table12Entity t WHERE t.column59 = :column59")
    List<Table12Entity> findByColumn59(@Param("column59") String column59);

    @Query("SELECT t FROM Table12Entity t WHERE t.column60 = :column60")
    List<Table12Entity> findByColumn60(@Param("column60") String column60);

    @Query("SELECT t FROM Table12Entity t WHERE t.column61 = :column61")
    List<Table12Entity> findByColumn61(@Param("column61") String column61);

    @Query("SELECT t FROM Table12Entity t WHERE t.column62 = :column62")
    List<Table12Entity> findByColumn62(@Param("column62") String column62);

    @Query("SELECT t FROM Table12Entity t WHERE t.column63 = :column63")
    List<Table12Entity> findByColumn63(@Param("column63") String column63);

    @Query("SELECT t FROM Table12Entity t WHERE t.column64 = :column64")
    List<Table12Entity> findByColumn64(@Param("column64") String column64);

    @Query("SELECT t FROM Table12Entity t WHERE t.column65 = :column65")
    List<Table12Entity> findByColumn65(@Param("column65") String column65);

    @Query("SELECT t FROM Table12Entity t WHERE t.column66 = :column66")
    List<Table12Entity> findByColumn66(@Param("column66") String column66);

    @Query("SELECT t FROM Table12Entity t WHERE t.column67 = :column67")
    List<Table12Entity> findByColumn67(@Param("column67") String column67);

    @Query("SELECT t FROM Table12Entity t WHERE t.column68 = :column68")
    List<Table12Entity> findByColumn68(@Param("column68") String column68);

    @Query("SELECT t FROM Table12Entity t WHERE t.column69 = :column69")
    List<Table12Entity> findByColumn69(@Param("column69") String column69);

    @Query("SELECT t FROM Table12Entity t WHERE t.column70 = :column70")
    List<Table12Entity> findByColumn70(@Param("column70") String column70);

    @Query("SELECT t FROM Table12Entity t WHERE t.column71 = :column71")
    List<Table12Entity> findByColumn71(@Param("column71") String column71);

    @Query("SELECT t FROM Table12Entity t WHERE t.column72 = :column72")
    List<Table12Entity> findByColumn72(@Param("column72") String column72);

    @Query("SELECT t FROM Table12Entity t WHERE t.column73 = :column73")
    List<Table12Entity> findByColumn73(@Param("column73") String column73);

    @Query("SELECT t FROM Table12Entity t WHERE t.column74 = :column74")
    List<Table12Entity> findByColumn74(@Param("column74") String column74);

    @Query("SELECT t FROM Table12Entity t WHERE t.column75 = :column75")
    List<Table12Entity> findByColumn75(@Param("column75") String column75);

    @Query("SELECT t FROM Table12Entity t WHERE t.column76 = :column76")
    List<Table12Entity> findByColumn76(@Param("column76") String column76);

    @Query("SELECT t FROM Table12Entity t WHERE t.column77 = :column77")
    List<Table12Entity> findByColumn77(@Param("column77") String column77);

    @Query("SELECT t FROM Table12Entity t WHERE t.column78 = :column78")
    List<Table12Entity> findByColumn78(@Param("column78") String column78);

    @Query("SELECT t FROM Table12Entity t WHERE t.column79 = :column79")
    List<Table12Entity> findByColumn79(@Param("column79") String column79);

    @Query("SELECT t FROM Table12Entity t WHERE t.column80 = :column80")
    List<Table12Entity> findByColumn80(@Param("column80") String column80);

    @Query("SELECT t FROM Table12Entity t WHERE t.column81 = :column81")
    List<Table12Entity> findByColumn81(@Param("column81") String column81);

    @Query("SELECT t FROM Table12Entity t WHERE t.column82 = :column82")
    List<Table12Entity> findByColumn82(@Param("column82") String column82);

    @Query("SELECT t FROM Table12Entity t WHERE t.column83 = :column83")
    List<Table12Entity> findByColumn83(@Param("column83") String column83);

    @Query("SELECT t FROM Table12Entity t WHERE t.column84 = :column84")
    List<Table12Entity> findByColumn84(@Param("column84") String column84);

    @Query("SELECT t FROM Table12Entity t WHERE t.column85 = :column85")
    List<Table12Entity> findByColumn85(@Param("column85") String column85);

    @Query("SELECT t FROM Table12Entity t WHERE t.column86 = :column86")
    List<Table12Entity> findByColumn86(@Param("column86") String column86);

    @Query("SELECT t FROM Table12Entity t WHERE t.column87 = :column87")
    List<Table12Entity> findByColumn87(@Param("column87") String column87);

    @Query("SELECT t FROM Table12Entity t WHERE t.column88 = :column88")
    List<Table12Entity> findByColumn88(@Param("column88") String column88);

    @Query("SELECT t FROM Table12Entity t WHERE t.column89 = :column89")
    List<Table12Entity> findByColumn89(@Param("column89") String column89);

    @Query("SELECT t FROM Table12Entity t WHERE t.column90 = :column90")
    List<Table12Entity> findByColumn90(@Param("column90") String column90);

    @Query("SELECT t FROM Table12Entity t WHERE t.column91 = :column91")
    List<Table12Entity> findByColumn91(@Param("column91") String column91);

    @Query("SELECT t FROM Table12Entity t WHERE t.column92 = :column92")
    List<Table12Entity> findByColumn92(@Param("column92") String column92);

    @Query("SELECT t FROM Table12Entity t WHERE t.column93 = :column93")
    List<Table12Entity> findByColumn93(@Param("column93") String column93);

    @Query("SELECT t FROM Table12Entity t WHERE t.column94 = :column94")
    List<Table12Entity> findByColumn94(@Param("column94") String column94);

    @Query("SELECT t FROM Table12Entity t WHERE t.column95 = :column95")
    List<Table12Entity> findByColumn95(@Param("column95") String column95);

    @Query("SELECT t FROM Table12Entity t WHERE t.column96 = :column96")
    List<Table12Entity> findByColumn96(@Param("column96") String column96);

    @Query("SELECT t FROM Table12Entity t WHERE t.column97 = :column97")
    List<Table12Entity> findByColumn97(@Param("column97") String column97);

    @Query("SELECT t FROM Table12Entity t WHERE t.column98 = :column98")
    List<Table12Entity> findByColumn98(@Param("column98") String column98);

    @Query("SELECT t FROM Table12Entity t WHERE t.column99 = :column99")
    List<Table12Entity> findByColumn99(@Param("column99") String column99);

    @Query("SELECT t FROM Table12Entity t WHERE t.column100 = :column100")
    List<Table12Entity> findByColumn100(@Param("column100") String column100);

}