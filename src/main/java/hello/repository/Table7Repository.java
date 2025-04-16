

package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import hello.entity.Table7;
import java.util.List;
import java.util.Optional;

@Repository
public interface Table7Repository extends JpaRepository<Table7, Long> {

    @Query("SELECT t FROM Table7 t WHERE t.id = :id")
    Optional<Table7> findById(@Param("id") Long id);

    @Query("SELECT t FROM Table7 t WHERE t.name = :name")
    List<Table7> findByName(@Param("name") String name);

    @Query("SELECT t FROM Table7 t WHERE t.description = :description")
    List<Table7> findByDescription(@Param("description") String description);

    @Query("SELECT t FROM Table7 t WHERE t.column1 = :column1")
    List<Table7> findByColumn1(@Param("column1") String column1);

    @Query("SELECT t FROM Table7 t WHERE t.column2 = :column2")
    List<Table7> findByColumn2(@Param("column2") String column2);

    @Query("SELECT t FROM Table7 t WHERE t.column3 = :column3")
    List<Table7> findByColumn3(@Param("column3") String column3);

    @Query("SELECT t FROM Table7 t WHERE t.column4 = :column4")
    List<Table7> findByColumn4(@Param("column4") String column4);

    @Query("SELECT t FROM Table7 t WHERE t.column5 = :column5")
    List<Table7> findByColumn5(@Param("column5") String column5);

    @Query("SELECT t FROM Table7 t WHERE t.column6 = :column6")
    List<Table7> findByColumn6(@Param("column6") String column6);

    @Query("SELECT t FROM Table7 t WHERE t.column7 = :column7")
    List<Table7> findByColumn7(@Param("column7") String column7);

    @Query("SELECT t FROM Table7 t WHERE t.column8 = :column8")
    List<Table7> findByColumn8(@Param("column8") String column8);

    @Query("SELECT t FROM Table7 t WHERE t.column9 = :column9")
    List<Table7> findByColumn9(@Param("column9") String column9);

    @Query("SELECT t FROM Table7 t WHERE t.column10 = :column10")
    List<Table7> findByColumn10(@Param("column10") String column10);

    @Query("SELECT t FROM Table7 t WHERE t.column11 = :column11")
    List<Table7> findByColumn11(@Param("column11") String column11);

    @Query("SELECT t FROM Table7 t WHERE t.column12 = :column12")
    List<Table7> findByColumn12(@Param("column12") String column12);

    @Query("SELECT t FROM Table7 t WHERE t.column13 = :column13")
    List<Table7> findByColumn13(@Param("column13") String column13);

    @Query("SELECT t FROM Table7 t WHERE t.column14 = :column14")
    List<Table7> findByColumn14(@Param("column14") String column14);

    @Query("SELECT t FROM Table7 t WHERE t.column15 = :column15")
    List<Table7> findByColumn15(@Param("column15") String column15);

    @Query("SELECT t FROM Table7 t WHERE t.column16 = :column16")
    List<Table7> findByColumn16(@Param("column16") String column16);

    @Query("SELECT t FROM Table7 t WHERE t.column17 = :column17")
    List<Table7> findByColumn17(@Param("column17") String column17);

    @Query("SELECT t FROM Table7 t WHERE t.column18 = :column18")
    List<Table7> findByColumn18(@Param("column18") String column18);

    @Query("SELECT t FROM Table7 t WHERE t.column19 = :column19")
    List<Table7> findByColumn19(@Param("column19") String column19);

    @Query("SELECT t FROM Table7 t WHERE t.column20 = :column20")
    List<Table7> findByColumn20(@Param("column20") String column20);

    @Query("SELECT t FROM Table7 t WHERE t.column21 = :column21")
    List<Table7> findByColumn21(@Param("column21") String column21);

    @Query("SELECT t FROM Table7 t WHERE t.column22 = :column22")
    List<Table7> findByColumn22(@Param("column22") String column22);

    @Query("SELECT t FROM Table7 t WHERE t.column23 = :column23")
    List<Table7> findByColumn23(@Param("column23") String column23);

    @Query("SELECT t FROM Table7 t WHERE t.column24 = :column24")
    List<Table7> findByColumn24(@Param("column24") String column24);

    @Query("SELECT t FROM Table7 t WHERE t.column25 = :column25")
    List<Table7> findByColumn25(@Param("column25") String column25);

    @Query("SELECT t FROM Table7 t WHERE t.column26 = :column26")
    List<Table7> findByColumn26(@Param("column26") String column26);

    @Query("SELECT t FROM Table7 t WHERE t.column27 = :column27")
    List<Table7> findByColumn27(@Param("column27") String column27);

    @Query("SELECT t FROM Table7 t WHERE t.column28 = :column28")
    List<Table7> findByColumn28(@Param("column28") String column28);

    @Query("SELECT t FROM Table7 t WHERE t.column29 = :column29")
    List<Table7> findByColumn29(@Param("column29") String column29);

    @Query("SELECT t FROM Table7 t WHERE t.column30 = :column30")
    List<Table7> findByColumn30(@Param("column30") String column30);

    @Query("SELECT t FROM Table7 t WHERE t.column31 = :column31")
    List<Table7> findByColumn31(@Param("column31") String column31);

    @Query("SELECT t FROM Table7 t WHERE t.column32 = :column32")
    List<Table7> findByColumn32(@Param("column32") String column32);

    @Query("SELECT t FROM Table7 t WHERE t.column33 = :column33")
    List<Table7> findByColumn33(@Param("column33") String column33);

    @Query("SELECT t FROM Table7 t WHERE t.column34 = :column34")
    List<Table7> findByColumn34(@Param("column34") String column34);

    @Query("SELECT t FROM Table7 t WHERE t.column35 = :column35")
    List<Table7> findByColumn35(@Param("column35") String column35);

    @Query("SELECT t FROM Table7 t")
    List<Table7> findAll();

    @Query("SELECT t FROM Table7 t WHERE t.id = :id")
    void deleteById(@Param("id") Long id);

    @Query("SELECT t FROM Table7 t WHERE t.name = :name")
    void deleteByName(@Param("name") String name);

    @Query("SELECT t FROM Table7 t WHERE t.description = :description")
    void deleteByDescription(@Param("description") String description);

    @Query("SELECT t FROM Table7 t WHERE t.column1 = :column1")
    void deleteByColumn1(@Param("column1") String column1);

    @Query("SELECT t FROM Table7 t WHERE t.column2 = :column2")
    void deleteByColumn2(@Param("column2") String column2);

    @Query("SELECT t FROM Table7 t WHERE t.column3 = :column3")
    void deleteByColumn3(@Param("column3") String column3);

    @Query("SELECT t FROM Table7 t WHERE t.column4 = :column4")
    void deleteByColumn4(@Param("column4") String column4);

    @Query("SELECT t FROM Table7 t WHERE t.column5 = :column5")
    void deleteByColumn5(@Param("column5") String column5);

    @Query("SELECT t FROM Table7 t WHERE t.column6 = :column6")
    void deleteByColumn6(@Param("column6") String column6);

    @Query("SELECT t FROM Table7 t WHERE t.column7 = :column7")
    void deleteByColumn7(@Param("column7") String column7);

    @Query("SELECT t FROM Table7 t WHERE t.column8 = :column8")
    void deleteByColumn8(@Param("column8") String column8);

    @Query("SELECT t FROM Table7 t WHERE t.column9 = :column9")
    void deleteByColumn9(@Param("column9") String column9);

    @Query("SELECT t FROM Table7 t WHERE t.column10 = :column10")
    void deleteByColumn10(@Param("column10") String column10);

    @Query("SELECT t FROM Table7 t WHERE t.column11 = :column11")
    void deleteByColumn11(@Param("column11") String column11);

    @Query("SELECT t FROM Table7 t WHERE t.column12 = :column12")
    void deleteByColumn12(@Param("column12") String column12);

    @Query("SELECT t FROM Table7 t WHERE t.column13 = :column13")
    void deleteByColumn13(@Param("column13") String column13);

    @Query("SELECT t FROM Table7 t WHERE t.column14 = :column14")
    void deleteByColumn14(@Param("column14") String column14);

    @Query("SELECT t FROM Table7 t WHERE t.column15 = :column15")
    void deleteByColumn15(@Param("column15") String column15);

    @Query("SELECT t FROM Table7 t WHERE t.column16 = :column16")
    void deleteByColumn16(@Param("column16") String column16);

    @Query("SELECT t FROM Table7 t WHERE t.column17 = :column17")
    void deleteByColumn17(@Param("column17") String column17);

    @Query("SELECT t FROM Table7 t WHERE t.column18 = :column18")
    void deleteByColumn18(@Param("column18") String column18);

    @Query("SELECT t FROM Table7 t WHERE t.column19 = :column19")
    void deleteByColumn19(@Param("column19") String column19);

    @Query("SELECT t FROM Table7 t WHERE t.column20 = :column20")
    void deleteByColumn20(@Param("column20") String column20);

    @Query("SELECT t FROM Table7 t WHERE t.column21 = :column21")
    void deleteByColumn21(@Param("column21") String column21);

    @Query("SELECT t FROM Table7 t WHERE t.column22 = :column22")
    void deleteByColumn22(@Param("column22") String column22);

    @Query("SELECT t FROM Table7 t WHERE t.column23 = :column23")
    void deleteByColumn23(@Param("column23") String column23);

    @Query("SELECT t FROM Table7 t WHERE t.column24 = :column24")
    void deleteByColumn24(@Param("column24") String column24);

    @Query("SELECT t FROM Table7 t WHERE t.column25 = :column25")
    void deleteByColumn25(@Param("column25") String column25);

    @Query("SELECT t FROM Table7 t WHERE t.column26 = :column26")
    void deleteByColumn26(@Param("column26") String column26);

    @Query("SELECT t FROM Table7 t WHERE t.column27 = :column27")
    void deleteByColumn27(@Param("column27") String column27);

    @Query("SELECT t FROM Table7 t WHERE t.column28 = :column28")
    void deleteByColumn28(@Param("column28") String column28);

    @Query("SELECT t FROM Table7 t WHERE t.column29 = :column29")
    void deleteByColumn29(@Param("column29") String column29);

    @Query("SELECT t FROM Table7 t WHERE t.column30 = :column30")
    void deleteByColumn30(@Param("column30") String column30);

    @Query("SELECT t FROM Table7 t WHERE t.column31 = :column31")
    void deleteByColumn31(@Param("column31") String column31);

    @Query("SELECT t FROM Table7 t WHERE t.column32 = :column32")
    void deleteByColumn32(@Param("column32") String column32);

    @Query("SELECT t FROM Table7 t WHERE t.column33 = :column33")
    void deleteByColumn33(@Param("column33") String column33);

    @Query("SELECT t FROM Table7 t WHERE t.column34 = :column34")
    void deleteByColumn34(@Param("column34") String column34);

    @Query("SELECT t FROM Table7 t WHERE t.column35 = :column35")
    void deleteByColumn35(@Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.id = :id")
    void updateById(@Param("id") Long id, @Param("name") String name, @Param("description") String description, @Param("column1") String column1, @Param("column2") String column2, @Param("column3") String column3, @Param("column4") String column4, @Param("column5") String column5, @Param("column6") String column6, @Param("column7") String column7, @Param("column8") String column8, @Param("column9") String column9, @Param("column10") String column10, @Param("column11") String column11, @Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.name = :name")
    void updateByName(@Param("name") String name, @Param("description") String description, @Param("column1") String column1, @Param("column2") String column2, @Param("column3") String column3, @Param("column4") String column4, @Param("column5") String column5, @Param("column6") String column6, @Param("column7") String column7, @Param("column8") String column8, @Param("column9") String column9, @Param("column10") String column10, @Param("column11") String column11, @Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.description = :description")
    void updateByDescription(@Param("description") String description, @Param("column1") String column1, @Param("column2") String column2, @Param("column3") String column3, @Param("column4") String column4, @Param("column5") String column5, @Param("column6") String column6, @Param("column7") String column7, @Param("column8") String column8, @Param("column9") String column9, @Param("column10") String column10, @Param("column11") String column11, @Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.column1 = :column1")
    void updateByColumn1(@Param("column1") String column1, @Param("column2") String column2, @Param("column3") String column3, @Param("column4") String column4, @Param("column5") String column5, @Param("column6") String column6, @Param("column7") String column7, @Param("column8") String column8, @Param("column9") String column9, @Param("column10") String column10, @Param("column11") String column11, @Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.column2 = :column2")
    void updateByColumn2(@Param("column2") String column2, @Param("column3") String column3, @Param("column4") String column4, @Param("column5") String column5, @Param("column6") String column6, @Param("column7") String column7, @Param("column8") String column8, @Param("column9") String column9, @Param("column10") String column10, @Param("column11") String column11, @Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.column3 = :column3")
    void updateByColumn3(@Param("column3") String column3, @Param("column4") String column4, @Param("column5") String column5, @Param("column6") String column6, @Param("column7") String column7, @Param("column8") String column8, @Param("column9") String column9, @Param("column10") String column10, @Param("column11") String column11, @Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.column4 = :column4")
    void updateByColumn4(@Param("column4") String column4, @Param("column5") String column5, @Param("column6") String column6, @Param("column7") String column7, @Param("column8") String column8, @Param("column9") String column9, @Param("column10") String column10, @Param("column11") String column11, @Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.column5 = :column5")
    void updateByColumn5(@Param("column5") String column5, @Param("column6") String column6, @Param("column7") String column7, @Param("column8") String column8, @Param("column9") String column9, @Param("column10") String column10, @Param("column11") String column11, @Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.column6 = :column6")
    void updateByColumn6(@Param("column6") String column6, @Param("column7") String column7, @Param("column8") String column8, @Param("column9") String column9, @Param("column10") String column10, @Param("column11") String column11, @Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.column7 = :column7")
    void updateByColumn7(@Param("column7") String column7, @Param("column8") String column8, @Param("column9") String column9, @Param("column10") String column10, @Param("column11") String column11, @Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.column8 = :column8")
    void updateByColumn8(@Param("column8") String column8, @Param("column9") String column9, @Param("column10") String column10, @Param("column11") String column11, @Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.column9 = :column9")
    void updateByColumn9(@Param("column9") String column9, @Param("column10") String column10, @Param("column11") String column11, @Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.column10 = :column10")
    void updateByColumn10(@Param("column10") String column10, @Param("column11") String column11, @Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.column11 = :column11")
    void updateByColumn11(@Param("column11") String column11, @Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.column12 = :column12")
    void updateByColumn12(@Param("column12") String column12, @Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.column13 = :column13")
    void updateByColumn13(@Param("column13") String column13, @Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21, @Param("column22") String column22, @Param("column23") String column23, @Param("column24") String column24, @Param("column25") String column25, @Param("column26") String column26, @Param("column27") String column27, @Param("column28") String column28, @Param("column29") String column29, @Param("column30") String column30, @Param("column31") String column31, @Param("column32") String column32, @Param("column33") String column33, @Param("column34") String column34, @Param("column35") String column35);

    @Query("SELECT t FROM Table7 t WHERE t.column14 = :column14")
    void updateByColumn14(@Param("column14") String column14, @Param("column15") String column15, @Param("column16") String column16, @Param("column17") String column17, @Param("column18") String column18, @Param("column19") String column19, @Param("column20") String column20, @Param("column21") String column21